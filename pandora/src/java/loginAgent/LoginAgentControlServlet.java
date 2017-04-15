/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginAgent;

/**
 *
 * @author algoprentice
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lrAgent.LRAgentControl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginAgentControlServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAgentControlServlet() {
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

        LRAgentControl lrac = new LRAgentControl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String err = "";
        if (username.equals("") || password.equals("")) {
            err += "Empty Fields\n";
        } else if (lrac.userExists(username) == false) {
            err += "Username doesn't exist\n";
        } else if (lrac.correctCredentials(username, password) == false) {
            err += "Incorrect Password.\n";
        }

        String url = "/login.jsp";
        try {
            if (err.length() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("user_id", lrac.getIdFromUsername(username));
                System.out.println("Username : " + session.getAttribute("username"));
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("err", err);
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
