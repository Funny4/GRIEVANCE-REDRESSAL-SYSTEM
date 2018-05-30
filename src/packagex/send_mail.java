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
 * Servlet implementation class send_mail
 */
@WebServlet("/send_mail")
public class send_mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send_mail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside send_mail");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
					
			database d = new database();
			int count = d.count.municipal_count() + 1000;
			String id = "mun-" + Integer.toString(count);
			String pass = name + "@" + Integer.toString(count);
			String subject = "Griveance Redresal System";
			String message = "Your Account Successfully created,   Login Id = " + id + " ,  Pass = " + pass;  
			d.municipal.insert_data(name, id, pass);
			   
			
			//Mailer.send("dbms11project@gmail.com","rahul!123", email , subject, message);
			
			request.setAttribute("error", "Message Succesfully Sent");
			request.setAttribute("link", "admin_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
					
			return;
		}
		catch (Exception exc) {
			request.setAttribute("error", "Kindly Re-Check Email Address");
			request.setAttribute("link", "admin_homepage.jsp");
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
