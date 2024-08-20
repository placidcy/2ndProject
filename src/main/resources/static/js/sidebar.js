function init() {
    let profile = document.querySelector('#profile');

    let user = JSON.parse(sessionStorage.getItem('auth'));
    if (user != null) {

        profile.innerHTML = "<div class='profile-image'>\n" +
            "    <img src='resources/images/anonymous.jpg' alt='profile'>\n" +
            "</div>\n" +
            "<div class='profile-info'>\n" +
            "    <div>닉네임 : " + user.nickname + "</div>\n" +
            "    <div>게시글 : ??</div>\n" +
            "</div>";

    } else {
        profile.innerHTML = '로그인 후 이용하세요.';
    }
}

window.addEventListener('load',  init);