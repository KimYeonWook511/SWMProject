<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 스터디 모집 내용 보기</title>
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
	<form role="form" method="post">
		<div class="main">
			<div class="column-main">
				<div class="study-title">
					<input type="hidden" name="studyNo" value="${studyVO.studyNo }">
					<div class="study-name">
						${studyVO.studyTitle }
					</div>
					<div class="study-status">
						<div class="status-viewCount">
							조회수 : ${studyVO.studyViewCount + 1}
						</div>
						<div class="status-write">
							<span class="status-writer">작성자 : ${studyVO.studyWriter }</span>
							<span class="status-writeDate">작성일 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${studyVO.studyWriteDate }"/></span>
						</div>
						<hr class="hr-bar">
					</div>
				</div>
				<div class="study-info">
					<table class="info-table">
						<tr>
							<th class="study_info_th">스터디 내용</th>
							<td>${studyVO.getReplStudyContent() }</td>
						</tr>
					</table>
					<c:if test="${loginVO.userId.equals(studyVO.studyWriter) || loginVO.userAuthority.equals('admin')}">
						<button type="button" class="btn btn-default pull-right delete">삭제</button>
						<button type="button" class="btn btn-default pull-right modify">수정</button>	
					</c:if>
					<button type="button" class="btn btn-default pull-right list">목록</button>
				</div>
			</div>
			<div class="column-side">
				<div class="user-info">
					<div class="user-info-title">
						게시물 회원 정보
					</div>
				</div>
			</div>
		</div>
	</form>
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);
			
			$(".modify").on("click", function() {
				formObj.attr("action", "/study/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			
			$(".delete").on("click", function() {
				if (!confirm("정말로 삭제하시겠습니까?")) return;
				formObj.attr("action", "/study/delete");
				formObj.submit();
			});
			
			$(".list").on("click", function() {
				self.location="/study/list";
			});
		});
	</script>
</body>
</html>