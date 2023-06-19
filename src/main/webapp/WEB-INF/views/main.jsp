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
<link rel="stylesheet" href="/css/main.css">
<style>
	.navbar {
		margin-bottom: 0px;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
	<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 1530px; height: 600px;">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active">
			<li data-target="#myCarousel" data-slide-to="1">
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="/resources/mainImg/1.jpg" style="width: 1530px; height: 600px;">
				<div class="myCarouselTitle">
					<span class="myCarouselTitle-inner">Welcome Study With Me</span>
				</div>
			</div>
			<div class="item">
				<img src="/resources/mainImg/2.jpg" style="width: 1530px; height: 600px;">
				<div class="myCarouselTitle">
					<span class="myCarouselTitle-inner">Welcome Study With Me</span>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
</body>
<script>
	if ('${joinResult}' == 'success') {
		alert("회원가입 성공");
		
	} else if ('${joinResult}' == 'fail_session') {
		alert("세션 오류");
	}
	
	if ('${loginResult}' == 1) {
		alert("로그인 성공");
	}
	
	if ('${logoutResult}' == 1) {
		alert("로그아웃 완료");
		
	} else if ('${logoutResult}' == -1) {
		alert("현재 로그인 상태가 아닙니다.");
	}
	
	if ('${msg}' == 1) {
		alert('허용되지 않은 접근입니다.');
		
	} else if ('${msg}' == 2) {
		alert('현재 로그인 중입니다.');
	}
</script>
</html>
