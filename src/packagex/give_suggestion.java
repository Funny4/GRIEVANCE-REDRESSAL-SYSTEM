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
 * Servlet implementation class give_suggestion
 */
@WebServlet("/give_suggestion")
public class give_suggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public give_suggestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside give_suggestion");
		String suggestion = request.getParameter("suggestion");
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("user_id").toString();
		
		System.out.println(user_id + " " + suggestion);
		database d = new database();
		int suggestion_no = d.count.suggestion_count() + 1000;
		d.suggestion.insert_data(suggestion_no, suggestion);
		d.user_suggestion.insert_data(user_id, suggestion_no);
		System.out.println("suggestion Registered");
		
		request.setAttribute("error", "Suggestion Registered, Suggestion No. = " + suggestion_no);
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
