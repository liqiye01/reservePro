package com.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.TimeArrange;
import com.reserve.dao.TimeArrangeMapper;

@Service
public class TimeArrangeService {
	
	@Autowired
	private TimeArrangeMapper timeArrangeMapper;
	
	public void updateByPrimaryKeySelective(TimeArrange timeArrange){
		timeArrangeMapper.updateByPrimaryKeySelective(timeArrange);
	}
	
	public void update(TimeArrange timeArrange){
		timeArrangeMapper.update(timeArrange);
	}
	
	public TimeArrange getById(String id){
		return timeArrangeMapper.selectByPrimaryKey(id);
	}

}
