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
            <form action="#" method="POST">
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
<%--                 
                <div class="tagBox">
	                <c:forEach var="post" items="${postInfo}">
	                    <span># ${post.tags}</span>
	                </c:forEach>
                </div>
                 --%>
            </section>
            
            <form action="#" method="POST">
                <input type="text" name="commentBar" id="commentBar" placeholder="답변을 남겨주세요." />
                <button>등록</button>
            </form>

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
                <c:forEach var="reply" items="${repliesList}">
	                <div class="comment">
	                    <p>${reply.user_id} <%-- <span>${reply.career}</span> --%></p>
	                    <p>${reply.content}</p>
	                    <span>${reply.created_at}</span> 
	                    <div class="buttons">
		                    <a href="<c:url value='/modify' />"><button>수정</button></a> 
		                    <a href="<c:url value='/delete' />"><button>삭제</button></a>
	                    </div>
	                    <hr />
	                </div>
                </c:forEach>
                <div class="page">
                    <button>1</button> <button>2</button> <button>3</button> <button>></button> 
                </div>
            </section>
        </section>
    </container>

</body>
</html>