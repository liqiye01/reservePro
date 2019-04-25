package com.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.Classroom;
import com.reserve.bean.ClassroomExample;
import com.reserve.bean.ClassroomExample.Criteria;
import com.reserve.dao.ClassroomMapper;



@Service
public class ClassroomService {

	@Autowired
	private ClassroomMapper classroomMapper;
	
	public List<Classroom> getClassroomByArea(String area) {
		ClassroomExample example = new ClassroomExample();
		Criteria criteria = example.createCriteria();
		criteria.andAreaEqualTo(area);
		List<Classroom> list = classroomMapper.selectByExample(example);
		return list;
	}

	public List<String> findBuildingnumByArea(int area) {
		
		return classroomMapper.findBuildingnumByArea(area);
	}

	public List<Classroom> findClassroomByBuildingNum(int buildingNum) {
		return classroomMapper.findClassroomByBuildingNum(buildingNum);
	}
	
	public Classroom getById(String id){
		return classroomMapper.selectByPrimaryKey(id);
	}

	public Classroom getDetailsById(String classroomId) {
		return classroomMapper.getDetailsById(classroomId);
	}
	
	public void save(Classroom classroom){
		Classroom classroom2 = classroomMapper.selectByPrimaryKey(classroom.getId());
		if(classroom2==null || classroom2.equals("")){
			classroomMapper.insert(classroom);
		}else{
			classroomMapper.updateByPrimaryKeySelective(classroom);
		}
		
	}

}
