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
 * Servlet implementation class municipal_login
 */
@WebServlet("/municipal_login")
public class municipal_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public municipal_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside municipal_login");
		String id = request.getParameter("municipal_id");
		String pass = request.getParameter("pass");
		
		System.out.println(id + " " + pass);
		database d = new database();
		int n = d.municipal.verify_login(id, pass);
		
		if(n == 0) {
			request.setAttribute("error", "Please Re-check municipal-Id & Password");
			request.setAttribute("link", "municipal_login.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if(n == 1) {
			request.setAttribute("error", "Login Verified");
			request.setAttribute("link", "homepage.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("municipal_id", id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("municipal_homepage.jsp");
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
