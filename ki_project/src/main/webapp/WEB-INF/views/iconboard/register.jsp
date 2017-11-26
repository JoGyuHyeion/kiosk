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
							<li><a href="#">아이콘</a></li>
							<li class="active">아이콘등록</li>
						</ol>
					</div>
					<h4 class="page-title">
						아이콘등록 <small>아이콘을 <code>등록</code> 할 수 있습니다.
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
							<form method="post" enctype="multipart/form-data"
								onsubmit="return formCheck()">
								<div class="form-horizontal" role="form">
									<!-- icon_name -->
									<div class="form-group">
										<label class="col-md-2 control-label">이름</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="Name"
												id="ic_name" name="ic_name">
										</div>
									</div>
									<!-- ic_icon -->
									<div class="form-group">
										<label class="col-md-2 control-label">이미지 파일</label> <input
											id="iconName"
											class="file_input_textbox form-control col-md-5 " readonly />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript:var path = document.getElementById('iconName').value = this.value.split('\\').pop().split('/').pop()"
												accept="image/*" name="iconFile" id="icon_filenm" />
										</div>
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
													self.location = "/iconboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
											});

								});
		
					function formCheck() {
						if ($.trim($("#ic_name").val()) == "") {
						alert("이름을 입력하세요");
						$("#ic_name").focus();
						return false;
					}else if ($.trim($("#icon_filenm").val()) == "") {
						alert("사진을 첨부하세요");
						$("#icon_filenm").focus();
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
<!-- /.content-wrapper -->
<%@include file="../include/footer.jsp"%>