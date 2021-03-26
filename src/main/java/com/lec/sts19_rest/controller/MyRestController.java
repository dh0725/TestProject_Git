package com.lec.sts19_rest.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.domain.EmployeeVO;
import com.lec.sts19_rest.domain.WriteDAO;
import com.lec.sts19_rest.domain.WriteDTO;

@RestController
@RequestMapping("MyRest")
public class MyRestController {
	
	WriteDAO dao;
	
	// MyBatis
	@Autowired
	private SqlSession sqlSession; 
	
	// TEXT 데이터 response
	@RequestMapping("/")
	public String helloTEXT() {
		return "Hello REST";
	}
	
	// JSON response
	@RequestMapping("/helloJSON")
	public WriteDTO helloJSON() {
		WriteDTO dto = new WriteDTO(100, "안녕하세요", "REST", "하하하", 123, LocalDateTime.now());
		return dto;
	}
	
	// 자바 List 객체 ==> JSON 배열 리스트로 변환하기
	@RequestMapping("/listJSON")
	public List<WriteDTO> listJSON() {
		WriteDAO dao = sqlSession.getMapper(WriteDAO.class);
		return dao.select();
	}
	
	// 자바 배열 ==> JSON 배열로 변환하기
	@RequestMapping("/arrJSON")
	public WriteDTO [] arrJSON() {
		WriteDAO dao = sqlSession.getMapper(WriteDAO.class);
		List<WriteDTO> list = dao.select();
		WriteDTO [] arr = new WriteDTO[list.size()];
		return list.toArray(arr);
	}
	
	// 자바 Map<key, value> 객체를 JSON object타입으로 변환하기
	// key value 쌍으로 object 타입으로 리턴된다
	// key는 integer
	// value는 object
	@RequestMapping("/mapJSON")
	public Map<Integer, WriteDTO> mapJSON(){
		WriteDAO dao = sqlSession.getMapper(WriteDAO.class);
		List<WriteDTO> list = dao.select();
		
		Map<Integer, WriteDTO> map = new HashMap<Integer, WriteDTO>();
		
		for(WriteDTO dto : list) {
			map.put(dto.getUid(), dto);
		}
		
		return map;
	}
	
	// XML response
	// XML 데이터 <= 자바 객체
	@RequestMapping("/helloXML")
	public EmployeeVO helloXML() {
		return new EmployeeVO(100, "홍길동", 200, new int[] {10, 20, 30}, 34.2); 
	}
	
	// 특정 uid 값의 게시글을 읽어와보도록
//	@RequestMapping("/read/{uid}")
//	public List<WriteDTO> read(@PathVariable("uid") int uid) {
//		WriteDAO dao = sqlSession.getMapper(WriteDAO.class);
//		return dao.selectByUid(uid);
//	}
	@RequestMapping("/read/{uid}")
	public ResponseEntity<WriteDTO> read(@PathVariable("uid") int uid) {
		WriteDAO dao = sqlSession.getMapper(WriteDAO.class);
		List<WriteDTO> list = dao.selectByUid(uid);
		
		// 실패
		if (list == null || list.size() == 0)
			return new ResponseEntity<WriteDTO>(HttpStatus.NOT_FOUND); // 404 Error

		// 성공
		return new ResponseEntity<WriteDTO>(list.get(0), HttpStatus.OK); // 200 success
	}
	
	// response code 받기

	
}
