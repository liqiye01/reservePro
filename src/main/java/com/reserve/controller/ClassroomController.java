package com.reserve.controller;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reserve.bean.Classroom;
import com.reserve.bean.PredictPerson;
import com.reserve.bean.PredictTable;
import com.reserve.bean.PredictTableExample;
import com.reserve.bean.UserExample;
import com.reserve.bean.PredictTableExample.Criteria;
import com.reserve.bean.TimeArrange;
import com.reserve.bean.User;
import com.reserve.dao.PredictPersonMapper;
import com.reserve.dao.PredictTableMapper;
import com.reserve.dao.TimeArrangeMapper;
import com.reserve.dao.UserMapper;
import com.reserve.service.ClassroomService;
import com.reserve.util.WeekDateUtil;



/**
 * 教室预定的controller
 * @author liqiye
 *
 */
@Controller
@RequestMapping("/classroom")
public class ClassroomController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private TimeArrangeMapper timeArrangeMapper;
	
	@Autowired
	private PredictPersonMapper predictPersonMapper;
	
	@Autowired
	private PredictTableMapper predictTableMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	//教学资源预定的资源详情页面
	@RequestMapping("/details")
	public String buildingDetails(String  buildingNum){
		int i = Integer.parseInt(buildingNum);
		List<Classroom> list = classroomService.findClassroomByBuildingNum(i);
		request.setAttribute("list", list);
		return "resourceReserve/classroomDetails";
	}
	
	
	//预定的详情页面
	@RequestMapping("/reserve")
	public String reserveDetails(String  id){
		Classroom classroom = classroomService.getById(id);
		String timeArrangeId = classroom.getTimeArrangeId();
		TimeArrange timeArrange = timeArrangeMapper.selectByPrimaryKey(timeArrangeId);
		String predictPersonId = classroom.getPredictPersonId();
		PredictPerson predictPerson = predictPersonMapper.selectByPrimaryKey(predictPersonId);
		if(predictPerson!=null){
			request.setAttribute("predictPerson", predictPerson);
		}
		request.setAttribute("classroom", classroom);
		request.setAttribute("timeArrange", timeArrange);
		
		List<String> weekDate = WeekDateUtil.getWeekDate();
		request.setAttribute("MonDate", weekDate.get(0));
		request.setAttribute("TueDate", weekDate.get(1));
		request.setAttribute("WenDate", weekDate.get(2));
		request.setAttribute("ThuDate", weekDate.get(3));
		request.setAttribute("FriDate", weekDate.get(4));
		request.setAttribute("SatDate", weekDate.get(5));
		request.setAttribute("SunDate", weekDate.get(6));
		request.setAttribute("todayDate", weekDate.get(7));
		
		return "resourceReserve/classroomReserve";
	}
		
	//教学资源分条页面
	@RequestMapping("/resource")
	public String classroomResource(String areaNum){
		int i = Integer.parseInt(areaNum);
		List<String> list2 = classroomService.findBuildingnumByArea(i);
		request.setAttribute("BudNumList", list2);
		request.setAttribute("areaNum", areaNum);
		return "resourceReserve/classroomResource";
	}
	
	//教学资源提交预定
	@RequestMapping("/submitReserve")
	public String classroomSubmitReserve(TimeArrange timeArrange){
		//先判断该用户有没有预定权利
		User currentUser = (User)request.getSession().getAttribute("user");
		Boolean permission = currentUser.getPermission().equals("1") ? true : false;
		if(!permission){
			//返回资源详情页面
			int i = Integer.parseInt(request.getParameter("buildingNum"));
			List<Classroom> list = classroomService.findClassroomByBuildingNum(i);
			request.setAttribute("list", list);
			request.setAttribute("banFlag", "1");  //用于页面判断弹出提示框
			return "resourceReserve/classroomDetails";
		}
		
		//将一周的日期封装进map
		String MonDate = request.getParameter("MonDate");
		String TueDate = request.getParameter("TueDate");
		String WenDate = request.getParameter("WenDate");
		String ThuDate = request.getParameter("ThuDate");
		String FriDate = request.getParameter("FriDate");
		String SatDate = request.getParameter("SatDate");
		String SunDate = request.getParameter("SunDate");
		HashMap<String, String> weekDate = new HashMap<String, String>();
		weekDate.put("MonDate", MonDate);
		weekDate.put("TueDate", TueDate);
		weekDate.put("WenDate", WenDate);
		weekDate.put("ThuDate", ThuDate);
		weekDate.put("FriDate", FriDate);
		weekDate.put("SatDate", SatDate);
		weekDate.put("SunDate", SunDate);
		
		String classroomId = request.getParameter("classroomId");
		String resourceType = request.getParameter("resourceType");
		String predictReason = request.getParameter("predictReason");
		String buildingNum = request.getParameter("buildingNum");
		String roomNum = request.getParameter("roomNum");
		String resourceName=buildingNum+"教"+roomNum;
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();   //获取当前用户，即预订者的用户名（学号）
		
		Classroom classroom = classroomService.getById(classroomId);
		//遍历类中的所有属性
		Field[] fields = timeArrange.getClass().getDeclaredFields();
		for(int i = 0 , len = fields.length; i < len; i++) {
			 // 对于每个属性，获取属性名
			 String varName = fields[i].getName();
			 try {
			 // 获取原来的访问控制权限
			 boolean accessFlag = fields[i].isAccessible();
			 // 修改访问控制权限
			 fields[i].setAccessible(true);
			 // 获取在对象f中属性fields[i]对应的对象中的变量
			 Object o;
			try {
				o = fields[i].get(timeArrange);
				if(o!=null && !o.equals("")){
					if(o.equals("yes")){
						//在插入预定信息前，先检验下是否已经存在该用户预定这个资源的对应时间，防止同一用户重复预定
						PredictTableExample example = new PredictTableExample();
						Criteria criteria = example.createCriteria();
						criteria.andPredictPersonEqualTo(username);
						criteria.andResourceIdEqualTo(classroomId);
						criteria.andResourceTypeEqualTo(resourceType);
						criteria.andPredictTimeEqualTo(varName);
						criteria.andPredictStateEqualTo("1");
						criteria.andResourceNameEqualTo(resourceName);
						criteria.andDelFlagEqualTo("0");
						List<PredictTable> list = predictTableMapper.selectByExample(example);
						if(list.size()>0){
							//返回资源详情页面,弹出已预约的提示框
							int num = Integer.parseInt(buildingNum);
							List<Classroom> list2 = classroomService.findClassroomByBuildingNum(num);
							request.setAttribute("list", list2);
							request.setAttribute("alreadyReserveFlag", "1");  //用于页面判断弹出已预约的提示框
							request.setAttribute("resourceName", resourceName);
							request.setAttribute("predictTime", WeekDateUtil.getChineseDate(varName));
							return "resourceReserve/classroomDetails";
						}
						
						//写入预定信息
						PredictTable predictTable = new PredictTable();
						String id = UUID.randomUUID().toString();
						predictTable.setId(id);
						predictTable.setPredictPerson(username);
						predictTable.setResourceType(resourceType);
						predictTable.setResourceId(classroomId);
						predictTable.setResourceName(resourceName);
						predictTable.setPredictState("1");
						predictTable.setDelFlag("0");
						predictTable.setPredictTime(varName);  //预定的时间段，保存monMorning  这种类型字符串
						predictTable.setPredictReason(predictReason);
						predictTable.setIsRead("0");
						HashMap<String,String> beginAndEndTime = WeekDateUtil.getBeginAndEndTime(varName,weekDate);   //调用工具类获取预定的开始时间和结束时间
						String beginTime = beginAndEndTime.get("beginTime");
						String endTime = beginAndEndTime.get("endTime");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						try {
							predictTable.setBeginTime(sdf.parse(beginTime));
							predictTable.setEndTime(sdf.parse(endTime));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						predictTableMapper.insert(predictTable);
					}
				}
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
				 // 恢复访问控制权限
				 fields[i].setAccessible(accessFlag);
				 } catch (IllegalArgumentException ex) {
				 ex.printStackTrace();
				 } 
			}
		
		//返回资源详情页面
		int i = Integer.parseInt(buildingNum);
		List<Classroom> list = classroomService.findClassroomByBuildingNum(i);
		request.setAttribute("list", list);
		request.setAttribute("reserveFlag", "1");  //用于页面判断弹出提示框
		request.setAttribute("resourceName", resourceName);
		return "resourceReserve/classroomDetails";
	}
	
	
	
}
