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
							<li><a href="#">공지관리</a></li>
							<li class="active">공지조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						공지수정 <small>공지를 <code>작성</code> 할 수 있습니다.
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
								<input type='hidden' name='brd_cd' value="notice">
								<div class="form-horizontal" role="form">
									<!-- bbs_title -->
									<div class="form-group">
										<label for="bbs_title" class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control"
												placeholder="Enter Title" id="bbs_title" name="bbs_title">
										</div>
									</div>
									<!-- bbs_content -->
									<div class="form-group">
										<label for="bbs_content" class="col-md-2 control-label">내용</label>
										<div class="col-md-10">
											<textarea class="form-control" rows="10" id="bbs_content"
												name="bbs_content"></textarea>
										</div>
									</div>
									<!-- bbs_file -->
									<div class="form-group">
										<label class="col-md-2 control-label">첨부 파일</label> <input
											id="fileName"
											class="file_input_textbox form-control col-md-5 " readonly />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript:var path = document.getElementById('fileName').value = this.value.split('\\').pop().split('/').pop()"
												name="imgFile" id="bbs_file" />
										</div>
									</div>
									<!-- 
									<div class="form-group">
										<label class="col-md-2 control-label">첨부이미지</label>
										<div class="col-md-10">
											<input type="file" class="form-control" id="bbs_file"
												name="bbs_file">
										</div>
									</div>
									 -->
									<!-- bbs_exp_sdt, bbs_exp_edt -->
									<div class="form-group">
										<label class="col-md-2 control-label">공지기간</label>
										<div class="col-md-8 input-group">
											<input type="date" class="form-control" id="bbs_exp_sdt"
												name="bbs_exp_sdt"> <span class="input-group-addon">
												~ </span> <input type="date" class="form-control" id="bbs_exp_edt"
												name="bbs_exp_edt">
										</div>
									</div>
									<!-- bbs_state     -->
									<div class="form-group">
										<label class="col-md-2 control-label">표시여부</label>
										<!-- checkbox checked 일경우 활성화 -->
										<div style="padding: 5px">
											<input type="checkbox" name="bbs_state" id="bbs_state"
												value="1" switch="none" /> <label for="bbs_state"
												data-on-label="On" data-off-label="Off"></label>
										</div>
									</div>
									<div class="form-group" style="text-align: center">
										<button type="submit"
											class="btn btn-primary waves-effect w-md waves-light m-b-5"
											id="change">등록</button>
										<button type="button"
											class="btn btn-warning waves-effect w-md waves-light m-b-5"
											id="back">돌아가기</button>
									</div>
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
																self.location = "/noticeboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
															});

										});
						function formCheck() {
							if ($.trim($("#bbs_title").val()) == "") {
								alert("제목을 입력하세요");
								$("#bbs_title").focus();
								return false;
							}else if ($.trim($("#bbs_content").val()) == "") {
								alert("내용을 입력하세요");
								$("#bbs_content").focus();
								return false;
							}else if ($("#bbs_exp_sdt").val() == "") {
								alert("노출 시작 날짜를 설정하세요");
								$("#bbs_exp_sdt").focus();
								return false;
							}else if ($("#bbs_exp_edt").val() == "") {
								alert("노출 시작 날짜를 설정하세요");
								$("#bbs_exp_edt").focus();
								return false;
							}else if ($.trim($("#bbs_file").val()) == "") {
								alert("파일을 첨부하세요");
								$("#bbs_file").focus();
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