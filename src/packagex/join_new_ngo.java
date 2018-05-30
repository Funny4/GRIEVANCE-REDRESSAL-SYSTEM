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
 * Servlet implementation class join_new_ngo
 */
@WebServlet("/join_new_ngo")
public class join_new_ngo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public join_new_ngo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside join_new_ngo");
		String ngo_name = request.getParameter("ngo_name");
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("user_id").toString();
				
		database d = new database();
		
		if(d.ngo.check_name(ngo_name) == 1) {
			request.setAttribute("error", "Please Re-Check NGO name");
			request.setAttribute("link", "user_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		String user_list[] = d.ngo_user.fetch_user_list(ngo_name);
		for(int i=0; i<user_list.length; i++) {
			if(user_list[i].compareTo(user_id) == 0) {
				request.setAttribute("error", "You are Already Member of this NGO");
				request.setAttribute("link", "user_homepage.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}
		
		d.ngo_user.insert_data(ngo_name, user_id);
		request.setAttribute("error", "Succesfully Joined the NGO");
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
