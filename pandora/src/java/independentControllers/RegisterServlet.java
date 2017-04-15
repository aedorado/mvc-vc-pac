package independentControllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import dao.UserDaoImp;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDaoImp userDAO = new UserDaoImp();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String gender = "Male";
        //String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        System.out.println(username);

        String err = "";
        String url = "/register.jsp";

        if (username.equals("") || password.equals("") || email.equals("")) {
            err += "Fields cannot be left blank.";
        } else {
            if (userDAO.exists(username) == true) {
                err += "Username already exists.";
            } else {
                Pattern pattenObj = Pattern
                        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcherObj = pattenObj.matcher(email);
                if (!matcherObj.matches()) {
                    err += "Email pattern incorrect.";
                }
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        try {
            if (err.length() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                userDAO.addUser(new UserBean(0, username, password, email, gender));
                userDAO.login(username, password);
                url = "/register.jsp";
                request.setAttribute("suc", "Added succesfully.");
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                url = "/register.jsp";
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/register.jsp");
        }

    }

}
