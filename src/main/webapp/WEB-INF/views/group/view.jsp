<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 스터디 그룹 정보</title>
<!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/navbar.css">
</head>
<body>
	<c:if test="${not empty loginVO}">
		<div class="col-lg-4">
			<br>
			<h2>${groupVO.groupName }</h2>
			<br><br><br>
			<form role="form" method="post">
				<input type="hidden" name="groupNo" value="${groupVO.groupNo }">
				<div class="study-title">
					<div class="study-status" style="grid-template-columns: 50px 1fr;">
						<div class="status-write">
							<span class="status-writer">그룹장 : ${groupVO.groupLeader }(${leaderVO.userName }) &nbsp;</span>
							<span class="status-writeDate">생성일 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${groupVO.groupCreateDate }"/></span>
						</div>
						<hr class="hr-bar">
					</div>
				</div>
				<div class="study-info">
					<table class="info-table">
						<tr>
							<th class="study_info_th" style="width: 130px;">스터디 그룹 설명</th>
							<td style="word-wrap: break-word;">${groupVO.getReplGroupExplain() }</td>
						</tr>
					</table>
					<hr class="hr-bar">
					<br>
					<table class="info-table">
						<tr>
							<th class="study_info_th">그룹원 정보</th>
						</tr>
						<tr>
							<td>
								<div style="overflow:scroll; width:450px; height:150px;">
									<table>
										<tr>
											<td>L : ${groupVO.groupLeader }(${leaderVO.userName }) / ${leaderVO.userGender }<c:if test="${loginVO.userId.equals(groupVO.groupLeader) }"> / ${leaderVO.userCallNumber }</c:if>
											</td>
										</tr>
										<c:forEach items="${memberList }" var="memberVO">
											<tr>
												<td>${memberVO.userId }(${memberVO.userName }) / ${memberVO.userGender }<c:if test="${loginVO.userId.equals(groupVO.groupLeader) }"> / ${memberVO.userCallNumber }</c:if>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<button type="button" class="btn btn-default pull-right cancel" onclick="window.close();">닫기</button>
								<c:if test="${loginVO.userId.equals(groupVO.groupLeader) }">
									<button type="button" class="btn btn-default pull-right xxx">xxx미정</button>
								</c:if>
							</td>			
						</tr>
					</table>
				</div>
			</form>	
		</div>
		<script>
			$(document).ready(function() {
				var formObj = $("form[role='form']");
				
				$(".cancel").on("click", function() {
					window.close();
				});
			});
		</script>
	</c:if>
</body>
</html>