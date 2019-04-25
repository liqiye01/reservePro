package com.reserve.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.security.provider.MD5;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reserve.bean.Classroom;
import com.reserve.bean.ClassroomExample;
import com.reserve.bean.PredictPerson;
import com.reserve.bean.TimeArrange;
import com.reserve.bean.User;
import com.reserve.bean.UserExample;
import com.reserve.bean.UserExample.Criteria;
import com.reserve.dao.UserMapper;
import com.reserve.util.Md5;

/**
 * 用户管理
 * @author liqiye
 *
 */
@Controller
@RequestMapping("/userManage")
public class UserManageController {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/userList")
	public String userList(User user, String pageNum){
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(user!=null && !user.equals("")){
			if(user.getUsername()!=null && !user.getUsername().equals("")){
				criteria.andUsernameLike("%"+user.getUsername()+"%");
			}
			if(user.getTureName()!=null && !user.getTureName().equals("")){
				criteria.andTureNameLike("%"+user.getTureName()+"%");
			}
			if(user.getLevel()!=null && !user.getLevel().equals("")){
				criteria.andLevelEqualTo(user.getLevel());
			}
			if(user.getMajor()!=null && !user.getMajor().equals("")){
				criteria.andMajorLike("%"+user.getMajor()+"%");
			}
			if(user.getPermission()!=null && !user.getPermission().equals("")){
				criteria.andPermissionEqualTo(user.getPermission());
			}
		}
		criteria.andDelFlagEqualTo("0");
		criteria.andPrivilegeMarkEqualTo("0");  //只获取一般用户，管理员请自行在数据库添加
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		if(pagenum>pageInfo.getPages()){
			pageNum=String.valueOf(pageInfo.getPages());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("username", user.getUsername());
		request.setAttribute("tureName", user.getTureName());
		request.setAttribute("level", user.getLevel());
		request.setAttribute("major", user.getMajor());
		request.setAttribute("permission", user.getPermission());
		return "userManage/userList";
	}
	
	
	@RequestMapping("/addUserPage")
	public String addUserPage(){
		User user = new User();
		request.setAttribute("user", user);
		//新增成功，返回标志，删掉session值
		if(request.getSession().getAttribute("addSuccess")!=null){
			request.setAttribute("addSuccess", request.getSession().getAttribute("addSuccess"));
			request.setAttribute("resourceName", request.getSession().getAttribute("resourceName"));
			request.getSession().removeAttribute("addSuccess");
			request.getSession().removeAttribute("resourceName");
		}
		if(request.getSession().getAttribute("existFlag")!=null){
			request.setAttribute("existFlag", request.getSession().getAttribute("existFlag"));
			request.setAttribute("resourceName", request.getSession().getAttribute("resourceName"));
			request.getSession().removeAttribute("existFlag");
			request.getSession().removeAttribute("resourceName");
		}
		return "userManage/addUserPage";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		if(user.getId()!=null && !user.getId().equals("")){
			//md5加密密码
			Md5 md5 = new Md5();
			try {
				if(user.getPassword()!=null) {
					user.setPassword(md5.EncoderByMd5(user.getPassword()));
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			userMapper.updateByPrimaryKeySelective(user);
			request.setAttribute("addSuccess", "1");
			request.setAttribute("updateSuccess", "1");
			request.setAttribute("resourceName", user.getUsername());
			return "userManage/addUserPage";
		}else{
			//先判断该用户是否已存在
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(user.getUsername());
			criteria.andDelFlagEqualTo("0");
			List<User> list = userMapper.selectByExample(example);
			if(list.size()>0){
				request.getSession().setAttribute("resourceName", user.getUsername());
				request.getSession().setAttribute("existFlag", "1");
				return "redirect:/userManage/addUserPage";
			}
			String uuid = UUID.randomUUID().toString();
			user.setId(uuid);
			user.setDelFlag("0");
			user.setPrivilegeMark("0");
			//md5加密密码
			Md5 md5 = new Md5();
			try {
				user.setPassword(md5.EncoderByMd5(user.getPassword()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			userMapper.insertSelective(user);
			//新增标志
			request.getSession().setAttribute("addSuccess", "1");
			request.getSession().setAttribute("resourceName", user.getUsername());
			return "redirect:/userManage/addUserPage";
		}
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(String id){
		User user = userMapper.selectByPrimaryKey(id);
		request.setAttribute("user", user);
		return "userManage/addUserPage";
	}
	
	
	@RequestMapping("/delUser")
	public String delUser(User user,String pageNum,String resourceName){
		userMapper.deleteByPrimaryKey(user.getId());
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(user!=null && !user.equals("")){
			if(user.getUsername()!=null && !user.getUsername().equals("")){
				criteria.andUsernameLike("%"+user.getUsername()+"%");
			}
			if(user.getTureName()!=null && !user.getTureName().equals("")){
				criteria.andTureNameLike("%"+user.getTureName()+"%");
			}
			if(user.getLevel()!=null && !user.getLevel().equals("")){
				criteria.andLevelEqualTo(user.getLevel());
			}
			if(user.getMajor()!=null && !user.getMajor().equals("")){
				criteria.andMajorLike("%"+user.getMajor()+"%");
			}
			if(user.getPermission()!=null && !user.getPermission().equals("")){
				criteria.andPermissionEqualTo(user.getPermission());
			}
		}
		criteria.andDelFlagEqualTo("0");
		criteria.andPrivilegeMarkEqualTo("0");  //只获取一般用户，管理员请自行在数据库添加
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		if(pagenum>pageInfo.getPages()){
			pageNum=String.valueOf(pageInfo.getPages());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("username", user.getUsername());
		request.setAttribute("tureName", user.getTureName());
		request.setAttribute("level", user.getLevel());
		request.setAttribute("major", user.getMajor());
		request.setAttribute("permission", user.getPermission());
		request.setAttribute("resourceName", resourceName);
		request.setAttribute("delFlag", "1");
		return "userManage/userList";
	}
	
	
}
