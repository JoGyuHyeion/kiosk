<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">

<link rel="shortcut icon" href="/resources/assets/images/favicon.ico">

<title>스마트 조직도</title>

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
<!-- fileUpload CSS -->
<link rel="stylesheet" href="/resources/assets/css/file_input.css">

<script src="/resources/assets/js/modernizr.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!--  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'> -->
<link rel='stylesheet prefetch'
	href='https://rawgit.com/adrotec/knockout-file-bindings/master/knockout-file-bindings.css'>

<!--venobox lightbox-->
<link rel="stylesheet"
	href="/resources/plugins/magnific-popup/css/magnific-popup.css" />

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
					<a href="list" class="logo"> <img
						src="/resources/assets/logo(clean).png" alt="" height="30">
					</a>

				</div>
				<!-- End Logo container-->


				<div class="menu-extras">

					<ul class="nav navbar-nav navbar-right pull-right">



						<button type="button"
							class="btn btn-danger waves-effect w-md waves-light m-b-5"
							onclick="
						location.href='/logout'">
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
						<!-- 계정관리 -->
						<c:if test="${0 eq login.auth}">
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>계정관리</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/userboard/register">계정생성(Super)</a></li>
										<li><a href="/userboard/list">계정조회(Super)</a></li>
									</ul>
								</li>
							</ul></li>
							</c:if>
						<!-- 기초설정 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>기초설정</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
									<c:if test="${0 eq login.auth}">
										<li><a href="/myinfoboard/bureau">부서관리(Super)</a></li>
										<li><a href="/myinfoboard/section?bcd=k000">국관리(Super)</a></li>
									</c:if>
										<li><a href="/myinfoboard/passwd">비밀번호변경</a></li>
										<li><a href="/myinfoboard/team">팀관리</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 직원등록 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>직원등록</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/staffboard/register">직원등록</a></li>
										<li><a href="/staffboard/list?page=1&perPageNum=10">직원조희</a></li>
										<li><a href="/staffboard/moveStaff?page=1&perPageNum=10">직원부서이동</a></li>
										
									</ul>
								</li>
							</ul></li>
						<!-- 갤러리 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>갤러리</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/galleryboard/register">갤러리등록</a></li>
										<li><a href="/galleryboard/list?page=1&perPageNum=6">갤러리조희</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 동영상 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>동영상</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/movieboard/register">동영상등록</a></li>
										<li><a href="/movieboard/list?page=1&perPageNum=6">동영상조희</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- 공지사항 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>공지사항</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/noticeboard/register">공지사항등록</a></li>
										<li><a href="/noticeboard/list?page=1&perPageNum=10">공지사항조희</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- kiosk설정 -->
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-google-pages"></i>manager</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
									<c:if test="${0 eq login.auth}">
										<li><a href="/iconboard/list">Icon(Super)</a></li>
										<li><a href="/backGroundboard/list?page=1&perPageNum=10">바탕화면(Super)</a></li>
										<li><a href="/buildingboard/list?keyword=1">Building(Super)</a></li>
									</c:if>
										<li><a href="/usbFileboard/usb">USB</a></li>
									</ul>
								</li>
							</ul></li>
					</ul>


				</div>
			</div>
		</div>
	</header>
	<!-- End Navigation Bar-->

	<script src="/resources/assets/js/modernizr.min.js"></script>
	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
</head>