package com.mycompany.my.subjectuser;

import java.util.List;

import com.mycompany.my.board.SubjectVO;

public interface SubjectUserService {
	public int insertUser(SubjectUserVO vo);

	public int deleteUser(int id);

	public int updateUser(SubjectUserVO vo);

	public SubjectUserVO getUser(int seq);

	public List<SubjectUserVO> getUserList();
	
	public List<SubjectUserVO> gettotal();
}
