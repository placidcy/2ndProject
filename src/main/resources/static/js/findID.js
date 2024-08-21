let nameTag;
let emailTag;
let sumbitButton;
let userID;

function isEmptyBlank() {
	let isEmpty = true;

	if (nameTag.value.trim() === "") {
		console.log(nameTag.value.trim());
		alert("아이디를 입력하세요");
		isEmpty = false;
	}

	else if (emailTag.value.trim() === "") {
		console.log(emailTag.value.trim());
		alert("이메일을 입력하세요");
		isEmpty = false;
	}

	return isEmpty;
}

function clickSubmitBtn() {
	sumbitButton.addEventListener("click", (event) => {
		if (isEmptyBlank() === false) {
			event.preventDefault();
		}
		
		else if(userID.user_id === "") {
			event.preventDefault();
			alert("찾는 아이디가 없습니다");
		}
	});
}


function init() {
	nameTag = document.querySelector("#name");
	emailTag = document.querySelector("#email");
	sumbitButton = document.querySelector("#submitBtn");
	
    let tempIDvalue = fetch("/findUserID", {method: "post"}).then(response => response.json());
	userID = JSON.parse(tempIDvalue);

	clickSubmitBtn();
}

window.addEventListener("load", init);