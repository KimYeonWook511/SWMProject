<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 스터디 그룹 등록</title>
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
			<h2>스터디 그룹 등록</h2>
			<br><br><br>
			<form role="form" method="post">
				<input type="hidden" name="studyNo" value="${studyVO.studyNo }">
				<div class="study-title">
					<div class="study-name" style="font-size: 20px;">
						스터디 그룹명<br>
						<input type="text" name="groupName" maxlength="50" style="width: 455px; height: 30px;">
					</div>
					<div class="study-status">
						<div class="status-write">
							<span class="status-writer">그룹장 : ${studyVO.studyWriter } &nbsp;</span>
						</div>
						<hr class="hr-bar">
					</div>
				</div>
				<div class="study-info">
					<table class="info-table">
						<tr>
							<th class="study_info_th" colspan="2">스터디 그룹 설명</th>
						</tr>
						<tr>
							<td colspan="2"><textarea rows="10" cols="60" name="groupExplain" maxlength="500" placeholder="내용을 입력해 주세요." style="resize: none;"></textarea></td>
						</tr>
						<tr>
							<th class="study_info_th">스터디 공고 정보</th>
							<th class="study_info_th">합격자 명단</th>
						</tr>
						<tr>
							<td>
								<div style="overflow:scroll; width:225px; height:150px;">
									번호 : ${studyVO.studyNo}<br>
									제목 : ${studyVO.studyTitle }<br>
									작성일 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${studyVO.studyWriteDate }"/>
								</div>
							</td>
							<td>
								<div style="overflow:scroll; width:225px; height:150px;">
									<c:if test="${passList.isEmpty() }">
										합격자 없음
									</c:if>
									<c:if test="${!passList.isEmpty() }">
										<c:forEach items="${passList }" var="userVO">
											${userVO.userId }(${userVO.userName }) / ${userVO.userGender }<br>
										</c:forEach>
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td style="text-align: right;"><input type="checkbox" id="checkbox_study">확인함</td>
							<td style="text-align: right;"><input type="checkbox" id="checkbox_passList">확인함</td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="button" class="btn btn-default pull-right register">등록하기</button>
								<button type="button" class="btn btn-default pull-right cancel" onclick="window.close();">취소</button>
							</td>			
						</tr>
					</table>
				</div>
			</form>	
		</div>
		<script>
			$(document).ready(function() {
				var formObj = $("form[role='form']");
				
				$(".register").on("click", function() {
					if (!confirm("등록하시겠습니까?\n(해당 스터디 공고는 삭제됩니다.)")) return;
					
					if (!document.getElementById('checkbox_study').checked) {
						alert("등록하려는 스터디가 맞는지 확인해 주세요.");
						return;
					}
					
					if (!document.getElementById('checkbox_passList').checked) {
						alert("스터디 그룹원 명단을 확인해 주세요.");
						return;
					}
					
					formObj.attr("action", "/study/registerGroup");
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