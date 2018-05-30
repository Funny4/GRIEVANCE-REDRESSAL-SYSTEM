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
 * Servlet implementation class give_feedback
 */
@WebServlet("/give_feedback")
public class give_feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public give_feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside give_feedback");
		database d = new database();
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("user_id").toString();
		
		int complain_no = Integer.parseInt(request.getParameter("complain_no"));
		
		if(d.complaint.check_complain_no(complain_no) == 0) {
			request.setAttribute("error", "Please Re-Check Complain No.");
			request.setAttribute("link", "user_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(d.user_complaint.fetch_user_id(complain_no).compareTo(user_id) != 0) {
			request.setAttribute("error", "Please Re-Check Complain No.");
			request.setAttribute("link", "user_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		/*if(d.complaint.fetch_complaint(complain_no).getFeedback().compareTo("pending") != 0) {
			request.setAttribute("error", "FeedBack Pre-Exist");
			request.setAttribute("link", "user_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}*/
		
		String feedback = request.getParameter("feedback");
		
		System.out.println(user_id + " " + complain_no + " " + feedback);
		
		d.complaint.insert_feedback(complain_no, feedback);
		System.out.println("FeedBack Registered");
		
		request.setAttribute("error", "FeedBack Registered");
		request.setAttribute("link", "user_homepage.jsp");
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
