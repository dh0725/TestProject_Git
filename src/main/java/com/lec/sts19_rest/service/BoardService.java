package com.lec.sts19_rest.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.sts19_rest.domain.WriteDAO;
import com.lec.sts19_rest.domain.WriteDTO;

// Service란
// Transaction을 담당한다.

// JSP MVC model2의 commnad와 비슷한 역할을 한다.
// JSP MVC model2에서는 Controller => Command => DAO
// SPRING MVC 에서는 @Controller => @Service => DAO => JdbcDAO

@Service
public class BoardService {
	
	WriteDAO dao;
	
//	@Autowired
//	public void setDao(WriteDAO dao) {
//		this.dao = dao;
//	}
	
	// MyBatis
	// SqlSession : Sql과 Spring을 연결하는 핵심 Module
	private SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 테스트 출력
	public BoardService() {
		super();
		System.out.println("BoardService() 생성");
	}
	
	public List<WriteDTO> list() {
		// MyBatis가 만들어준 DAO
		dao = sqlSession.getMapper(WriteDAO.class);
		return dao.select();
	}
	
	public int write(WriteDTO dto) {
		dao = sqlSession.getMapper(WriteDAO.class);
//		return dao.insert(dto);
		
		int result = dao.insert(dto);
		System.out.println("생성된 uid는 " + dto.getUid());
		
		return result;
		
//		return dao.insert(dto.getSubject(), dto.getContent(), dto.getName());
	}
	
	// @Transactional
	public List<WriteDTO> viewByUid(int uid) {
		// ※사실, 트랜잭션은 여기서 발생해야 한다.
		// 1. 조회수 증가 : incViewCnt()
		// 2. 글 하나 읽어오기 : selectByUid()
		

		dao = sqlSession.getMapper(WriteDAO.class); // MyBatis 사용
		dao.incViewCnt(uid);
		return dao.selectByUid(uid);
	}

	public List<WriteDTO> selectByUid(int uid) {
		dao = sqlSession.getMapper(WriteDAO.class); // MyBatis 사용
		return dao.selectByUid(uid); // 1개짜리 List
	}

	public int update(WriteDTO dto) {
		dao = sqlSession.getMapper(WriteDAO.class); // MyBatis 사용
//		return dao.update(dto);
		return dao.update(dto.getUid(), dto);
	}

	public int deleteByUid(int uid) {
		dao = sqlSession.getMapper(WriteDAO.class); // MyBatis 사용
		return dao.deleteByUid(uid);
	}
	
	
	

}
