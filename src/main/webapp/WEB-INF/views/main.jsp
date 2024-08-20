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
                user_id: "${auth != null ? auth.user_id : ''}",
                nickname: "${auth != null ? auth.nickname : ''}"
            }));
        }
    </script>
    <script src="/resources/js/mainPg.js"></script>
    <title>Main</title>
</head>
<body>
    <header class="header-container">
        <div class="logo">
            직장IN
        </div>
        <form method="GET" action="search">
            <div class="search">
                <input id="search-input" name="keyword" type="text" placeholder="궁금한 내용을 검색해보세요 !"/>
                <button id="searchBtn">검색</button>
            </div>
        </form>

        <div class="button-container">
            <a><button id = "loginBtn">로그인</button></a>
            <a><button id = "signUpOrMyPageBtn">회원가입</button></a>
        </div>

    </header>

    <div class="container">
        <jsp:include page="sidebar/sidebar.jsp" />
        <main class="content">
            <div class="post-container">
                <div class="list-title">
                    <c:choose>
                        <c:when test="${keyword != null}">
                            <span>${keyword} 검색결과</span>
                        </c:when>
                        <c:otherwise>
                            <span>글 목록</span>
                        </c:otherwise>
                    </c:choose>
                </div>
                <c:forEach items="${postList}" var="post">
                    <div class="post">
                        <div class="tags">
                             <a href="<c:url value="/search-position?position=${post.position}"/>">
                                 # ${post.position}
                             </a>
                        </div>
                        <div class="title">
                            <a href="/detailPageProcess?post_id=${post.post_id}&commentCount=0">${post.title}</a>
                        </div>
                        <div class="post-content">
                            ${post.content}
                        </div>
                        <div class="info">
                            <span> 조회수 : ${post.view_count} </span>
                            <span>댓글수 ${repliesList.size()} </span>
                            <span>${post.created_date} </span>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- 페이지 번호 네비게이션 -->
            <div class="pagination">
                <c:if test="${postCount > 1}">
                    <a href="?postCount=${postCount - 1}"> < ;</a>
                </c:if>

                <c:forEach begin="1" end="${totalPages}" var="i">
                    <c:choose>
                        <c:when test="${i == postCount}">
                            <span class="current">${i}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="?postCount=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${postCount < totalPages}">
                    <a href="?postCount=${postCount + 1}"> > </a>
                </c:if>
            </div>
        </main>
    </div>
</body>
</html>