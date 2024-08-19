<%@ page contentType="text/html; charset=UTF-8" %>

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
    <h1 class="title">직장IN</h1>
    <h2 class="section-title">[필수] 회원 정보 입력</h2>
    <form class="signup-form" method="POST" action="signup">
        <div class="input-group">
            <input type="text" name="userId" id="userid" placeholder="아이디">
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

        <h2 class="section-title">[선택] 선호 직종</h2>

        <div class="job-preferences">
            <button class="preference-btn" value="secure" type="button">보안</button>
            <button class="preference-btn" value="server" type="button">서버</button>
            <button class="preference-btn" value="game" type="button">게임</button>
            <button class="preference-btn" value="data" type="button">데이터</button>
            <button class="preference-btn" value="web" type="button">웹</button>
        </div>

        <button class="submit-btn" type="submit">회원가입</button>
    </form>
</div>
</body>
</html>