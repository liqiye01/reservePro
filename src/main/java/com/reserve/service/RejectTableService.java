package com.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.PredictTable;
import com.reserve.bean.RejectTable;
import com.reserve.bean.RejectTableExample;
import com.reserve.dao.RejectTableMapper;

@Service
public class RejectTableService {

	@Autowired
	private RejectTableMapper rejectTableMapper;
	
	public void save(RejectTable rejectTable){
		RejectTable table = rejectTableMapper.selectByPrimaryKey(rejectTable.getId());
		if(table==null || table.equals("")){
			rejectTableMapper.insert(rejectTable);
		}else{
			rejectTableMapper.updateByPrimaryKeySelective(rejectTable);
		}
		
	}
	
	public void deleteByExample(RejectTableExample example){
		rejectTableMapper.deleteByExample(example);
	}
	
	public RejectTable getById(String id){
		return rejectTableMapper.selectByPrimaryKey(id);
	}
	
	
}
