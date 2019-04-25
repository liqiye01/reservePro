package com.reserve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.reserve.bean.Classroom;
import com.reserve.bean.LaboratoryBuilding;
import com.reserve.bean.MeetingRoom;
import com.reserve.bean.PredictPerson;
import com.reserve.bean.PredictTable;
import com.reserve.bean.RejectTable;
import com.reserve.bean.RejectTableExample;
import com.reserve.bean.SportsGround;
import com.reserve.bean.TimeArrange;
import com.reserve.bean.User;
import com.reserve.bean.UserExample;
import com.reserve.bean.UserExample.Criteria;
import com.reserve.dao.UserMapper;
import com.reserve.service.ClassroomService;
import com.reserve.service.LaboratoryService;
import com.reserve.service.MeetingService;
import com.reserve.service.PredictPersonService;
import com.reserve.service.PredictTableService;
import com.reserve.service.RejectTableService;
import com.reserve.service.SportService;
import com.reserve.service.TimeArrangeService;


/**
 * 资源分配的controller
 * @author liqiye
 *
 */

@Controller
@RequestMapping("/distribution")
public class DistributionController {
	
	private static final boolean TimeArrangeExample = false;

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private PredictTableService predictTableService;
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private TimeArrangeService timeArrangeService;
	
	@Autowired 
	private PredictPersonService predictPersonService;
	
	@Autowired
	private RejectTableService rejectTableService;
	
	@Autowired
	private LaboratoryService laboratoryService;
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private UserMapper userMapper;
	
	
	//资源分配列表
	@RequestMapping("/resource")
	public String distributionList(String type,String state){ 
		
		List<PredictTable> list = predictTableService.getPredictListByType(type,state);
		request.setAttribute("list", list);
		request.setAttribute("type", type);
		request.setAttribute("state", state);
		return "resourceDistribution/resourceDistribution";
	}
	
