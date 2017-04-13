<%-- 
    Document   : addImage
    Created on : 13 Apr, 2017, 12:24:35 PM
    Author     : dorado
--%>
<%
    if (session.getAttribute("username") == null) {
//        out.println("hello");
        response.sendRedirect("login.jsp"); 
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="upload-image" action="UploadImageServlet" method="POST" enctype="multipart/form-data">
            <input type="file" name="file" accept=".png,.jpg,.jpeg">
            <input type="text" name="caption" placeholder="caption">
            <input type="submit">
        </form>
    </body>
</html>
