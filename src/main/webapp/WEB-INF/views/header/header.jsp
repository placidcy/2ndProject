<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="header-container">
    <a href="main" class="logo">
        직장IN
    </a>
    <form class="search-form" method="GET" action="search">
        <div class="search">
            <input id="search-input" name="keyword" type="text" placeholder="궁금한 내용을 검색해보세요 !"/>
            <button id="searchBtn">검색</button>
        </div>
    </form>

    <div class="button-container">
        <a><button id = "loginBtn">로그인</button></a>
        <a><button id = "signUpOrMyPageBtn">회원가입</button></a>
        <c:if test="${nickname ne null}">
            <a><button id = "changePassWordBtn">비밀번호 변경</button></a>
        </c:if>
    </div>

</header>
