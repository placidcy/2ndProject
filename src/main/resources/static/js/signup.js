function mainHandler() {
    location.href = '/main';
}
document.addEventListener('DOMContentLoaded', function() {
    const logo = document.querySelector('.logo');
    logo.addEventListener('click', mainHandler);
    //password/text 교체
    const passwordFields = document.querySelectorAll('.input-group input[type="password"]');
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

    //이메일 유효성 검사
    function validateEmail(email) {
        const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        return re.test(String(email).toLowerCase());
    }

    //선호 직종 선택
    document.querySelectorAll('.preference-btn').forEach(button => {
        button.addEventListener('click', function () {
            const isSelected = button.classList.contains('selected');
            document.querySelectorAll('.preference-btn').forEach(btn => {
                btn.classList.remove('selected');
            });

            if (!isSelected) {
                button.classList.add('selected');
                document.getElementById('preference').value = button.value;
            } else {
                document.getElementById('preference').value = "";
            }
        });
    });



    document.querySelector('.submit-btn').addEventListener('click', function (event) {
        if (!validateForm()) {
            event.preventDefault();
        } else {
            const form = document.querySelector('.signup-form');
            form.submit();
            alert("회원가입이 완료되었습니다.");
        }
    });
});
