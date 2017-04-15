<%-- 
    Document   : logout
    Created on : 13 Apr, 2017, 11:49:34 PM
    Author     : dorado
--%>
<%
    session.setAttribute("user_id", null);
    session.setAttribute("username", null);
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
