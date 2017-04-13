<%-- 
    Document   : profile.jsp
    Created on : 13 Apr, 2017, 12:02:34 PM
    Author     : dorado
--%>
<%@include file="header.jsp" %>
<%@include file="navbar.html" %>
<%
    redirectIfSessionUnset(response, session);
%>

<%@page import="model.UserBean" %>
<%@page import="model.ImageBean" %>
<%@page import="dao.UserDaoImp" %>
<%@page import="dao.ImageDaoImp" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
long user_id = Long.parseLong(request.getParameter("user_id"));
UserDaoImp udi = new UserDaoImp();
long totalImagesPosted = udi.totalImagesPosted(user_id);
long totalFollowers = udi.totalFollowers(user_id);
long totalFollowing = udi.totalFollowing(user_id);
List<Integer> imgIdList = udi.listImagesPosted(user_id);
%>
<%!
public String pageHTML(List<Integer> imgIdList) {
    String output = "";
    for (Integer i: imgIdList) {
        output += imageIdToHTML(i.intValue());
    }
    return output;
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.println(session.getAttribute("username")); %></title>
    </head>
    <body>
        <% out.println(totalImagesPosted); %> Images Posted
        <% out.println(totalFollowers); %> Followers
        <% out.println(totalFollowing); %> Following
        <% out.println(pageHTML(imgIdList)); %>
    </body>
</html>
