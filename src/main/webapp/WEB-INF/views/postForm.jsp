<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>게시글 작성 페이지</title>
    <!-- CSS 링크 -->
    <link rel="stylesheet" href="<c:url value='/resources/css/postForm.css' />" />
    <!-- JavaScript 파일 링크 -->
    <script src="<c:url value='/resources/js/postForm.js' />" defer></script>
</head>
<body>
    <div id="container">
        <header>
            <a href="<c:url value='/main' />"><h1 class="logo">직장IN</h1></a>
            <div class="searchBox">
                <form method="POST" action="<c:url value='/search' />" id="searchform">
                    <div id="searchDisplay">
                        <input type="text" name="searchBar" placeholder="제목으로 검색해보세요." id="searchValue" />
                        <button type="submit">검색</button>
                    </div>
                </form>
            </div>
        </header>

        <div class="main">
            <aside class="sidebar">
                <div class="sidebar-container">
                    <a href="<c:url value='/postForm' />"><button class="writeBtn">글쓰기</button></a>
                    <div class="profile">
                        <img src="<c:url value='/resources/images/anonymous.jpg' />" alt="anonymous" id="profileImg"/>
                        <p class="profileText">${auth.nickname}</p>
                        <p class="profileText">게시글: ${postCount} 댓글: ${replyCount}</p>
                    </div>
                    <div class="best-post">
                        <p>인기 Topic</p>
                    </div>
                </div>
            </aside>

            <div id="sectionBox">
                <form method="POST" action="<c:url value='/postFormProcess' />" id="questionForm">
                    <label for="position">직무선택</label>
                    <select name="position" id="position">
                        <option value="웹">웹</option>
                        <option value="서버">서버</option>
                        <option value="게임">게임</option>
                        <option value="데이터">데이터</option>
                        <option value="보안">보안</option>
                    </select>

                    <hr />
                    <input type="text" name="title" id="title" placeholder="제목" />

                    <hr />
                    <textarea name="content" id="content" placeholder="내용을 입력하세요."></textarea>

                    <hr />
                    <input type="text" name="tags" id="tags" placeholder="#태그 입력(#으로 구분해주세요.)"/>

                    <hr />
					<div id="btnBox">
                    <input type="submit" value="질문하기" id="submitBtn"/>
                    <a href="<c:url value='/main' />"><button type="button" class="cancelBtn">취소</button></a>
                	</div>
				</form>
            </div>
        </div>
    </div>
</body>
</html>