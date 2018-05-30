package packagex;
import java.sql.*;
import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;
import sun.font.CreatedFontTracker;
import sun.net.www.content.image.png;

public class database {
	
	public userx user;
	public complaintx complaint;
	public municipalx municipal;
	public suggestionx suggestion;
	public user_complaintx user_complaint;
	public municipal_complaintx municipal_complaint;
	public user_suggestionx user_suggestion;
	public ngox ngo;
	public ngo_userx ngo_user;
	public countx count;
	
	public database() {
		user = new userx();
		complaint = new complaintx();
		municipal = new municipalx();
		suggestion = new suggestionx();
		user_complaint = new user_complaintx();
		municipal_complaint = new municipal_complaintx();
		user_suggestion = new user_suggestionx();
		ngo = new ngox();
		ngo_user = new ngo_userx();
		count = new countx();
	}

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		database d = new database();
		int c=-1;
		//c = d.user.insert_data("rahul", "r@123", "chanderiya");
		//d.user.fetch_data();
		//c = d.user.verify_login("r@123", "chanderiya");
		//c = d.user.delete_data("r@123");
		//System.out.println(d.user.get_user_name("rahul@1997"));
		//System.out.println(c);
		
		//d.complaint.insert_complain(1, "complain");
		//d.complaint.insert_activity_report(1, "pending");
		//d.complaint.insert_feedback(1, "feedback");
		/*complaint comp = d.complaint.fetch_complaint(1);
		System.out.println(comp.getComplain_no() + "," + comp.getComplain() + "," + comp.getStatus() + "," 
		+ "," + comp.getSolution() + "," + comp.getFeedback());*/
		//d.complaint.delete_data(1);
		/*complaint comp_arr[] = d.complaint.fetch_all_complaints();
		for(int i=0; i<comp_arr.length; i++) {
			System.out.println(comp_arr[i].getComplain());
		}*/
		//System.out.println(d.complaint.check_complain_no(1));
		
		d.municipal.insert_data("rahul", "chanderiya","pass");
		//d.municipal.fetch_data();
		
		//d.suggestion.insert_data(1, "suggestion");
		//System.out.println(d.suggestion.fetch_data(1));
		//d.suggestion.delete_data(1);
		
		//d.user_complaint.insert_data("rahul", 101);
		//System.out.println(d.user_complaint.fetch_complain_no("rahul"));
		//System.out.println(d.user_complaint.fetch_user_id(101));
		//d.user_complaint.delete_data("rahul");
		
		//d.municipal_complaint.insert_data("rahul", 101);
		//System.out.println(d.municipal_complaint.fetch_complain_no("rahul"));
		//System.out.println(d.municipal_complaint.fetch_municipal_id(101));
		//d.municipal_complaint.delete_data("rahul");
		//System.out.println(d.municipal_complaint.most_free_municipal());
		
		//d.user_suggestion.insert_data("rahul", 101);
		//System.out.println(d.user_suggestion.fetch_suggestion_no("rahul"));
		//System.out.println(d.user_suggestion.fetch_user_id(101));
		//d.user_suggestion.delete_data("rahul");
		
		//d.municipal.insert_data("rahul", "chanderiya");
		//d.municipal.fetch_data();
		//d.municipal.verify_login("rahul", "chanderiya");
		//d.municipal.delete_data("rahul");
		
		//d.ngo.insert_data("name-1", "mission-1");
		//d.ngo.fetch_data();
		//d.ngo.delete_data("name-1");
		//System.out.println(d.ngo.fetch_ngo_mission("lalsf"));
		//System.out.println(d.ngo_user.fetch_user_list("lalsf").length);
		
		//d.ngo_user.insert_data("name-1", "user_id-2");
		//d.ngo_user.fetch_data();
		/*String str[] = d.ngo_user.fetch_user_list("name-1");
		for(int i=0; i<str.length; i++) {
			System.out.println(str[i]);
		}*/
		//d.ngo_user.delete_data("name-1");
		
