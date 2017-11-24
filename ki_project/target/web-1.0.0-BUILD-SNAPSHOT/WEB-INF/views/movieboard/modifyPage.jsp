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
							<li class="active">동영상수정</li>
						</ol>
					</div>
					<h4 class="page-title">
						동영상등록 <small>동영상을 <code>수정</code> 할 수 있습니다.
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
						<form method="post" role="form" enctype="multipart/form-data">
							<div class="col-md-7">
								<div class="form-horizontal" role="form">
									<!-- vi_name -->
									<div class="form-group">
										<label class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="Name"
												id="vi_name" name="vi_name" value="${com_videoVO.vi_name}">
										</div>
									</div>
									<!-- vi_video -->
									<div class="form-group">
										<label class="col-md-2 control-label">이미지 파일</label> <input
											id="videoName" name="videoName"
											class="file_input_textbox form-control col-md-5 "
											readonly="readonly" value="${com_videoVO.vi_video}" />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript:var path = document.getElementById('videoName').value = this.value.split('\\').pop().split('/').pop()"
												accept="video/*" name="videoFile" id="video_file" />
										</div>
										<input type="hidden" name="vi_video" id="vi_video"
											value="${com_videoVO.vi_video}">
									</div>
									<!-- <div class="form-group clearfix">
										<div class="col-sm-12 padding-left-0 padding-right-0">
											<input type="file" name="videoFile" id="vi_video"
												multiple="multiple">
										</div>
									</div> -->

									<div class="form-group" style="text-align: center">
										<button type="submit"
											class="btn btn-primary waves-effect w-md waves-light m-b-5"
											id="change">수정</button>
										<button type="button"
											class="btn btn-warning waves-effect w-md waves-light m-b-5"
											id="back">돌아가기</button>
									</div>
								</div>
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