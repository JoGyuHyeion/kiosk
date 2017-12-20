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
							<li><a href="#">manager</a></li>
							<li class="active">배경화면</li>
						</ol>
					</div>
					<h4 class="page-title">
						배경화면정보 <small>배경화면의  <code>세부정보</code>를 <code>열람</code> 할 수 있습니다.
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
												placeholder="Name" id="bi_name" name="bi_name"
												value="${com_bgImgVO.bi_name}">
										</div>
									</div>
									<!-- img -->
									<div class="form-group">
										<label class="col-md-2 control-label">배경사진</label>
										<div class="col-me-10">
											<img
												src="${pageContext.request.contextPath}${uploadPath}${com_bgImgVO.bi_img}"
												class="thumb-img" alt="등록된 사진이 없습니다.">
										</div>
									</div>
									<!-- img_gallery  노출 여부   -->
									<div class="form-group">
										<label class="col-md-2 control-label">표시여부</label>
										<!-- checkbox checked 일경우 활성화 -->
										<div style="padding: 5px">
											<input type="checkbox" name="bi_able" id="bi_able"
												value="1" switch="none" onclick="return false" /> <label
												for="bi_able" data-on-label="On" data-off-label="Off"></label>
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
						<form action="/backGroundboard/removePage" method="post">
							<input type="hidden" name="bi_no" value="${com_bgImgVO.bi_no}">
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
											$("#change")
													.on(
															"click",
															function() {
																self.location = "/backGroundboard/modifyPage?bi_no=${com_bgImgVO.bi_no}";
															});
											$("#back")
													.on(
															"click",
															function() {
																self.location = "/backGroundboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});

											
											
											//alert("${com_bgImgVO.bi_able}");
											var bi_able = ${com_bgImgVO.bi_able};
											if (bi_able == 1) { //값 비교
												$('input:checkbox[id="bi_able"]')
														.attr("checked", true); //checked 처리
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