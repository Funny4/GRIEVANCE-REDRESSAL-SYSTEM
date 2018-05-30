<%@ page import="packagex.database"%>
<%@ page import="packagex.complaint"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false"%>

<%
HttpSession session = request.getSession(false);
String user_id = session.getAttribute("user_id").toString();
database d = new database();
String user_name = d.user.get_user_name(user_id);
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Grievance Redressal System</title>
		<meta name="description" content="description">
		<meta name="author" content="DevOOPS">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="user_homepage_assets/plugins/bootstrap/bootstrap.css" rel="stylesheet">
		<link href="user_homepage_assets/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
		<link href="user_homepage_assets/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
		<link href="user_homepage_assets/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
		<link href="user_homepage_assets/plugins/xcharts/xcharts.min.css" rel="stylesheet">
		<link href="user_homepage_assets/plugins/select2/select2.css" rel="stylesheet">
		<link href="user_homepage_assets/plugins/justified-gallery/justifiedGallery.css" rel="stylesheet">
		<link href="user_homepage_assets/css/style_v1.css" rel="stylesheet">
		<link href="user_homepage_assets/plugins/chartist/chartist.min.css" rel="stylesheet">
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
				<script src="http://getbootstrap.com/docs-assets/js/html5shiv.js"></script>
				<script src="http://getbootstrap.com/docs-assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
<body>
<header class="navbar">
	<div class="container-fluid expanded-panel">
		<div class="row">
			<div id="logo" class="col-xs-12 col-sm-2">
				<a href="user_homepage.jsp">User Homepage</a>
			</div>
			<div id="top-panel" class="col-xs-12 col-sm-10">
				<div class="row">
					<div class="col-xs-8 col-sm-4">
					</div>
					<div class="col-xs-4 col-sm-8 top-panel-right">
						<ul class="nav navbar-nav pull-right panel-menu">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
									<div class="avatar">
										 <!-- img src="user_homepage_assets/img/avatar.jpg" --> <class="user_homepage_assets/img-circle" alt="avatar" />
									</div>
									<i class="fa fa-angle-down pull-right"></i>
									<div class="user-mini pull-right">
										<span class="welcome">Welcome,</span>
										<span><%= user_id %></span>
									</div>
								</a>
								<ul class="dropdown-menu">
									
									<li>
										<a href="homepage.jsp">
											<i class="fa fa-power-off"></i>
											<span>Logout</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<!--End Header-->
<!--Start Container-->
<div id="main" class="container-fluid">
	<div class="row">
		<div id="sidebar-left" class="col-xs-2 col-sm-2">
			<ul class="nav main-menu">
				<li>
					<a href="user_dashboard.jsp" class="ajax-link">
						<i class="fa fa-dashboard"></i>
						<span class="hidden-xs">Dashboard</span>
					</a>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-bar-chart-o"></i>
						<span class="hidden-xs">Complains</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="user_complain_table.jsp">My Complains</a></li>
						<li><a class="ajax-link" href="all_complain_table.jsp">All Complains</a></li>
						<li><a class="ajax-link" href="file_new_complain.jsp">File New Complain</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-table"></i>
						 <span class="hidden-xs">Suggestions</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="give_suggestion.jsp">Give Suggestion</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-table"></i>
						 <span class="hidden-xs">FeedBack</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="give_feedback.jsp">Give FeedBack</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-pencil-square-o"></i>
						 <span class="hidden-xs">NGO</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="my_ngo_table.jsp">My NGO</a></li>
						<li><a class="ajax-link" href="all_ngo_table.jsp">All NGO</a></li>
						<li><a class="ajax-link" href="join_new_ngo.jsp">Join New NGO</a></li>
						<li><a class="ajax-link" href="form_new_ngo.jsp">Form New NGO</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!--Start Content-->
		<div id="content" class="col-xs-12 col-sm-10">
			<div id="about">
				<div class="about-inner">
					<h4 class="page-header">Open-source admin theme for you</h4>
					<p>User Homepage</p>
					<p>Homepage - <a href="http://devoops.me" target="_blank">http://devoops.me</a></p>
					<p>Email - <a href="mailto:devoopsme@gmail.com">devoopsme@gmail.com</a></p>
					<p>Twitter - <a href="http://twitter.com/devoopsme" target="_blank">http://twitter.com/devoopsme</a></p>
				</div>
			</div>
			<div class="preloader">
				<img src="img/devoops_getdata.gif" class="devoops-getdata" alt="preloader"/>
			</div>
			<div id="ajax-content"></div>
		</div>
		<!--End Content-->
	</div>
</div>
<!--End Container-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--<script src="http://code.jquery.com/jquery.js"></script>-->
<script src="user_homepage_assets/plugins/jquery/jquery.min.js"></script>
<script src="user_homepage_assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="user_homepage_assets/plugins/bootstrap/bootstrap.min.js"></script>
<script src="user_homepage_assets/plugins/justified-gallery/jquery.justifiedGallery.min.js"></script>
<script src="user_homepage_assets/plugins/tinymce/tinymce.min.js"></script>
<script src="user_homepage_assets/plugins/tinymce/jquery.tinymce.min.js"></script>
<!-- All functions for this theme + document.ready processing -->
<script src="user_homepage_assets/js/devoops.js"></script>
</body>
</html>
