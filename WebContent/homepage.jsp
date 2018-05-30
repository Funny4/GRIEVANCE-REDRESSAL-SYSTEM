<%@ page import="packagex.database"%>
<%@ page import="packagex.complaint"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false"%>

<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Griveance Redresal</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="homepage_assets/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="homepage_assets/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="homepage_assets/css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="homepage_assets/css/magnific-popup.css">

	<!-- Flexslider  -->
	<link rel="stylesheet" href="homepage_assets/css/flexslider.css">

	<!-- Owl Carousel -->
	<link rel="stylesheet" href="homepage_assets/css/owl.carousel.min.css">
	<link rel="stylesheet" href="homepage_assets/css/owl.theme.default.min.css">
	
	<!-- Flaticons  -->
	<link rel="stylesheet" href="homepage_assets/fonts/flaticon/font/flaticon.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="homepage_assets/css/style.css">

	<!-- Modernizr JS -->
	<script src="homepage_assets/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="homepage_assets/js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="colorlib-loader"></div>
		<aside id="colorlib-hero">
			<div class="flexslider">
				<ul class="slides">
			   	<li style="background-image: url(homepage_assets/images/complaint.jpg);">
			   		<div class="overlay"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-8 col-sm-12 col-md-offset-2 slider-text">
				   				<div class="slider-text-inner text-center">
				   					<h1>Grievance Redressal System</h1>
				   					<h2>An online web-enabled System</h2>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
			   	<li style="background-image: url(homepage_assets/images/download3.jpg);">
			   		<div class="overlay"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-8 col-sm-12 col-md-offset-2 slider-text">
				   				<div class="slider-text-inner text-center">
				   					<h1>Online Lodge your Complaints</h1>
				   					<h2>Share ideas , Join NGO's</h2>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
			   	<li style="background-image: url(homepage_assets/images/download4.jpg);">
			   		<div class="overlay"></div>
			   		<div class="container-fluids">
			   			<div class="row">
				   			<div class="col-md-8 col-sm-12 col-md-offset-2 slider-text">
				   				<div class="slider-text-inner text-center">
				   					<h1>Better way for City Administration</h1>
				   					<h2>Complain : : Solution : : Feedback</h2>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
			   	<li style="background-image: url(homepage_assets/images/download2.jpg);">
			   		<div class="overlay"></div>
			   		<div class="container-fluids">
			   			<div class="row">
				   			<div class="col-md-8 col-sm-12 col-md-offset-2 slider-text">
				   				<div class="slider-text-inner text-center">
				   					<h1>You Build Your Future</h1>
				   					<h2>Your active participation means a lot to us.</h2>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>	
			  	</ul>
		  	</div>
		</aside>

		<div id="colorlib-intro">
			<div class="container">
				<div class="row">
					<div class="col-md-12 tabulation animate-box">
						<ul class="nav nav-tabs">
							<li><a href="admin_login.jsp">Admin Login</a></li>
							<li><a href="user_signup_login.jsp">User Login</a></li>
							<li><a href="municipal_login.jsp">Municipal Login</a></li>
							<li><a href="">NGO Login</a></li>
						</ul>
						<div class="tab-content">
							<div id="plan" class="tab-pane fade in active">
								<div class="row">
									<div class="col-md-6">
										<div class="services-img" style="background-image: url(homepage_assets/images/download.png);"></div>
									</div>
									<div class="col-md-6">
										<div class="services-desc">
											<p>Public Grievance Redressal System is an online web-enabled system which primarily aims to enable submission of grievances by the aggrieved citizens from anywhere and anytime (24x7) basis to Departments who scrutinize and take action for speedy and favorable redress of these grievances.It's an platform where users can share ideas , issue complaints for improvement of city administration. Their active participation can only bring transparency and flexibility in the system.</p>
											<!--<ul>
												<li>It is a paradisematic country in which</li>
												<li>Even the all-powerful Pointing has no control</li>
												<li>When she reached the first hills of the Italic Mountains</li>
												<li>Alphabet Village and the subline of her own road</li>
											</ul>-->
										</div>
									</div>
								</div>
				         </div>
					  </div>
		         </div>
				</div>
			</div>
		</div>
		
		<div id="colorlib-services">
			<div class="container">
				<div class="row">
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span class="icon">
								<i class="flaticon-engineer"></i>
							</span>
							<div class="desc">
								<h3>Online File Complaint</h3>
								<p>New users have to first sign up then they can lodge their complain.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span class="icon">
								<i class="flaticon-engineering"></i>
							</span>
							<div class="desc">
								<h3>Providing Solution</h3>
								<p>Users are provided solutions of their problems by concerned department.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span class="icon">
								<i class="flaticon-skyline"></i>
							</span>
							<div class="desc">
								<h3>Feedback</h3>
								<p>If the user wants to give feedback for the provided solution he can give it.</p>
								</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span class="icon">
								<i class="flaticon-crane"></i>
							</span>
							<div class="desc">
								<h3>NGOs</h3>
								<p>Users can also join any NGO or create one for upraisal of public demands not completed.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span class="icon">
								<i class="flaticon-sketch"></i>
							</span>
							<div class="desc">
								<h3>Municipal Department</h3>
								<p>They take care that the complains are being resolved.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span class="icon">
								<i class="flaticon-conveyor"></i>
							</span>
							<div class="desc">
								<h3>Active Participation</h3>
								<p>Users need to actively take part in this Online Platform for proper fuctioning of this Grievance Redressal Website.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="colorlib-counter" class="colorlib-counters" style="background-image: url(images/cover_img_1.jpg);" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div class="row no-gutter">
					<div class="col-md-3 col-sm-6 aside-stretch text-center animate-box">
						<div class="counter-entry">
							<span class="icon icon-white"><i class="flaticon-skyline"></i></span>
							<span class="colorlib-counter js-counter" data-from="0" data-to="145" data-speed="5000" data-refresh-interval="50"></span>
							<span class="colorlib-counter-label">Complaints</span>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 text-center animate-box">
						<div class="counter-entry">
							<span class="icon"><i class="flaticon-engineer"></i></span>
							<span class="colorlib-counter js-counter" data-from="0" data-to="100" data-speed="5000" data-refresh-interval="50"></span>
							<span class="colorlib-counter-label">Employees</span>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 text-center animate-box">
						<div class="counter-entry">
							<span class="icon"><i class="flaticon-architect-with-helmet"></i></span>
							<span class="colorlib-counter js-counter" data-from="0" data-to="500" data-speed="5000" data-refresh-interval="50"></span>
							<span class="colorlib-counter-label">Users</span>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 text-center animate-box">
						<div class="counter-entry">
							<span class="icon"><i class="flaticon-worker"></i></span>
							<span class="colorlib-counter js-counter" data-from="0" data-to="78" data-speed="5000" data-refresh-interval="50"></span>
							<span class="colorlib-counter-label">NGO'S</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="about-wrap">
		<div id="colorlib-about" class="colorlib-about-img" style="background-image: url(homepage_assets/images/team.jpg);" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center colorlib-heading colorlib-heading2 animate-box">
						<h2>Our Team</h2>
						<!--<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name</p>-->
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 animate-box">
						<div class="about-flex">
							<div class="col-half">
								<a href="#" class="staff-img" style="background-image: url(homepage_assets/images/rahul.jpg);">
									<div class="desc-staff">
										<h3>Rahul Chanderiya</h3>
										<span>IIM2016002</span>
									</div>
								</a>
			
								<a href="#" class="staff-img" style="background-image: url(homepage_assets/images/black.jpg);">
									<div class="desc-staff">
										<h3></h3>
										<span></span>
									</div>
								</a>
								<a href="#" class="staff-img" style="background-image: url(homepage_assets/images/black.jpg);">
									<div class="desc-staff">
										<h3></h3>
										<span></span>
									</div>
								</a>
								<a href="#" class="staff-img" style="background-image: url(homepage_assets/images/ankit.jpg);">
									<div class="desc-staff">
										<h3>Ankit Kumar Gupta</h3>
										<span>IHM2016004</span>
									</div>
								</a>
							</div>
							<div class="col-half">
								<div class="desc">
									<p></p>
									<div class="fancy-collapse-panel">
			                     <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
											<div class="panel panel-default">
												<div class="panel-heading" role="tab" id="headingOne">
													<h4 class="panel-title">
													   <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Who we are
													   </a>
													</h4>
												</div>
												<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
													<div class="panel-body">
													   <p>We are students at <strong>IIIT Allahabad.</strong> Persuing graduation from here. We have developed this Grievance Redressal Website for the betterment of conditions of Public.</p>
													</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading" role="tab" id="headingTwo">
													<h4 class="panel-title">
													   <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">What we do?
													   </a>
													</h4>
												</div>
											 	<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
													<div class="panel-body">
													   <p>We keep a look at the complaints given by users and try to provide solution to their problems.</p>
												 	</div>
												</div>
											</div>
			                     	<div class="panel panel-default">
			                         	<div class="panel-heading" role="tab" id="headingThree">
			                             	<h4 class="panel-title">
			                                 <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">Importance 
			                                 </a>
			                             	</h4>
			                         	</div>
			                         	<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
			                             	<div class="panel-body">
			                                 <p>Now people don't have to go to Municipal Department and lodge their complaints. They can now easily file a complain online and get their work done. </p>	
			                              </div>
			                           </div>
			                        </div>
			                     </div>
			                  </div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>

		<div id="colorlib-testimony">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center colorlib-heading animate-box">
						<h2>Client Says:</h2>
						<p>These are the feedbacks from the users using the website.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<div class="row animate-box">
							<div class="owl-carousel1">
								<div class="item">
									<div class="testimony-slide">
										<div class="testimony-wrap">
											<figure>
												<img src="homepage_assets/images/nikhil.jpg" alt="user">
											</figure>
											<blockquote>
												<span>Ashutosh Yelgulwar</span>
												<p>The website is very helping to anyone. You can easily sign up and file your Complaint. You can also see the status of your Complain.</p>
											</blockquote>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="testimony-slide">
										<div class="testimony-wrap">
											<figure>
												<img src="homepage_assets/images/shakya.jpg" alt="user">
											</figure>
											<blockquote>
												<span>Sudhanshu Shakya</span>
												<p>Awesome Website.</p>
											</blockquote>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="testimony-slide">
										<div class="testimony-wrap">
											<figure>
												<img src="homepage_assets/images/ujjwal.jpg" alt="user">
											</figure>
											<blockquote>
												<span>Ujjwal Gupta</span>
												<p>A Good Website for Online Redressal of Complaints.</p>
											</blockquote>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	
		<!--<div id="colorlib-subscribe">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center colorlib-heading animate-box">
						<h2>Subscribe Newsletter</h2>
						<p>Subscribe our newsletter and get latest update</p>
					</div>
				</div>
				<div class="row animate-box">
					<div class="col-md-6 col-md-offset-3">
						<div class="row">
							<div class="col-md-12">
							<form class="form-inline qbstp-header-subscribe">
								<div class="col-three-forth">
									<div class="form-group">
										<input type="text" class="form-control" id="email" placeholder="Enter your email">
									</div>
								</div>
								<div class="col-one-third">
									<div class="form-group">
										<button type="submit" class="btn btn-primary">Subscribe Now</button>
									</div>
								</div>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>-->
		<footer id="colorlib-footer">
			<div class="contact-information">
				<div class="container">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="row">
								<div class="col-md-4 text-center">
									<div class="info-wrap">
										<span class="icon"><i class="icon-location4"></i></span>
										<p>IIIT Allahabad, <br> Jhalwa, Allahabad - 211002</p>
									</div>
								</div>
								<div class="col-md-4 text-center">
									<div class="info-wrap">
										<span class="icon"><i class="icon-world"></i></span>
										<p><a href="https://www.iiita.ac.in/">IIIT Allahabad</a> <br> <a href="https://www.iiita.ac.in/">www.iiita.ac.in</a></p>
									</div>
								</div>
								<div class="col-md-4 text-center">
									<div class="info-wrap">
										<span class="icon"><i class="icon-phone2"></i></span>
										<p><a href="#">(001) 2345 6789</a> <br> <a href="#">(001) 9876 5432</a></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--<div class="container">
				<div class="row row-pb-md">
					<div class="col-md-3 colorlib-widget">
						<h4>About Complex</h4>
						<p>Far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics</p>
						<p>
							<ul class="colorlib-social-icons">
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-facebook"></i></a></li>
								<li><a href="#"><i class="icon-linkedin"></i></a></li>
								<li><a href="#"><i class="icon-dribbble"></i></a></li>
							</ul>
						</p>
					</div>
					<div class="col-md-3 col-md-push-1 colorlib-widget">
						<h4>Information</h4>
						<p>
							<ul class="colorlib-footer-links">
								<li><a href="#"><i class="icon-check"></i> Our Company</a></li>
								<li><a href="#"><i class="icon-check"></i> Certification</a></li>
								<li><a href="#"><i class="icon-check"></i> Our services</a></li>
								<li><a href="#"><i class="icon-check"></i> Career</a></li>
								<li><a href="#"><i class="icon-check"></i> Core Values</a></li>
								<li><a href="#"><i class="icon-check"></i> Company History</a></li>
								<li><a href="#"><i class="icon-check"></i> FAQ</a></li>
							</ul>
						</p>
					</div>

					<div class="col-md-3 colorlib-widget">
						<h4>Instagram</h4>
						<div class="instagram">
							<a href="#" class="insta-img" style="background-image: url(homepage_assets/images/building-1.jpg);"></a>
							<a href="#" class="insta-img" style="background-image: url(homepage_assets/images/building-2.jpg);"></a>
							<a href="#" class="insta-img" style="background-image: url(homepage_assets/images/building-3.jpg);"></a>
							<a href="#" class="insta-img" style="background-image: url(homepage_assets/images/building-4.jpg);"></a>
							<a href="#" class="insta-img" style="background-image: url(homepage_assets/images/building-5.jpg);"></a>
							<a href="#" class="insta-img" style="background-image: url(homepage_assets/images/building-6.jpg);"></a>
						</div>
					</div>

					<div class="col-md-3 col-md-push-1 colorlib-widget">
						<h4>Contact Info</h4>
						<ul class="colorlib-footer-links">
							<li>291 South 21th Street, <br> Suite 721 New York NY 10016</li>
							<li><a href="tel://1234567920"><i class="icon-phone"></i> + 1235 2355 98</a></li>
							<li><a href="mailto:info@yoursite.com"><i class="icon-envelope"></i> info@yoursite.com</a></li>
							<li><a href="http://luxehotel.com"><i class="icon-location4"></i> yourwebsite.com</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="copy">
				<div class="container">
					<div class="row">
						<div class="col-md-12 text-center">
							<p>
								<small class="block">
							Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
<!--Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart3" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>-->
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
								</small>
							</p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>-->

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="homepage_assets/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="homepage_assets/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="homepage_assets/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="homepage_assets/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="homepage_assets/js/jquery.stellar.min.js"></script>
	<!-- Flexslider -->
	<script src="homepage_assets/js/jquery.flexslider-min.js"></script>
	<!-- Owl carousel -->
	<script src="homepage_assets/js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="homepage_assets/js/jquery.magnific-popup.min.js"></script>
	<script src="homepage_assets/js/magnific-popup-options.js"></script>
	<!-- Counters -->
	<script src="homepage_assets/js/jquery.countTo.js"></script>
	<!-- Main -->
	<script src="homepage_assets/js/main.js"></script>

	</body>
</html>

