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
						<form>
							<div class="col-md-7">
								<div class="form-horizontal" role="form">
									<!-- vi_name -->
									<div class="form-group">
										<label class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control" readonly="readonly"
												placeholder="Name" id="vi_name" name="vi_name"
												value="${com_videoVO.vi_name}">
										</div>
									</div>
									<!-- video -->
									<div class="form-group">
										<label class="col-md-2 control-label">동영상</label>
										<div class="col-md-10">
											<video controls>
											<source src="${pageContext.request.contextPath}/resources/upload/${com_videoVO.vi_video}" type="video/mp4">
											<source src="movie.ogg" type="video/ogg">
											</video>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="form-group" style="text-align: center">
						<button type="button"
							class="btn btn-primary waves-effect w-md waves-light m-b-5"
							id="change">수정</button>
						<form action="/movieboard/removePage" method="post">
							<input type="hidden" name="img_no" value="${com_videoVO.vi_no}">
							<button type="submit"
								class="btn btn-danger waves-effect w-md waves-light m-b-5"
								id="delete">삭제</button>
						</form>
						<button type="button"
							class="btn btn-warning waves-effect w-md waves-light m-b-5"
							id="back">돌아가기</button>
					</div>
					<script>
						$(document).ready(function() {
							var formObj = $("form[role='form']");
							console.log(formObj);
							$("#change").on("click",function() {
								self.location = "/movieboard/modifyPage?vi_no=${com_videoVO.vi_no}";
								});
							
							$("#back").on("click",function() {
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
<%@include file="../include/footer.jsp"%>