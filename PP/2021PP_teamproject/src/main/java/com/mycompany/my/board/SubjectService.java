package com.mycompany.my.board;

import java.util.List;

public interface SubjectService {
	public int insertSubject(SubjectVO vo);

	public int deleteSubject(int id);

	public int updateSubject(SubjectVO vo);

	public SubjectVO getSubject(int seq);

	public List<SubjectVO> getSubjectList();
	
	public List<SubjectVO> getSubjectListS(String area) ;
}
