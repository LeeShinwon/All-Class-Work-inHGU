package com.mycompany.my.subjectuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectUserServiceimpl implements SubjectUserService{
	@Autowired
	SubjectUserDAO userDAO;

	@Override
	public int insertUser(SubjectUserVO vo) {
		return userDAO.insertUser(vo);
	}

	@Override
	public int deleteUser(int id) {
		return userDAO.deleteUser(id);
	}

	@Override
	public int updateUser(SubjectUserVO vo) {
		return userDAO.updateUser(vo);
	}

	@Override
	public SubjectUserVO getUser(int seq) {
		return userDAO.getUser(seq);
	}

	@Override
	public List<SubjectUserVO> getUserList() {
		return userDAO.getUserList();
	}
	@Override
	public List<SubjectUserVO> gettotal() {
		return userDAO.gettotal();
	}

	
}
