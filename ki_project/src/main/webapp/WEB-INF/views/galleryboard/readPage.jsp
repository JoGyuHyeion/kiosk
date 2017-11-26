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
							<li><a href="#">갤러리</a></li>
							<li class="active">갤러리수정</li>
						</ol>
					</div>
					<h4 class="page-title">
						갤러리등록 <small>갤러리를 <code>수정</code> 할 수 있습니다.
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
									<!-- img_title -->
									<div class="form-group">
										<label class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control" readonly="readonly"
												placeholder="Name" id="img_title" name="img_title"
												value="${com_imageVO.img_title}">
										</div>
									</div>
									<!-- img -->
									<img width="600" height="400"
										src="${pageContext.request.contextPath}/resources/upload/${com_imageVO.img_filenm}"
										class="thumb-img"
										onerror="this.src='/resources/assets/images/properties/1.jpg'">

									<!-- img_gallery  노출 여부   -->
									<div class="form-group">
										<label class="col-md-2 control-label">표시여부</label>
										<!-- checkbox checked 일경우 활성화 -->
										<div style="padding: 5px">
											<input type="checkbox" name="img_gallery" id="img_gallery"
												value="1" switch="none" onclick="return false" /> <label
												for="img_gallery" data-on-label="On" data-off-label="Off"></label>
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
						<form action="/galleryboard/removePage" method="post">
							<input type="hidden" name="img_no" value="${com_imageVO.img_no}">
							<button type="submit"
								class="btn btn-danger waves-effect w-md waves-light m-b-5"
								id="delete">삭제</button>
						</form>
						<button type="button"
							class="btn btn-warning waves-effect w-md waves-light m-b-5"
							id="back">돌아가기</button>
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
																self.location = "/galleryboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});
											$("#back")
													.on(
															"click",
															function() {
																self.location = "/galleryboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});

											alert("${com_imageVO.img_gallery}");
											var input = ${com_imageVO.img_gallery};
											if (input == 1) { //값 비교
												$('input:checkbox[id="img_gallery"]').attr("checked", true); //checked 처리
											}
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