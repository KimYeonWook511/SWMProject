<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 메뉴</title>
<style>
	.navbar-brand {
		background-image: url("/resources/mainImg/logo.png");
		background-size: cover;
		background-position: center;
		margin-left: 10px;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/" style="width: 150px;"></a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav"  style="margin-left: 10px;">
				<li><a href="/">메인으로</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						스터디
					</a>
					<ul class="dropdown-menu">
						<li><a href="/study/list">스터디 리스트</a></li>
						<c:if test="${not empty loginVO}">
							<li><a href="/study/write">스터디 모집하기</a></li>
							<li><a href="/study/myStudyList">나의 스터디 모집 리스트</a></li>
							<li><a href="/study/myApplyList">나의 지원서 리스트</a></li>
						</c:if>
					</ul>
				</li>
				<c:if test="${not empty loginVO}">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							나의 스터디 그룹
						</a>
						<ul class="dropdown-menu">
							<li><a href="/group/list">그룹 리스트</a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${loginVO.userAuthority == 'admin' }">
					<li><a href="/">관리자 창</a></li>
				</c:if>
			</ul>
			<c:if test="${empty loginVO}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" 
							aria-expanded="false" style="font-weight: bold; font-size: 15px; padding-left: 20px; padding-right: 20px;">
							접속하기
						</a>
						<ul class="dropdown-menu">
							<li><a href="/user/login">로그인</a></li> 
							<li><a href="/user/signup">회원가입</a></li>
						</ul>
					</li>
				</ul>
			</c:if>
			<c:if test="${not empty loginVO}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdwon">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" 
							aria-expanded="false" style="font-weight: bold; font-size: 15px; padding-left: 20px; padding-right: 20px;">
							<c:if test="${loginVO.userAuthority == 'member' }">
								${loginVO.userName } 회원
							</c:if>
							<c:if test="${loginVO.userAuthority == 'admin' }">
								${loginVO.userName } 관리자
							</c:if>
						</a>
						<ul class="dropdown-menu">
							<li><a href="/user/logout">로그아웃</a></li> 							
						</ul>
					</li>
				</ul>
			</c:if>
		</div>
	</nav>
</body>
</html>