<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content-wrapper">


	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<h2>직원등록</h2>
		</ol>
		<!-- Example DataTables Card-->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-table"></i>등록
			</div>
			<div class="card-body">
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">

					<input type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">


					<!-- 이름  -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-4">
								<label for="name">이름</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_nm}">
							</div>
						</div>
					</div>
					<!-- 직위 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-5">
								<label for="name">직위</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_job}">
							</div>
						</div>
					</div>
					<!-- 전화번호 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-4">
								<label for="name">전화번호</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_tel}">
							</div>
						</div>
					</div>
					<!-- 이메일 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-4">
								<label for="name">이메일</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_email}">
							</div>
						</div>
					</div>
					<!-- 대표업무 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-6">
								<label for="name">대표업무</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_job}">
							</div>
						</div>
					</div>
					<!-- 사무설명 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-10">
								<label for="name">사무설명</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_profile}">
							</div>
						</div>
					</div>
					<!-- 이미지파일 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-4">
								<label for="name">이미지파일</label> <input type="file"
									class="form-control" name="" id="name"> <small>사진
									최소 사이즈는 가로320px 세로400px입니다.</small>
							</div>

						</div>
					</div>
					<!-- 근무부서 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-4">
								<label for="name">근무부서</label> <select name="" id=""
									class="form-control">
									<option value="">siba</option>
								</select>
							</div>
						</div>
					</div>
					<!-- 근무팀 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-4">
								<label for="name">근무팀</label> <select name="" id=""
									class="form-control">
									<option value="">sibaTeam</option>
								</select>
							</div>
						</div>
					</div>
					<!-- 팀순위 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-2">
								<label for="name">팀순위</label> <input type="text"
									class="form-control" name="" id="name"
									value="${com_staffVO.st_sort}">
							</div>
						</div>
					</div>

					<!-- 직원표시 -->
					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-2">
								<label for="name">직원표시</label> <input type="checkbox"
									class="form-control-inline" value="${com_staffVO.st_display}">노출</input>
							</div>
						</div>
					</div>
					<!-- 상태 -->

					<div class="form-group ">
						<div class="form-row">
							<div class="col-md-8">
								<label for="name">상태</label> <input type="radio"
									class="form-control-inline" name="status" value="1">근무중</input>
								<input type="radio" class="form-control-inline" name="status"
									value="2">휴가
								</inpuzt>
								<input type="radio" class="form-control-inline" name="status"
									value="3">출장</input> <input type="radio"
									class="form-control-inline" name="status" value="4">교육</input>


							</div>
						</div>
					</div>

				</form>

			</div>

			<div class="form-group">
				<div class="form-row">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>
			</div>


			<div class="card-footer small text-muted">직원등록</div>
		</div>


		<script>
			$(document)
					.ready(
							function() {

								var formObj = $("form[role='form']");
								console.log(formObj);
								$(".btn-warning")
										.on(
												"click",
												function() {
													self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
															+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
												});

								$(".btn-primary").on("click", function() {
									formObj.submit();
								});
							});
		</script>




	</div>
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>