<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css">
    <script>
        let auth = ${auth.nickname != null ? 'true' : null};

        if (auth) {
            // auth 객체가 존재할 경우 sessionStorage에 저장
            sessionStorage.setItem('auth', JSON.stringify({
                nickname: "${auth != null ? auth.nickname : ''}"
            }));
        }
    </script>
    <script src="/resources/js/mainPg.js"></script>
    <title>Main </title>
</head>
<body>
    <header class="header-container">
        <div class="logo">
            직장IN
        </div>
        <div class="search">
            <input type="text" placeholder="궁금한 내용을 검색해보세요 !"/>
        </div>


        <a><button id = "loginBtn">로그인</button></a>
        <a><button id = "signUpOrMyPageBtn">회원가입</button></a>

    </header>

    <div class="container">
        <jsp:include page="sidebar/sidebar.jsp" />
<%--        <aside class="sidebar">--%>
<%--            <div class="sidebar-container">--%>

<%--                 <a href="<c:url value='/postForm' />"><button class="writeBtn">글쓰기</button></a>--%>
<%--                <div id="profile" class="profile">--%>
<%--                    로그인 후 이용하세요--%>

<%--                </div>--%>

<%--                <div class="best-post">--%>
<%--                    인기 토픽--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </aside>--%>

        <main class="content">
<%--            <div class="tabs">--%>
<%--                <button class="scrap">스크랩</button>--%>
<%--                <button class="all">전체</button>--%>
<%--            </div>--%>
            <div class="post-container">
                글 목록
                <c:forEach items="${postList}" var="post">
                    <div class="post">
                        <div class="tags">
                            <span> # ${post.position}</span>
                        </div>
                        <div class="title">
                            <a href="#">${post.title}</a>
                        </div>
                        <div class="post-content">
                            ${post.content}
                        </div>
                        <div class="info">
                            <span> 조회수 : ${post.view_count}</span>
                            <span>추천수</span>
                            <span>댓글수</span>
                            <span>${post.created_date}</span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </main>
    </div>
</body>
</html>