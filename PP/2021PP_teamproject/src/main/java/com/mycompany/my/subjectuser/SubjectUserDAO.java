package com.mycompany.my.subjectuser;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class SubjectUserDAO {
	@Autowired
	SqlSession sqlSession;

	public int insertUser(SubjectUserVO vo) {
		int result = sqlSession.insert("SubjectUser.insertUser", vo);
		return result;
	}
	
	public int deleteUser(int id) {
		int result = sqlSession.delete("SubjectUser.deleteUser", id);
		return result;
	}
	public int updateUser(SubjectUserVO vo) {
		int result = sqlSession.update("SubjectUser.updateUser", vo);
		return result;
	}

	public SubjectUserVO getUser(int seq) {
		SubjectUserVO one = sqlSession.selectOne("SubjectUser.getUser", seq);
		return one;
	}

	public List<SubjectUserVO> getUserList() {
		List<SubjectUserVO> list = sqlSession.selectList("SubjectUser.getUserList");
		return list;
	}
	public List<SubjectUserVO> gettotal() {
		List<SubjectUserVO> list = sqlSession.selectList("SubjectUser.getUserList");
		return list;
	}
	
	

}
