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

												<c:forEach items="${list}" var="com_teamVO">

													<tr>
														<td><input type="text" class="form-control"
															id="team_cd" name="team_cd" size="3"
															value="${com_teamVO.team_cd}" readonly="readonly"></td>
														<td><input type="text" class="form-control"
															id="team_nm" name="team_nm" size="40"
															value="${com_teamVO.team_nm}"></td>
														<td><input type="text" class="form-control"
															id="team_sort" name="team_sort" size="3"
															value="${com_teamVO.team_sort}"></td>
														<c:set var="team_use" value="${com_teamVO.team_use}" />
														<td><div style="padding: 5px">
																<input type="checkbox" name="team_use" switch="none"
																	id="team_use" value="${com_teamVO.team_use}" 
																	<c:if test = "${com_teamVO.team_use eq '1'}">checked</c:if>
																	/><label
																	for="team_use" data-on-label="On" data-off-label="Off"></label>
															</div></td>
														<td><a href="#" class="table-action-btn h2"><i
																class="mdi mdi-close-box-outline text-danger"></i></a></td>
													</tr>

												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="4">
														<div class="form-group" style="text-align: center">
															<button type="button" id="btnSave"
																class="btn btn-primary waves-effect w-md waves-light m-b-5">저장</button>
															<button data-toggle="modal" data-target="#teamModal"
																class="btn btn-warning waves-effect w-md waves-light m-b-5"
																href="#teamAdd">
																<i class="fa fa-plus-circle"></i> 팀추가
															</button>
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
		<!-- modal  -->
		<div class="modal fade" id="teamModal" tabindex="-1" role="dialog"
			aria-labelledby="temaModalModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="imageModalLabel">팀정보</h4>
					</div>
					<div></div>
					<div class="modal-body">
						<form class="form-horizontal" action="modifypage" method="post">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="team_cd">팀코드</label>
								<div class="col-sm-10">
									<input type="text" id="team_cd" name="team_cd" value=""
										maxlength="3" placeholder="팀코드 ex) T08" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="team_nm">팀명</label>
								<div class="col-sm-10">
									<input type="text" id="team_nm" name="team_nm" value=""
										maxlength="30" placeholder="팀명(30자 이내)" class="form-control">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" id="btnAdd">과추가</button>
					</div>
				</div>
			</div>
		</div>
		<script>
			$(document).ready(function() {
				$('#teamAdd').on('show.bs.modal', function(event) {
					$("#section_name").val("");

					$("#section_name").focus();

					var button = $(event.relatedTarget)
					var recipient = button.data('whatever')
					var modal = $(this)
					modal.find('.modal-body input').val(recipient)

				});
				$("#btnAdd").click(function() {
					var team_cd = "";
					var team_nm = "";

					team_cd = $("#team_cd").val();
					team_nm = $("#team_nm").val();

					if (team_cd.length == 0)
						return false;
					if (team_nm.length == 0)
						return false;

					$.ajax({
						url : '/team/insert',
						type : 'post',
						data : {
							"team_cd" : team_cd,
							"team_nm" : team_nm
						},
						success : function(data) {
							location.reload();
						}
					});

				});

				$(".team-del").click(function() {
					var team_cd = $(this).data("teamcd");
					$.ajax({
						url : '/team/del',
						type : 'post',
						dataType : 'json',
						data : {
							"team_cd" : team_cd
						},
						success : function(data) {
							if (data.row == 1) {
								location.reload();
							} else if (data.row == 0) {
								alert(data.msg);
							}
						}
					});
				});

			});
		</script>
		<!-- end row -->
		<%@include file="../include/footer.jsp"%>