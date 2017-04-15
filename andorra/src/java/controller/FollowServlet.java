/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author dorado
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import static java.lang.System.out;
import model.*;

public class FollowServlet extends HttpServlet {

    private final FollowersDaoImp followDao = new FollowersDaoImp();
    private final UserDaoImp userDao = new UserDaoImp();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        FollowersDaoImp followDao = new FollowersDaoImp();
        long sessionUser = ((Long) session.getAttribute("user_id")).longValue();
        long follow = Long.parseLong(request.getParameter("follow"));
        if (followDao.isfollowing(sessionUser, follow)) {
            followDao.deleteFollower(sessionUser, follow);
            response.sendRedirect("profile.jsp?user_id=" + follow);
        } else {
            followDao.addFollower(new FollowersBean(sessionUser, follow));
            response.sendRedirect("profile.jsp?user_id=" + follow);

        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }
}
