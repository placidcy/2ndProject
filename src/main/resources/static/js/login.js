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


function setCookie(name, value, days) {
    let cookieString = `${name} = ${value || ''} ;`;

    if (days) {
        const date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        cookieString += `expires=${date.toUTCString()} ;`;
    }

    document.cookie = `${cookieString} path=/`;
}



function loginHandler() {
    const username = document.getElementById('user_id').value;
    const saveId = document.getElementById('saveId').checked;
    if(saveId) {
        setCookie('saveId', username, 30);
    } else {
        setCookie('saveId', '', 0);
    }
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