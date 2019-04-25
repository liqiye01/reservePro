package com.reserve.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reserve.bean.PredictTable;
import com.reserve.bean.PredictTableExample;
import com.reserve.bean.PredictTableExample.Criteria;
import com.reserve.bean.RejectTable;
import com.reserve.bean.RejectTableExample;
import com.reserve.bean.User;
import com.reserve.dao.PredictTableMapper;
import com.reserve.dao.RejectTableMapper;
import com.reserve.dao.UserMapper;
import com.reserve.service.PredictTableService;
import com.reserve.service.RejectTableService;
import com.reserve.service.UserService;
import com.reserve.util.Md5;
import com.reserve.util.WeekDateUtil;



@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PredictTableMapper predictTableMapper;
	
	@Autowired
	private RejectTableMapper rejectTableMapper;
	
	@Autowired
	private PredictTableService predictTableService;
	
	@Autowired
	private RejectTableService rejectTableService;
	
	@Autowired
	private UserMapper userMapper;
	
	
	//登录页面
	@RequestMapping("/loginPage")
	public String loginPage(String loginFlag){
		//登录标记，用于非法访问资源时拦截器捕获返回登录页面的提示
		if(loginFlag!=null){
			request.setAttribute("loginFlag", loginFlag);
		}
		return "loginPage";
	}
	
	//主页面（菜单栏，其他页面用iframe引进来）
	@RequestMapping("/mainPage")
	public String view(Model model){
		return "mainPage";
	}
	
	
	
	//登录
	@RequestMapping("/login")
	public String mainPage(String privilegeMark,String username,String password) throws IOException, ServletException {

		//取得remeberMe的值
		 String remeberMe = request.getParameter("RememberMe");
		 //创建Cookie存储用户名和密码
		 Cookie nameCookie = new Cookie("username",username);
		 Cookie passwordCookie = new Cookie("password",password);
		 Cookie privilegeMarkCookie = new Cookie("privilegeMark","1");
		 //取得路径
		 String path = request.getContextPath()+"/";
		 //设置有效路径
		 nameCookie.setPath(path);
		 passwordCookie.setPath(path);
		 privilegeMarkCookie.setPath(path);
		 privilegeMarkCookie.setMaxAge(7*24*60*60);//设置生命周期为一周
		 nameCookie.setMaxAge(7*24*60*60);//设置生命周期为一周
		 if("yes".equals(remeberMe)){
			  //如果选择了记住密码的复选框
			  //设置时间
			  passwordCookie.setMaxAge(7*24*60*60);//设置生命周期为一周
		 }else{
			  //清空
			 passwordCookie.setMaxAge(0);//设置生命周期为0
			 
		 }
		//存储Cookie
		response.addCookie(nameCookie);
		response.addCookie(passwordCookie);
		
		List<User> list = userService.getUserByUsername(username, privilegeMark);
		if(list.size()>0){
		for (User user : list) {
			//先将密码md5加密
			Md5 md5 = new Md5();
			try {
				password=md5.EncoderByMd5(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			if(user.getPassword().equals(password)){
				request.getSession().setAttribute("user", user);
				if(privilegeMark.equals("1")){
					//成功登陆管理员页面
					response.addCookie(privilegeMarkCookie);
					//到预定表和驳回表查看有没有该用户的数据可以提示
					PredictTableExample example = new PredictTableExample();
					Criteria criteria = example.createCriteria();
					criteria.andPredictPersonEqualTo(username);
					criteria.andPredictStateEqualTo("2");
					criteria.andDelFlagEqualTo("0");
					criteria.andIsReadEqualTo("0");
					List<PredictTable> list2 = predictTableMapper.selectByExample(example);
					String successName="";
					String successIds="";
					if(list2.size()>0){
						for (PredictTable predictTable : list2) {
							String resourceName = predictTable.getResourceName();
							String predictTime = predictTable.getPredictTime();
							predictTime=WeekDateUtil.getChineseDate(predictTime);
							successName+=resourceName+=predictTime+"</br>";
							successIds+=predictTable.getId()+",";
						}
						request.setAttribute("reserveSuccess", "1");
						request.setAttribute("successName", successName);
						request.setAttribute("successIds", successIds);
					}
					RejectTableExample example2 = new RejectTableExample();
					com.reserve.bean.RejectTableExample.Criteria criteria2 = example2.createCriteria();
					criteria2.andPredictorEqualTo(username);
					criteria2.andDelFlagEqualTo("0");
					criteria2.andIsReadEqualTo("0");
					List<RejectTable> list3 = rejectTableMapper.selectByExample(example2);
					String rejectName="";
					String rejectIds="";
					if(list3.size()>0){
						for (RejectTable rejectTable : list3) {
							String resourceName = rejectTable.getResourceName();
							String predictTime = rejectTable.getPredictTime();
							predictTime=WeekDateUtil.getChineseDate(predictTime);
							rejectName+=resourceName+=predictTime+"</br>";
							rejectIds+=rejectTable.getId()+",";
						}
						request.setAttribute("reserveReject", "1");
						request.setAttribute("rejectName", rejectName);
						request.setAttribute("rejectIds", rejectIds);
					}
					return "mainPage";
				}else if(privilegeMark.equals("0")){
					//成功登陆一般用户页面
					//到预定表和驳回表查看有没有该用户的数据可以提示
					PredictTableExample example = new PredictTableExample();
					Criteria criteria = example.createCriteria();
					criteria.andPredictPersonEqualTo(username);
					criteria.andPredictStateEqualTo("2");
					criteria.andIsReadEqualTo("0");
					criteria.andDelFlagEqualTo("0");
					List<PredictTable> list2 = predictTableMapper.selectByExample(example);
					String successName="";
					String successIds="";
					if(list2.size()>0){
						for (PredictTable predictTable : list2) {
							String resourceName = predictTable.getResourceName();
							String predictTime = predictTable.getPredictTime();
							predictTime=WeekDateUtil.getChineseDate(predictTime);
							successName+=resourceName+=predictTime+"</br>";
							successIds+=predictTable.getId()+",";
						}
						request.setAttribute("reserveSuccess", "1");
						request.setAttribute("successName", successName);
						request.setAttribute("successIds", successIds);
					}
					RejectTableExample example2 = new RejectTableExample();
					com.reserve.bean.RejectTableExample.Criteria criteria2 = example2.createCriteria();
					criteria2.andPredictorEqualTo(username);
					criteria2.andDelFlagEqualTo("0");
					criteria2.andIsReadEqualTo("0");
					List<RejectTable> list3 = rejectTableMapper.selectByExample(example2);
					String rejectName="";
					String rejectIds="";
					if(list3.size()>0){
						for (RejectTable rejectTable : list3) {
							String resourceName = rejectTable.getResourceName();
							String predictTime = rejectTable.getPredictTime();
							predictTime=WeekDateUtil.getChineseDate(predictTime);
							rejectName+=resourceName+=predictTime+"</br>";
							rejectIds+=rejectTable.getId()+",";
						}
						request.setAttribute("reserveReject", "1");
						request.setAttribute("rejectName", rejectName);
						request.setAttribute("rejectIds", rejectIds);
					}
					return "mainPageGeneral";
				}
			}else{
				//密码错误
				request.setAttribute("flag", "1");
				request.setAttribute("username", username);
				if(privilegeMark.equals("1")){
					request.setAttribute("change", "1");
				}
				return "loginPage";
			}
		}
		}else{
			if(privilegeMark.equals("1")){
				request.setAttribute("flag", "2");
				request.setAttribute("change", "1");
			}else if(privilegeMark.equals("0")){
				request.setAttribute("flag", "3");
			}
			return "loginPage";
		}
		return "loginPage";
	}
	
	@RequestMapping("/welcomeUse")
	public String welcomeUse(){
		return "welcomeUse";
	}
	
	//登录的预定成功弹出框查看后调用方法，修改查看状态
	@RequestMapping("/checkSuccess")
	public void checkSuccess(String successIds){
		String[] successId = successIds.split(",");
		for (String id : successId) {
			if(id!=null && !id.equals("")){
				PredictTable predictTable = predictTableService.getById(id);
				predictTable.setIsRead("1");
				predictTableService.save(predictTable);
			}
		}
	}
	
	@RequestMapping("/checkReject")
	public void checkReject(String rejectIds){
		String[] rejectId = rejectIds.split(",");
		for (String id : rejectId) {
			if(id!=null && !id.equals("")){
				RejectTable rejectTable = rejectTableService.getById(id);
				rejectTable.setIsRead("1");
				rejectTableService.save(rejectTable);
			}
		}
	}
	
	@RequestMapping("/quitLogin")
	public String quitLogin(){
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		return "loginPage";
	}
	
	
	@RequestMapping("/myReserve")
	public String myReserve(String predictState){
		
		PredictTableExample example = new PredictTableExample();
		Criteria criteria = example.createCriteria();
		if(predictState!=null && !predictState.equals("")){
			criteria.andPredictStateEqualTo(predictState);
		}
		criteria.andDelFlagEqualTo("0");
		User user = (User)request.getSession().getAttribute("user");
		String username = user.getUsername();
		criteria.andPredictPersonEqualTo(username);
		List<PredictTable> list = predictTableMapper.selectByExample(example);
		for (PredictTable predictTable : list) {
			String chineseDate = WeekDateUtil.getChineseDate(predictTable.getPredictTime());
			predictTable.setPredictTime(chineseDate);
		}
		if(predictState!=null && !predictState.equals("")){
			request.setAttribute("predictState", predictState);
		}
		request.setAttribute("list", list);
		return "myReserve";
	}
	
	/**
	 * 个人信息页面
	 * @return
	 */
	@RequestMapping("/personalMsgPage")
	public String personalMsgPage(){
		User user = (User)request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		return "personMsg/personalMsgPage";
	}
	
	@RequestMapping("/updateUserMsg")
	public String updateUserMsg(User user){
		userMapper.updateByPrimaryKeySelective(user);
		request.setAttribute("updateMsg", "1");
		//信息同步到session
		request.getSession().setAttribute("user", user);
		return "personMsg/personalMsgPage";
	}
	
	@RequestMapping("/updateUserPwdPage")
	public String updateUserPwdPage(){
		return "personMsg/updateUserPwdPage";
	}
	
	@RequestMapping("/updateUserPwd")
	public String updateUserPwd(String oldPassword,String password){
		Md5 md5 = new Md5();
		try {
			oldPassword = md5.EncoderByMd5(oldPassword);
			password = md5.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = (User)request.getSession().getAttribute("user");
		String pwd = user.getPassword();
		//修改密码成功
		if(pwd.equals(oldPassword)){
			if(pwd.equals(password)){
				request.setAttribute("samePwd", "1");
				return "personMsg/updateUserPwdPage";
			}else{
				user.setPassword(password);
				userMapper.updateByPrimaryKeySelective(user);
				request.getSession().setAttribute("user", user);
				request.setAttribute("user", user);
				request.setAttribute("updatePwd", "1");
				return "personMsg/personalMsgPage";
			}
		}else{
			request.setAttribute("oldPwdError", "1");
			return "personMsg/updateUserPwdPage";
		}
	}
	
}
