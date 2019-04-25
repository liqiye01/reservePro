package com.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.MeetingRoom;
import com.reserve.bean.MeetingRoomExample;
import com.reserve.bean.MeetingRoomExample.Criteria;
import com.reserve.dao.MeetingRoomMapper;


@Service
public class MeetingService {

	@Autowired
	private MeetingRoomMapper meetingRoomMapper;

	public List<String> findBuildingnum() {
		return meetingRoomMapper.findBuildingnum();
	}

	public List<MeetingRoom> findMeetingByBuildingNum(int buildingNum) {
		return meetingRoomMapper.findMeetingByBuildingNum(buildingNum);
	}

	public MeetingRoom getById(String id) {
		return meetingRoomMapper.selectByPrimaryKey(id);
	}

	public List<MeetingRoom> findListByArea(String areaNum) {
		MeetingRoomExample example = new MeetingRoomExample();
		Criteria criteria = example.createCriteria();
		criteria.andAreaEqualTo(areaNum);
		List<MeetingRoom> list = meetingRoomMapper.selectByExample(example);
		return list;
	}
	
	
	
}
