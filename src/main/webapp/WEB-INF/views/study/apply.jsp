<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 스터디 지원</title>
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
			<h2>스터디 지원</h2>
			<br><br><br>
			<form role="form" method="post">
				<input type="hidden" name="studyNo" value="${studyNo }">
				<table class="info-table">
					<tr>
						<th class="study_info_th">지원 내용</th>
					</tr>
					<tr>
						<td><textarea rows="10" cols="60" name="applyContent" maxlength="500" placeholder="내용을 입력해 주세요." style="resize: none;"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" class="btn btn-default pull-right apply">지원</button>
							<button type="button" class="btn btn-default pull-right cancel" onclick="window.close();">취소</button>
						</td>			
					</tr>
				</table>
			</form>	
		</div>
		<script>
			$(document).ready(function() {
				var formObj = $("form[role='form']");
				
				$(".apply").on("click", function() {
					if (!confirm("지원하시겠습니까?")) return;
					formObj.attr("action", "/study/apply.do");
					formObj.submit();
				});
				
				$(".cancel").on("click", function() {
					window.close();
				});
			});
		</script>
	</c:if>
</body>
</html>