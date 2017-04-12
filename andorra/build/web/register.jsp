<%-- 
    Document   : register
    Created on : 13 Apr, 2017, 12:23:37 AM
    Author     : dorado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<link href="css/login.css" rel='stylesheet' type='text/css' />-->
<title>Registration Form</title>
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
                            <h2>Registration Form</h2>
                            <lable></lable>
                    </div>
                    <form action="RegisterServlet" method="post">
                            <li style="color: red"><%=err%></li>
                            Username
                            <li><input type="text" class="text" value=""
                                    name="username"><a href="#" class=" icon2 user2"></a></li>
                            Password	
                            <li><input type="password" value=""
                                    name="password"><a href="#" class=" icon2 lock2"></a></li>
                            Sex
                            <li><input type="text" value="" list="exampleList"
                                    name="gender"> 
                                    <datalist id="exampleList">
                                    <option value="Male">
                                    <option value="Female">
                                    </datalist><a href="#" class=" icon2 lock2"></a></li>
                            Email
                            <li><input type="text" value=""
                                    name="email"><a href="#" class=" icon2 lock2"></a></li>
                            <div class="submit two">
                                    <input type="submit" value="Submit">
                            </div>
                            <h5>
                                    <a href="login.jsp">Login</a>
                            </h5>
                    </form>
            </div>
    </div>
</body>
</html>