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
 * Servlet implementation class provide_activity_report
 */
@WebServlet("/provide_activity_report")
public class provide_activity_report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public provide_activity_report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside provide_activity_report");
		database d = new database();
		HttpSession session = request.getSession();
		String municipal_id = session.getAttribute("municipal_id").toString();
		
		int complain_no = Integer.parseInt(request.getParameter("complain_no"));
		
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
		
		String activity_report = request.getParameter("activity_report");
		
		System.out.println(municipal_id + " " + complain_no + " " + activity_report);
		
		d.complaint.insert_activity_report(complain_no, activity_report);
		System.out.println("Activity Report Provided");
		
		request.setAttribute("error", "Activity Report Provided");
		request.setAttribute("link", "municipal_homepage.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		dispatcher.forward(request, response);
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
