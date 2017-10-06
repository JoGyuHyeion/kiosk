<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">

<link rel="shortcut icon" href="/resources/assets/images/favicon.ico">

<title>Zircos - Responsive Admin Dashboard Template</title>

<!-- App css -->
<link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/assets/css/core.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/assets/css/components.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/assets/css/icons.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/assets/css/pages.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/assets/css/menu.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/assets/css/responsive.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="/resources/plugins/switchery/switchery.min.css">

<!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

<script src="/resources/assets/js/modernizr.min.js"></script>

</head>


<body>


	<!-- Navigation Bar-->
	<header id="topnav">
		<div class="topbar-main">
			<div class="container">

				<!-- Logo container-->
				<div class="logo">
					<!-- Text Logo -->
					<!--<a href="index.html" class="logo">-->
					<!--Zircos-->
					<!--</a>-->
					<!-- Image Logo -->
					<a href="index.html" class="logo"> <img
						src="/resources/assets/images/logo.png" alt="" height="30">
					</a>

				</div>
				<!-- End Logo container-->


				<div class="menu-extras">

					<ul class="nav navbar-nav navbar-right pull-right">



						<button type="button" class="btn btn-danger waves-effect w-md waves-light m-b-5">
							<i class="ti-power-off m-r-5"></i> Logout
						</button>


					</ul>
					<div class="menu-item">
						<!-- Mobile menu toggle-->
						<a class="navbar-toggle">
							<div class="lines">
								<span></span> <span></span> <span></span>
							</div>
						</a>
						<!-- End mobile menu toggle-->
					</div>
				</div>
				<!-- end menu-extras -->

			</div>
			<!-- end container -->
		</div>
		<!-- end topbar-main -->

		<div class="navbar-custom">
			<div class="container">
				<div id="navigation">
					<!-- Navigation Menu-->
					<ul class="navigation-menu">
						<!-- 기초설정 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>기초설정</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="myinfo_pswd.html">비밀번호변경</a></li>
										<li><a href="section_set.html">과관리</a></li>
										<li><a href="page-register.html">Kiosk배경화면</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 직원등록 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>직원등록</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="page-starter.html">직원등록</a></li>
										<li><a href="page-login.html">직원조희</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 갤러리 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>갤러리</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="page-starter.html">갤러리등록</a></li>
										<li><a href="page-login.html">갤러리조희</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 동영상 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>동영상</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="page-starter.html">동영상등록</a></li>
										<li><a href="page-login.html">동영상조희</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 공지사항 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>공지사항</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="page-starter.html">공지사항등록</a></li>
										<li><a href="page-login.html">공지사항조희</a></li>
									</ul>
								</li>
							</ul></li>

					</ul>


				</div>
			</div>
		</div>
	</header>
	<!-- End Navigation Bar-->