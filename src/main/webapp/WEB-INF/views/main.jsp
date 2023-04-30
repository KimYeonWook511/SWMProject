<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="/user/signup">회원가입</a><br>
<a href="/user/login">로그인</a><br>
userid : ${loginVO.userid }<br>
username : ${loginVO.username }<br>
signdate : ${loginVO.signdate }<br>
</body>
<script>
	if ('${joinResult}' == 'success') {
		alert("회원가입 성공");
		
	} else if ('${joinResult}' == 'fail_session') {
		alert("세션 오류");
	}
	
	if ('${loginResult}' == 1) {
		location.href = "/"; // url 새로고침
		alert("로그인 성공");
	}
	
	if ('${logoutResult}' == 1) {
		alert("로그아웃 성공");
		
	} else if ('${logoutResult}' == -1) {
		alert("현재 로그인 상태가 아닙니다.");
	}
	
	switch ('${msg}') {
	case '허용되지 않은 접근입니다.':
		alert('${msg}');
		location.href = "/"; // url 새로고침
		break;
		
	default:
		break;
	}
</script>
</html>
