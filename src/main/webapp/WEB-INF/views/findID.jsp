<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String userID = request.getParameter("user_id"); 
%>

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
		</section>
		<form method="POST" action="getUserID" id="findIDForm">
			<input type="text" name="name" id="name" placeholder="이름"/>
			<br />
			<input type="email" name="email" id="email" placeholder="이메일"/>
			<br />
			
			<c:set var="identify" value="${userID}" />
				<c:choose>
					<c:when test="${identify != ''}">
						<c:out value="${identify}" />
					</c:when>
					
					<c:otherwise>
						<p>찾는 아이디가 없습니다</p>
					</c:otherwise>
				</c:choose>
			<br />
			
			<input type="submit" value="아이디 찾기" id="submitBtn"/>
		</form>
		
		

	</div>
</body>
</html>