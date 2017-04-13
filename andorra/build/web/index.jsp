<%-- 
    Document   : index
    Created on : 11 Apr, 2017, 6:08:21 PM
    Author     : dorado
--%>
<%--<jsp:useBean id="user" scope="session" class="model.UserBean" />--%>
<%--<jsp:setProperty name="user" property="username" value="Anurag" />--%>
<%--<jsp:getProperty name="user" property="username" />--%>
<%@include file="header.jsp" %>
<% redirectIfSessionUnset(response, session); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.UserBean" %>
<%@page import="model.ImageBean" %>
<%@page import="dao.UserDaoImp" %>
<%@page import="dao.ImageDaoImp" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        hi
    </body>
</html>
