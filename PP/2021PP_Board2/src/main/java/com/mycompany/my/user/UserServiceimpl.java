package com.mycompany.my.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceimpl{
	@Autowired
	UserDAO userDAO;

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	

	
}
