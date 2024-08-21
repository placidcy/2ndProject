function init() {
    let profile = document.querySelector('#profile');

    let user = JSON.parse(sessionStorage.getItem('auth'));
    if (user != null) {

        profile.innerHTML =
            "<div class='profile-image'>\n" +
            "    <a href='/editProfile'>" +
            "        <img src='resources/images/anonymous.jpg' alt='profile'>\n" +
            "    </a>\n" +
            "</div>\n" +
            "<div class='profile-info'>\n" +
            "    <div>닉네임 : " + user.nickname + "</div>\n" +
            "    <div>게시글 : "+user.postCount+"</div>\n" +
            "    <div>댓글 : "+user.replyCount+"</div>\n" +
            "</div>";

    } else {
        profile.innerHTML = '로그인 후 이용하세요.';
    }
}
// <%--<p class="profileText">게시글: ${postCount} 댓글: ${replyCount}</p>--%>

window.addEventListener('load',  init);