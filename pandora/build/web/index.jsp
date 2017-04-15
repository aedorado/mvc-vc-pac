<%-- 
    Document   : index
    Created on : 15 Apr, 2017, 5:10:34 PM
    Author     : dorado
--%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="homepageAgent.HomepageAgentControl"%>
<%! HomepageAgentControl hpac = new HomepageAgentControl(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <div class="major-div">
            <% out.println(hpac.getHomepageImageHTML(((Long)session.getAttribute("user_id")).longValue())); %> 
        </div>
    </body>
</html>