		//d.count.complain_count();
		//d.count.suggestion_count();
		//System.out.println(d.count.municipal_count());
		
	}
	
	public class userx {
		
		private void fetch_data() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				Statement stmt = con.createStatement();
				String querry = "select * from user";
				ResultSet rs = stmt.executeQuery(querry);
				
				while(rs.next()) {
					System.out.println(rs.getString("name") + "," + rs.getString("id") + "," + rs.getString("pass"));
				}
			}
			
			catch(Exception exc) {
				System.out.println(exc);
			}
			
		}
		
		public int verify_login (String id, String pass) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from user where id = ? and pass = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				stmt.setString(2, pass);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					System.out.println("User Verified");
					return 1;
				}
				else {
					System.out.println("User not Verified");
					return 0;
				}
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				System.out.println("User not Verified");
				return 0;
			}
			
		}
		
		public int check_id(String id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from user where id = ? ";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				
				System.out.println(id);
				
				if(rs.next()) {
					return 0;
				}
				
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
			
		}
		
		public int insert_data(String name, String id, String pass) {
			
			System.out.println(name + " " + id + " " + pass);
			int c = check_id(id);
			if(c==0)
			{
				System.out.println("ID pre-exist");
				return 0;
			}
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into user value (?,?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, name);
				stmt.setString(2, id);
				stmt.setString(3, pass);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public String get_user_name(String id) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select name from user where id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				//System.out.println("name fetched");
				return rs.getString("name");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
		}
		
		public int delete_data(String id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from user where id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
	}
	
	
	
	public class municipalx {
		
		private void fetch_data() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				Statement stmt = con.createStatement();
				String querry = "select * from municipal";
				ResultSet rs = stmt.executeQuery(querry);
				
				while(rs.next()) {
					System.out.println(rs.getString("name") + "," + rs.getString("id") + "," + rs.getString("pass"));
				}
			}
			
			catch(Exception exc) {
				System.out.println(exc);
			}
			
		}
		
		public int verify_login (String id, String pass) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from municipal where id = ? and pass = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				stmt.setString(2, pass);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					System.out.println("municipal Verified");
					return 1;
				}
				else {
					System.out.println("municipal not Verified");
					return 0;
				}
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				System.out.println("municipal not Verified");
				return 0;
			}
			
		}
		
		private int check_id(String id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from municipal where id = ? ";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					return 0;
				}
				
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
			
		}
		
		public int insert_data(String name, String id, String pass) {
			
			System.out.println(name + " " + id + " " + pass);
			int c = check_id(id);
			if(c==0)
			{
				System.out.println("ID pre-exist");
				return 0;
			}
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into municipal value (?,?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, name);
				stmt.setString(2, id);
				stmt.setString(3, pass);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public String get_municipal_name(String id) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select name from municipal where id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				//System.out.println("name fetched");
				return rs.getString("name");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
		}
		
		public int delete_data(String id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from municipal where id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, id);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
	}
	
	
	
	public class complaintx {

		public complaint fetch_complaint(int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from complaint where complain_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, complain_no);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				
				complaint comp = new complaint();
				comp.setComplain_no(rs.getInt("complain_no"));
				comp.setComplain(rs.getString("complain"));
				comp.setActivity_report(rs.getString("activity_report"));
				comp.setFeedback(rs.getString("feedback"));
				
				return comp;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				complaint comp = new complaint();
				return comp;
			}
			
		}
		
		public int check_complain_no(int complain_no) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select complain from complaint where complain_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, complain_no);
				ResultSet rs = stmt.executeQuery();
				if(rs.next() == false) {
					return 0;
				}
				
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public complaint[] fetch_all_complaints() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select complain_no from user_complaint";
				PreparedStatement stmt = con.prepareStatement(querry);
				ResultSet rs = stmt.executeQuery();
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				complaint comp_arr[] = new complaint[rowcount];
	
				for(int i=0; i<rowcount; i++) {
					complaint comp = fetch_complaint(rs.getInt("complain_no"));			
					comp_arr[i] = comp;
					rs.next();
				}
				
				return comp_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int insert_complain(int complain_no, String complain) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into complaint value (?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, complain_no);
				stmt.setString(2, complain);
				stmt.setString(3, null);
				stmt.setString(4, null);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int insert_activity_report(int complain_no, String activity_report) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "update complaint "
						+ "set activity_report = ?"
						+ "where complain_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, activity_report);
				stmt.setInt(2, complain_no);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int insert_feedback(int complain_no, String feedback) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "update complaint "
						+ "set feedback = ?"
						+ "where complain_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, feedback);
				stmt.setInt(2, complain_no);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data(int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from complaint where complain_no = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, complain_no);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
	}
	
	public class suggestionx {
		
		public String fetch_suggestion(int suggestion_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from suggestion where suggestion_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, suggestion_no);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				return rs.getString("suggestion");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int[] fetch_all_suggestion_no() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select suggestion_no from suggestion";
				PreparedStatement stmt = con.prepareStatement(querry);
				ResultSet rs = stmt.executeQuery();
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				int suggestion_arr[] = new int[rowcount];
	
				for(int i=0; i<rowcount; i++) {
					suggestion_arr[i] = rs.getInt(1);
					rs.next();
				}
				
				return suggestion_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int insert_data(int suggestion_no, String suggestion) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into suggestion value (?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, suggestion_no);
				stmt.setString(2, suggestion);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data(int suggestion_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from suggestion where suggestion_no = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, suggestion_no);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
	}
	
	
	
	public class user_complaintx {
		
		public int[] fetch_complain_no(String user_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from user_complaint where user_id = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1,user_id);
				ResultSet rs = stmt.executeQuery();
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				int comp_arr[] = new int[rowcount];
				
				for(int i=0; i<rowcount; i++) {
					comp_arr[i] = rs.getInt("complain_no");
					rs.next();
				}
				
				return comp_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public String fetch_user_id(int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from user_complaint where complain_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1,complain_no);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				return rs.getString("user_id");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int insert_data(String user_id, int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into user_complaint value (?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, user_id);
				stmt.setInt(2, complain_no);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data_by_user_id(String user_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from user_complaint where user_id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, user_id);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data_by_complain_no(int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from user_complaint where complain_no = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, complain_no);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
	}

	
	
	public class municipal_complaintx {
		
		public int[] fetch_complain_no(String municipal_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from municipal_complaint where municipal_id = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1,municipal_id);
				ResultSet rs = stmt.executeQuery();
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				int comp_arr[] = new int[rowcount];
				
				for(int i=0; i<rowcount; i++) {
					comp_arr[i] = rs.getInt("complain_no");
					rs.next();
				}
				
				return comp_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		

		public String most_free_municipal() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select id from municipal";
				PreparedStatement stmt = con.prepareStatement(querry);
				ResultSet rs = stmt.executeQuery();
				String return_id = null;
				int count = 10000, c;
				
				while(rs.next()) {
					
					String municipal_id = rs.getString(1);
					String querry1 = "select complain_no from  municipal_complaint where municipal_id = ?";
					PreparedStatement stmt1 = con.prepareStatement(querry1);
					stmt1.setString(1,municipal_id);
					ResultSet rs1 = stmt1.executeQuery();
					
					c=0;
					while(rs1.next()) {
						String querry2 = "select complain from  complaint where complain_no = ?";
						PreparedStatement stmt2 = con.prepareStatement(querry2);
						stmt2.setInt(1,rs1.getInt(1));
						ResultSet rs2 = stmt2.executeQuery();
						/*if(rs2.next() == true) {
							if(rs2.getString(1).compareTo("pending") == 0) {
								c++;
							}
						}*/
						c++;
					}
					
					if(c < count) {
						count = c;
						return_id = municipal_id;
						System.out.println(return_id + " " + c);
					}	
				}
				
				return return_id;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
		}
		
		public String fetch_municipal_id(int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from municipal_complaint where complain_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1,complain_no);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				return rs.getString("municipal_id");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int insert_data(String municipal_id, int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into municipal_complaint value (?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, municipal_id);
				stmt.setInt(2, complain_no);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data_by_municipal_id(String municipal_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from municipal_complaint where municipal_id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, municipal_id);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data_by_complain_no(int complain_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from municipal_complaint where complain_no = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1, complain_no);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
	}
	
	
	
	public class user_suggestionx {
		
		public int fetch_suggestion_no(String user_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from user_suggestion where user_id = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1,user_id);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				return rs.getInt("suggestion_no");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
			
		}
		
		public String fetch_user_id(int suggestion_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from user_suggestion where suggestion_no = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setInt(1,suggestion_no);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				return rs.getString("user_id");
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int insert_data(String user_id, int suggestion_no) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into user_suggestion value (?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, user_id);
				stmt.setInt(2, suggestion_no);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data(String user_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from user_suggestion where user_id = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, user_id);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
	}
	
	
	
	public class ngox {
		
		private void fetch_data() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				Statement stmt = con.createStatement();
				String querry = "select * from ngo";
				ResultSet rs = stmt.executeQuery(querry);
				
				while(rs.next()) {
					System.out.println(rs.getString("name") + "," + rs.getString("mission"));
				}
			}
			
			catch(Exception exc) {
				System.out.println(exc);
			}
			
		}
		
		public String[] fetch_all_ngo() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				Statement stmt = con.createStatement();
				String querry = "select name from ngo";
				ResultSet rs = stmt.executeQuery(querry);
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				String ngo_arr[] = new String[rowcount];
	
				for(int i=0; i<rowcount; i++) {
					ngo_arr[i] = rs.getString("name");	
					rs.next();
				}
				
				return ngo_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		

		public String fetch_ngo_mission(String ngo_name) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select mission from ngo where name = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1,ngo_name);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				return rs.getString(1);
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int check_name(String name) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select * from ngo where name = ? ";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					return 0;
				}
				
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
			
		}
		
		public int insert_data(String name, String mission) {
			
			int c = check_name(name);
			if(c==0)
			{
				System.out.println("Name pre-exist");
				return 0;
			}
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into ngo value (?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, name);
				stmt.setString(2, mission);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data(String name) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from ngo where name = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, name);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
				
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
	}
	
	
	public class ngo_userx {
		
		private void fetch_data() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				Statement stmt = con.createStatement();
				String querry = "select * from ngo_user";
				ResultSet rs = stmt.executeQuery(querry);
				
				while(rs.next()) {
					System.out.println(rs.getString("ngo_name") + "," + rs.getString("user_id"));
				}
			}
			
			catch(Exception exc) {
				System.out.println(exc);
			}
			
		}
		
		public String[] fetch_user_list(String ngo_name) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select user_id from ngo_user where ngo_name = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, ngo_name);
				ResultSet rs = stmt.executeQuery();
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				String user_arr[] = new String[rowcount];
	
				for(int i=0; i<rowcount; i++) {
					user_arr[i] = rs.getString("user_id");
					
					rs.next();
				}
				
				return user_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public String[] fetch_ngo_list(String user_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "select ngo_name from ngo_user where user_id = ?";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, user_id);
				ResultSet rs = stmt.executeQuery();
				
				rs.last();
				int rowcount = rs.getRow();
				rs.first();
				String ngo_arr[] = new String[rowcount];
	
				for(int i=0; i<rowcount; i++) {
					ngo_arr[i] = rs.getString("ngo_name");
					
					rs.next();
				}
				
				return ngo_arr;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return null;
			}
			
		}
		
		public int insert_data(String ngo_name, String user_id) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "insert into ngo_user value (?,?)";
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, ngo_name);
				stmt.setString(2, user_id);
				stmt.execute();
				stmt.close();
				System.out.println("Data Inserted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
		public int delete_data(String ngo_name) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				String querry = "delete from ngo_user where ngo_name = ?" ;
				PreparedStatement stmt = con.prepareStatement(querry);
				stmt.setString(1, ngo_name);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("Data Deleted");
				return 1;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return 0;
			}
		}
		
	}
	
	
	public class countx {
		
		public int complain_count() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				
				String querry1 = "select count(complain_no) " + 
						"from complaint ";
				PreparedStatement stmt1 = con.prepareStatement(querry1);
				ResultSet rs = stmt1.executeQuery(querry1);
				rs.next();
				int count = rs.getInt(1);
				System.out.println(count);
				return count;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return -1;
			}
			
		}
		
		public int suggestion_count() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				
				String querry1 = "select count(suggestion_no) " + 
						"from suggestion ";
				PreparedStatement stmt = con.prepareStatement(querry1);
				ResultSet rs = stmt.executeQuery(querry1);
				rs.next();
				int count = rs.getInt(1);
				System.out.println(count);
				return count;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return -1;
			}
			
		}
		
		public int municipal_count() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ankit?autoReconnect=true&useSSL=false", "root", "1234");
				
				String querry1 = "select count(id) " + 
						"from municipal ";
				PreparedStatement stmt = con.prepareStatement(querry1);
				ResultSet rs = stmt.executeQuery(querry1);
				rs.next();
				int count = rs.getInt(1);
				System.out.println(count);
				return count;
			}
			
			catch(Exception exc) {
				System.out.println(exc);
				return -1;
			}
			
		}
			
	}

}
