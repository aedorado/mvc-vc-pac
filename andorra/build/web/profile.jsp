<%-- 
    Document   : profile.jsp
    Created on : 13 Apr, 2017, 12:02:34 PM
    Author     : dorado
--%>
<%@page import="model.UserBean" %>
<%@page import="dao.UserDaoImp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  

long user_id = Long.parseLong(request.getParameter("user_id"));
UserDaoImp udi = new UserDaoImp();
long totalImagesPosted = udi.totalImagesPosted(user_id);
long totalFollowers = udi.totalFollowers(user_id);
long totalFollowing = udi.totalFollowing(user_id);

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.println(session.getAttribute("username")); %></title>
    </head>
    <body>
        <% out.println(totalImagesPosted); %> Images Posted
        <% out.println(totalFollowers); %> Followers
        <% out.println(totalFollowing); %> Following
    </body>
</html>
