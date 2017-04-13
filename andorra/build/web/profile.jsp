<%-- 
    Document   : profile.jsp
    Created on : 13 Apr, 2017, 12:02:34 PM
    Author     : dorado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! String username = "Dorado"; %>
<% session.setAttribute("username", "dorado"); %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% session.getAttribute("username"); %></title>
    </head>
    <body>
        <h1>Hello <% session.getAttribute("username"); %>!</h1>
    </body>
</html>
