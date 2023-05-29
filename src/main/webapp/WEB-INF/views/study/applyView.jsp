<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 스터디 지원서</title>
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
<style>
	.study-status {
		grid-area: study-status;
		display: grid;
		grid-template-columns: 0px 1fr;
		grid-template-rows: auto 1px;
		grid-template-areas: '. status-write' 'hr-bar hr-bar';
	}
</style>
</head>
<body>
	<c:if test="${not empty loginVO}">
		<div class="col-lg-4">
			<br>
			<h2>스터디 지원서</h2>
			<br><br><br>
			<form role="form" method="post">
				<input type="hidden" name="applyNo" value="${applyVO.applyNo }">
				<div class="study-title">
					<div class="study-status">
						<div class="status-write">
							<span class="status-writer">작성자 : ${applyVO.applyWriter } &nbsp;</span>
							<span class="status-writeDate">작성일 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${applyVO.applyDate }"/></span>
						</div>
						<hr class="hr-bar">
					</div>
				</div>
				<div class="study-info">
					<table class="info-table">
						<tr>
							<th class="study_info_th">지원 내용</th>
							<td>${applyVO.getReplApplyContent() }</td>
						</tr>
					</table>
					<c:if test="${loginVO.userId.equals(applyAccessVO.studyWriter) }">
						<button type="button" class="btn btn-default pull-right pass">합격</button>
						<button type="button" class="btn btn-default pull-right fail">불합격</button>
					</c:if>
					<c:if test="${loginVO.userId.equals(applyAccessVO.applyWriter) }">
						<button type="button" class="btn btn-default pull-right delete">지원취소</button>
					</c:if>
					<c:if test="${loginVO.userAuthority.equals('admin') }">
						<button type="button" class="btn btn-default pull-right pass">합격</button>
						<button type="button" class="btn btn-default pull-right fail">불합격</button>
						<button type="button" class="btn btn-default pull-right delete">지원취소</button>
					</c:if>
				</div>
			</form>	
		</div>
		<script>
			$(document).ready(function() {
				var formObj = $("form[role='form']");
				
				$(".pass").on("click", function() {
					if (!confirm("합격시키겠습니까?")) return;
					formObj.attr("action", "/study/applyPass");
					formObj.submit();
				});
				
				$(".fail").on("click", function() {
					if (!confirm("불합격시키겠습니까?")) return;
					formObj.attr("action", "/study/applyFail");
					formObj.submit();
				});
				
				$(".delete").on("click", function() {
					if (!confirm("지원을 취소하시겠습니까?")) return;
					formObj.attr("action", "/study/applyDelete");
					formObj.submit();
				});
			});
		</script>
	</c:if>
</body>
</html>