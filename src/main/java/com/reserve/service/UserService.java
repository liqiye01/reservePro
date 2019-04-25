package com.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.bean.User;
import com.reserve.bean.UserExample;
import com.reserve.bean.UserExample.Criteria;
import com.reserve.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUserByUsername(String username,String privilegeMark){
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPrivilegeMarkEqualTo(privilegeMark);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}
	

}
