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
							<li class="active">직원조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						직원수정 <small>직원을 <code>수정</code> 할 수 있습니다.
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
									<!-- st_nm -->
									<div class="form-group">
										<label class="col-md-2 control-label">이름</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												id="st_nm" name="st_nm" value="${com_staffVO.st_nm}">
										</div>
									</div>
									<!-- st_position -->
									<div class="form-group">
										<label class="col-md-2 control-label">직위</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="st_position"
												name="st_position" value="${com_staffVO.st_position}">
										</div>
									</div>
									<!-- st_tel -->
									<div class="form-group">
										<label class="col-md-2 control-label">전화번호</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="st_tel" name="st_tel"
												value="${com_staffVO.st_tel}">
										</div>
									</div>

									<!-- st_email -->
									<div class="form-group">
										<label class="col-md-2 control-label">이메일</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="st_email" name="st_email"
												value="${com_staffVO.st_email}">
										</div>
									</div>
									<!-- st_job-->
									<div class="form-group">
										<label class="col-md-2 control-label">대표업무</label>
										<div class="col-md-10">
											<input type="text" readonly="readonly" class="form-control"
												readonly="readonly" rows="10" id="st_job" name="st_job"
												value="${com_staffVO.st_job}">
										</div>
									</div>
									<!-- st_profile -->
									<div class="form-group">
										<label class="col-md-2 control-label">사무설명</label>
										<div class="col-md-10">
											<textarea class="form-control" readonly="readonly" rows="10"
												id="st_profile" name="st_profile">${com_staffVO.st_profile}</textarea>
										</div>
									</div>

									<!-- st_filenm -->
									<div class="form-group">
										<label class="col-md-2 control-label">사진</label>
										<div class="col-md-10">
											<!-- 파일다운로드 -->
											<!-- <input type="file" class="form-control" id="st_filenm"
                                                    name="st_filenm"> -->
										</div>
									</div>


								</div>
							</div>



						</form>
					</div>
					<div class="form-group" style="text-align: center">
						<button type="submit"
							class="btn btn-primary waves-effect w-md waves-light m-b-5"
							id="change">수정</button>
						<form action="/staffboard/removePage" method="post">
							<input type="hidden" name="st_no" value="${com_staffVO.st_no}">
							<button type="submit"
								class="btn btn-danger waves-effect w-md waves-light m-b-5"
								id="delete">삭제</button>
						</form>
						<button type="submit"
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
																self.location = "/staffboard/modifyPage?page=${cri.page}&perPageNum=${cri.perPageNum}&st_no=${com_staffVO.st_no}";
															});

											$("#back")
													.on(
															"click",
															function() {
																self.location = "/staffboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
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
