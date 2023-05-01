<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 메인</title>
<!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
	.navbar {
		margin-bottom: 0px;
	}
</style>
</head>
<body>
<a href="/user/signup" class="btn btn-default">회원가입</a><br>
<a href="/user/login" class="btn btn-default">로그인</a><br>
<a href="/study/write" class="btn btn-default">스터디모집하기</a><br>
세션확인--------------------------<br>
userId : ${loginVO.userId }<br>
userName : ${loginVO.userName }<br>
userSignDate : ${loginVO.userSignDate }<br>
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
