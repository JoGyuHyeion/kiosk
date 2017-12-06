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
							<li class="active">building</li>
						</ol>
					</div>
					<h4 class="page-title">
						건물사진등록 <small>건물사진을 <code>등록</code> 할 수 있습니다.
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
						<div class="col-md-7">
							<form method="post" role="form" enctype="multipart/form-data"
								onsubmit="return formCheck()">
								<div class="form-horizontal" role="form">
									<!-- bu_name -->
									<div class="form-group">
										<label class="col-md-3 control-label">건물이름</label>
										<div class="col-md-7">
											<input type="text" class="form-control" placeholder="Name"
												id="bu_name" name="bu_name">
										</div>
									</div>
									<!-- bu_type -->
									<div class="form-group">
										<label class="col-md-3 control-label">건물 구분</label>
										<div class="col-md-5">
											<select name="bu_type" id="bu_type" class="form-control">
												<option value="1" selected>본관</option>
												<option value="2">동관</option>
												<option value="3">서관</option>
											</select>
										</div>
									</div>
									<!-- bu_img -->
									<div class="form-group">
										<label class="col-md-3 control-label">이미지 파일</label> <input
											id="imgName"
											class="file_input_textbox form-control col-md-5 " readonly />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript:var path = document.getElementById('imgName').value = this.value.split('\\').pop().split('/').pop()"
												accept="image/*" name="imgFile" id="img_filenm" />
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
																self.location = "/buildingboard/list?keyword=1";
															});

										});
						
						function formCheck() {
							if ($.trim($("#bu_name").val()) == "") {
								alert("제목을 입력하세요");
								$("#bu_name").focus();
								return false;
							}else if ($.trim($("#img_filenm").val()) == "") {
								alert("사진을 첨부하세요");
								$("#img_filenm").focus();
								return false;
							}
							return true;

						}
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