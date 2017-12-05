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
						공지수정 <small>공지를 <code>수정</code> 할 수 있습니다.
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
									<!-- bbs_title -->
									<div class="form-group">
										<label for="bbs_title" class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control"
												placeholder="Enter Title" id="bbs_title" name="bbs_title"
												value="${com_boardVO.bbs_title}">
										</div>
									</div>
									<!-- bbs_content -->
									<div class="form-group">
										<label for="bbs_content" class="col-md-2 control-label">내용</label>
										<div class="col-md-10">
											<textarea class="form-control" rows="10"
												placeholder="Enter ..." id="bbs_content" name="bbs_content">${com_boardVO.bbs_content}</textarea>
										</div>
									</div>
									<!-- bbs_file -->
									<div class="form-group">
										<label class="col-md-2 control-label">이미지 파일</label> <input
											id="imgName" name="imgName"
											class="file_input_textbox form-control col-md-5 "
											readonly="readonly" value="${com_boardVO.bbs_file}" />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript:var path = document.getElementById('imgName').value = this.value.split('\\').pop().split('/').pop()"
												accept="image/*" name="imgFile" id="img_file" />
										</div>
										<input type="hidden" name="bbs_file" id="bbs_file"
											value="${com_boardVO.bbs_file}">
									</div>
									<!-- <div class="form-group">
										<label for="bbs_file" class="col-md-2 control-label">첨부
											파일</label>
										<div class="col-md-10">
											<input type="file" class="form-control" id="bbs_file"
												name="bbs_file">
										</div>
									</div> -->
									<!-- brd_cd -->
									<div class="form-group">
										<label class="col-md-2 control-label">공지/이벤트</label>
										<div class="radio radio-info radio-inline">
											<input type="radio" id="notice" value="notice" name="brd_cd">
											<label for="notice">공지</label>
										</div>
										<div class="radio radio-inline radio-warning">
											<input type="radio" id="event" value="event" name="brd_cd">
											<label for="event">이벤트</label>
										</div>
									</div>
									<!-- bbs_exp_sdt, bbs_exp_edt -->
									<div class="form-group">
										<label class="col-md-2 control-label">공지기간</label>
										<div class="col-md-8 input-group">
											<input type="date" class="form-control" id="bbs_exp_sdt"
												name="bbs_exp_sdt" value="${com_boardVO.bbs_exp_sdt}">
											<span class="input-group-addon"> ~ </span> <input type="date"
												class="form-control" id="bbs_exp_edt" name="bbs_exp_edt"
												value="${com_boardVO.bbs_exp_edt}">

										</div>
									</div>
									<!-- bbs_state     -->
									<%-- <c:set value="${com_boardVO.bbs_state}" var="bbs_state" />
									 --%>
									<div class="form-group">
										<label for="bbs_state" class="col-md-2 control-label">표시여부</label>
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
											id="change">수정</button>
										<button type="button"
											class="btn btn-warning waves-effect w-md waves-light m-b-5"
											id="back">돌아가기</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- end col -->
		</div>

		<!-- end row -->

		<script>
			
			

			$(document)
					.ready(
							function() {
								var formObj = $("form[role='form']");
								/* var bbs_state ="<c:out value="${bbs_state}"/>";
								if(bbs_state == 1){
									 $("#bbs_state").attr('checked',true);			
								}else{
									 $("#bbs_state").attr('checked',false);	
								} */
								
								
								console.log(formObj);
								$("#back")
										.on(
												"click",
												function() {
													self.location = "/noticeboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
												});
								
							/* alert("${com_boardVO.bbs_state}"); */
							var bbs_state = ${com_boardVO.bbs_state};
							if(bbs_state==1){
								$('input:checkbox[id="bbs_state"]').attr("checked",true);
							}
							var brd_cd = "${com_boardVO.brd_cd}";
							$('input:radio[name="brd_cd"]:input[value='+brd_cd+']').prop("checked", true);

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
	<!-- end container -->
</section>
<!-- end wrapper -->
<%@include file="../include/footer.jsp"%>