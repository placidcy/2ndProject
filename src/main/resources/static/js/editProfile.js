document.addEventListener('DOMContentLoaded', () => {

    const photoPlaceholder = document.querySelector('.photo-placeholder');
    photoPlaceholder.addEventListener('click', () => {
        const fileInput = document.createElement('input');
        fileInput.type = 'file';
        fileInput.accept = 'image/*';

        fileInput.addEventListener('change', (event) => {
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = () => {
                    photoPlaceholder.style.backgroundImage = `url(${reader.result})`;
                    photoPlaceholder.textContent = '';
                };
                reader.readAsDataURL(file);
            }
        });

        fileInput.click();
    });

    // 경력 추가 버튼 기능
    let careerIndex = 0;
    const addBtn = document.querySelector('.add-btn');
    addBtn.addEventListener('click', () => {
        const careerSection = document.querySelector('.career-section');
        const newCareerInput = document.createElement('div');
        newCareerInput.classList.add('career-inputs');

        newCareerInput.innerHTML = `
        <div class="input-group">
            <input type="text" name="careers[${careerIndex}].companyName" placeholder="회사명">
        </div>
        <div class="input-group">
            <input type="text" name="careers[${careerIndex}].jobTitle" placeholder="담당직무">
        </div>
        <div class="input-group">
            <input type="text" name="careers[${careerIndex}].startDate" placeholder="입사년월">
        </div>
        <div class="input-group">
            <input type="text" name="careers[${careerIndex}].endDate" placeholder="퇴사년월">
        </div>
        <div class="input-group checkbox-group">
            <input type="checkbox" class="current-checkbox" name="careers[${careerIndex}].isEmployed">
            <label>재직</label>
            <button class="remove-btn" type="button">- 제거</button>
        </div>
    `;
        // 제거 버튼 기능 추가
        newCareerInput.querySelector('.remove-btn').addEventListener('click', () => {
            newCareerInput.remove();
        });
        newCareerInput.querySelector('.current-checkbox').addEventListener('change', (event) => {
            if (event.target.checked) {
                document.querySelectorAll('.current-checkbox').forEach(checkbox => {
                    if (checkbox !== event.target) {
                        checkbox.checked = false;
                    }
                });
            }
        });

        careerSection.appendChild(newCareerInput);
        careerIndex++;
    });


    document.querySelector('.submit-btn').addEventListener('click', function (event) {
        alert("수정이 완료되었습니다.");
    });
});
