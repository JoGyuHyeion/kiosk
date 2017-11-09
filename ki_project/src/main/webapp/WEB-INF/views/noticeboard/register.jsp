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
						<form method="post" role="form">
							<input type='hidden' name='brd_cd' value="notice">
							<div class="col-md-7">
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
										<label class="col-md-2 control-label">첨부이미지</label>
										<div class="col-md-10">
											<input type="file" class="form-control" id="bbs_file"
												name="bbs_file">
										</div>
									</div>
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
								</div>
								<div class="form-group" style="text-align: center">
									<button type="submit"
										class="btn btn-primary waves-effect w-md waves-light m-b-5"
										id="change">등록</button>
									<button type="button"
										class="btn btn-warning waves-effect w-md waves-light m-b-5"
										id="back" onclick="history.go(-1)">돌아가기</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- end col -->
		</div>
	</div>
	<!-- /.content -->
</section>
<!-- /.content-wrapper -->
<%@include file="../include/footer.jsp"%>