package com.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.LaboratoryBuilding;
import com.reserve.dao.LaboratoryBuildingMapper;

@Service
public class LaboratoryService {

	@Autowired
	private LaboratoryBuildingMapper laboratoryBuildingMapper;

	public List<String> findBuildingnum() {
		return laboratoryBuildingMapper.findBuildingnum();
	}

	public List<LaboratoryBuilding> findLaboratoryByBuildingNum(int buildingNum) {
		return laboratoryBuildingMapper.findLaboratoryByBuildingNum(buildingNum);
	}

	public LaboratoryBuilding getById(String id) {
		return laboratoryBuildingMapper.selectByPrimaryKey(id);
	}
	
	
	
}
