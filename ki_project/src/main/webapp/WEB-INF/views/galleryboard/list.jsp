<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->

<section class="wrapper">

	<form role="form" action="modifyPage" method="post">

		<input type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
			type='hidden' name='searchType' value="${cri.searchType}"> <input
			type='hidden' name='keyword' value="${cri.keyword}">

	</form>
	<div class="container">



		<!-- Page-Title -->
		<div class="row">
			<div class="col-sm-12">
				<div class="page-title-box">
					<div class="btn-group pull-right">
						<ol class="breadcrumb hide-phone p-0 m-0">
							<li><a href="#">디지털조직도</a></li>
							<li><a href="#">갤러리</a></li>
							<li class="active">갤러리조회</li>
						</ol>
					</div>
					<h4 class="page-title">갤러리조회</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->


		<div class="row">
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="#" class="text-dark">4BHK Alexander Court,New York</a>
								</h3>

								<div class="m-t-20" style="text-align: center">
									<button type="button"
										class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
									<button type="button"
										class="btn btn-danger btn-inline waves-effect waves-light">
										<i class="glyphicon  glyphicon-trash"></i>삭제
									</button>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="#" class="text-dark">4BHK Alexander Court,New York</a>
								</h3>

								<div class="m-t-20" style="text-align: center">
									<button type="button"
										class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
									<button type="button"
										class="btn btn-danger btn-inline waves-effect waves-light">
										<i class="glyphicon  glyphicon-trash"></i>삭제
									</button>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="#" class="text-dark">4BHK Alexander Court,New York</a>
								</h3>

								<div class="m-t-20" style="text-align: center">
									<button type="button"
										class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
									<button type="button"
										class="btn btn-danger btn-inline waves-effect waves-light">
										<i class="glyphicon  glyphicon-trash"></i>삭제
									</button>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="#" class="text-dark">4BHK Alexander Court,New York</a>
								</h3>

								<div class="m-t-20" style="text-align: center">
									<button type="button"
										class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
									<button type="button"
										class="btn btn-danger btn-inline waves-effect waves-light">
										<i class="glyphicon  glyphicon-trash"></i>삭제
									</button>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="#" class="text-dark">4BHK Alexander Court,New York</a>
								</h3>

								<div class="m-t-20" style="text-align: center">
									<button type="button"
										class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
									<button type="button"
										class="btn btn-danger btn-inline waves-effect waves-light">
										<i class="glyphicon  glyphicon-trash"></i>삭제
									</button>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="#" class="text-dark">4BHK Alexander Court,New York</a>
								</h3>

								<div class="m-t-20" style="text-align: center">
									<button type="button"
										class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
									<button type="button"
										class="btn btn-danger btn-inline waves-effect waves-light">
										<i class="glyphicon  glyphicon-trash"></i>삭제
									</button>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
			<!-- end col -->
			<div class="text-right">
				<ul class="pagination pagination-split m-t-0">
					<li class="disabled"><a href="#"><i
							class="fa fa-angle-left"></i></a></li>
					<li><a href="#">1</a></li>
					<li class="active"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
				</ul>
			</div>
		</div>
		<!-- end row -->


	</div>
	<!-- end row -->

	<script>
		var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리가 완료되었습니다.");
		}
	</script>

	<script>
		$(document).ready(
				function() {

					$('#searchBtn').on(
							"click",
							function(event) {

								self.location = "list"
										+ '${pageMaker.makeQuery(1)}'
										+ "&searchType="
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val();

							});

					$('#newBtn').on("click", function(evt) {

						self.location = "register";

					});

				});
	</script>

	<%@include file="../include/footer.jsp"%>