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
@WebServlet("/form_new_ngo")
public class form_new_ngo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public form_new_ngo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside form_new_ngo");
		database d = new database();
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("user_id").toString();
		
		String ngo_name = request.getParameter("ngo_name");
		String ngo_mission = request.getParameter("ngo_mission");
		
		System.out.println(ngo_name + " " + ngo_mission);
		
		if(d.ngo.check_name(ngo_name) == 0) {
			request.setAttribute("error", "Please Choose Different Name for NGO");
			request.setAttribute("link", "user_homepage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		d.ngo.insert_data(ngo_name, ngo_mission);
		d.ngo_user.insert_data(ngo_name, user_id);
		request.setAttribute("error", "NGO Formed Successfully");
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
