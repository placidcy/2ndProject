<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html lang="ko">
<head>
 <meta charset="UTF-8" />
 <title>게시글 작성 페이지</title>
 <script src="postForm.js"></script>   
 <link rel="stylesheet" href="postForm.css" />
</head>

<body>
<div id="container">
	<header>
	 <a href="메인페이지">직장IN</a>
	 <form method="POST" action="" id="searchform">
	 <input type="text" placeholder="제목으로 검색해보세요." id="searchValue" />
	 <input type="submit" value="검색" />
	 </form>
	</header>

	<hr />
	
<div id="leftBox">
    <button id="write">글쓰기</button>
    <div id="profile">
    <img src="images/anonymous.jpg" alt="anonymous" id="profileImg"/>
	<p class="profileText">${postCount} ${replyCount}</p>
    </div>
    <hr />
    <p>인기 Topic</p>
 </div>
 
 <div id="sectionBox">
	
	<form method="POST" id="questionForm">
		<label>직무선택</label>
		<input type="checkbox" name="jobCheck" id="jobCheck" />
		<br />
 		<select id="position">
 			<option value="Web">웹</option>
 			<option value="Server">서버</option>
 			<option value="Game">게임</option>
 			<option value="Data">데이터</option>
 			<option value="Security">보안</option>
 		</select>
		
		<hr />
		<input type="text" name="title" id="title" placeholder="제목" />
 		<hr />
 		<textarea cols="72" rows="20" id="content"></textarea>
 		<br />
 		<input type="text" name="tag" id="tag" placeholder="#태그 입력(#으로 구분해주세요.)"/>
 		<hr />
		<input type="submit" formaction="" value="질문하기" id="submitBtn"/> <input type="submit" formaction="" value="취소"/>
 		<!--submitForm, cancelForm 액션 추가하고 컨트롤러 생성 해야함-->
	</form>
 </div>

</div>
</body>
</html>