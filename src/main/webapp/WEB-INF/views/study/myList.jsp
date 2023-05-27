<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 나의 스터디</title>
<!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/list.css">
</head>
<body>
	<c:if test="${not empty loginVO}">
	<jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
	<h2 style="margin-left:10px;">나의 스터디 모집 리스트</h2>
	<br>
	<table class="table table-bordered">
		<tr>
			<th style="width: 60px">번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>게시일</th>
			<th>지원자수</th>
		</tr>
		<c:forEach items="${studyList }" var="studyVO">
			<tr class="rowdata">
				<td class="studyNo">${studyVO.studyNo }</td>
				<td>${studyVO.studyTitle }</td>
				<td>${studyVO.studyWriter }</td>
				<td>${studyVO.studyViewCount }</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${studyVO.studyWriteDate }"/></td>
				<td>${applyCountMap.get(studyVO.studyNo) }</td>
			</tr>			
		</c:forEach>
	</table>
	<script>
		$(function() { // onready - html의 body 부분의 내용이 다 로딩되면 동작되도록 한다.
			// 데이터 한줄 클릭하면 글보기로 이동되는 이벤트 처리
			$(".rowdata").click(function() { // rowdata 클래스가 클릭되면 function 실행
				location = '/study/view?studyNo=' + $(this).find(".studyNo").text();
			})
		});
	</script>
	</c:if>
</body>
</html>