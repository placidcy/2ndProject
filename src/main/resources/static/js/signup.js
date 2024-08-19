document.addEventListener('DOMContentLoaded', function() {


    const passwordFields = document.querySelectorAll('.input-group input[type="password"]');
    let preference;

    //password/text 교체
    document.querySelectorAll('.eye-btn').forEach((button, index) => {
        button.addEventListener('click', function () {
            const field = passwordFields[index];
            const type = field.getAttribute('type') === 'password' ? 'text' : 'password';
            field.setAttribute('type', type);
        });
    });

    //유효성 검사
    function validateForm() {
        const userId = document.getElementById('userid')
        const password = document.getElementById('password')
        const confirmPassword = document.getElementById('confirm-password')
        const name = document.getElementById('name')
        const nickname = document.getElementById('nickname')
        const email = document.getElementById('email')

        userId.classList.remove('invalid');
        password.classList.remove('invalid');
        confirmPassword.classList.remove('invalid');
        name.classList.remove('invalid');
        nickname.classList.remove('invalid');
        email.classList.remove('invalid');

        if (!userId.value.trim()) {
            alert("아이디를 입력해주세요.");
            userId.classList.add('invalid')
            return false;
        }
        if (!password.value.trim()) {
            alert("비밀번호를 입력해주세요.");
            password.classList.add('invalid')
            return false;
        }
        if (password.value.trim() !== confirmPassword.value.trim()) {
            alert("비밀번호가 일치하지 않습니다.");
            confirmPassword.classList.add('invalid')
            return false;
        }
        if (!name.value.trim()) {
            alert("이름을 입력해주세요.");
            name.classList.add('invalid')
            return false;
        }
        if (!nickname.value.trim()) {
            alert("닉네임을 입력해주세요.");
            nickname.classList.add('invalid')
            return false;
        }
        if (!email.value.trim()) {
            alert("이메일을 입력해주세요.");
            email.classList.add('invalid')
            return false;
        }
        if (!validateEmail(email.value.trim())) {
            alert("유효한 이메일 주소를 입력해주세요.");
            email.classList.add('invalid')
            return false;
        }

        return true;
    }

    function validateEmail(email) {
        const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        return re.test(String(email).toLowerCase());
    }

    document.querySelectorAll('.preference-btn').forEach(button => {
        button.addEventListener('click', function () {
            document.querySelectorAll('.preference-btn').forEach(btn => btn.classList.remove('selected'));
            button.classList.toggle('selected');

            const buttonValue = button.value;
            preference = buttonValue;
            console.log("Selected value:", buttonValue);
        });
    });

    document.querySelector('.submit-btn').addEventListener('click', function (event) {
        if (!validateForm()) {
            event.preventDefault();
        } else {
            console.log("id : " ,document.getElementById('userid').value.trim());
            console.log("pw : " ,document.getElementById('password').value.trim());
            console.log("ckpw : " ,document.getElementById('confirm-password').value.trim());
            console.log("name : " ,document.getElementById('name').value.trim());
            console.log("nickname : " ,document.getElementById('nickname').value.trim());
            console.log("email : " ,document.getElementById('email').value.trim());
            console.log("Selected value:", preference);
        }
    });
});
