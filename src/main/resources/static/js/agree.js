function init() {
    const selectedAll = document.getElementById('selectedAll');
    const checkboxes = document.querySelectorAll('#agreementForm input[type="checkbox"]:not(#selectedAll)');
    const termsOfUse = document.getElementById('termsOfUse');
    const infoCollection = document.getElementById('InfoCollection');
    const submitBtn = document.getElementById('submitBtn');

    function updateSubmitButton() {
        if (termsOfUse.checked && infoCollection.checked) {
            submitBtn.disabled = false;
        }
		else {
            submitBtn.disabled = true;
        }
    }

    selectedAll.addEventListener('change', () => {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectedAll.checked;
        });
        updateSubmitButton();
    });

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            if (Array.from(checkboxes).every(cb => cb.checked)) {
                selectedAll.checked = true;
            } else {
                selectedAll.checked = false;
            }
            updateSubmitButton();
        });
    });

    termsOfUse.addEventListener('change', updateSubmitButton);
    infoCollection.addEventListener('change', updateSubmitButton);

    updateSubmitButton();
}

window.addEventListener('load', init);

