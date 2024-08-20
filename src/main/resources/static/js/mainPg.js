
function loginHandler() {
    location.href = '/login';
}

function logoutHandler() {
    sessionStorage.removeItem('auth');
    location.href = '/logout';
}

function mypageHandler() {
    location.href = '/mypage';
}

function signUpHandler() {
    location.href = '/agreement';
}

function changePassWordHandler() {
    location.href = '/changePasswd';
}

function init() {
    let profile = document.querySelector('#profile');
    let loginBtn = document.querySelector('#loginBtn');
    let signUpOrMyPageBtn = document.querySelector('#signUpOrMyPageBtn');

    let user = JSON.parse(sessionStorage.getItem('auth'));
    if (user != null) {
        let changePassWordBtn = document.querySelector('#changePassWordBtn');

        profile.innerHTML = "<div class='profile-image'>\n" +
            "    <img src='resources/images/anonymous.jpg' alt='profile'>\n" +
            "</div>\n" +
            "<div class='profile-info'>\n" +
            "    <div>닉네임 : " + user.nickname + "</div>\n" +
            "    <div>게시글 : ??</div>\n" +
            "</div>";

        loginBtn.innerHTML = '로그아웃';
        loginBtn.removeEventListener('click', loginHandler);
        loginBtn.addEventListener('click', logoutHandler);

        signUpOrMyPageBtn.innerHTML = '마이페이지';
        signUpOrMyPageBtn.addEventListener('click', mypageHandler);

        changePassWordBtn.addEventListener('click', changePassWordHandler);

    } else {
        profile.innerHTML = '로그인 후 이용하세요.';

        loginBtn.innerHTML = '로그인';
        loginBtn.addEventListener('click', loginHandler);

        signUpOrMyPageBtn.innerHTML = '회원가입';
        signUpOrMyPageBtn.addEventListener('click', signUpHandler);
    }
}

window.addEventListener('load',  init);