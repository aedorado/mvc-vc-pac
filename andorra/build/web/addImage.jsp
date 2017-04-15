<%-- 
    Document   : addImage
    Created on : 13 Apr, 2017, 12:24:35 PM
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Images</title>
    </head>
    <body>
        <div class="col-md-8 col-md-offset-2">
            <%
                if (request.getAttribute("err") != null) {
                        String err = (String) request.getAttribute("err");
                        out.println("<div class='alert alert-danger'>" + err + "</div>");
                }
                if (request.getAttribute("suc") != null) {
                        String suc = (String) request.getAttribute("suc");
                        out.println("<div class='alert alert-success'>" + suc + "</div>");
                }
            %>
            <form name="upload-image" action="UploadImageServlet" method="POST" enctype="multipart/form-data">
                <input type="text" name="caption" placeholder="caption" class='form-control'><br>
                <input type="file" name="file" accept=".png,.jpg,.jpeg"><br>
                <input type="submit" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
