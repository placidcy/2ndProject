
function loginHandler() {
    location.href = '/login';
}

function logoutHandler() {
    sessionStorage.removeItem('auth');
    location.reload();
}

function init() {
    let profile = document.querySelector('#profile');
    let loginBtn = document.querySelector('#loginBtn');
    let user = JSON.parse(sessionStorage.getItem('auth'));
    if (user) {
        // user = JSON.parse(user);
        profile.innerHTML = "<div class='profile-image'>\n" +
            "    <img src='resources/static/images/anonymous.jpg' alt='profile'>\n" +
            "</div>\n" +
            "<div class='profile-info'>\n" +
            "    <div>닉네임 : " + user.nickname + "</div>\n" +
            "    <div>게시글 : ??</div>\n" +
            "</div>";
        loginBtn.innerHTML = '로그아웃';
        loginBtn.addEventListener('click', logoutHandler);
    } else {
        profile.innerHTML = '로그인 후 이용하세요.';
        loginBtn.innerHTML = '로그인';
        loginBtn.addEventListener('click', loginHandler);
    }
}



window.addEventListener('load',  init);