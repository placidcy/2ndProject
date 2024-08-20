let nameTag;
let emailTag;
let sumbitButton;

function isEmptyBlank() {
	let isEmpty = true;
	
	if(nameTag.value.trim() === "") {
		console.log(nameTag.value.trim());
		alert("아이디를 입력하세요");
		isEmpty = false;
	}
	
	else if(emailTag.value.trim() === "") {
		console.log(emailTag.value.trim());
		alert("이메일을 입력하세요");
		isEmpty = false;
	}
	
	return isEmpty;
}

function clickSubmitBtn() {
	sumbitButton.addEventListener("click", (event) => {
		if(isEmptyBlank() === false) {
			event.preventDefault();
		}
	});
}


function init() {
	nameTag = document.querySelector("#name");
	emailTag = document.querySelector("#email");
	sumbitButton = document.querySelector("#submitBtn");
	
	clickSubmitBtn();
}

window.addEventListener("load", init);