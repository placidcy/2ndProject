<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
	
	<link rel="stylesheet" href="resources/css/findID.css" />
	<script src="resources/js/findID.js"></script>
</head>
<body>
	<div id="container">
		<header><a href="<c:url value='/main' />">직장IN</a></header>
		
		<section>
			<h4>회원 정보에 등록한 이름과 이메일이 같아야 아이디를 찾을 수 있습니다</h4>
		</sectin>
		<form method="POST" action="getUserID" id="findIDForm">
			<input type="text" name="name" id="name" placeholder="이름"/>
			<br />
			<input type="email" name="email" id="email" placeholder="이메일"/>
			<br />
			
			<input type="submit" value="아이디 찾기" id="submitBtn"/>
		</form>
	</div>
</body>
</html>