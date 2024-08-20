function logoHandler() {
    location.href = '/main';
}
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
    let loginBtn = document.querySelector('#loginBtn');
    let signUpOrMyPageBtn = document.querySelector('#signUpOrMyPageBtn');

    let user = JSON.parse(sessionStorage.getItem('auth'));
    if (user != null) {
        let changePassWordBtn = document.querySelector('#changePassWordBtn');

        loginBtn.innerHTML = '로그아웃';
        loginBtn.removeEventListener('click', loginHandler);
        loginBtn.addEventListener('click', logoutHandler);

        signUpOrMyPageBtn.innerHTML = '마이페이지';
        signUpOrMyPageBtn.addEventListener('click', mypageHandler);

        changePassWordBtn.addEventListener('click', changePassWordHandler);

    } else {
        loginBtn.innerHTML = '로그인';
        loginBtn.addEventListener('click', loginHandler);

        signUpOrMyPageBtn.innerHTML = '회원가입';
        signUpOrMyPageBtn.addEventListener('click', signUpHandler);
    }
}

window.addEventListener('load',  init);