	//批准
	@RequestMapping("/approval")
	public String approval(String type,String id){
		PredictTable predictTable = predictTableService.getById(id);
		predictTable.setPredictState("2");
		predictTable.setIsRead("0");
		predictTableService.save(predictTable);
		String predictTime = predictTable.getPredictTime();   //预定的时间段   monMorning 类型的字符串
		String resourceId = predictTable.getResourceId();
		List<PredictTable> list2= predictTableService.getListByResourceId(resourceId);  //通过类型和资源Id找到所有数据
		//批准了一个，将其他预定的资源中，资源一样预定时间一样的数据改成驳回，并写进驳回表
		for (PredictTable predictTable2 : list2) {
			if(!predictTable2.getId().equals(id) && predictTable2.getPredictTime().equals(predictTime)){
				predictTable2.setPredictState("3");
				predictTableService.save(predictTable2);
				//驳回后将数据写进驳回表，用于用户登录后提示，过期定时器自动删除
				RejectTable rejectTable = new RejectTable();
				String uuid = UUID.randomUUID().toString();
				rejectTable.setId(uuid);
				rejectTable.setEndTime(predictTable2.getEndTime());
				rejectTable.setPredictor(predictTable2.getPredictPerson());
				rejectTable.setPredictTime(predictTable2.getPredictTime());
				rejectTable.setResourceType(type);
				rejectTable.setResourceId(predictTable2.getResourceId());
				rejectTable.setResourceName(predictTable2.getResourceName());
				rejectTable.setIsRead("0");
				rejectTable.setDelFlag("0");
				rejectTableService.save(rejectTable);
			}
		}
		
		User user = (User)request.getSession().getAttribute("user");
		String username = user.getUsername();
		
		TimeArrange timeArrange=null;
		PredictPerson predictPerson=null;
		
		if(type.equals("1")){
			Classroom classroom = classroomService.getById(resourceId);
			String timeArrangeId = classroom.getTimeArrangeId();
			String predictPersonId = classroom.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}else if(type.equals("2")){
			LaboratoryBuilding laboratoryBuilding = laboratoryService.getById(resourceId);
			String timeArrangeId = laboratoryBuilding.getTimeArrangeId();
			String predictPersonId = laboratoryBuilding.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}else if(type.equals("3")){
			SportsGround sportsGround = sportService.getById(resourceId);
			String timeArrangeId = sportsGround.getTimeArrangeId();
			String predictPersonId = sportsGround.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}else if(type.equals("4")){
			MeetingRoom meetingRoom = meetingService.getById(resourceId);
			String timeArrangeId = meetingRoom.getTimeArrangeId();
			String predictPersonId = meetingRoom.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}
		
		if(predictTime.equals("monMorning")){
			timeArrange.setMonMorning("4");
			predictPerson.setMonMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("monAfternoon")){
			timeArrange.setMonAfternoon("4");
			predictPerson.setMonAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("monEvening")){
			timeArrange.setMonEvening("4");
			predictPerson.setMonEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("tueMorning")){
			timeArrange.setTueMorning("4");
			predictPerson.setTueMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("tueAfternoon")){
			timeArrange.setTueAfternoon("4");
			predictPerson.setTueAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("tueEvening")){
			timeArrange.setTueEvening("4");
			predictPerson.setTueEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("wedMorning")){
			timeArrange.setWedMorning("4");
			predictPerson.setWedMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("wedAfternoon")){
			timeArrange.setWedAfternoon("4");
			predictPerson.setWedAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("wedEvening")){
			timeArrange.setWedEvening("4");
			predictPerson.setWedEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("thuMorning")){
			timeArrange.setThuMorning("4");
			predictPerson.setThuMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("thuAfternoon")){
			timeArrange.setThuAfternoon("4");
			predictPerson.setThuAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("thuEvening")){
			timeArrange.setThuEvening("4");
			predictPerson.setThuEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("friMorning")){
			timeArrange.setFriMorning("4");
			predictPerson.setFriMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("friAfternoon")){
			timeArrange.setFriAfternoon("4");
			predictPerson.setFriAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("friEvening")){
			timeArrange.setFriEvening("4");
			predictPerson.setFriEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("satMorning")){
			timeArrange.setSatMorning("4");
			predictPerson.setSatMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("satAfternoon")){
			timeArrange.setSatAfternoon("4");
			predictPerson.setSatAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("satEvening")){
			timeArrange.setSatEvening("4");
			predictPerson.setSatEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("sunMorning")){
			timeArrange.setSunMorning("4");
			predictPerson.setSunMorning(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("sunAfternoon")){
			timeArrange.setSunAfternoon("4");
			predictPerson.setSunAfternoon(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("sunEvening")){
			timeArrange.setSunEvening("4");
			predictPerson.setSunEvening(username);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		
		request.setAttribute("type", type);
		request.setAttribute("state", "1");
		List<PredictTable> list = predictTableService.getPredictListByType(type,"1");
		request.setAttribute("list", list);
		return "resourceDistribution/resourceDistribution";
	}
	
	//驳回
	@RequestMapping("/reject")
	public String reject(String type,String id){
		PredictTable predictTable = predictTableService.getById(id);
		predictTable.setPredictState("3");
		predictTableService.save(predictTable);
		//驳回后将数据写进驳回表，用于用户登录后提示，用户登录后或者过期定时器自动删除
		RejectTable rejectTable = new RejectTable();
		String uuid = UUID.randomUUID().toString();
		rejectTable.setId(uuid);
		rejectTable.setEndTime(predictTable.getEndTime());
		rejectTable.setPredictor(predictTable.getPredictPerson());
		rejectTable.setPredictTime(predictTable.getPredictTime());
		rejectTable.setResourceType(type);
		rejectTable.setResourceId(predictTable.getResourceId());
		rejectTable.setResourceName(predictTable.getResourceName());
		rejectTable.setIsRead("0");
		rejectTable.setDelFlag("0");
		rejectTableService.save(rejectTable);
		
		request.setAttribute("type", type);
		request.setAttribute("state", "1");
		List<PredictTable> list = predictTableService.getPredictListByType(type,"1");
		request.setAttribute("list", list);
		return "resourceDistribution/resourceDistribution";
	}
	
	//撤销批准
	@RequestMapping("/revokeApproval")
	public String revokeApproval(String type,String id){
		PredictTable predictTable = predictTableService.getById(id);
		predictTable.setPredictState("1");
		predictTableService.save(predictTable);
		//撤销的数据同步到对应的时间安排表，和预订者表
		String resourceId = predictTable.getResourceId();   //资源的Id
		String predictTime = predictTable.getPredictTime();
		
		TimeArrange timeArrange=null;
		PredictPerson predictPerson=null;
		if(type.equals("1")){
			Classroom classroom = classroomService.getById(resourceId);
			String timeArrangeId = classroom.getTimeArrangeId();
			String predictPersonId = classroom.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}else if(type.equals("2")){
			LaboratoryBuilding laboratoryBuilding = laboratoryService.getById(resourceId);
			String timeArrangeId = laboratoryBuilding.getTimeArrangeId();
			String predictPersonId = laboratoryBuilding.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}else if(type.equals("3")){
			SportsGround sportsGround = sportService.getById(resourceId);
			String timeArrangeId = sportsGround.getTimeArrangeId();
			String predictPersonId = sportsGround.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}else if(type.equals("4")){
			MeetingRoom meetingRoom = meetingService.getById(resourceId);
			String timeArrangeId = meetingRoom.getTimeArrangeId();
			String predictPersonId = meetingRoom.getPredictPersonId();
			timeArrange = timeArrangeService.getById(timeArrangeId);
			predictPerson = predictPersonService.getById(predictPersonId);
		}
			
		if(predictTime.equals("monMorning")){
			timeArrange.setMonMorning("2");
			predictPerson.setMonMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
			
		}
		if(predictTime.equals("monAfternoon")){
			timeArrange.setMonAfternoon("2");
			predictPerson.setMonAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("monEvening")){
			timeArrange.setMonEvening("2");
			predictPerson.setMonEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("tueMorning")){
			timeArrange.setTueMorning("2");
			predictPerson.setTueMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("tueAfternoon")){
			timeArrange.setTueAfternoon("2");
			predictPerson.setTueAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("tueEvening")){
			timeArrange.setTueEvening("2");
			predictPerson.setTueEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("wedMorning")){
			timeArrange.setWedMorning("2");
			predictPerson.setWedMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("wedAfternoon")){
			timeArrange.setWedAfternoon("2");
			predictPerson.setWedAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("wedEvening")){
			timeArrange.setWedEvening("2");
			predictPerson.setWedEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("thuMorning")){
			timeArrange.setThuMorning("2");
			predictPerson.setThuMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("thuAfternoon")){
			timeArrange.setThuAfternoon("2");
			predictPerson.setThuAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("thuEvening")){
			timeArrange.setThuEvening("2");
			predictPerson.setThuEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("friMorning")){
			timeArrange.setFriMorning("2");
			predictPerson.setFriMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("friAfternoon")){
			timeArrange.setFriAfternoon("2");
			predictPerson.setFriAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("friEvening")){
			timeArrange.setFriEvening("2");
			predictPerson.setFriEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("satMorning")){
			timeArrange.setSatMorning("2");
			predictPerson.setSatMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("satAfternoon")){
			timeArrange.setSatAfternoon("2");
			predictPerson.setSatAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("satEvening")){
			timeArrange.setSatEvening("2");
			predictPerson.setSatEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("sunMorning")){
			timeArrange.setSunMorning("2");
			predictPerson.setSunMorning(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("sunAfternoon")){
			timeArrange.setSunAfternoon("2");
			predictPerson.setSunAfternoon(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		if(predictTime.equals("sunEvening")){
			timeArrange.setSunEvening("2");
			predictPerson.setSunEvening(null);
			timeArrangeService.updateByPrimaryKeySelective(timeArrange);
			predictPersonService.updateByPrimaryKeySelective(predictPerson);
		}
		
		request.setAttribute("type", type);
		request.setAttribute("state", "2");
		List<PredictTable> list = predictTableService.getPredictListByType(type,"2");
		request.setAttribute("list", list);
		return "resourceDistribution/resourceDistribution";
	}
	
	//撤销驳回
	@RequestMapping("/revokeReject")
	public String revokeReject(String type,String id){
		PredictTable predictTable = predictTableService.getById(id);
		predictTable.setPredictState("1");
		predictTableService.save(predictTable);
		//撤销驳回后，还要将驳回表中的对应数据删除
		String resourceId = predictTable.getResourceId();
		String predictTime = predictTable.getPredictTime();
		String predictPerson = predictTable.getPredictPerson();
		RejectTableExample example = new RejectTableExample();
		com.reserve.bean.RejectTableExample.Criteria criteria = example.createCriteria();
		criteria.andResourceIdEqualTo(resourceId);
		criteria.andPredictTimeEqualTo(predictTime);
		criteria.andPredictorEqualTo(predictPerson);
		rejectTableService.deleteByExample(example);
		
		request.setAttribute("type", type);
		request.setAttribute("state", "3");
		List<PredictTable> list = predictTableService.getPredictListByType(type,"3");
		request.setAttribute("list", list);
		return "resourceDistribution/resourceDistribution";
	}
	
	@RequestMapping(value ="/getUserMsg",produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String getUserMsg(String username){
		if(username.equals("") || username==null){
			username="1";
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andDelFlagEqualTo("0");
		User user = userMapper.selectByExample(example).get(0);
		String username2 = user.getUsername();
		String trueName = user.getTureName();
		String gender = user.getGender();
		String major = user.getMajor();
		String classnum = user.getClassnum();
		String level = user.getLevel();
		String data="";
		data="{\"username\":\""+username2+"\",\"tureName\":\""+trueName+"\",\"level\":\""+level+"\",\"major\":\""+major
				+"\",\"classnum\":\""+classnum+"\",\"gender\":\""+gender+"\"}";
		return data;
	}
	
	
}
