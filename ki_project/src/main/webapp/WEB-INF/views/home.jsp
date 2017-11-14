<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

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
<!-- fileUpload CSS -->
<link rel="stylesheet" href="/resources/assets/css/file_input.css">

<script src="/resources/assets/js/modernizr.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!--  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'> -->
<link rel='stylesheet prefetch'
	href='https://rawgit.com/adrotec/knockout-file-bindings/master/knockout-file-bindings.css'>
</head>


<body class="bg-transparent">

	<!-- HOME -->
	<section>
		<div class="container-alt">
			<div class="row">
				<div class="col-sm-12">

					<div class="wrapper-page">

						<div class="m-t-40 account-pages">
							<div class="text-center account-logo-box">
								<h2 class="text-uppercase">
									<a href="index.html" class="text-success"> <span><img
											src="/resources/assets/logo(clean).png" alt="" height="36"></span>
									</a>
								</h2>
								<!--<h4 class="text-uppercase font-bold m-b-0">Sign In</h4>-->
							</div>
							<div class="account-content">
								<form class="form-horizontal" action="#">
									
									<div class="form-group ">
										<div class="col-xs-12">
											<select class="form-control">
												<c:forEach items="${service}" var="com_sectionVO">
													<option value ="${com_sectionVO.section_fullcode}">${com_sectionVO.section_fullpath}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group ">
										<div class="col-xs-12">
											<input class="form-control" type="text" required=""
												placeholder="Username">
										</div>
									</div>

									<div class="form-group">
										<div class="col-xs-12">
											<input class="form-control" type="password" required=""
												placeholder="Password">
										</div>
									</div>



			

									<div class="form-group account-btn text-center m-t-10">
										<div class="col-xs-12">
											<button
												class="btn w-md btn-bordered btn-danger waves-effect waves-light"
												type="submit">Log In</button>
										</div>
									</div>

								</form>

								<div class="clearfix"></div>

							</div>
						</div>
						<!-- end card-box-->



					</div>
					<!-- end wrapper -->

				</div>
			</div>
		</div>
	</section>
	<!-- END HOME -->



	<!-- jQuery  -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/bootstrap.min.js"></script>
	<script src="/resources/assets/js/detect.js"></script>
	<script src="/resources/assets/js/fastclick.js"></script>
	<script src="/resources/assets/js/jquery.blockUI.js"></script>
	<script src="/resources/assets/js/waves.js"></script>
	<script src="/resources/assets/js/jquery.slimscroll.js"></script>
	<script src="/resources/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/resources/plugins/switchery/switchery.min.js"></script>

	<!-- fileupload -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/knockout/3.1.0/knockout-min.js'></script>
	<script
		src='https://rawgit.com/adrotec/knockout-file-bindings/master/knockout-file-bindings.js'></script>
	<script src='/resources/assets/js/fileupload.js'></script>

	<!-- App js -->
	<script src="/resources/assets/js/jquery.core.js"></script>
	<script src="/resources/assets/js/jquery.app.js"></script>

</body>
</html>
