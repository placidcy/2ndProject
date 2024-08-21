<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<aside class="sidebar">
    <div class="sidebar-container">

        <a href="<c:url value='/postForm' />">
            <button class="writeBtn">글쓰기</button>
        </a>
		<div id="profile" class="profile">
		<c:choose>
		<c:when test="${auth != null}">
		 <div class='profile-image'>
		  <a href='/editProfile'><img src='resources/images/anonymous.jpg' alt='profile'></a>
		 </div>
		 <div class='profile-info'>
			<div>닉네임: ${auth.nickname} </div>
			<div>게시글: ${postCount} </div>
			<div>댓글 : ${replyCount} </div>
		</div>	
		</c:when>
		<c:otherwise>
			로그인 후 이용하세요.	
		</c:otherwise>
		</c:choose>
		</div>
       

        <div class="best-post">
            <p>인기 Topic</p>
            <c:forEach var="hotPost" items="${hotPostList}" varStatus="status">
                <a href="/detailPageProcess?post_id=${hotPost.post_id}&commentCount=0">
                    <p class="hotTopic">${status.count}.
                        <c:choose>
                            <c:when test="${hotPost.title.length() > 9}">
                                ${hotPost.title.substring(0,9)}...
                            </c:when>
                            <c:otherwise>
                                ${hotPost.title}
                            </c:otherwise>
                        </c:choose>
                    </p>
                </a>
            </c:forEach>
        </div>
    </div>
</aside>