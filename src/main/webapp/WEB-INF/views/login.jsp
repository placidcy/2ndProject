<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
	<script src="resources/js/login.js"></script>
    <link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
<div id="container">
    <a href="<c:url value='/main' />"><div id="logo">직장IN</div></a>
    <form action="loginProcess" method="POST" >
        <div class="input-section">
            <input type="text" name="user_id" id="userId" placeholder="아이디"/>
            <input type="password" name="password" id="password" placeholder="비밀번호"/>
            <div class="options">
                <label>
                    <input type="checkbox" name="rememberId" id="saveId" value="true">
                    아이디 저장
                </label>
            </div>
        </div>
        <button type="submit" id="login-button">로그인</button>
    </form>

    <div id="help-links">
        <a href="<c:url value='/findID' />">아이디 찾기</a>
        <a href="<c:url value='/findPasswd' />">비밀번호 찾기</a>
        <a href="<c:url value='/agreement' />">회원가입</a>
    </div>
</div>
</body>
</html>
