<%-- 
    Document   : index
    Created on : 11 Apr, 2017, 6:08:21 PM
    Author     : dorado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="user" scope="session" class="model.UserBean" />
<jsp:setProperty name="user" property="username" value="Anurag" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <jsp:getProperty name="user" property="username" />!</h1>
        <a href="register.jsp">Register</a>
    </body>
</html>
