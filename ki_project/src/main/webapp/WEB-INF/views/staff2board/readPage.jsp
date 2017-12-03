<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
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
							<li><a href="#">직원관리</a></li>
							<li class="active">직원정보</li>
						</ol>
					</div>
					<h4 class="page-title">
						직원정보 <small>직원의 <code>세부정보</code>를 <code>열람</code> 할 수
							있습니다.
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
									<!-- usr_nm -->
									<div class="form-group">
										<label class="col-md-2 control-label">이름</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												id="usr_nm" name="usr_nm" value="${com_staff2VO.usr_nm}">
										</div>
									</div>
									<!-- posit_nm-->
									<div class="form-group">
										<label class="col-md-2 control-label">직위</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="posit_nm" name="posit_nm"
												value="${com_staff2VO.posit_nm}">
										</div>
									</div>
									<!-- telno -->
									<div class="form-group">
										<label class="col-md-2 control-label">전화번호</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="telno" name="telno"
												value="${com_staff2VO.telno}">
										</div>
									</div>

									<!-- email_addr -->
									<div class="form-group">
										<label class="col-md-2 control-label">이메일</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="email_addr"
												name="email_addr" value="${com_staff2VO.email_addr}">
										</div>
									</div>
									<!-- st_job-->
									<div class="form-group">
										<label class="col-md-2 control-label">대표업무</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="st_key" name="st_key"
												value="${com_staff2VO.main_task}">
										</div>
									</div>
									<!-- adi_info7 -->
									<div class="form-group">
										<label class="col-md-2 control-label">사무설명</label>
										<div class="col-md-10">
											<textarea class="form-control" readonly="readonly" rows="10"
												id="adi_info7" name="adi_info7">${com_staff2VO.adi_info7}</textarea>
										</div>
									</div>

									<!-- img_filenm -->
									<div class="form-group">
										<label class="col-md-2 control-label">사진</label>
										<div class="col-me-10">
											<img
												src="${pageContext.request.contextPath}${uploadPath}${com_staff2VO.img_filenm}"
												class="thumb-img" alt="등록된 사진이 없습니다.">
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
						<form action="/staff2board/removePage" method="post">
							<input type="hidden" name="st_no" value="${com_staff2VO.st_no}">
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
																self.location = "/staff2board/modifyPage?page=${cri.page}&perPageNum=${cri.perPageNum}&st_no=${com_staff2VO.st_no}";
															});

											$("#back")
													.on(
															"click",
															function() {
																self.location = "/staff2board/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});
										});
					</script>

				</div>

			</div>
			<!-- end col -->
		</div>
	</div>
</section>
<%@include file="../include/footer.jsp"%>
