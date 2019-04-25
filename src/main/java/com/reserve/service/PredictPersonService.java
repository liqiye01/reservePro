package com.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.PredictPerson;
import com.reserve.dao.PredictPersonMapper;

@Service
public class PredictPersonService {
	
	@Autowired 
	PredictPersonMapper predictPersonMapper;
	
	public void updateByPrimaryKeySelective(PredictPerson predictPerson){
		predictPersonMapper.updateByPrimaryKeySelective(predictPerson);
	}
	
	public void update(PredictPerson predictPerson){
		predictPersonMapper.update(predictPerson);
	}

	public PredictPerson getById(String id) {
		return predictPersonMapper.selectByPrimaryKey(id);
	}

}
