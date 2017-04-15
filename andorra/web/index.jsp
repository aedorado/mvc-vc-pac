<%-- 
    Document   : home
    Created on : 13 Apr, 2017, 12:03:16 PM
    Author     : dorado
--%>
<% 
if (session.getAttribute("username") == null) {
    response.sendRedirect("login.jsp");
}  
%>
<%@include file="header.jsp" %>
<%@include file="navbar.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.UserBean" %>
<%@page import="model.ImageBean" %>
<%@page import="dao.UserDaoImp" %>
<%@page import="dao.ImageDaoImp" %>
<%@page import="java.util.List" %>
<%    
long user_id = (Long) session.getAttribute("user_id");
UserDaoImp udi = new UserDaoImp();
List<Integer> imgIdList = udi.listImagesPostedByFollowing(user_id);
%>
<%!
public String pageHTML(List<Integer> imgIdList, HttpSession session) {
    String output = "";
    for (Integer i: imgIdList) {
        output += imageIdToHTML(i.intValue(), session);
    }
    return output;
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="major-div">
            <% out.println(pageHTML(imgIdList, session)); %> 
        </div>
    </body>
</html>
