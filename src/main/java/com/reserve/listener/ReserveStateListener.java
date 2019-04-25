package com.reserve.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.reserve.bean.Classroom;
import com.reserve.bean.LaboratoryBuilding;
import com.reserve.bean.MeetingRoom;
import com.reserve.bean.PredictPerson;
import com.reserve.bean.PredictTable;
import com.reserve.bean.PredictTableExample;
import com.reserve.bean.PredictTableExample.Criteria;
import com.reserve.bean.RejectTable;
import com.reserve.bean.RejectTableExample;
import com.reserve.bean.SportsGround;
import com.reserve.bean.TimeArrange;
import com.reserve.dao.ClassroomMapper;
import com.reserve.dao.LaboratoryBuildingMapper;
import com.reserve.dao.MeetingRoomMapper;
import com.reserve.dao.PredictPersonMapper;
import com.reserve.dao.PredictTableMapper;
import com.reserve.dao.RejectTableMapper;
import com.reserve.dao.SportsGroundMapper;
import com.reserve.dao.TimeArrangeMapper;


/**
 * 项目启动就执行的类
 * 用于判断当前时间，对比预定表与驳回表的数据的结束时间，大于或等于则删除数据，修改状态及对应的信息
 * @author liqiye
 *
 */
@Component
public class ReserveStateListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private PredictTableMapper predictTableMapper;
	
	@Autowired
	private RejectTableMapper rejectTableMapper;
	
	@Autowired
	private ClassroomMapper classroomMapper;
	
	@Autowired
	private LaboratoryBuildingMapper laboratoryBuildingMapper;
	
	@Autowired
	private SportsGroundMapper sportsGroundMapper;
	
	@Autowired 
	private MeetingRoomMapper meetingRoomMapper;
	
	@Autowired
	private TimeArrangeMapper timeArrangeMapper;
	
	@Autowired
	private PredictPersonMapper predictPersonMapper;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			Runnable runnable = new Runnable() {  
	            public void run() {  
	            	//定时器每次执行的代码
	            	System.out.println("删除过期的预定和驳回数据并同步修改 (每十分钟执行一次)");
	            	System.out.println("若想修改执行的频率，请到ReserveStateListener.java文件修改");
	            	Calendar calendar = Calendar.getInstance();
	            	Date curentTime = calendar.getTime();   //当前时间
	            	PredictTableExample example = new PredictTableExample();
	            	Criteria criteria = example.createCriteria();
	            	criteria.andDelFlagEqualTo("0");
	            	List<PredictTable> predictList = predictTableMapper.selectByExample(example);
	            	for (PredictTable predictTable : predictList) {
						Date endTime = predictTable.getEndTime();
						if(curentTime.after(endTime)){
							predictTable.setDelFlag("1");
							predictTableMapper.updateByPrimaryKeySelective(predictTable);  //逻辑删除预定表过期数据
							String resourceType = predictTable.getResourceType();  //资源类型
							String resourceId = predictTable.getResourceId();
							String predictTime = predictTable.getPredictTime();  //预定的时间
							if(predictTable.getPredictState().equals("2")){
								if(resourceType.equals("1")){
									Classroom classroom = classroomMapper.selectByPrimaryKey(resourceId);
									String timeArrangeId = classroom.getTimeArrangeId();
									String predictPersonId = classroom.getPredictPersonId();
									TimeArrange timeArrange = timeArrangeMapper.selectByPrimaryKey(timeArrangeId);
									PredictPerson predictPerson = predictPersonMapper.selectByPrimaryKey(predictPersonId);
									method(predictTime, timeArrange, predictPerson);
								}
								if(resourceType.equals("2")){
									LaboratoryBuilding laboratoryBuilding = laboratoryBuildingMapper.selectByPrimaryKey(resourceId);
									String timeArrangeId = laboratoryBuilding.getTimeArrangeId();
									String predictPersonId = laboratoryBuilding.getPredictPersonId();
									TimeArrange timeArrange = timeArrangeMapper.selectByPrimaryKey(timeArrangeId);
									PredictPerson predictPerson = predictPersonMapper.selectByPrimaryKey(predictPersonId);
									method(predictTime, timeArrange, predictPerson);
								}
								if(resourceType.equals("3")){
									SportsGround sportsGround = sportsGroundMapper.selectByPrimaryKey(resourceId);
									String timeArrangeId = sportsGround.getTimeArrangeId();
									String predictPersonId = sportsGround.getPredictPersonId();
									TimeArrange timeArrange = timeArrangeMapper.selectByPrimaryKey(timeArrangeId);
									PredictPerson predictPerson = predictPersonMapper.selectByPrimaryKey(predictPersonId);
									method(predictTime, timeArrange, predictPerson);
								}
								if(resourceType.equals("4")){
									MeetingRoom meetingRoom = meetingRoomMapper.selectByPrimaryKey(resourceId);
									String timeArrangeId = meetingRoom.getTimeArrangeId();
									String predictPersonId = meetingRoom.getPredictPersonId();
									TimeArrange timeArrange = timeArrangeMapper.selectByPrimaryKey(timeArrangeId);
									PredictPerson predictPerson = predictPersonMapper.selectByPrimaryKey(predictPersonId);
									method(predictTime, timeArrange, predictPerson);
								}
							
							}
						}
					}
	            	RejectTableExample example2 = new RejectTableExample();
	            	com.reserve.bean.RejectTableExample.Criteria criteria2 = example2.createCriteria();
	            	criteria2.andDelFlagEqualTo("0");
	            	List<RejectTable> rejectList = rejectTableMapper.selectByExample(example2);
	            	for (RejectTable rejectTable : rejectList) {
	            		Date endTime = rejectTable.getEndTime();
	            		if(curentTime.after(endTime)){
	            			rejectTable.setDelFlag("1");
	            			rejectTableMapper.updateByPrimaryKeySelective(rejectTable);   //逻辑删除驳回表过期数据
						}
					}
	            }
			};
			ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();  
	        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
	        service.scheduleAtFixedRate(runnable, 0, 60*10, TimeUnit.SECONDS);
		}
	}
	
	public void method(String predictTime,TimeArrange timeArrange,PredictPerson predictPerson){
		if(predictTime!=null && !predictTime.equals("")){
			if(predictTime.equals("monMorning")){
				timeArrange.setMonMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setMonMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("monAfternoon")){
				timeArrange.setMonAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setMonAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("monEvening")){
				timeArrange.setMonEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setMonEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("tueMorning")){
				timeArrange.setTueMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setTueMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("tueAfternoon")){
				timeArrange.setTueAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setTueAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("tueEvening")){
				timeArrange.setTueEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setTueEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("wedMorning")){
				timeArrange.setWedMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setWedMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("wedAfternoon")){
				timeArrange.setWedAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setWedAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("wedEvening")){
				timeArrange.setWedEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setWedEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("thuMorning")){
				timeArrange.setThuMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setThuMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("thuAfternoon")){
				timeArrange.setThuAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setThuAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("thuEvening")){
				timeArrange.setThuEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setThuEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("friMorning")){
				timeArrange.setFriMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setFriMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("friAfternoon")){
				timeArrange.setFriAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setFriAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("friEvening")){
				timeArrange.setFriEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setFriEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("satMorning")){
				timeArrange.setSatMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setSatMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("satAfternoon")){
				timeArrange.setSatAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setSatAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("satEvening")){
				timeArrange.setSatEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setSatEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("sunMorning")){
				timeArrange.setSunMorning("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setSunMorning("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("sunAfternoon")){
				timeArrange.setSunAfternoon("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setSunAfternoon("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			if(predictTime.equals("sunEvening")){
				timeArrange.setSunEvening("2");  //修改为待预定
				timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
				predictPerson.setSunEvening("");  //清空预订者表对应的数据
				predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
			}
			
		}
	}

}
