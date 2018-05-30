package packagex;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class user_login
 */
@WebServlet("/user_login")
public class user_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside user_login");
		String id = request.getParameter("user_id");
		String pass = request.getParameter("pass");
		
		System.out.println(id + " " + pass);
		database d = new database();
		int n = d.user.verify_login(id, pass);
		
		if(n == 0) {
			request.setAttribute("error", "Please Re-check User-Id & Password");
			request.setAttribute("link", "user_signup_login.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if(n == 1) {
			request.setAttribute("error", "Login Verified");
			request.setAttribute("link", "homepage.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_homepage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
