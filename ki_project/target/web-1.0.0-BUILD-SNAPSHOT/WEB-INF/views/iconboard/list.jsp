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
							<div class="col-md-2">
								<div class="text-center card-box ableColor">
									<h4 class="m-b-5">${com_iconVO.ic_name}</h4>
									<div class="text-center">
										<img src="${uploadPath}${com_iconVO.ic_icon}" alt="" width="150" height="150">
									</div>
									<p class="text-muted font-13">마지막 수정 날짜 :
										${com_iconVO.ic_ndt}</p>

									<div class="row">
										<input type="hidden" id="img_file_name${com_iconVO.ic_no}" value="${com_iconVO.ic_icon}"> 
										<input type="hidden" id="ic_default${com_iconVO.ic_no}" value="${com_iconVO.ic_default}">
										<input type="hidden" class="ableValue" id="ic_able${com_iconVO.ic_no}" value="${com_iconVO.ic_able}">
										<button
											class="btn btn-info btn-rounded waves-effect m-t-10 waves-light change_btn"
											data-toggle="modal" data-target="#imageModal"
											value="${com_iconVO.ic_no}">수정</button>
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
						<input type="hidden" id="ic_no" name="ic_no">

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
							<p class="text-muted font-13 m-b-15 ">활성 / 비활성 여부</p>
							<div class="radio radio-info radio-inline">
								<input type="radio" id="Able" value="1" name="ic_able">
								<label for="Able"> 활성 </label>
							</div>
							<div class="radio radio-inline">
								<input type="radio" id="Disable" value="0" name="ic_able"
									checked> <label for="Disable"> 비활성 </label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">파일 등록</label> <input
								id="iconName" name="iconName"
								class="file_input_textbox form-control col-md-5 "
								readonly="readonly" />
							<div class="file_input_div">
								<input type="button" value="파일 선택" id="file_upload_btn"
									class="file_input_button btn btn-primary" /> <input
									type="file" class="file_input_hidden" data-icon='false'
									onchange="javascript:var path = document.getElementById('iconName').value = this.value.split('\\').pop().split('/').pop()"
									accept="image/*" name="iconFile" id="img_filenm" />
							</div>
							<input type="hidden" name="ic_icon" id="ic_icon">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">수정하기</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>

	<script>
	
	 for(var i=0; i<$(".ableValue").length; i++){
			
		 if( $(".ableValue").eq(i).val() ==0){
			 $(".ableColor").eq(i).css("background-color", "Crimson  ");
			
		 }
	 } 
		$(document).ready(
				
				
				function() {
					/* $('#imageModal').on('show.bs.modal', function(event) {
						var button = $(event.relatedTarget);
						var ic_no = button.data('icNo');
						//alert(ic_no);
						var modal = $(this);
						modal.find('.modal-body input').val(ic_no);
					});
					 */
					$('.change_btn').click(function() {
						var ic_no = $(this).val();
						var ic_icon=$("#img_file_name"+ic_no.toString()).val();
						var ic_default = $("#ic_default"+ic_no.toString()).val();
						var ic_able = $("#ic_able"+ic_no.toString()).val();
					
						$('#imageModal').find('#ic_no').val(ic_no);			
						$('#imageModal').find('#ic_icon').val(ic_icon);
						$('#imageModal .modal-body').find('#iconName').val(ic_icon);
						$('input:radio[name="ic_default"]:input[value='+ic_default+']').prop("checked", true);
						$('input:radio[name="ic_able"]:input[value='+ic_able+']').prop("checked", true);

						if(ic_default==1){
							$('#file_upload_btn').attr('disabled', true);
							$('#img_filenm').attr('style', 'display:none');
						}
					});

					
					$("input[type='radio']").click(
							function() {
								var radioValue = $('input[name=ic_default]:checked').attr('id');
								//alert(radioValue);
								if (radioValue == "Custom") {
									$('#file_upload_btn').attr('disabled', false);
									$('#img_filenm').attr('style', 'display:');
								} else if (radioValue == "Default") {
									$('#file_upload_btn').attr('disabled', true);
									$('#img_filenm').attr('style', 'display:none');
								}
							});
				});
	</script>

	<!-- /.content -->
</section>
<!-- /.content-wrapper -->
<%@include file="../include/footer.jsp"%>