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
						직원수정 <small>직원을 <code>등록</code> 할 수 있습니다.
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
						<form role="form" method="post" enctype="multipart/form-data"
							onsubmit="return formCheck()">
							<div class="col-md-7">
								<div class="form-horizontal" role="form">
									<!-- usr_nm -->
									<div class="form-group">
										<label class="col-md-2 control-label">이름</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="Name"
												id="usr_nm" name="usr_nm">
										</div>
									</div>
									<!-- posit_nm -->
									<div class="form-group">
										<label class="col-md-2 control-label">직위</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="직위"
												id="posit_nm" name="posit_nm">
										</div>
									</div>
									<!-- telno -->
									<div class="form-group">
										<label class="col-md-2 control-label">전화번호</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="전화번호"
												id="telno" name="telno">
										</div>
									</div>
									<!-- email_addr -->
									<div class="form-group">
										<label class="col-md-2 control-label">이메일</label>
										<div class="col-md-10">
											<input type="email" class="form-control" placeholder="Email"
												id="email_addr" name="email_addr">
										</div>
									</div>
									<!--st_key -->
									<div class="form-group">
										<label class="col-md-2 control-label">대표업무</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="대표업무"
												id="st_key" name="st_key">
										</div>
									</div>
									<!-- adi_info7 -->
									<div class="form-group">
										<label class="col-md-2 control-label">사무설명</label>
										<div class="col-md-10">
											<textarea class="form-control" rows="2" id="adi_info7"
												name="adi_info7"> ${com_staff2VO.adi_info7}</textarea>
										</div>
									</div>
									<!-- img_filenm -->
									<div class="form-group">
										<label class="col-md-2 control-label">이미지 파일</label> <input
											id="imgName"
											class="file_input_textbox form-control col-md-5 " readonly />
										<div class="file_input_div">
											<input type="button" value="파일"
												class="file_input_button btn btn-primary" /> <input
												type="file" class="file_input_hidden" data-icon='false'
												onchange="javascript: var path = document.getElementById('imgName').value = this.value.split('\\').pop().split('/').pop()"
												accept="image/*" name="imgFile" id="img_filenm" />
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-md-2 control-label">사진</label>
										<div class="col-md-10">
											<input type="file" class="form-control" id="img_filenm"
												name="imgFile"> <small>사진 최소 사이즈는 가로320px
												세로400px입니다.</small>
										</div>
									</div> -->
								</div>
							</div>

							<div class="col-md-5">
								<div class="form-horizontal" role="form">
									<!-- section_cd -->
									<div class="form-group">
										<label class="col-md-2 control-label">근무부서</label>
										<div class="col-md-7">
											<select name="section_cd" id="section_cd"
												class="form-control">
												<c:forEach items="${sectionService}" var="com_sectionVO">
													<option value="${com_sectionVO.section_fullcode}">${com_sectionVO.section_fullpath}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<!-- team_cd -->
									<div class="form-group">
										<label class="col-md-2 control-label">근무팀</label>
										<div class="col-md-7">
											<select name="team_cd" id="team_cd" class="form-control">
												<option value="">::근무팀을 선택하여 주세요!</option>
											</select>
										</div>
									</div>
									<!-- st_display     -->
									<div class="form-group">
										<label class="col-md-2 control-label">직원표시</label>
										<div class="col-md-7">
											<select name="usr_work_state_code_nm"
												id="usr_work_state_code_nm" class="form-control">
												<option value="재직">재직</option>
												<option value="재직(파견)">재직(파견)</option>
												<option value="휴직">휴직</option>
											</select>
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
					<script>
						$(document).ready(function() {
							
							var formObj = $("form[role='form']");
							console.log(formObj);
							
							$("#back").on("click",function() {
								self.location = "/staff2board/list?page=${cri.page}&perPageNum=${cri.perPageNum}";
								});
							
							$("#section_cd").change( function () {
								
								var section_cd = $("#section_cd option:selected").val();
								
								$.getJSON("/staffModify/getTeams/"+section_cd, function(data) {
									
									var str="";
						    		console.log(data.length);
						    		
						    		$(data).each(function(){
						    			str+="<option value='"+this.section_cd+"'>"+this.team_nm+"</option>"
						    			
						    		});
						    		
						    		 $("#team_cd").html(str);
						    	 });
						    	 
						     });
						});

						function formCheck() {
							if ($.trim($("#usr_nm").val()) == "") {
								alert("이름을 입력하세요");
								$("#usr_nm").focus();
								return false;
							} else if ($.trim($("#posit_nm").val()) == "") {
								alert("직위를 입력하세요");
								$("#posit_nm").focus();
								return false;
							} else if ($.trim($("#telno").val()) == "") {
								alert("전화번호를 입력하세요");
								$("#telno").focus();
								return false;
							} else if ($.trim($("#email_addr").val()) == "") {
								alert("이메일을 입력하세요");
								$("#email_addr").focus();
								return false;
							} else if ($.trim($("#st_key").val()) == "") {
								alert("대표 업무를 입력하세요");
								$("#st_key").focus();
								return false;
							} else if ($.trim($("#adi_info7").val()) == "") {
								alert("사무 설명을 입력하세요");
								$("#adi_info7").focus();
								return false;
							} else if ($.trim($("#img_filenm").val()) == "") {
								alert("사진을 첨부하세요");
								$("#img_filenm").focus();
								return false;
							} else if ($.trim($("#section_cd").val()) == "") {
								alert("근무 부서를 선택하세요");
								$("#section_cd").focus();
								return false;
							} else if ($.trim($("#team_cd").val()) == "") {
								alert("근무 팀을 선택하세요");
								$("#team_cd").focus();
								return false;
							} else if(!$(':input:radio[name=st_status]:checked').val()){
								alert("상태를 선택해주세요");
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