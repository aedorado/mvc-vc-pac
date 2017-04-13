<%-- 
    Document   : login
    Created on : 13 Apr, 2017, 11:52:05 AM
    Author     : algoprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    
    <body>
    <%
            String err = "";
            if (request.getAttribute("err") != null) {
                    err = (String) request.getAttribute("err");
            }
    %>
    
    <!--/start-login-two-->
    <div class="login-02">
            <div class="two-login  hvr-float-shadow">
                    <div class="two-login-head">
                            <img src="images/top-note.png" alt="" />
                            <h2>Login Form</h2>
                            <lable></lable>
                    </div>
                    <form action="LoginServlet" method="post">
                            <li style="color: red"><%=err%></li>
                            Username
                            <li><input type="text" class="text" value=""
                                    name="username"><a href="#" class=" icon2 user2"></a></li>
                            Password	
                            <li><input type="password" value=""
                                    name="password"><a href="#" class=" icon2 lock2"></a></li>
                            <div class="submit two">
                                    <input type="submit" value="Submit">
                            </div>
                    </form>
            </div>
    </div>
</body>
</html>