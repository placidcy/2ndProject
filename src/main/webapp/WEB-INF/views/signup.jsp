<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <script src="resources/js/signup.js"></script>
    <link rel="stylesheet" href="resources/css/signup.css" />
</head>
<body>
<div class="container">
    <div class="logo">
        <a href="<c:url value='/main' />">직장IN</a>
    </div>
    <h2 class="section-title"><span>[필수] </span>회원 정보 입력</h2>
    <form class="signup-form" method="POST" action="signupProgress">
        <div class="input-group">
            <div class="input-group">
                <input type="text" name="user_id" id="userid" placeholder="아이디">
            </div>
            <div class="input-group">
                <input type="password" name="password" id="password" placeholder="비밀번호">
                <button class="eye-btn" type="button">&#128065;</button>
            </div>
            <div class="input-group">
                <input type="password" id="confirm-password" placeholder="비밀번호 확인">
                <button class="eye-btn" type="button">&#128065;</button>
            </div>
            <div class="input-group">
                <input type="text" name="name" id="name" placeholder="이름">
            </div>
            <div class="input-group">
                <input type="text" name="nickname" id="nickname" placeholder="닉네임">
            </div>
            <div class="input-group">
                <input type="email" name="email" id="email" placeholder="이메일">
            </div>
<!-- 
            <h2 class="section-title">[선택] 선호 직종</h2>
            <input type="hidden" name="preference" id="preference">
            <div class="job-preferences">
                <button class="preference-btn" value="secure" type="button">보안</button>
                <button class="preference-btn" value="server" type="button">서버</button>
                <button class="preference-btn" value="game" type="button">게임</button>
                <button class="preference-btn" value="data" type="button">데이터</button>
                <button class="preference-btn" value="web" type="button">웹</button>
            </div>
 -->
        </div>
        <button class="submit-btn" type="submit">회원가입</button>
    </form>
</div>
</body>