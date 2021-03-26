<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<script>
	// form 유효성 검사하기
	// 게시글의 작성자명과 제목은 필수요소이므로
	// 입력되지 않으면 별도의 알림창으로 알려주기
	function chkSubmit(){
		frm = document.forms['frm'];
		
		var name = frm['name'].value.trim();
		var subject = frm['subject'].value.trim();
	
		if(name == ""){
			alert("작성자 란은 반드시 입력해야 합니다.");
			frm['name'].focus();
			return false;
		}
		if(subject == ""){
			alert("제목은 반드시 작성해야 합니다");
	        frm["subject"].focus();
	        return false;
		}
		return true;
	}
</script>
<body>
	<h2>글작성</h2>
	<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
	작성자 : <input type="text" name="name"/><br>
	제목 : <input type="text" name="subject"/><br>
	내용:<br>
	<textarea name="content"></textarea>

	<br><br>

	<input type="submit" value="등록"/>
	</form>
	<br>
	<button type="button" onclick="location.href = 'list.do'">목록으로</button>
</body>
</html>
















