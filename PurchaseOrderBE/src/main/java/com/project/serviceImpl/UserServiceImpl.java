package com.project.serviceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.model.User;
import com.project.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	public boolean addUser(User uObj) {
		System.out.println("yo");
		uObj.setCreatedDate(LocalDate.now());
		uObj.setCreatedBy("System");
		uObj.setIsActive("Y");
		uObj.setRole("Buyer");
		return userDao.addUser(uObj);
	
	
	}

	@Override
	public User validateUser(String email, String password) {
		
		return userDao.validateUser(email, password);
	}

}
