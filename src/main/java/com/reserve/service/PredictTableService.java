package com.reserve.service;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.PredictTable;
import com.reserve.bean.PredictTableExample;
import com.reserve.bean.PredictTableExample.Criteria;
import com.reserve.dao.PredictTableMapper;


@Service

public class PredictTableService {

	@Autowired
	private PredictTableMapper predictTableMapper;
	
	//按类型和批准状态获取预定资源的列表
	public List<PredictTable> getPredictListByType(String type,String state) {
		
		PredictTableExample example = new PredictTableExample();
		Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("0");
		criteria.andResourceTypeEqualTo(type);  //获取对应类型的
		criteria.andPredictStateEqualTo(state);  //获取对应批准状态的
		List<PredictTable> list = predictTableMapper.selectByExample(example);
		return list;
	}
	
	
	public PredictTable getById(String id){
		return predictTableMapper.selectByPrimaryKey(id);
	}
	
	public void save(PredictTable predictTable){
		PredictTable table = predictTableMapper.selectByPrimaryKey(predictTable.getId());
		if(table==null || table.equals("")){
			predictTableMapper.insert(predictTable);
		}else{
			predictTableMapper.updateByPrimaryKeySelective(predictTable);
		}
		
	}

	//通过类型和资源Id找到所有数据
	public List<PredictTable> getListByResourceId(String resourceId) {
		PredictTableExample example = new PredictTableExample();
		Criteria criteria = example.createCriteria();
		criteria.andResourceIdEqualTo(resourceId); //获取对应资源id
		List<PredictTable> list = predictTableMapper.selectByExample(example);
		return list;
	}
	
	
}
