<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<li><a href="#">공지관리</a></li>
							<li class="active">공지조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						공지수정 <small>공지사항을 <code>수정</code> 할 수 있습니다.
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
									<!-- bbs_title -->
									<div class="form-group">
										<label class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="제목"
												id="bbs_title" name="bbs_title"
												value="${com_boardVO.bbs_title}">
										</div>
									</div>
									<!-- bbs_content -->
									<div class="form-group">
										<label class="col-md-2 control-label">내용</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="내용"
												id="bbs_content" name="bbs_content"
												value="${com_boardVO.bbs_content}">
										</div>
									</div>
									<!-- bbs_file -->
									<div class="form-group">
										<label class="col-md-2 control-label">첨부이미지</label>
										<div class="col-md-10">
											<input type="file" class="form-control" id="st_filenm"
												name="st_filenm">
										</div>
									</div>
									<!-- bbs_exp_sdt -->
									<!-- bbs_exp_edt -->

									<!-- bbs_state -->

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
													self.location = "/noticeboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
															+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
												});

								$("#back").on("click", function() {
									formObj.submit();
								});
							});
		</script>
	</div>
</section>
<%@include file="../include/footer.jsp"%>