<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>프로필 수정</title>
    <script src="resources/js/editProfile.js"></script>
    <link rel="stylesheet" href="resources/css/editProfile.css" />
</head>
<body>
<div class="container">
    <h1 class="title">직장IN</h1>
    <form class="profile-section" method="POST" action="editProfileProgress">
        <div class="section-header">
            <h2>프로필 수정</h2>
        </div>
        <div class="personal-info">
            <div class="photo-section">
                <div class="photo-placeholder">사진 추가</div>
            </div>
            <div class="details-section">
                <div class="input-group">
                    <label for="nickname">닉네임</label>
                    <input type="text" name="nickname" id="nickname" value="" >
                </div>
                <div class="input-group">
                    <label for="userId">아이디</label>
                    <input type="text" name="user_id" id="userId" value="hwnsgur" readonly>
                </div>
                <div class="input-group">
                    <label for="name">이름</label>
                    <input type="text" name="name" id="name" value="" >
                </div>
                <div class="input-group">
                    <label for="email">이메일</label>
                    <input type="email" name="email" id="email" value="" >
                </div>
            </div>
        </div>
        <div class="career-section">
            <h3>경력</h3>
            <div class="career-inputs">
                <div class="input-group">
                    <input type="text" name="companyName" placeholder="회사명">
                </div>
                <div class="input-group">
                    <input type="text" name="jobTitle" placeholder="담당직무">
                </div>
                <div class="input-group">
                    <input type="text" name="startDate" placeholder="입사년월">
                </div>
                <div class="input-group">
                    <input type="text" name="endDate" placeholder="퇴사년월">
                </div>
                <div class="input-group checkbox-group">
                    <input type="checkbox" id="current" name="isEmployed">
                    <label for="current">재직</label>
                </div>
            </div>
            <button class="add-btn" type="button">+ 추가</button>
        </div>
        <button class="submit-btn" type="submit">적용</button>
    </form>
</div>
</body>
</html>
