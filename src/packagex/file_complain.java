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
@WebServlet("/file_complain")
public class file_complain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public file_complain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside file_complain");
		String complain = request.getParameter("complain");
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("user_id").toString();
		
		database d = new database();
		int complain_no = d.count.complain_count() + 1000;
		String municipal_id = d.municipal_complaint.most_free_municipal();
		System.out.println(user_id + " " + complain + " " + complain_no);
		d.complaint.insert_complain(complain_no, complain);
		d.complaint.insert_activity_report(complain_no, "Pending");
		d.complaint.insert_feedback(complain_no, "Pending");
		d.user_complaint.insert_data(user_id, complain_no);
		d.municipal_complaint.insert_data(municipal_id, complain_no);

		request.setAttribute("error", "Complain Registered, Complain No. = " + complain_no);
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
