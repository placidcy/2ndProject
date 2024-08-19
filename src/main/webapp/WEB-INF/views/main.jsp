<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css">
    <script>
        console.log("${auth.nickname}");
        // auth 변수를 sessionStorage에 저장
        if (sessionStorage.getItem('auth') === null) {
            sessionStorage.setItem('auth',
                '{"nickname": "${auth.nickname}" }'
            );
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


        <a href="<c:url value='/login' />"><button>로그인</button></a>
        <a href="<c:url value='/regist' />"><button>회원가입</button></a>

    </header>

    <div class="container">
        <aside class="sidebar">
            <div class="sidebar-container">

                 <a href="<c:url value='/postForm' />"><button class="writeBtn">글쓰기</button></a>
                <div class="profile">
                    로그인 후 이용하세요

                </div>

                <div class="best-post">
                    인기 토픽
                </div>
            </div>
        </aside>

        <main class="content">
            <div class="tabs">
<%--                <button class="scrap">스크랩</button>--%>
<%--                <button class="all">전체</button>--%>
                글 목록

            </div>
            <div class="post-container">
                <div class="post">
                    <div class="tags">
                        <span>태그1</span>
                        <span>태그2</span>
                        <span>태그3</span>
                    </div>
                    <div class="title">
                        <a href="#">제목</a>
                    </div>
                    <div class="post-content">
                        내용
                    </div>
                    <div class="info">
                        <span>조회수</span>
                        <span>추천수</span>
                        <span>댓글수</span>
                        <span>날짜</span>
                    </div>
                </div>

                <div class="post">
                    <div class="tags">
                        <span>태그1</span>
                        <span>태그2</span>
                        <span>태그3</span>
                    </div>
                    <div class="title">
                        <a href="#">제목</a>
                    </div>
                    <div class="post-content">
                        내용
                    </div>
                    <div class="info">
                        <span>조회수</span>
                        <span>추천수</span>
                        <span>댓글수</span>
                        <span>날짜</span>
                    </div>
                </div>

                <div class="post">
                    <div class="tags">
                        <span>태그1</span>
                        <span>태그2</span>
                        <span>태그3</span>
                    </div>
                    <div class="title">
                        <a href="#">제목</a>
                    </div>
                    <div class="post-content">
                        내용
                    </div>
                    <div class="info">
                        <span>조회수</span>
                        <span>추천수</span>
                        <span>댓글수</span>
                        <span>날짜</span>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>