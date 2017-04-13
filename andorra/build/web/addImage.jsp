<%-- 
    Document   : addImage
    Created on : 13 Apr, 2017, 12:24:35 PM
    Author     : dorado
--%>
<%@include file="header.jsp" %>
<%
    
    redirectIfSessionUnset(response, session);
    
    String err = "";
    if (request.getAttribute("err") != null) {
            err = (String) request.getAttribute("err");
    }
    
    String suc = "";
    if (request.getAttribute("suc") != null) {
            suc = (String) request.getAttribute("suc");
    }
    out.print(suc);
    
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
            <input type="file" name="file" accept=".jpg">
            <input type="text" name="caption" placeholder="caption">
            <input type="submit">
        </form>
    </body>
</html>
