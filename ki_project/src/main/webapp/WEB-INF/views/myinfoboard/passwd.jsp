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
							<li><a href="#">기초설정</a></li>
							<li class="active">비밀번호변경</li>
						</ol>
					</div>
					<h4 class="page-title">
						비밀번호 변경 <small>비밀번호를 <code>변경</code> 할 수 있습니다.
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
						<form>
							<div class="col-md-7">
								<div class="form-horizontal" role="form">
									<!-- cur_section_pass -->
									<div class="form-group">
										<label class="col-md-2 control-label">현재 비밀번호</label>
										<div class="col-md-5">
											<input type="password" class="form-control"
												placeholder="현재 비밀번호" id="cur_section_pass"
												name="cur_section_pass">
										</div>
									</div>
									<!-- section_pass -->
									<div class="form-group">
										<label class="col-md-2 control-label">비밀번호</label>
										<div class="col-md-5">
											<input type="password" class="form-control"
												placeholder="현재 비밀번호" id="section_pass" name="section_pass">
										</div>
										<div class="col-md-5">
											<p>비밀번호는 숫자만 가능합니다.</p>
										</div>
									</div>
									<!-- section_pass_ok -->
									<div class="form-group">
										<label class="col-md-2 control-label">비밀번호 확인</label>
										<div class="col-md-5">
											<input type="password" class="form-control"
												placeholder="현재 비밀번호" id="section_pass_ok"
												name="section_pass_ok">
										</div>
									</div>
								</div>
							</div>



						</form>
					</div>
					<div class="form-group" style="text-align: center">
						<button type="submit"
							class="btn btn-primary waves-effect w-md waves-light m-b-5">저장</button>
					</div>

				</div>
			</div>
			<!-- end col -->
			
			<script>
			//cur_section_pass
			</script>

		</div>
		<!-- end row -->
		<%@include file="../include/footer.jsp"%>