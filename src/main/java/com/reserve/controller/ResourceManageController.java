package com.reserve.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reserve.bean.Classroom;
import com.reserve.bean.ClassroomExample;
import com.reserve.bean.ClassroomExample.Criteria;
import com.reserve.bean.LaboratoryBuilding;
import com.reserve.bean.LaboratoryBuildingExample;
import com.reserve.bean.MeetingRoom;
import com.reserve.bean.MeetingRoomExample;
import com.reserve.bean.PredictPerson;
import com.reserve.bean.SportsGround;
import com.reserve.bean.SportsGroundExample;
import com.reserve.bean.TimeArrange;
import com.reserve.dao.ClassroomMapper;
import com.reserve.dao.LaboratoryBuildingMapper;
import com.reserve.dao.MeetingRoomMapper;
import com.reserve.dao.PredictPersonMapper;
import com.reserve.dao.SportsGroundMapper;
import com.reserve.dao.TimeArrangeMapper;
import com.reserve.service.PredictPersonService;
import com.reserve.service.TimeArrangeService;

@Controller
@RequestMapping("/manage")
public class ResourceManageController {

	@Autowired 
	private ClassroomMapper classroomMapper;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private TimeArrangeMapper timeArrangeMapper;
	
	@Autowired
	private PredictPersonMapper predictPersonMapper;
	
	@Autowired 
	private LaboratoryBuildingMapper laboratoryBuildingMapper;
	
	@Autowired
	private MeetingRoomMapper meetingRoomMapper;
	
