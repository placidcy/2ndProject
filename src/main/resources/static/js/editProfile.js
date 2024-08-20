
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
    const addBtn = document.querySelector('.add-btn');
    addBtn.addEventListener('click', () => {
        const careerInputs = document.querySelector('.career-inputs');
        const newCareerSection = document.createElement('div');
        newCareerSection.classList.add('career-section');
        newCareerSection.innerHTML = `
            <div class="input-group">
                <input type="text" name="companyName" placeholder="회사명">
            </div>
            <div class="input-group">
                <input type="text" name="jobTitle" placeholder="담당직무">
            </div>
            <div class="input-group">
                <input type="text" name="startDate" placeholder="입사년월">
            </div>
            <div class="input-group">
                <input type="text" name="endDate" placeholder="퇴사년월">
            </div>
            <div class="input-group checkbox-group">
                <input type="checkbox" id="current" name="isEmployed">
                <label for="current">재직</label>
            </div>
            <button class="remove-btn" type="button">- 제거</button>
        `;

        // 제거 버튼 기능 추가
        newCareerSection.querySelector('.remove-btn').addEventListener('click', () => {
            newCareerSection.remove();
        });

        careerInputs.appendChild(newCareerSection);
    });

    // 폼 제출
    const submitBtn = document.querySelector('.submit-btn');
    submitBtn.addEventListener('click', (event) => {
        event.preventDefault();
    });
});