package packagex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

class Mailer{  
    public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }
    

/*public class SendMailSSL{
	public Mailer mailer;
	
	public SendMailSSL(String email,String subject ,String message) {
		 mailer = new Mailer();
		 Mailer.send("dbms11project@gmail.com","rahul!123", email, subject, message);
	}
*/	

}    

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
					
					Mailer mailer = new Mailer();
					mailer.send("dbms11project@gmail.com","rahul!123", email , subject , message);
					
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

