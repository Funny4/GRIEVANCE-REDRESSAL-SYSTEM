package packagex;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * Servlet implementation class user_login
 */
@WebServlet("/user_signup")
public class user_signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside user_signup");
			String name = request.getParameter("first_name") + " " + request.getParameter("last_name");
			String id = request.getParameter("user_id");
			String pass = request.getParameter("pass");
			
			database d = new database();
			int n = d.user.insert_data(name, id, pass);
			System.out.println(n);
			
			if(n==0) {
				request.setAttribute("error", "Sorry Username Pre-Exist !!");
				System.out.println("username already exist");
				request.setAttribute("link", "user_signup_login.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}
			System.out.println("successfuly signed up");
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_signup_login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		catch(Exception exc){
			request.setAttribute("error", exc);
			request.setAttribute("link", "signup.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
