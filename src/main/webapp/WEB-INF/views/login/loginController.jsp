<%@ page import="com.project.model.UserDO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userDAO" class="com.project.model.UserDao" scope="session" />



<%

    if(request.getMethod().equals("POST")) {
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        UserDO user = userDAO.login(userId, password);
        if(user != null) {
            session.setAttribute("user", user);
            response.sendRedirect("main/main.jsp");
        } else {
            out.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다.'); history.back();</script>");
        }
    }
%>