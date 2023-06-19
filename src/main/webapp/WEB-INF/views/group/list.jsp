<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 나의 스터디 그룹</title>
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
	<h2 style="margin: 30px 0px 30px 10px; font-size: 40px;">나의 스터디 그룹</h2>
	<hr class="hr-bar">
	<h2 style="margin-left:10px;">리더인 스터디 그룹(${groupListL.size() }개)</h2>
	<br>
	<c:if test="${groupListL.isEmpty() }">
		<div class="empty_table"><div class="empty_table_inner">리더인 스터디 그룹 존재하지 않음</div></div>
	</c:if>
	<c:if test="${!groupListL.isEmpty() }">
		<table class="table table-bordered">
			<tr>
				<th style="width: 80px">그룹번호</th>
				<th style="width: 600px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">그룹명</th>
				<th style="width: 180px">그룹장</th>
				<th>등록일</th>
				<th>그룹원수</th>
			</tr>
			<c:forEach items="${groupListL }" var="groupVO">
				<tr class="rowdata">
					<td class="groupNo">${groupVO.groupNo }</td>
					<td>${groupVO.groupName }</td>
					<td>${groupVO.groupLeader }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${groupVO.groupCreateDate }"/></td>
					<td>${countMap.get(groupVO.groupNo) }</td>
				</tr>			
			</c:forEach>
		</table>
	</c:if>
	<hr class="hr-bar">
	<h2 style="margin-left:10px;">멤버인 스터디 그룹(${groupListM.size() }개)</h2>
	<br>
	<c:if test="${groupListM.isEmpty() }">
		<div class="empty_table"><div class="empty_table_inner">멤버인 스터디 그룹 존재하지 않음</div></div>
	</c:if>
	<c:if test="${!groupListM.isEmpty() }">
		<table class="table table-bordered">
			<tr>
				<th style="width: 80px">그룹번호</th>
				<th style="width: 600px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">그룹명</th>
				<th style="width: 180px">그룹장</th>
				<th>등록일</th>
				<th>그룹원수</th>
			</tr>
			<c:forEach items="${groupListM }" var="groupVO">
				<tr class="rowdata">
					<td class="groupNo">${groupVO.groupNo }</td>
					<td>${groupVO.groupName }</td>
					<td>${groupVO.groupLeader }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${groupVO.groupCreateDate }"/></td>
					<td>${countMap.get(groupVO.groupNo) }</td>
				</tr>			
			</c:forEach>
		</table>
	</c:if>
	<script>
		$(function() { // onready - html의 body 부분의 내용이 다 로딩되면 동작되도록 한다.
			// 데이터 한줄 클릭하면 지원서 보기로 이동되는 이벤트 처리
			$(".rowdata").click(function() { // rowdata 클래스가 클릭되면 function 실행
				popup($(this).find(".groupNo").text());
			});
		});
		
		function popup(groupNo) {
			window.open("/group/view?groupNo=" + groupNo, "스터디 그룹 정보", "width=500,height=590,location=no,status=no,scrollbars=yes");
		}
	</script>
	</c:if>
</body>
</html>