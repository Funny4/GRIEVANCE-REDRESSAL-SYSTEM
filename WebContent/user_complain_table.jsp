<%@ page import="packagex.database"%>
<%@ page import="packagex.complaint"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false"%>

<div class="row">
	<div id="breadcrumb" class="col-xs-12">
		<a href="#" class="show-sidebar">
			<i class="fa fa-bars"></i>
		</a>
		<ol class="breadcrumb pull-left">
			<li><a href="user_homepage.jsp">Home</a></li>
			<li><a href="#">Complains</a></li>
			<li><a href="#">My Complains</a></li>
		</ol>
		<div id="social" class="pull-right">
			<a href="#"><i class="fa fa-google-plus"></i></a>
			<a href="#"><i class="fa fa-facebook"></i></a>
			<a href="#"><i class="fa fa-twitter"></i></a>
			<a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-youtube"></i></a>
		</div>
	</div>
</div>
<h2>My Complains Status</h2>
<br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
					<a class="expand-link">
						<i class="fa fa-expand"></i>
					</a>
					<a class="close-link">
						<i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead>
						<tr>
							<th>Complain No.</th>
							<th>Complain</th>
							<th>Activity Report</th>
							<th>Feed Back</th>
						</tr>
					</thead>
					<tbody>
					<%
						HttpSession session = request.getSession(false);
						String user_id = session.getAttribute("user_id").toString();
						database d = new database();
						int arr[] = d.user_complaint.fetch_complain_no(user_id);
						int length = arr.length;
						complaint comp;
					%>

	  				<% for(int i=0; i<length; i++) {  
		  					comp = d.complaint.fetch_complaint(arr[i]);
	   				%>
            
      	 			<tr>
       	 			<td><%= comp.getComplain_no()%></td>
         			<td><%= comp.getComplain()%></td>
         			<td><%= comp.getActivity_report()%></td>
         			<td><%= comp.getFeedback()%></td>
         			</tr>
      
      				<% } %>
					<!-- End: list_row -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
