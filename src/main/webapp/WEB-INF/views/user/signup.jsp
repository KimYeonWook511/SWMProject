<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SWM | 회원가입</title>
<!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div style="padding-top: 20px;">
				<form method="post">
					<h3 style="text-align: center;">회원가입</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="userId" maxlength="20" id="userId" pattern="^[a-zA-Z0-9]+$">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="userPassword" maxlength="20" id="userPassword">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호 확인"
							name="confirmUserPassword" maxlength="20" id="confirmUserPassword">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름"
							name="userName" maxlength="20" id="userName">
					</div>
					<div>
						<input type="tel" class="form-control"
							placeholder="전화번호 / '-'는 빼고 입력해 주세요" name="userCallNumber"
							pattern=".{11,11}" title="전화번호는 11자리로 입력해 주세요" id="userCallNumber"
							oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
					</div>
					<br>
					<div class="form-group" style="text-align: center;">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <%-- 								<c:out value="${dto.gender != '여자' ? 'active' : ''}"/>>  --%>
								<input type="radio" name="userGender" autocomplete="off"
								value="남자" id="male" checked>남자 <%-- 								<c:out value="${dto.gender != '여자' ? 'checked' : ''}"/>>			 --%>
							</label> <label class="btn btn-primary"> <%-- 								<c:out value="${dto.gender == '여자' ? 'active' : ''}"/>> --%>
								<input type="radio" name="userGender" autocomplete="off"
								value="여자" id="female">여자 <%-- 								<c:out value="${dto.gender == '여자' ? 'checked' : ''}"/>> --%>
							</label>
						</div>
					</div>
					<br>
					<br> 
					<input type="submit" class="btn btn-primary form-control" value="회원가입">
				</form>
			</div>
		</div>
	</div>

	<script>
		if ('${signupResult}' == 'fail_id') {
			alert("이미 존재하는 아이디입니다.");

		} else if ('${signupResult}' == 'fail_password') {
			alert("비밀번호를 확인해 주세요.");

		} else if ('${signupResult}' == 'empty_userId') {
			alert("아이디를 입력해 주세요.");

		} else if ('${signupResult}' == 'empty_userPassword') {
			alert("비밀번호를 입력해 주세요.");

		} else if ('${signupResult}' == 'empty_userName') {
			alert("이름을 입력해 주세요.");

		} else if ('${signupResult}' == 'empty_userCallNumber') {
			alert("전화번호를 입력해 주세요.");
		};

		document.getElementById("userId").value = '${dto.userId}';
		document.getElementById("userName").value = '${dto.userName}';
		document.getElementById("userCallNumber").value = '${dto.userCallNumber}';
	</script>
</body>
</html>