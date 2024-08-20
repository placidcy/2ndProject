document.addEventListener('DOMContentLoaded', () => {
    // 사진 추가 기능
    const photoPlaceholder = document.querySelector('.photo-placeholder');
    photoPlaceholder.addEventListener('click', () => {
        // 여기서는 파일 업로드를 위한 input 요소를 추가합니다.
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

        // 폼 데이터를 수집하는 로직을 추가합니다.
        const profileData = {
            nickname: document.querySelector('#nickname').value,
            userId: document.querySelector('#userid').value,
            name: document.querySelector('#name').value,
            email: document.querySelector('#email').value,
            careers: []
        };

        document.querySelectorAll('.career-section').forEach((section) => {
            const career = {
                companyName: section.querySelector('input[name="companyName"]').value,
                jobTitle: section.querySelector('input[name="jobTitle"]').value,
                startDate: section.querySelector('input[name="startDate"]').value,
                endDate: section.querySelector('input[name="endDate"]').value,
                isEmployed: section.querySelector('input[name="isEmployed"]').checked
            };
            profileData.careers.push(career);
        });
    });
});