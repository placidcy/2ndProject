function submitHandler(event){
	let oldPasswd = document.querySelector('#oldPasswd');
	let newPasswd = document.querySelector('#newPasswd');
	let confirmNewPasswd = document.querySelector('#confirmNewPasswd');

	
	if(oldPasswd.value === newPasswd.value){
		if(oldPasswd.value.trim() || newPasswd.value.trim() || confirmNewPasswd.value.trim()){
			alert('현재 비밀번호와 새로운 비밀번호가 같습니다.');
			event.preventDefault();
		}
		else{
			alert('비밀번호를 입력해 주세요');
			event.preventDefault();
		}	
	}
	else if(newPasswd.value !== confirmNewPasswd.value && newPasswd.value.length > 0){
		alert('비밀번호 확인 값이 다릅니다.');
		event.preventDefault();
	}
	else if(newPasswd.value.length < 4){
		alert('비밀번호는 4자리 이상이어야 합니다.');
		event.preventDefault();
	}
}

function init(){
	document.querySelector('#changePasswdForm').addEventListener('submit',submitHandler);
}


window.addEventListener('load',init);