let allBoxes;
let checkingAllBoxes;
let adReception;
let submitBtn;

function checkAllChecked() {
	let checkResult = false;
	let uncheckedBoxesCount = 0;

	for (let checkBox of allBoxes) {
		if (checkBox !== checkingAllBoxes && checkBox !== adReception && checkBox.checked === false) {
			uncheckedBoxesCount++;
		}
	}

	if (uncheckedBoxesCount > 0) {
		alert("필수로 체크할 내용을 확인하세요");
		checkResult = false;
	}

	else {
		checkResult = true;
	}

	return checkResult;
}

function allCheckBoxes() {
	checkingAllBoxes.addEventListener("click", () => {
		for (let checkBox of allBoxes) {
			if (checkingAllBoxes.checked === true) {
				checkBox.checked = true;
			}

			else {
				checkBox.checked = false;
			}
		}
	});
}

function clickSubmitBtn() {
	submitBtn.addEventListener("click", (event) => {
		if (checkAllChecked() === false) {
			event.preventDefault();
		}
	});
}


function init() {
	checkingAllBoxes = document.querySelector("#allCheckingBox");
	allBoxes = document.querySelectorAll(".radio");
	adReception = document.querySelector("#adReception");
	submitBtn = document.querySelector("#submitBtn");

	allCheckBoxes();
	clickSubmitBtn();
}

window.addEventListener("load", init);