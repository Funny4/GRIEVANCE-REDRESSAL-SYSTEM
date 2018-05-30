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
 * Servlet implementation class user_file_omplain_suggestion
 */
@WebServlet("/delete_complain")
public class delete_complain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_complain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside delete_complain");
			int complain_no = Integer.parseInt(request.getParameter("complain_no"));
			
			database d = new database();
			d.user_complaint.delete_data_by_complain_no(complain_no);
			d.complaint.delete_data(complain_no);
			
			if(d.complaint.check_complain_no(complain_no) == 0) {
				request.setAttribute("error", "Please Re-Check Complain No.");
				request.setAttribute("link", "municipal_homepage.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}

			request.setAttribute("error", "Successfully Complain Deleted");
			request.setAttribute("link", "admin_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		catch(Exception exc) {
			request.setAttribute("error", "Please Re-Check Complain No.");
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
