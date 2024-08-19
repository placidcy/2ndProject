<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 변경 페이지</title>
	<script src="resources/js/changePasswd.js"></script>
	<link rel="stylesheet" href="resources/css/changePasswd.css" />
</head>
<body>
	<div id="container">
		<header><a href="<c:url value='/main' />">직장IN</a></header>
		<form method="POST" action="changePasswdProcess" id="changePasswdForm">
			<input type="password" name="oldPasswd" id="oldPasswd" placeholder="현재 비밀번호"/>
			<br />
			<input type="password" name="newPasswd" id="newPasswd" placeholder="새로운 비밀번호"/>
			<br />
			<input type="password" name="confirmNewPasswd" id="confirmNewPasswd" placeholder="새로운 비밀번호 확인"/>
			<br />
			<input type="submit" value="비밀번호 변경" id="submitBtn"/>
		</form>
	</div>
</body>
</html>