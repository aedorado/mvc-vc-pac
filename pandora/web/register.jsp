<%-- 
    Document   : register
    Created on : 13 Apr, 2017, 12:23:37 AM
    Author     : dorado
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="css/login.css" rel='stylesheet' type='text/css' />-->
        <title>Registration Form</title>
    </head>
    <body>
        <div class="container">
            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <h1 class="title">Pandorra: Registration</h1>
                        <hr />
                    </div>
                </div> 
                <div class="main-login main-center col-md-6 col-md-offset-3">

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
                    <form class="form-horizontal" method="post" action="RegisterAgentControlServlet">
                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">Your Name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Your Email</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Username</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                                </div>
                            </div>
                        </div>  
                        <br>
                        <div class="form-group ">
                            <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register">
                        </div>
                        <div style="text-align:center;">OR</div><br>
                    </form>
                    <div class="form-group ">
                        <a href='login.jsp'><button class="btn btn-primary btn-block login-button">Login</button></a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>