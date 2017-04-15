<%-- 
    Document   : profile.jsp
    Created on : 13 Apr, 2017, 12:02:34 PM
    Author     : dorado
--%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="profileAgent.ProfileAgentControl"%>
<%! ProfileAgentControl prac = new ProfileAgentControl();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <ul id="user-details">
            <li><% out.println(prac.getNumImagesPosted(Long.parseLong(request.getParameter("user_id")))); %> Images Posted</li>
            <li><% out.println(prac.getTotalFollowers(Long.parseLong(request.getParameter("user_id")))); %> Followers</li>
            <li><% out.println(prac.getTotalFollowing(Long.parseLong(request.getParameter("user_id")))); %> Following</li>
        </ul>
        <br>
        <div class="major-div">
            <% out.println(prac.getProfileImageHTML(Long.parseLong(request.getParameter("user_id"))));%> 
        </div>
    </body>
</html>
