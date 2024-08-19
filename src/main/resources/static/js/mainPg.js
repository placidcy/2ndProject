
function loginHandler() {
    location.href = '/login';
}

function logoutHandler() {
    sessionStorage.removeItem('user');
    location.reload();
}

function init() {
    let profile = document.querySelector('#profile');
    let loginBtn = document.querySelector('#loginBtn');
    let user = JSON.parse(sessionStorage.getItem('auth'));
    console.log(user.nickname);
    if (user) {
        // user = JSON.parse(user);
        profile.innerHTML = "<div class='profile-image'>\n" +
            "    <img src='static/images/anonymous.jpg' alt='profile'>\n" +
            "</div>\n" +
            "<div class='profile-info'>\n" +
            "    <span>닉네임 : " + user.nickname + "</span>\n" +
            "    <span>게시글 : ??</span>\n" +
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