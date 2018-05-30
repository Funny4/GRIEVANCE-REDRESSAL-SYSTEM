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
 * Servlet implementation class invalid_complain
 */
@WebServlet("/invalid_complain")
public class invalid_complain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public invalid_complain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside invalid_complain");
		try {
			int complain_no = Integer.parseInt(request.getParameter("complain_no"));
			HttpSession session = request.getSession();
			String municipal_id = session.getAttribute("municipal_id").toString();
			
			database d = new database();
			
			if(d.complaint.check_complain_no(complain_no) == 0) {
				request.setAttribute("error", "Please Re-Check Complain No.");
				request.setAttribute("link", "municipal_homepage.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			if(d.municipal_complaint.fetch_municipal_id(complain_no).compareTo(municipal_id) != 0) {
				request.setAttribute("error", "Please Re-Check Complain No.");
				request.setAttribute("link", "municipal_homepage.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			d.municipal_complaint.delete_data_by_complain_no(complain_no);
			d.complaint.insert_activity_report(complain_no, "Invalid Complain");
			
			request.setAttribute("error", "Invalid Complain Successfully Redirected to Admin");
			request.setAttribute("link", "municipal_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		catch(Exception exc) {
			request.setAttribute("error", "Please Re-Check Complain No.");
			request.setAttribute("link", "municipal_homepage.jsp");
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
