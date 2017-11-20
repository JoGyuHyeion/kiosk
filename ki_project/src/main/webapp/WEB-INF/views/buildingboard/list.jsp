<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="wrapper">
	<div class="container">
		<!-- Page-Title -->
		<div class="row">
			<div class="col-sm-12">
				<div class="page-title-box">
					<div class="btn-group pull-right">
						<ol class="breadcrumb hide-phone p-0 m-0">
							<li><a href="#">디지털조직도</a></li>
							<li><a href="#">건물정보</a></li>
							<li class="active">층수사진</li>
						</ol>
					</div>
					<h4 class="page-title">층수사진</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="col-lg -12">
			<div class="card-box">

				<div class="row">

					<div class="col-sm-8 col-centered">
						<form role="form">

							<label class=" col-md-2 control-label" for="search_bcd">건물
								선택</label> <select id="search_bcd" name="search_bcd"
								class="form-control">
								<option value="none">본관</option>
								<option value="none">동관</option>
								<option value="none">서관</option>

							</select>
						</form>
					</div>

				</div>

				<div class="row">
					<div class="text-center">

						<h3>본관 정보</h3>


						<div class="text-align">
							<div class="col-lg-8 col-centered">

								<!-- START carousel-->
								<div id="carousel-example-captions" data-ride="carousel"
									class="carousel slide">
									<ol class="carousel-indicators">
										<li data-target="#carousel-example-captions" data-slide-to="0"
											class="active"></li>
										<li data-target="#carousel-example-captions" data-slide-to="1"></li>
										<li data-target="#carousel-example-captions" data-slide-to="2"></li>
									</ol>
									<div role="listbox" class="carousel-inner">
										<div class="item active text-center">
											<img src="/resources/upload/building/b-1F.jpg"
												alt="First slide image">
											<div class="carousel-caption">
												<h3 class="text-white font-600">b-1F</h3>

											</div>
										</div>
										<div class="item">
											<img src="/resources/upload/building/b-2F.jpg"
												alt="Second slide image">
											<div class="carousel-caption">
												<h3 class="text-white font-600">b-2F</h3>

											</div>
										</div>
										<div class="item">
											<img src="/resources/upload/building/b-3F.jpg"
												alt="Third slide image">
											<div class="carousel-caption">
												<h3 class="text-white font-600">b-3F</h3>

											</div>
										</div>
										<div class="item">
											<img src="/resources/upload/building/b-4F.jpg"
												alt="Third slide image">
											<div class="carousel-caption">
												<h3 class="text-white font-600">b-4F</h3>

											</div>
										</div>
										<a href="#carousel-example-captions" role="button"
											data-slide="prev" class="left carousel-control"> <span
											aria-hidden="true" class="fa fa-angle-left"></span> <span
											class="sr-only">Previous</span>
										</a> <a href="#carousel-example-captions" role="button"
											data-slide="next" class="right carousel-control"> <span
											aria-hidden="true" class="fa fa-angle-right"></span> <span
											class="sr-only">Next</span>
										</a>
									</div>
									<!-- END carousel-->
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-lg-8 col-centered">
								<div class="card-box">
									<h4 class="header-title m-t-0 m-b-30">건물 정보</h4>

									<div class="tabs-vertical-env">
										<ul class="nav tabs-vertical">
											<li class="active"><a href="#v-home" data-toggle="tab"
												aria-expanded="false">1층</a></li>
											<li class=""><a href="#v-profile" data-toggle="tab"
												aria-expanded="true">2층</a></li>
											<li class=""><a href="#v-messages" data-toggle="tab"
												aria-expanded="false">3층</a></li>
											<li class=""><a href="#v-settings" data-toggle="tab"
												aria-expanded="false">4 층</a></li>
										</ul>

										<div class="tab-content">
											<div class="tab-pane active" id="v-home">

												<img src="/resources/upload/building/b-1F.jpg"
													alt="First slide image" class="img-responsive" />
												<div class="form-group" style="text-align: center">
													<button
														class="btn btn-info btn-rounded waves-effect m-t-10 waves-light"
														data-toggle="modal" data-target="#buildingModal">수정</button>
													<label class="col-md-5 control-label">마지막 수정 날짜:
														17.10.29</label>
												</div>
											</div>
											<div class="tab-pane" id="v-profile">
												<img src="/resources/upload/building/b-2F.jpg"
													alt="First slide image" class="img-responsive" />
												<div class="form-group" style="text-align: center">
													<button
														class="btn btn-info btn-rounded waves-effect m-t-10 waves-light"
														data-toggle="modal" data-target="#buildingModal">수정</button>
													<label class="col-md-5 control-label">마지막 수정 날짜:
														17.10.29</label>
												</div>
											</div>
											<div class="tab-pane" id="v-messages">
												<img src="/resources/upload/building/b-3F.jpg"
													alt="First slide image" class="img-responsive" />
												<div class="form-group" style="text-align: center">
													<button
														class="btn btn-info btn-rounded waves-effect m-t-10 waves-light"
														data-toggle="modal" data-target="#buildingModal">수정</button>
													<label class="col-md-5 control-label">마지막 수정 날짜:
														17.10.29</label>
												</div>
											</div>
											<div class="tab-pane" id="v-settings">
												<img src="/resources/upload/building/b-4F.jpg"
													alt="First slide image" class="img-responsive" />
												<div class="form-group" style="text-align: center">
													<button
														class="btn btn-info btn-rounded waves-effect m-t-10 waves-light"
														data-toggle="modal" data-target="#buildingModal">수정</button>
													<label class="col-md-5 control-label">마지막 수정 날짜:
														17.10.29</label>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- end col -->
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- modal  -->
		<div class="modal fade" id="buildingModal" tabindex="-1" role="dialog"
			aria-labelledby="imageModalModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="imageModalLabel">Building 수정</h4>
					</div>
					<div></div>
					<div class="modal-body">
						<form action="/building/modifyPage" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="image" class="control-label">파일 등록</label> <input
									type="file" id="file_upload" class="form-control"
									name="iconFile">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">수정하기</button>
							</div>

						</form>
					</div>

				</div>
			</div>
		</div>
		<script>
			$(document).ready(function() {
				$('#buildingModal').on('show.bs.modal', function(event) {
					var button = $(event.relatedTarget);
					var ic_no = button.data('icNo');
					//alert(ic_no);
					var modal = $(this);
					modal.find('.modal-body input').val(ic_no);
				});


			});
		</script>
	</div>
</section>
<%@include file="../include/footer.jsp"%>