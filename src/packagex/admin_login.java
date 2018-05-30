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
 * Servlet implementation class admin_login
 */
@WebServlet("/admin_login")
public class admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("inside admin_login");
		String id = request.getParameter("user_id");
		String pass = request.getParameter("pass");
		
		System.out.println(id + " " + pass);
		
		if(id.compareTo("admin") == 0 && pass.compareTo("admin") == 0) {
			System.out.println("login verified");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin_homepage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else {
			System.out.println("login not verified");
			request.setAttribute("error", "Please Re-check User-Id & Password");
			request.setAttribute("link", "admin_login.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
