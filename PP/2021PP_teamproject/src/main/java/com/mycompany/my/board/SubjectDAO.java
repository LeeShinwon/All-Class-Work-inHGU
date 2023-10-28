package com.mycompany.my.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SubjectDAO {
	@Autowired
	SqlSession sqlSession;

	public int insertSubject(SubjectVO vo) {
		int result = sqlSession.insert("mapper.insertSubject", vo);
		return result;
	}
	
	public int deleteSubject(int id) {
		int result = sqlSession.delete("mapper.deleteSubject", id);
		return result;
	}
	public int updateSubject(SubjectVO vo) {
		int result = sqlSession.update("mapper.updateSubject", vo);
		return result;
	}

	public SubjectVO getSubject(int seq) {
		SubjectVO one = sqlSession.selectOne("mapper.getSubject", seq);
		return one;
	}

	public List<SubjectVO> getSubjectList() {
		List<SubjectVO> list = sqlSession.selectList("mapper.getSubjectList");
		return list;
	}
	
	public List<SubjectVO> getSubjectListS(String area) {
		System.out.println(area+"h");
		List<SubjectVO> list = sqlSession.selectList("mapper.getSubjectList2", area);
		System.out.println(area+"hh");
		return list;
	}
}
