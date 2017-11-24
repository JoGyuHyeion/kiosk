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
						배경화면 등록 <small>배경화면 사진을 <code>등록</code> 할 수 있습니다.
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
								onsubmit="return formCheck()")>
								<div class="form-horizontal" role="form">
									<!-- bi_name -->
									<div class="form-group">
										<label class="col-md-3 control-label">제목</label>
										<div class="col-md-7">
											<input type="text" class="form-control" placeholder="Name"
												id="bi-name" name="bi_name">
										</div>
									</div>
									<!-- 배경화면 사용 가능 여부   -->
									<div class="form-group">
										<label class="col-md-3 control-label">표시여부</label>
										<!-- checkbox checked 일경우 활성화 -->
										<div style="padding: 5px">
											<input type="checkbox" name="bi_able" id="bi_able"
												switch="none" value="1" /> <label for="bi_able"
												data-on-label="On" data-off-label="Off"></label>
										</div>
									</div>
									<!-- bi_img-->
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
																self.location = "/backGroundboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});

										});
						
						function formCheck() {
							if ($.trim($("#bi_name").val()) == "") {
								alert("제목을 입력하세요");
								$("#bi_name").focus();
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