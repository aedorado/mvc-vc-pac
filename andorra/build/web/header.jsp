<%-- 
    Document   : header
    Created on : 13 Apr, 2017, 10:29:08 PM
    Author     : dorado
--%>

<%@page import="model.ImageBean"%>
<%@page import="dao.ImageDaoImp"%>
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

    public String imageIdToHTML(long i) {
        ImageDaoImp idi = new ImageDaoImp();
        ImageBean img = idi.getImageByID(i);
        String placeholder = "";
        placeholder += "<div>";
        placeholder += "<img src='uploads/" + i + ".jpg'>";
        placeholder += "</div>";
        return placeholder;
    }

%>
