function getCookie(name) {
    const decodedCookie = decodeURIComponent(document.cookie);
    const cookies = decodedCookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
        let cookie = cookies[i].trim();
        if (cookie.indexOf(name + "=" ) === 0) {
            return cookie.substring((name + "=").length, cookie.length);
        }
    }
    return null;
}



function loginHandler() {
    const username = document.getElementById('user_id').value;
    const saveId = document.getElementById('saveId').checked;
}



function init() {
    const saveId = getCookie('saveId');
    if(saveId) {
        document.getElementById('user_id').value = saveId;
        document.getElementById('saveId').checked = true;
    }

    document.getElementById('login-button').addEventListener('click', loginHandler);
}

window.addEventListener('load', init);