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
    String err = "";
    if (request.getAttribute("err") != null) {
        err = (String) request.getAttribute("err");
    }
    String suc = "";
    if (request.getAttribute("suc") != null) {
        suc = (String) request.getAttribute("suc");
        System.out.println("SUC : " + suc);
    }
%>
<%@include file="header.jsp" %>
<%@include file="navbar.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Images</title>
    </head>
    <body>
        <%=suc%>
        <div class="col-md-8 col-md-offset-2">
            <form name="upload-image" action="UploadImageServlet" method="POST" enctype="multipart/form-data">
                <input type="text" name="caption" placeholder="caption" class='form-control'><br>
                <input type="file" name="file" accept=".png,.jpg,.jpeg"><br>
                <input type="submit" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
