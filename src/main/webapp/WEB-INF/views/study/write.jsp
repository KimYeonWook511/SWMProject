<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 스터디 모집하기</title>
<!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/board.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
	<c:if test="${not empty loginVO}">
		<form action="/study/write" method="post">
			<div class="main">
				<div class="column-main">
					<div class="study-title">
						<div class="study-name" style="font-size: 20px;">
							스터디 게시판 제목<br>
							<input type="text" name="studyTitle" maxlength="50" style="width: 800px; height: 30px;">
						</div>
						<div class="study-status"></div>
						<hr class="hr-bar">
					</div>
					<div class="study-info">
						<table class="info-table">
							<tr>
								<th class="study_info_th">스터디 내용</th>
								<td><textarea rows="10" cols="95" name="studyContent" maxlength="5000"></textarea></td>
							</tr>
							<tr>
								<td colspan="2"><button class="btn btn-default pull-right">스터디 모집 등록</button></td>
							</tr>
						</table>
					</div>	
				</div>
				<div class="column-side">
					<div style="width:400px; height:400px;"></div>
				</div>
			</div>
		</form>
	</c:if>
</body>
</html>