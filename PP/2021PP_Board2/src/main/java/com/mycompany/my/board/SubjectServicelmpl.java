package com.mycompany.my.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectServicelmpl implements SubjectService {
	@Autowired
	SubjectDAO subjectDAO;

	@Override
	public int insertSubject(SubjectVO vo) {
		// TODO Auto-generated method stub
		return subjectDAO.insertSubject(vo);
	}

	@Override
	public int deleteSubject(int id) {
		// TODO Auto-generated method stub
		return subjectDAO.deleteSubject(id);
	}

	@Override
	public int updateSubject(SubjectVO vo) {
		// TODO Auto-generated method stub
		return subjectDAO.updateSubject(vo);
	}

	@Override
	public SubjectVO getSubject(int seq) {
		// TODO Auto-generated method stub
		return subjectDAO.getSubject(seq);
	}

	@Override
	public List<SubjectVO> getSubjectList() {
		return subjectDAO.getSubjectList();
	}

}