	@Autowired 
	private SportsGroundMapper sportsGroundMapper;
	
	
	/**
	 * 教学楼
	 * @param classroom
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/classroomListPage")
	public String classroomListPage(Classroom classroom,String pageNum){
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		ClassroomExample example = new ClassroomExample();
		Criteria criteria = example.createCriteria();
		
		if(classroom!=null && !classroom.equals("")){
			if(classroom.getArea()!=null && !classroom.getArea().equals("")){
				criteria.andAreaEqualTo(classroom.getArea());
			}
			if(classroom.getBuildingNum()!=null ){
				criteria.andBuildingNumEqualTo(classroom.getBuildingNum());
			}
			if(classroom.getFloor()!=null ){
				criteria.andFloorEqualTo(classroom.getFloor());
			}
			if(classroom.getMaxPopulation()!=null ){
				criteria.andMaxPopulationEqualTo(classroom.getMaxPopulation());
			}
			if(classroom.getAirConditioner()!=null && !classroom.getAirConditioner().equals("")){
				criteria.andAirConditionerEqualTo(classroom.getAirConditioner());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<Classroom> list = classroomMapper.selectByExample(example);
		PageInfo<Classroom> pageInfo = new PageInfo<>(list);
		if(pagenum>pageInfo.getPages()){
			pageNum=String.valueOf(pageInfo.getPages());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", classroom.getArea());
		request.setAttribute("buildingNum", classroom.getBuildingNum());
		request.setAttribute("floor", classroom.getFloor());
		request.setAttribute("maxPopulation", classroom.getMaxPopulation());
		request.setAttribute("airConditioner", classroom.getAirConditioner());
		return "resourceManage/classroomListPage";
	}
	
	@RequestMapping("/addClassroomPage")
	public String addClassroomPage(){
		Classroom classroom = new Classroom();
		TimeArrange timeArrange = new TimeArrange();
		classroom.setTimeArrange(timeArrange);
		request.setAttribute("classroom", classroom);
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
		return "resourceManage/addClassroomPage";
	}
	
	@RequestMapping("/addClassroom")
	public String addClassroom(Classroom classroom){
		String resourceName=classroom.getBuildingNum()+"教"+classroom.getRoomNum();
		if(classroom.getId()!=null && !classroom.getId().equals("")){
			classroom.getTimeArrange().setDelFlag("0");
			//不知道为什么传过来的timeArrange.id是classroom的id,懒得解决了，直接再根据他查询到timeArrange
			String timeArrangeId = classroomMapper.selectByPrimaryKey(classroom.getId()).getTimeArrangeId();
			classroom.getTimeArrange().setId(timeArrangeId);
			timeArrangeMapper.updateByPrimaryKeySelective(classroom.getTimeArrange());
			classroomMapper.updateByPrimaryKeySelective(classroom);
			request.setAttribute("addSuccess", "1");
			request.setAttribute("updateSuccess", "1");
			request.setAttribute("resourceName", resourceName);
			return "resourceManage/addClassroomPage";
		}else{
			//先判断该资源是否已存在
			ClassroomExample example = new ClassroomExample();
			Criteria criteria = example.createCriteria();
			criteria.andAreaEqualTo(classroom.getArea());
			criteria.andBuildingNumEqualTo(classroom.getBuildingNum());
			criteria.andFloorEqualTo(classroom.getFloor());
			criteria.andRoomNumEqualTo(classroom.getRoomNum());
			criteria.andDelFlagEqualTo("0");
			List<Classroom> list = classroomMapper.selectByExample(example);
			if(list.size()>0){
				request.getSession().setAttribute("resourceName", resourceName);
				request.getSession().setAttribute("existFlag", "1");
				return "redirect:/manage/addClassroomPage";
			}
			
			TimeArrange timeArrange2 = classroom.getTimeArrange();
			String timeArrangeId = UUID.randomUUID().toString();
			timeArrange2.setId(timeArrangeId);
			timeArrange2.setDelFlag("0");
			timeArrangeMapper.insert(timeArrange2);
			String predictPersonId = UUID.randomUUID().toString();
			PredictPerson predictPerson = new PredictPerson();
			predictPerson.setId(predictPersonId);
			predictPerson.setDelFlag("0");
			predictPersonMapper.insert(predictPerson);
			String uuid = UUID.randomUUID().toString();
			classroom.setId(uuid);
			classroom.setDelFlag("0");
			classroom.setTimeArrangeId(timeArrangeId);
			classroom.setPredictPersonId(predictPersonId);
			classroomMapper.insert(classroom);
			//新增标志
			request.getSession().setAttribute("addSuccess", "1");
			request.getSession().setAttribute("resourceName", resourceName);
			return "redirect:/manage/addClassroomPage";
		}
	}
	
	@RequestMapping("/delClassroom")
	public String delClassroom(Classroom classroom,String pageNum,String resourceName){
		classroomMapper.deleteByPrimaryKey(classroom.getId());
		timeArrangeMapper.deleteByPrimaryKey(classroom.getTimeArrangeId());
		predictPersonMapper.deleteByPrimaryKey(classroom.getPredictPersonId());
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		ClassroomExample example = new ClassroomExample();
		Criteria criteria = example.createCriteria();
		
		if(classroom!=null && !classroom.equals("")){
			if(classroom.getArea()!=null && !classroom.getArea().equals("")){
				criteria.andAreaEqualTo(classroom.getArea());
			}
			if(classroom.getBuildingNum()!=null ){
				criteria.andBuildingNumEqualTo(classroom.getBuildingNum());
			}
			if(classroom.getFloor()!=null ){
				criteria.andFloorEqualTo(classroom.getFloor());
			}
			if(classroom.getMaxPopulation()!=null ){
				criteria.andMaxPopulationEqualTo(classroom.getMaxPopulation());
			}
			if(classroom.getAirConditioner()!=null && !classroom.getAirConditioner().equals("")){
				criteria.andAirConditionerEqualTo(classroom.getAirConditioner());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<Classroom> list = classroomMapper.selectByExample(example);
		PageInfo<Classroom> pageInfo = new PageInfo<>(list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", classroom.getArea());
		request.setAttribute("buildingNum", classroom.getBuildingNum());
		request.setAttribute("floor", classroom.getFloor());
		request.setAttribute("maxPopulation", classroom.getMaxPopulation());
		request.setAttribute("airConditioner", classroom.getAirConditioner());
		request.setAttribute("resourceName", resourceName);
		request.setAttribute("delFlag", "1");
		return "resourceManage/classroomListPage";
	}
	
	@RequestMapping("/updateClassroom")
	public String updateClassroom(String id){
		Classroom classroom = classroomMapper.getDetailsById(id);
		request.setAttribute("classroom", classroom);
		return "resourceManage/addClassroomPage";
	}
	
	
	/**
	 * 实验室
	 */
	@RequestMapping("/laboratoryListPage")
	public String laboratoryListPage(LaboratoryBuilding laboratoryBuilding,String pageNum){
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		LaboratoryBuildingExample example = new LaboratoryBuildingExample();
		com.reserve.bean.LaboratoryBuildingExample.Criteria criteria = example.createCriteria();
		
		if(laboratoryBuilding!=null && !laboratoryBuilding.equals("")){
			if(laboratoryBuilding.getArea()!=null && !laboratoryBuilding.getArea().equals("")){
				criteria.andAreaEqualTo(laboratoryBuilding.getArea());
			}
			if(laboratoryBuilding.getBuildingNum()!=null ){
				criteria.andBuildingNumEqualTo(laboratoryBuilding.getBuildingNum());
			}
			if(laboratoryBuilding.getFloor()!=null ){
				criteria.andFloorEqualTo(laboratoryBuilding.getFloor());
			}
			if(laboratoryBuilding.getMaxPopulation()!=null ){
				criteria.andMaxPopulationEqualTo(laboratoryBuilding.getMaxPopulation());
			}
			if(laboratoryBuilding.getAirConditioner()!=null && !laboratoryBuilding.getAirConditioner().equals("")){
				criteria.andAirConditionerEqualTo(laboratoryBuilding.getAirConditioner());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<LaboratoryBuilding> list = laboratoryBuildingMapper.selectByExample(example);
		PageInfo<LaboratoryBuilding> pageInfo = new PageInfo<>(list);
		if(pagenum>pageInfo.getPages()){
			pageNum=String.valueOf(pageInfo.getPages());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", laboratoryBuilding.getArea());
		request.setAttribute("buildingNum", laboratoryBuilding.getBuildingNum());
		request.setAttribute("floor", laboratoryBuilding.getFloor());
		request.setAttribute("maxPopulation", laboratoryBuilding.getMaxPopulation());
		request.setAttribute("airConditioner", laboratoryBuilding.getAirConditioner());
		request.setAttribute("laboratoryFlag", "1");  //实验室的标志位
		return "resourceManage/laboratoryListPage";
	}
	
	@RequestMapping("/addLaboratoryPage")
	public String addLaboratoryPage(){
		LaboratoryBuilding laboratoryBuilding = new LaboratoryBuilding();
		TimeArrange timeArrange = new TimeArrange();
		laboratoryBuilding.setTimeArrange(timeArrange);
		request.setAttribute("laboratoryBuilding", laboratoryBuilding);
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
		return "resourceManage/addLaboratoryPage";
	}
	
	@RequestMapping("/addLaboratory")
	public String addLaboratory(LaboratoryBuilding laboratoryBuilding){
		String resourceName=laboratoryBuilding.getBuildingNum()+"实"+laboratoryBuilding.getRoomNum();
		if(laboratoryBuilding.getId()!=null && !laboratoryBuilding.getId().equals("")){
			laboratoryBuilding.getTimeArrange().setDelFlag("0");
			//不知道为什么传过来的timeArrange.id是classroom的id,懒得解决了，直接再根据他查询到timeArrange
			String timeArrangeId = laboratoryBuildingMapper.selectByPrimaryKey(laboratoryBuilding.getId()).getTimeArrangeId();
			laboratoryBuilding.getTimeArrange().setId(timeArrangeId);
			timeArrangeMapper.updateByPrimaryKeySelective(laboratoryBuilding.getTimeArrange());
			laboratoryBuildingMapper.updateByPrimaryKeySelective(laboratoryBuilding);
			request.setAttribute("addSuccess", "1");
			request.setAttribute("updateSuccess", "1");
			request.setAttribute("resourceName", resourceName);
			return "resourceManage/addLaboratoryPage";
		}else{
			//先判断该资源是否已存在
			LaboratoryBuildingExample example = new LaboratoryBuildingExample();
			com.reserve.bean.LaboratoryBuildingExample.Criteria criteria = example.createCriteria();
			criteria.andAreaEqualTo(laboratoryBuilding.getArea());
			criteria.andBuildingNumEqualTo(laboratoryBuilding.getBuildingNum());
			criteria.andFloorEqualTo(laboratoryBuilding.getFloor());
			criteria.andRoomNumEqualTo(laboratoryBuilding.getRoomNum());
			criteria.andDelFlagEqualTo("0");
			List<LaboratoryBuilding> list = laboratoryBuildingMapper.selectByExample(example);
			if(list.size()>0){
				request.getSession().setAttribute("resourceName", resourceName);
				request.getSession().setAttribute("existFlag", "1");
				return "redirect:/manage/addLaboratoryPage";
			}
			
			TimeArrange timeArrange2 = laboratoryBuilding.getTimeArrange();
			String timeArrangeId = UUID.randomUUID().toString();
			timeArrange2.setId(timeArrangeId);
			timeArrange2.setDelFlag("0");
			timeArrangeMapper.insert(timeArrange2);
			String predictPersonId = UUID.randomUUID().toString();
			PredictPerson predictPerson = new PredictPerson();
			predictPerson.setId(predictPersonId);
			predictPerson.setDelFlag("0");
			predictPersonMapper.insert(predictPerson);
			String uuid = UUID.randomUUID().toString();
			laboratoryBuilding.setId(uuid);
			laboratoryBuilding.setDelFlag("0");
			laboratoryBuilding.setTimeArrangeId(timeArrangeId);
			laboratoryBuilding.setPredictPersonId(predictPersonId);
			laboratoryBuildingMapper.insert(laboratoryBuilding);
			//新增标志
			request.getSession().setAttribute("addSuccess", "1");
			request.getSession().setAttribute("resourceName", resourceName);
			return "redirect:/manage/addLaboratoryPage";
		}
	}
	
	@RequestMapping("/delLaboratory")
	public String delLaboratory(LaboratoryBuilding laboratoryBuilding,String pageNum,String resourceName){
		laboratoryBuildingMapper.deleteByPrimaryKey(laboratoryBuilding.getId());
		timeArrangeMapper.deleteByPrimaryKey(laboratoryBuilding.getTimeArrangeId());
		predictPersonMapper.deleteByPrimaryKey(laboratoryBuilding.getPredictPersonId());
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		LaboratoryBuildingExample example = new LaboratoryBuildingExample();
		com.reserve.bean.LaboratoryBuildingExample.Criteria criteria = example.createCriteria();
		if(laboratoryBuilding!=null && !laboratoryBuilding.equals("")){
			if(laboratoryBuilding.getArea()!=null && !laboratoryBuilding.getArea().equals("")){
				criteria.andAreaEqualTo(laboratoryBuilding.getArea());
			}
			if(laboratoryBuilding.getBuildingNum()!=null ){
				criteria.andBuildingNumEqualTo(laboratoryBuilding.getBuildingNum());
			}
			if(laboratoryBuilding.getFloor()!=null ){
				criteria.andFloorEqualTo(laboratoryBuilding.getFloor());
			}
			if(laboratoryBuilding.getMaxPopulation()!=null ){
				criteria.andMaxPopulationEqualTo(laboratoryBuilding.getMaxPopulation());
			}
			if(laboratoryBuilding.getAirConditioner()!=null && !laboratoryBuilding.getAirConditioner().equals("")){
				criteria.andAirConditionerEqualTo(laboratoryBuilding.getAirConditioner());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<LaboratoryBuilding> list = laboratoryBuildingMapper.selectByExample(example);
		PageInfo<LaboratoryBuilding> pageInfo = new PageInfo<>(list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", laboratoryBuilding.getArea());
		request.setAttribute("buildingNum", laboratoryBuilding.getBuildingNum());
		request.setAttribute("floor", laboratoryBuilding.getFloor());
		request.setAttribute("maxPopulation", laboratoryBuilding.getMaxPopulation());
		request.setAttribute("airConditioner", laboratoryBuilding.getAirConditioner());
		request.setAttribute("resourceName", resourceName);
		request.setAttribute("delFlag", "1");
		return "resourceManage/laboratoryListPage";
	}
	
	@RequestMapping("/updateLaboratory")
	public String updateLaboratory(String id){
		LaboratoryBuilding laboratoryBuilding = laboratoryBuildingMapper.getDetailsById(id);
		request.setAttribute("laboratoryBuilding", laboratoryBuilding);
		return "resourceManage/addLaboratoryPage";
	}
	
	/**
	 * 会议室
	 */
	@RequestMapping("/meetingListPage")
	public String meetingListPage(MeetingRoom meetingRoom,String pageNum){
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		MeetingRoomExample example = new MeetingRoomExample();
		com.reserve.bean.MeetingRoomExample.Criteria criteria = example.createCriteria();
		
		if(meetingRoom!=null && !meetingRoom.equals("")){
			if(meetingRoom.getArea()!=null && !meetingRoom.getArea().equals("")){
				criteria.andAreaEqualTo(meetingRoom.getArea());
			}
			if(meetingRoom.getBuildingNum()!=null ){
				criteria.andBuildingNumEqualTo(meetingRoom.getBuildingNum());
			}
			if(meetingRoom.getFloor()!=null ){
				criteria.andFloorEqualTo(meetingRoom.getFloor());
			}
			if(meetingRoom.getMaxPopulation()!=null ){
				criteria.andMaxPopulationEqualTo(meetingRoom.getMaxPopulation());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<MeetingRoom> list = meetingRoomMapper.selectByExample(example);
		PageInfo<MeetingRoom> pageInfo = new PageInfo<>(list);
		if(pagenum>pageInfo.getPages()){
			pageNum=String.valueOf(pageInfo.getPages());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", meetingRoom.getArea());
		request.setAttribute("buildingNum", meetingRoom.getBuildingNum());
		request.setAttribute("floor", meetingRoom.getFloor());
		request.setAttribute("maxPopulation", meetingRoom.getMaxPopulation());
		return "resourceManage/meetingListPage";
	}
	
	@RequestMapping("/addMeetingPage")
	public String addMeetingPage(){
		MeetingRoom meetingRoom = new MeetingRoom();
		TimeArrange timeArrange = new TimeArrange();
		meetingRoom.setTimeArrange(timeArrange);
		request.setAttribute("meetingRoom", meetingRoom);
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
		return "resourceManage/addMeetingPage";
	}
	
	@RequestMapping("/addMeeting")
	public String addMeeting(MeetingRoom meetingRoom){
		String resourceName=meetingRoom.getBuildingNum()+"教"+meetingRoom.getRoomNum();
		if(meetingRoom.getId()!=null && !meetingRoom.getId().equals("")){
			meetingRoom.getTimeArrange().setDelFlag("0");
			//不知道为什么传过来的timeArrange.id是classroom的id,懒得解决了，直接再根据他查询到timeArrange
			String timeArrangeId = meetingRoomMapper.selectByPrimaryKey(meetingRoom.getId()).getTimeArrangeId();
			meetingRoom.getTimeArrange().setId(timeArrangeId);
			timeArrangeMapper.updateByPrimaryKeySelective(meetingRoom.getTimeArrange());
			meetingRoomMapper.updateByPrimaryKeySelective(meetingRoom);
			request.setAttribute("addSuccess", "1");
			request.setAttribute("updateSuccess", "1");
			request.setAttribute("resourceName", resourceName);
			return "resourceManage/addMeetingPage";
		}else{
			//先判断该资源是否已存在
			MeetingRoomExample example = new MeetingRoomExample();
			com.reserve.bean.MeetingRoomExample.Criteria criteria = example.createCriteria();
			criteria.andAreaEqualTo(meetingRoom.getArea());
			criteria.andBuildingNumEqualTo(meetingRoom.getBuildingNum());
			criteria.andFloorEqualTo(meetingRoom.getFloor());
			criteria.andRoomNumEqualTo(meetingRoom.getRoomNum());
			criteria.andDelFlagEqualTo("0");
			List<MeetingRoom> list = meetingRoomMapper.selectByExample(example);
			if(list.size()>0){
				request.getSession().setAttribute("resourceName", resourceName);
				request.getSession().setAttribute("existFlag", "1");
				return "redirect:/manage/addMeetingPage";
			}
			
			TimeArrange timeArrange2 = meetingRoom.getTimeArrange();
			String timeArrangeId = UUID.randomUUID().toString();
			timeArrange2.setId(timeArrangeId);
			timeArrange2.setDelFlag("0");
			timeArrangeMapper.insert(timeArrange2);
			String predictPersonId = UUID.randomUUID().toString();
			PredictPerson predictPerson = new PredictPerson();
			predictPerson.setId(predictPersonId);
			predictPerson.setDelFlag("0");
			predictPersonMapper.insert(predictPerson);
			String uuid = UUID.randomUUID().toString();
			meetingRoom.setId(uuid);
			meetingRoom.setDelFlag("0");
			meetingRoom.setTimeArrangeId(timeArrangeId);
			meetingRoom.setPredictPersonId(predictPersonId);
			meetingRoomMapper.insert(meetingRoom);
			//新增标志
			request.getSession().setAttribute("addSuccess", "1");
			request.getSession().setAttribute("resourceName", resourceName);
			return "redirect:/manage/addMeetingPage";
		}
	}
	
	@RequestMapping("/delMeeting")
	public String delMeeting(MeetingRoom meetingRoom,String pageNum,String resourceName){
		meetingRoomMapper.deleteByPrimaryKey(meetingRoom.getId());
		timeArrangeMapper.deleteByPrimaryKey(meetingRoom.getTimeArrangeId());
		predictPersonMapper.deleteByPrimaryKey(meetingRoom.getPredictPersonId());
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		MeetingRoomExample example = new MeetingRoomExample();
		com.reserve.bean.MeetingRoomExample.Criteria criteria = example.createCriteria();
		if(meetingRoom!=null && !meetingRoom.equals("")){
			if(meetingRoom.getArea()!=null && !meetingRoom.getArea().equals("")){
				criteria.andAreaEqualTo(meetingRoom.getArea());
			}
			if(meetingRoom.getBuildingNum()!=null ){
				criteria.andBuildingNumEqualTo(meetingRoom.getBuildingNum());
			}
			if(meetingRoom.getFloor()!=null ){
				criteria.andFloorEqualTo(meetingRoom.getFloor());
			}
			if(meetingRoom.getMaxPopulation()!=null ){
				criteria.andMaxPopulationEqualTo(meetingRoom.getMaxPopulation());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<MeetingRoom> list = meetingRoomMapper.selectByExample(example);
		PageInfo<MeetingRoom> pageInfo = new PageInfo<>(list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", meetingRoom.getArea());
		request.setAttribute("buildingNum", meetingRoom.getBuildingNum());
		request.setAttribute("floor", meetingRoom.getFloor());
		request.setAttribute("maxPopulation", meetingRoom.getMaxPopulation());
		request.setAttribute("resourceName", resourceName);
		request.setAttribute("delFlag", "1");
		return "resourceManage/meetingListPage";
	}
	
	@RequestMapping("/updateMeeting")
	public String updateMeeting(String id){
		MeetingRoom meetingRoom = meetingRoomMapper.getDetailsById(id);
		request.setAttribute("meetingRoom", meetingRoom);
		return "resourceManage/addMeetingPage";
	}
	
	
	/**
	 * 体育场地
	 * @param classroom
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/sportListPage")
	public String sportListPage(SportsGround sportsGround,String pageNum){
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		SportsGroundExample example = new SportsGroundExample();
		com.reserve.bean.SportsGroundExample.Criteria criteria = example.createCriteria();
		
		if(sportsGround!=null && !sportsGround.equals("")){
			if(sportsGround.getArea()!=null && !sportsGround.getArea().equals("")){
				criteria.andAreaEqualTo(sportsGround.getArea());
			}
			if(sportsGround.getName()!=null && !sportsGround.getName().equals("")){
				criteria.andNameLike("%"+sportsGround.getName()+"%");   //必须要拼两个百分号才可以模糊查询
			}
			if(sportsGround.getSpace()!=null && !sportsGround.getSpace().equals("")){
				criteria.andSpaceLessThanOrEqualTo(sportsGround.getSpace());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<SportsGround> list = sportsGroundMapper.selectByExample(example);
		PageInfo<SportsGround> pageInfo = new PageInfo<>(list);
		if(pagenum>pageInfo.getPages()){
			pageNum=String.valueOf(pageInfo.getPages());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", sportsGround.getArea());
		request.setAttribute("name", sportsGround.getName());
		request.setAttribute("space", sportsGround.getSpace());
		return "resourceManage/sportListPage";
	}
	
	@RequestMapping("/addSportPage")
	public String addSportPage(){
		SportsGround sportsGround = new SportsGround();
		TimeArrange timeArrange = new TimeArrange();
		sportsGround.setTimeArrange(timeArrange);
		request.setAttribute("sportsGround", sportsGround);
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
		return "resourceManage/addSportPage";
	}
	
	@RequestMapping("/addSport")
	public String addSport(SportsGround sportsGround){
		String resourceName=sportsGround.getName();
		if(sportsGround.getId()!=null && !sportsGround.getId().equals("")){
			sportsGround.getTimeArrange().setDelFlag("0");
			//不知道为什么传过来的timeArrange.id是classroom的id,懒得解决了，直接再根据他查询到timeArrange
			String timeArrangeId = sportsGroundMapper.selectByPrimaryKey(sportsGround.getId()).getTimeArrangeId();
			sportsGround.getTimeArrange().setId(timeArrangeId);
			timeArrangeMapper.updateByPrimaryKeySelective(sportsGround.getTimeArrange());
			sportsGroundMapper.updateByPrimaryKeySelective(sportsGround);
			request.setAttribute("addSuccess", "1");
			request.setAttribute("updateSuccess", "1");
			request.setAttribute("resourceName", resourceName);
			return "resourceManage/addSportPage";
		}else{
			//先判断该资源是否已存在
			SportsGroundExample example = new SportsGroundExample();
			com.reserve.bean.SportsGroundExample.Criteria criteria = example.createCriteria();
			criteria.andAreaEqualTo(sportsGround.getArea());
			criteria.andNameEqualTo(sportsGround.getName());
			List<SportsGround> list = sportsGroundMapper.selectByExample(example);
			if(list.size()>0){
				request.getSession().setAttribute("resourceName", resourceName);
				request.getSession().setAttribute("existFlag", "1");
				return "redirect:/manage/addSportPage";
			}
			
			TimeArrange timeArrange2 = sportsGround.getTimeArrange();
			String timeArrangeId = UUID.randomUUID().toString();
			timeArrange2.setId(timeArrangeId);
			timeArrange2.setDelFlag("0");
			timeArrangeMapper.insert(timeArrange2);
			String predictPersonId = UUID.randomUUID().toString();
			PredictPerson predictPerson = new PredictPerson();
			predictPerson.setId(predictPersonId);
			predictPerson.setDelFlag("0");
			predictPersonMapper.insert(predictPerson);
			String uuid = UUID.randomUUID().toString();
			sportsGround.setId(uuid);
			sportsGround.setDelFlag("0");
			sportsGround.setTimeArrangeId(timeArrangeId);
			sportsGround.setPredictPersonId(predictPersonId);
			sportsGroundMapper.insert(sportsGround);
			//新增标志
			request.getSession().setAttribute("addSuccess", "1");
			request.getSession().setAttribute("resourceName", resourceName);
			return "redirect:/manage/addSportPage";
		}
	}
	
	@RequestMapping("/delSport")
	public String delSport(SportsGround sportsGround,String pageNum,String resourceName){
		sportsGroundMapper.deleteByPrimaryKey(sportsGround.getId());
		timeArrangeMapper.deleteByPrimaryKey(sportsGround.getTimeArrangeId());
		predictPersonMapper.deleteByPrimaryKey(sportsGround.getPredictPersonId());
		//防止数据不正常
		if(pageNum==null || pageNum.equals("")){
			pageNum="1";
		}
		SportsGroundExample example = new SportsGroundExample();
		com.reserve.bean.SportsGroundExample.Criteria criteria = example.createCriteria();
		
		if(sportsGround!=null && !sportsGround.equals("")){
			if(sportsGround.getArea()!=null && !sportsGround.getArea().equals("")){
				criteria.andAreaEqualTo(sportsGround.getArea());
			}
			if(sportsGround.getName()!=null && !sportsGround.getName().equals("")){
				criteria.andNameEqualTo(sportsGround.getName());
			}
			if(sportsGround.getSpace()!=null && !sportsGround.getSpace().equals("")){
				criteria.andSpaceEqualTo(sportsGround.getSpace());
			}
		}
		criteria.andDelFlagEqualTo("0");
		int pagenum = Integer.parseInt(pageNum);  //当前页数
		int pageSize=16;    //一页的数据量
		PageHelper.startPage(pagenum,pageSize);
		List<SportsGround> list = sportsGroundMapper.selectByExample(example);
		PageInfo<SportsGround> pageInfo = new PageInfo<>(list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pages", String.valueOf(pageInfo.getPages()));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("area", sportsGround.getArea());
		request.setAttribute("name", sportsGround.getName());
		request.setAttribute("space", sportsGround.getSpace());
		request.setAttribute("resourceName", resourceName);
		request.setAttribute("delFlag", "1");
		return "resourceManage/sportListPage";
	}
	
	@RequestMapping("/updateSport")
	public String updateSport(String id){
		SportsGround sportsGround = sportsGroundMapper.getDetailsById(id);
		request.setAttribute("sportsGround", sportsGround);
		return "resourceManage/addSportPage";
	}
	
	
}
