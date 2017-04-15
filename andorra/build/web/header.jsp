<%-- 
    Document   : header
    Created on : 13 Apr, 2017, 10:29:08 PM
    Author     : dorado
--%>

<%@page import="model.ImageBean"%>
<%@page import="dao.ImageDaoImp"%>
<%@page import="model.UserBean"%>
<%@page import="dao.UserDaoImp"%>
<%@page import="dao.FollowersDaoImp"%>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>

<%!
    public void redirectIfSessionUnset(HttpServletResponse response, HttpSession session) {
        try {
            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {

        }
    }

    public String imageIdToHTML(long i, HttpSession session) {
        ImageDaoImp idi = new ImageDaoImp();
        ImageBean img = idi.getImageByID(i);
        UserDaoImp udi = new UserDaoImp();
        UserBean uploader = udi.getUserByID(img.getUserId() );
        String placeholder = "";
        placeholder += "<div class='image-div'>";
        placeholder += "<img class='img-rounded img-thumbnail img-responsive my-img' src='uploads/" + i + ".jpg'>";
        placeholder += "<div>" + img.getCaption() + "</div>";
        placeholder += "<div>By: <a href='profile.jsp?user_id=" + img.getUserId() + "'>" + uploader.getUsername() + "</a></div>";
        placeholder += "<div class='interaction-div'>";
//        if (idi.isLikedBy(i, (Long)session.getAttribute("user_id"))) {
//            placeholder += "<img class='like-button' src='img/liked.svg'>";
//        } else {
//            placeholder += "<img class='unlike-button' src='img/unliked.svg'>";
//        }
        placeholder += "</div>";
        placeholder += "</div><br>";
        return placeholder;
    }

%>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
