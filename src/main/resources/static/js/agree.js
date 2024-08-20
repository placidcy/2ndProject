function selectAllButton() {
	const checkboxes = document.querySelectorAll('input[type="checkbox"]');
	checkboxes.forEach((checkbox)=>{
		checkbox.checked = document.querySelector('#selectedAll').checked;
	});
}

document.querySelector('#selectedAll').addEventListener('click', selectAllButton);