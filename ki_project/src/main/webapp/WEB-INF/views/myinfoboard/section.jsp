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
					<div class="row">
						<div class="col-sm-8">
							<form role="form">

								<label class=" col-md-2 control-label" for="search_bcd">국코드</label>
								<select id="search_bcd" name="search_bcd" class="form-control">
									<option value="none">::해당 국을 선택하세요!</option>
									<option value="K010" selected="selected">경제산업국</option>
									<option value="K020">도시개발국</option>
									<option value="K030">문화관광실</option>
									<option value="K040">시민행정국</option>
									<option value="K050">특별기관</option>
									<option value="K060">농업기술센터</option>
									<option value="K070">의회</option>
									<option value="K999">부서이동</option>
								</select>
							</form>
						</div>

					</div>
					<div class="row">
						<div class="table-responsive col-md-8 ">
							<table class="table">
								<thead>
									<tr>
										<td>과코드</td>
										<td>과명칭</td>
										<td>사용여부</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" class="form-control" size="6"
											value="S010" readonly="readonly"></td>
										<td><input type="text" class="form-control" size="40"
											value="기업지원과"></td>
										<td><input type="checkbox" style="align-content: center"
											class="" name="" id=""></td>
										<td><a href="#" class="table-action-btn h2"><i
												class="mdi mdi-close-box-outline text-danger"></i></a></td>
									</tr>
									<tr>
										<td><input type="text" class="form-control" size="6"
											value="S010" readonly="readonly"></td>
										<td><input type="text" class="form-control" size="40"
											value="기업지원과"></td>
										<td><input type="checkbox" style="align-content: center"
											class="" name="" id=""></td>
										<td><a href="#" class="table-action-btn h2"><i
												class="mdi mdi-close-box-outline text-danger"></i></a></td>
									</tr>
									<tr>
										<td><input type="text" class="form-control" size="6"
											value="S010" readonly="readonly"></td>
										<td><input type="text" class="form-control" size="40"
											value="기업지원과"></td>
										<td><input type="checkbox" style="align-content: center"
											class="" name="" id=""></td>
										<td><a href="#" class="table-action-btn h2"><i
												class="mdi mdi-close-box-outline text-danger"></i></a></td>
									</tr>
									<tr>
										<td><input type="text" class="form-control" size="6"
											value="S010" readonly="readonly"></td>
										<td><input type="text" class="form-control" size="40"
											value="기업지원과"></td>
										<td><input type="checkbox" style="align-content: center"
											class="" name="" id=""></td>
										<td><a href="#" class="table-action-btn h2"><i
												class="mdi mdi-close-box-outline text-danger"></i></a></td>
									</tr>
									<tr>
										<td><input type="text" class="form-control" size="6"
											value="S010" readonly="readonly"></td>
										<td><input type="text" class="form-control" size="40"
											value="기업지원과"></td>
										<td><input type="checkbox" style="align-content: center"
											class="" name="" id=""></td>
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
													과추가</a>
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



		<!-- end row -->
		<%@include file="../include/footer.jsp"%>