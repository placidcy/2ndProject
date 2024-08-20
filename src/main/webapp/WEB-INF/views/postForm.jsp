<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>게시글 작성 페이지</title>
    <!-- CSS 링크 -->
    <link rel="stylesheet" href="<c:url value='/resources/css/postForm.css' />" />
    <link rel="stylesheet" href="/resources/css/sidebar.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <!-- JavaScript 파일 링크 -->
    <script src="<c:url value='/resources/js/postForm.js' />" defer></script>
    <script src="/resources/js/header.js"></script>
    <script src="/resources/js/sidebar.js"></script>
</head>
<body>
    <jsp:include page="header/header.jsp">
        <jsp:param name="nickname" value="${auth.nickname}"/>
        <jsp:param name="hotPostList" value="${hotPostList}"/>
    </jsp:include>
    <div class="container">
        <jsp:include page="sidebar/sidebar.jsp" />
        <main class="content">
            <div id="sectionBox">
                <form method="POST" id="questionForm">
                    <label for="position">직무선택</label>
                    <select name="position" id="position">
                        <option value="웹">웹</option>
                        <option value="서버">서버</option>
                        <option value="게임">게임</option>
                        <option value="데이터">데이터</option>
                        <option value="보안">보안</option>
                    </select>

                    <hr />
                    <input type="text" name="title" id="title" placeholder="제목" value="${postInfo.title}" />

                    <hr />
                    <textarea name="content" id="content" placeholder="내용을 입력하세요.">${postInfo.content}</textarea>

                    <hr />
                    <input type="text" name="tags" id="tags" placeholder="#태그 입력(#으로 구분해주세요.)" value="${postInfo.tags}" />

                    <hr />
					<div id="btnBox">
                        <c:choose>
                            <c:when test="${postInfo == null}">
                                <input type="submit" formaction="<c:url value='/postFormProcess' />" value="질문하기" id="submitBtn"/>
                                <a href="<c:url value='/main' />"><button type="button" class="cancelBtn">취소</button></a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" formaction="<c:url value='/postUpdate' />" value="수정하기" id="submitBtn"/>
                                <input type="hidden" name="post_id" value="${postInfo.post_id}" />
                                <a href="/detailPageProcess?post_id=${postInfo.post_id}&commentCount=0"><button type="button" class="cancelBtn">취소</button></a>
                            </c:otherwise>
                        </c:choose>
					</div>
				</form>
            </div>
        </main>
    </div>
</body>
</html>