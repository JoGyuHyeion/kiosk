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
							<li><a href="#">디지털 조직도</a></li>
							<li><a href="#">동영상</a></li>
							<li class="active">동영상등록</li>
						</ol>
					</div>
					<h4 class="page-title">
						동영상등록 <small>동영상을 <code>등록</code> 할 수 있습니다.
						</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<div class="row">
<<<<<<< HEAD
						<form method="post" role="form" enctype="multipart/form-data">
							<div class="col-md-7">
=======
						<div class="col-md-7">

							<form method="post" role="form" enctype="multipart/form-data">
>>>>>>> 707341ae304f93802333e9b08a381bdcb86bf019
								<div class="form-horizontal" role="form">
									<!-- vi_name-->
									<div class="form-group">
										<label class="col-md-3 control-label">제목</label>
										<div class="col-md-7">
											<input type="text" class="form-control" placeholder="Name"
												id="vi_video" name="vi_video">
										</div>
									</div>
									<!-- vi_video -->
									<div class="form-group">
										<label class="col-md-3 control-label">동영상 파일</label> <input
											id="videoName"
											class="file_input_textbox form-control col-md-5 " readonly />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript:var path = document.getElementById('videoName').value = this.value.split('\\').pop().split('/').pop()"
												accept="video/*" name="videoFile" id="vi_video" />
										</div>
									</div>
<<<<<<< HEAD
								</div>
								<div class="form-group" style="text-align: center">
									<button type="submit"
										class="btn btn-primary waves-effect w-md waves-light m-b-5">등록</button>
									<button type="button"
										class="btn btn-warning waves-effect w-md waves-light m-b-5"
										id="back">돌아가기</button>
=======
>>>>>>> 707341ae304f93802333e9b08a381bdcb86bf019
								</div>
						</div>
					</div>

					<div class="form-group" style="text-align: center">
						<button type="submit"
							class="btn btn-primary waves-effect w-md waves-light m-b-5">등록</button>
						<button type="button"
							class="btn btn-warning waves-effect w-md waves-light m-b-5"
							id="back">돌아가기</button>
					</div>
					</form>
				</div>
				<script>
						$(document)
								.ready(
										function() {
											var formObj = $("form[role='form']");
											console.log(formObj);
											$("#back")
													.on(
															"click",
															function() {
																self.location = "/movieboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});

										});
					</script>

			</div>
		</div>
		<!-- end col -->

	</div>
	<!-- end row -->

	</div>
	<!-- end container -->
</section>
<!-- end wrapper -->
<%@include file="../include/footer.jsp"%>