<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>상세 페이지</title>
    <link rel="stylesheet" href="resources/css/detailPage.css" />
	
</head>
<body>
    <header>
        <a href="<c:url value='/main' />"><h1 class="logo">직장IN</h1></a>
        <div class="searchBox">
            <form action="<c:url value='/search' />" method="POST">
                <input type="text" name="searchBar" placeholder="검색어를 입력하세요." />
            </form>
        </div>
    </header>

    <container>
        <section class="sideNavWrap">
			<%--              
			<a href="<c:url value='/postForm' />"><button>글쓰기</button></a>
            <div class="infoBox">
                <dl>
                    <dt>닉네임</dt>
                    <dd>
                        <span>글
                            <b>${postCount}</b>
                        </span>
                        <span>답변
                            <b>${replyCount}</b>
                        </span>
                    </dd>
                </dl>
            </div>
            --%>
            <jsp:include page="sidebar/sidebar.jsp" />
        </section>
        <section class="contentWrap">
            <section class="content">
                <div class="top">
                    <%-- <a href="#"><span>${postInfo.positon}</span></a> --%>
                    <h3>${postInfo.title}</h3>
                </div>
                <div class="date">
                    <span>${postInfo.created_date}</span>
                </div>
                <div class="post">
                    <p>${postInfo.content}</p>
                </div>
                <div  class="author">
                    <p>${postInfo.user_id}</p>
                </div>
				<c:if test="${postInfo.user_id == auth.user_id}">
				<div  class="postUD">
				    <a href="/postModify?post_id=${postInfo.post_id}"><button id="modifyBtn">수정</button></a>
					<a href="/postDelete?post_id=${postInfo.post_id}"><button id="deleteBtn">삭제</button></a>
				</div>
				</c:if> 
<%--                
                <div class="tagBox">
	                <c:forEach var="post" items="${postInfo}">
	                    <span># ${post.tags}</span>
	                </c:forEach>
                </div>
                 --%>
            </section>
 			<div class="commentBox">
			     <form action="submitReply" method="POST">
			        <input type="hidden" name="post_id" value="${postInfo.post_id}" />
			        <input type="hidden" name="user_id" value="${auth.user_id}" />
					<input type="hidden" name="commentCount" value="${commentCount}" />
					
			        <input name="content" id="commentBar" placeholder="답변을 남겨주세요." value="${modifyReply}" required />
			    
					<c:choose>
					<c:when test="${modifyReply == null}">
					<button type="submit" formaction="<c:url value='/submitReply' />">등록</button>
					</c:when>
					<c:otherwise>
					<input type="hidden" name="reply_id" value="${modifyReply_id}" />
					<button type="submit" formaction="<c:url value='/replyUpdate' />">수정</button>
					</c:otherwise>
					</c:choose>

			    </form>
 			</div>
            <section class="warning">
                <ul>
                    <li>
                        답변을 등록하면 닉네임으로 작성자에게 전달됩니다. 
                    </li>
                    <li>
                        개인 정보를 공유 및 요청하거나, 명예훼손, 무단 관고, 불법 정보 유포 시 이에 대한 민형사상 책임은 작성자에게 있습니다.
                    </li>
                    <li>
                        개인정보가 포함되거나 부적절한 댓글은 비노출 또는 해당 서비스 이용 불가 처리될 수 있습니다. 
                    </li>
                </ul>
            </section>

            <section class="commentWrap">
                <h4 class="total-comment">답변 ${repliesList.size()}</h4>
                <c:forEach var="reply" items="${repliesList}" begin="${commentCount*10}" end="${commentCount*10 + 9}">
	                <div class="comment">
	                    <p>${reply.user_id} <%-- <span>${reply.career}</span> --%></p>
	                    <p>${reply.content}</p>
	                    <span>${reply.created_at}</span>
                        <form action="reply-like" method="POST">
                       		<input type="hidden" name="commentCount" value="${commentCount}" />
                            <button type="submit">좋아요</button>
                        </form>
                        <span>${reply.likes}</span>
						<c:if test="${reply.user_id == auth.user_id}">
                        <div class="buttons">
		                    <a href="<c:url value='/replyModify?post_id=${postInfo.post_id}&reply_id=${reply.reply_id}' />"><button>수정</button></a> 
		                    <a href="<c:url value='/replyDelete?post_id=${postInfo.post_id}&reply_id=${reply.reply_id}' />"><button>삭제</button></a>
	                    </div>
						</c:if>
	                    <hr />
	                </div>
                </c:forEach>
                <div class="page">
					<c:forEach  begin="0" end="${Math.floor(repliesList.size()/10)}" varStatus="status">
						<a href="/detailPageProcess?post_id=${postInfo.post_id}&commentCount=${status.count-1}"><button>${status.count} </button></a>
					</c:forEach>
                </div>
            </section>
        </section>
    </container>

</body>
</html>