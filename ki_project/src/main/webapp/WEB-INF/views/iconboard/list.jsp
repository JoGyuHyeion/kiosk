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
							<li><a href="#">Zircos</a></li>
							<li><a href="#">Kiosk관리</a></li>
							<li class="active">Icon 수정</li>
						</ol>
					</div>
					<h4 class="page-title">Icon 수정</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->
		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">


					<div class="row">
						<c:forEach items="${list}" var="com_iconVO">						
						<input type="hidden" id="ic_no" name="ic_no" value="${com_iconVO.ic_no}">
							<div class="col-md-2">
								<div class="text-center card-box">
									<h4 class="m-b-5">${com_iconVO.ic_name}</h4>
									<div class="text-center">
										<img src="/resources/upload/icon/${com_iconVO.ic_icon}" alt=""
											width="150" height="150">
									</div>
									<p class="text-muted font-13">마지막 수정 날짜 :
										${com_iconVO.ic_ndt}</p>

									<div class="row">
										<button
											class="btn btn-info btn-rounded waves-effect m-t-10 waves-light"
											data-toggle="modal" data-target="#imageModal" data-icNo="${com_iconVO.ic_no}">수정</button>
									</div>

								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- end col -->

	<!-- modal  -->
	<div class="modal fade" id="imageModal" tabindex="-1" role="dialog"
		aria-labelledby="imageModalModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="imageModalLabel">ICON 수정</h4>
				</div>
				<div></div>
				<div class="modal-body">
					<form action="/iconboard/modifyPage" method="post"
						enctype="multipart/form-data">
						<input type="text" id="ic_no" name="ic_no">
							
						<div class="form-group">
							<p class="text-muted font-13 m-b-15 ">Default / Custom 여부</p>
							<div class="radio radio-info radio-inline">
								<input type="radio" id="Custom" value="0" name="ic_default">
								<label for="Custom"> Custom </label>
							</div>
							<div class="radio radio-inline">
								<input type="radio" id="Default" value="1" name="ic_default"
									checked> <label for="Default"> Default </label>
							</div>
						</div>
						<div class="form-group">
							<label for="image" class="control-label">파일 등록</label> <input
								type="file" id="file_upload" class="form-control"
								name="iconFile">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" >수정하기</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>

	<script>
		$(document).ready(
				function() {
					$('#imageModal').on('show.bs.modal', function(event) {
						var button = $(event.relatedTarget);
						var ic_no = button.data('icNo');
						//alert(ic_no);
						var modal = $(this);
						modal.find('.modal-body input').val(ic_no);
					});

					$('#file_upload').attr('disabled', true);

					$("input[type='radio']").change(
							function() {
								var radioValue = $(
										'input[name=ic_default]:checked').attr(
										'id');
								//alert(radioValue);
								if (radioValue == "Custom") {
									$('#file_upload').attr('disabled', false);
								} else if (radioValue == "Default") {
									$('#file_upload').attr('disabled', true);
								}
							});
				});

	</script>

	<!-- /.content -->
</section>
<!-- /.content-wrapper -->
<%@include file="../include/footer.jsp"%>