package com.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.SportsGround;
import com.reserve.bean.SportsGroundExample;
import com.reserve.bean.SportsGroundExample.Criteria;
import com.reserve.dao.SportsGroundMapper;


@Service
public class SportService {

	@Autowired
	private SportsGroundMapper sportsGroundMapper;
	
	public SportsGround getById(String id) {
		return sportsGroundMapper.selectByPrimaryKey(id);
	}
	
	public List<SportsGround> findListByArea(String areaNum) {
		return sportsGroundMapper.findListByArea(areaNum);
	}
	
}
