/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author algoprentice
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImp;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UserDaoImp userDAO = new UserDaoImp();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String err = "";
        if (username.equals("") || password.equals("")) {
            err += "Empty Fields\n";
        } else if (userDAO.exists(username) == false) {
            err += "Username doesn't exist\n";
        } else if (userDAO.login(username, password) == false) {
            err += "Incorrect Password.\n";
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        String url = "/login.jsp";
        try {
            if (err.length() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("user_id", userDAO.getIdFromUsername(username));

                //userDAO.login(username, password);
//                Cookie loginCookie = new Cookie("username", username);
                //setting cookie to expiry in 30 mins
//                loginCookie.setMaxAge(30 * 60);
//                response.addCookie(loginCookie);
                System.out.println("Username : " + session.getAttribute("username"));
                response.sendRedirect("index.jsp");
            } else {
                url = "/login.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login.jsp");
        }
    }

}
