let allBoxes;
let checkingAllBoxes;
let adReception;
let submitBtn;
let infoBox;
let termsBox;

function checkAllChecked() {
	let uncheckedBoxesCount = 0;

	if (infoBox.checked === false) {
		uncheckedBoxesCount++;
	} else if (termsBox.checked === false) {
		uncheckedBoxesCount++;
	}

	if (uncheckedBoxesCount > 0) {
		submitBtn.disabled = true;
	} else {
		submitBtn.disabled = false;
	}
}

function allCheckBoxes() {
	checkingAllBoxes.addEventListener("click", () => {
		if(checkingAllBoxes.checked === false) {
			for (let checkBox of allBoxes) {
				checkBox.checked = false;
			}
			submitBtn.disabled = true;
		} else {
			for (let checkBox of allBoxes) {
				if (checkingAllBoxes.checked === true) {
					checkBox.checked = true;
				}
			}
			submitBtn.disabled = false;
		}
	});
}


function init() {
	checkingAllBoxes = document.querySelector("#allCheckingBox");
	allBoxes = document.querySelectorAll(".radio");
	submitBtn = document.querySelector("#submitBtn");

	infoBox = document.querySelector("#InfoCollection");
	termsBox = document.querySelector("#termsOfUse");
	adReception = document.querySelector("#adReception");


	allCheckBoxes();
	infoBox.addEventListener("click", checkAllChecked);
	termsBox.addEventListener("click", checkAllChecked);
}

window.addEventListener("load", init);