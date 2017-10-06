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
						<form action="modifypage" method="post">
							<input type='hidden' name='page' value="${cri.page}"> <input
								type='hidden' name='perPageNum' value="${cri.perPageNum}">
							<input type='hidden' name='searchType' value="${cri.searchType}">
							<input type='hidden' name='keyword' value="${cri.keyword}">

							<div class="col-md-7">
								<div class="form-horizontal" role="form">
									<!-- st_nm -->
									<div class="form-group">
										<label class="col-md-2 control-label">이름</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="Name"
												id="st_nm" name="st_nm" value="${com_staffVO.st_nm}">
										</div>
									</div>
									<!-- st_position -->
									<div class="form-group">
										<label class="col-md-2 control-label">직위</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="직위"
												id="st_position" name="st_position"
												value="${com_staffVO.st_position}">
										</div>
									</div>
									<!-- st_tel -->
									<div class="form-group">
										<label class="col-md-2 control-label">전화번호</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="전화번호"
												id="st_tel" name="st_tel" value="${com_staffVO.st_tel}">
										</div>
									</div>
									<!-- st_email -->
									<div class="form-group">
										<label class="col-md-2 control-label">이메일</label>
										<div class="col-md-10">
											<input type="email" class="form-control" placeholder="Email"
												id="st_email" name="st_email"
												value="${com_staffVO.st_email}">
										</div>
									</div>
									<!-- st_job -->
									<div class="form-group">
										<label class="col-md-2 control-label">대표업무</label>
										<div class="col-md-10">
											<input type="email" class="form-control" placeholder="대표업무"
												id="st_job" name="st_job" value="${com_staffVO.st_job}">
										</div>
									</div>
									<!-- st_profile -->
									<div class="form-group">
										<label class="col-md-2 control-label">사무설명</label>
										<div class="col-md-10">
											<textarea class="form-control" rows="2" id="st_profile"
												name="st_profile"> ${com_staffVO.st_profile}</textarea>
										</div>
									</div>
									<!-- st_filenm -->
									<div class="form-group">
										<label class="col-md-2 control-label">사진</label>
										<div class="col-md-10">
											<input type="file" class="form-control" id="st_filenm"
												name="st_filenm"> <small>사진 최소 사이즈는 가로320px
												세로400px입니다.</small>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-5">
								<div class="form-horizontal" role="form">
									<!-- section_cd -->
									<div class="form-group">
										<label class="col-md-2 control-label">근무부서</label>
										<div class="col-md-7">
											<select name="section_cd" id="section_cd"
												class="form-control" value="${com_staffVO.section_cd}">
												<option value="">전체관리자</option>
											</select>
										</div>
									</div>
									<!-- team_cd -->
									<div class="form-group">
										<label class="col-md-2 control-label">근무팀</label>
										<div class="col-md-7">
											<select name="team_cd" id="team_cd" class="form-control"
												value="${com_staffVO.team_cd}">
												<option value="">::근무팀을 선택하여 주세요!</option>
											</select>
										</div>
									</div>
									<!-- st_display     -->
									<div class="form-group">
										<label class="col-md-2 control-label">직원표시</label>
										<!-- checkbox checked 일경우 활성화 -->
										<div style="padding: 5px">
											<input type="checkbox" name="st_display" id="st_display" value="1"
												switch="none" /> <label for="st_display" data-on-label="On"
												data-off-label="Off"></label>
										</div>
									</div>
									<!-- st_status     -->
									<div class="form-group">
										<label class="col-md-2 control-label">상태</label>
										<div class="col-md-7">

											<div class="radio radio-success">
												<input type="radio" name="st_status" id="st_status1"
													value="1"> <label for="st_status1"> 근무중 </label>
											</div>
											<div class="radio">
												<input type="radio" name="st_status" id="st_status2"
													value="2"> <label for="st_status2"> 휴가 </label>
											</div>
											<div class="radio radio-warning">
												<input type="radio" name="st_status" id="st_status3"
													value="3"> <label for="st_status3"> 출장 </label>
											</div>
											<div class="radio radio-info">
												<input type="radio" name="st_status" id="st_status4"
													value="4"> <label for="st_status4"> 교육 </label>
											</div>

										</div>
										<!-- end col -->
									</div>

									<!--display, status javascript 코드 view 표시  -->
									<script>
										var display = '<c:out value="${com_staffVO.st_display}"/>';
										var status = '<c:out value="${com_staffVO.st_status}"/>';
										alert("Display, Status 확인 \n"
												+ "표시여부: " + display
												+ "\n근무 상태: " + status);
										if (display == 1) {
											document
													.getElementById('st_display').checked = true;
										} else {
										}

										if (status == 1) {
											document
													.getElementById('st_status1').checked = true;
										} else if (status == 2) {
											document
													.getElementById('st_status2').checked = true;
										} else if (status == 3) {
											document
													.getElementById('st_status3').checked = true;
										} else if (status == 4) {
											document
													.getElementById('st_status4').checked = true;
										}
									</script>

								</div>
							</div>
						</form>
					</div>
					<div class="form-group" style="text-align: center">
						<button type="submit"
							class="btn btn-primary waves-effect w-md waves-light m-b-5"
							id="change">수정</button>
						<button type="submit"
							class="btn btn-warning waves-effect w-md waves-light m-b-5"
							id="back">돌아가기</button>
					</div>

				</div>
			</div>
			<!-- end col -->

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
														self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
																+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
													});

									$("#back").on("click", function() {
										formObj.submit();
									});
								});
			</script>
		</div>
		<%@include file="../include/footer.jsp"%>