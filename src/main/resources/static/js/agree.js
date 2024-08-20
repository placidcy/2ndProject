function init() {
    const selectedAll = document.getElementById('selectedAll');
    const termsOfUse = document.getElementById('termsOfUse');
    const infoCollection = document.getElementById('InfoCollection');
    const submitBtn = document.getElementById('submitBtn');
    const checkboxes = document.querySelectorAll('#agreementForm input[type="checkbox"]:not(#selectedAll)');

    function canClickNext() {
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
        canClickNext();
    });

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            if (Array.from(checkboxes).every(cb => cb.checked)) {
                selectedAll.checked = true;
            } else {
                selectedAll.checked = false;
            }
            canClickNext();
        });
    });

    termsOfUse.addEventListener('change', canClickNext);
    infoCollection.addEventListener('change', canClickNext);

    canClickNext();
}

window.addEventListener('load', init);

