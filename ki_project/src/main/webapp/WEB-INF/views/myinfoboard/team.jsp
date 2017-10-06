<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="wrapper">


	<div class="container">


		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<!-- Page-Title -->
					<div class="row">
						<div class="col-sm-12">
							<div class="page-title-box">
								<div class="btn-group pull-right">
									<ol class="breadcrumb hide-phone p-0 m-0">
										<li><a href="#">디지털 조직도</a></li>
										<li><a href="#">기초설정</a></li>
										<li class="active">팀관리</li>
									</ol>
								</div>
								<h4 class="page-title">
									팀관리 <small>팀 <code>관리</code> 할 수 있습니다.
									</small>
								</h4>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="card-box">

								<div class="row">
									<div class="table-responsive col-md-8 ">
										<table class="table">
											<thead>
												<tr>
													<td>팀코드</td>
													<td>팀명칭</td>
													<td>팀순위</td>
													<td>사용여부</td>
													<td>삭제</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td><input type="text" class="form-control" size="3"
														value="T00" readonly="readonly"></td>
													<td><input type="text" class="form-control" size="40"
														value="임원"></td>
													<td><input type="text" class="form-control" size="3"
														value="1"></td>
													<td><input type="checkbox"
														style="align-content: center" class="" name="" id=""></td>
													<td><a href="#" class="table-action-btn h2"><i
															class="mdi mdi-close-box-outline text-danger"></i></a></td>
												</tr>
												<tr>
													<td><input type="text" class="form-control" size="3"
														value="T01" readonly="readonly"></td>
													<td><input type="text" class="form-control" size="40"
														value="기업지원팀"></td>
													<td><input type="text" class="form-control" size="3"
														value="2"></td>
													<td><input type="checkbox"
														style="align-content: center" class="" name="" id=""></td>
													<td><a href="#" class="table-action-btn h2"><i
															class="mdi mdi-close-box-outline text-danger"></i></a></td>
												</tr>
												<tr>
													<td><input type="text" class="form-control" size="3"
														value="T00" readonly="readonly"></td>
													<td><input type="text" class="form-control" size="40"
														value="임원"></td>
													<td><input type="text" class="form-control" size="3"
														value="1"></td>
													<td><input type="checkbox"
														style="align-content: center" class="" name="" id=""></td>
													<td><a href="#" class="table-action-btn h2"><i
															class="mdi mdi-close-box-outline text-danger"></i></a></td>
												</tr>
												<tr>
													<td><input type="text" class="form-control" size="3"
														value="T01" readonly="readonly"></td>
													<td><input type="text" class="form-control" size="40"
														value="기업지원팀"></td>
													<td><input type="text" class="form-control" size="3"
														value="2"></td>
													<td><input type="checkbox"
														style="align-content: center" class="" name="" id=""></td>
													<td><a href="#" class="table-action-btn h2"><i
															class="mdi mdi-close-box-outline text-danger"></i></a></td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="4">
														<div class="form-group" style="text-align: center">
															<button type="button" id="btnSave"
																class="btn btn-primary waves-effect w-md waves-light m-b-5">저장</button>
															<a data-toggle="modal"
																class="btn btn-warning waves-effect w-md waves-light m-b-5"
																href="#sectionAdd"><i class="fa fa-plus-circle"></i>
																팀추가</a>
														</div>
													</td>
												</tr>
											</tfoot>
										</table>
									</div>
									<!-- end table responsive -->
								</div>


							</div>
							<!-- end card-box -->



						</div>
						<!-- end col -->


					</div>
					<!-- end row -->


				</div>
				<!-- end card-box -->



			</div>
			<!-- end col -->


		</div>
		<!-- end row -->



		<!-- end row -->
		<%@include file="../include/footer.jsp"%>