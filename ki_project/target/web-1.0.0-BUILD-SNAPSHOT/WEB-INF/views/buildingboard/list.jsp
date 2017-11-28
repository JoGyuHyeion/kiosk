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
							<li><a href="#">디지털조직도</a></li>
							<li><a href="#">건물정보</a></li>
							<li class="active">층수사진</li>
						</ol>
					</div>
					<h4 class="page-title">층수사진</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="col-lg -12">
			<div class="card-box">

				<div class="row">

					<div class="col-sm-8 col-centered">
						<form role="form">

							<label class=" col-md-2 control-label" for="search_bcd">건물
								선택</label> <select id="search_bcd" name="search_bcd"
								class="form-control">
								<option value="none">본관</option>
								<option value="none">동관</option>
								<option value="none">서관</option>
							</select>
						</form>
					</div>
				</div>
				<div class="row">
					<div class="text-center">
						<div class="text-align">
							<div class="col-lg-8 col-centered">
								<h3 class="header-title m-t-0 m-b-30">본관 정보</h3>
								<!-- START carousel-->
								<div id="carousel-example-captions" data-ride="carousel"
									class="carousel slide">
									<ol class="carousel-indicators">
										<c:forEach items="${list}" var="com_buildingVO">
											<c:choose>
												<c:when test="${com_buildingVO.bu_no==1}">
													<li data-target="#carousel-example-captions"
														data-slide-to="${com_buildingVO.bu_name}" class="active"></li>
												</c:when>
												<c:otherwise>
													<li data-target="#carousel-example-captions"
														data-slide-to="${com_buildingVO.bu_name}"></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</ol>
									<div role="listbox" class="carousel-inner">
										<c:forEach items="${list}" var="com_buildingVO">
											<c:choose>
												<c:when test="${com_buildingVO.bu_no==1}">
													<div class="item active text-center">
														<img
															src="${pageContext.request.contextPath}/resources/upload/${com_buildingVO.bu_img}"
															alt="default slide image"
															onerror="this.src='/resources/assets/images/properties/1.jpg'">
														<div class="carousel-caption">
															<h3 class="text-white font-600">${com_buildingVO.bu_name}</h3>
														</div>
													</div>
												</c:when>
												<c:otherwise>
													<div class="item">
														<img
															src="${pageContext.request.contextPath}/resources/upload/${com_buildingVO.bu_img}"
															alt="default slide image"
															onerror="this.src='/resources/assets/images/properties/1.jpg'">
														<div class="carousel-caption">
															<h3 class="text-white font-600">${com_buildingVO.bu_name}</h3>
														</div>
													</div>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<a href="#carousel-example-captions" role="button"
											data-slide="prev" class="left carousel-control"> <span
											aria-hidden="true" class="fa fa-angle-left"></span> <span
											class="sr-only">Previous</span>
										</a> <a href="#carousel-example-captions" role="button"
											data-slide="next" class="right carousel-control"> <span
											aria-hidden="true" class="fa fa-angle-right"></span> <span
											class="sr-only">Next</span>
										</a>
									</div>
									<!-- END carousel-->
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-lg-8 col-centered">
								<div class="card-box">
									<h4 class="header-title m-t-0 m-b-30">건물 정보</h4>

									<div class="tabs-vertical-env">
										<ul class="nav tabs-vertical">
											<c:forEach items="${list}" var="com_buildingVO">
												<c:choose>
													<c:when test="${com_buildingVO.bu_no==1}">
														<li class="active"><a
															href="#bu_no${com_buildingVO.bu_no}" data-toggle="tab"
															aria-expanded="false">${com_buildingVO.bu_name}</a></li>
													</c:when>
													<c:otherwise>
														<li class=""><a href="#bu_no${com_buildingVO.bu_no}"
															data-toggle="tab" aria-expanded="false">${com_buildingVO.bu_name}</a>
														</li>
													</c:otherwise>
												</c:choose>

											</c:forEach>
										</ul>

										<div class="tab-content">
											<c:forEach items="${list}" var="com_buildingVO">
												<c:choose>
													<c:when test="${com_buildingVO.bu_no==1}">
														<div class="tab-pane active"
															id="bu_no${com_buildingVO.bu_no}">
															<img width="700" height="400"
																src="${pageContext.request.contextPath}/resources/upload/${com_buildingVO.bu_img}"
																alt="default slide image"
																onerror="this.src='/resources/assets/images/properties/1.jpg'">
															<div class="form-group" style="text-align: center">
																<input type="hidden"
																	id="img_file_name${com_buildingVO.bu_no}"
																	value="${com_buildingVO.bu_img}">
																<button
																	class="btn btn-info btn-rounded waves-effect m-t-10 waves-light change_btn"
																	data-toggle="modal" data-target="#buildingModal"
																	value="${com_buildingVO.bu_no}">수정</button>
																<label class="col-md-5 control-label">마지막 수정 날짜:
																	${com_buildingVO.bu_ndt}</label>
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="tab-pane" id="bu_no${com_buildingVO.bu_no}">
															<img width="700" height="400"
																src="${pageContext.request.contextPath}/resources/upload/${com_buildingVO.bu_img}"
																alt="default slide image"
																onerror="this.src='/resources/assets/images/properties/1.jpg'">
															<div class="form-group" style="text-align: center">
																<input type="hidden"
																	id="img_file_name${com_buildingVO.bu_no}"
																	value="${com_buildingVO.bu_img}">
																<button
																	class="btn btn-info btn-rounded waves-effect m-t-10 waves-light change_btn"
																	data-toggle="modal" data-target="#buildingModal"
																	value="${com_buildingVO.bu_no}">수정</button>
																<label class="col-md-5 control-label">마지막 수정 날짜:
																	${com_buildingVO.bu_ndt}</label>
															</div>
														</div>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
							<!-- end col -->
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- modal  -->
		<div class="modal fade" id="buildingModal" tabindex="-1" role="dialog"
			aria-labelledby="imageModalModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="imageModalLabel">Building 수정</h4>
					</div>
					<div></div>
					<div class="modal-body">
						<form action="/buildingboard/modifyPage" method="post"
							enctype="multipart/form-data">
							<input type="hidden" id="bu_no" name="bu_no">
							<div class="form-group">
								<label class="col-md-2 control-label">파일 등록</label> <input
									id="imgName" name="imgName"
									class="file_input_textbox form-control col-md-5 "
									readonly="readonly" />
								<div class="file_input_div">
									<input type="button" value="파일 선택" id="file_upload_btn"
										class="file_input_button btn btn-primary" /> <input
										type="file" class="file_input_hidden" data-icon='false'
										onchange="javascript:var path = document.getElementById('imgName').value = this.value.split('\\').pop().split('/').pop()"
										accept="image/*" name="imgFile" id="img_file" />
								</div>
								<input type="hidden" name="bu_img" id="bu_img">
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
			$(document).ready(function() {
				/* $('#buildingModal').on('show.bs.modal', function(event) {
					var button = $(event.relatedTarget);
					var ic_no = button.data('icNo');
					//alert(ic_no);
					var modal = $(this);
					modal.find('.modal-body input').val(ic_no);
				}); */
				$('.change_btn').click(function() {
					var bu_no = $(this).val();
					var bu_img = $("#img_file_name"+bu_no.toString()).val();
					$('#buildingModal').find('#bu_no').val(bu_no);
					$('#buildingModal').find('#bu_img').val(bu_img);
					$('#buildingModal .modal-body').find('#imgName').val(bu_img);
					 
				});

			});
		</script>
	</div>
</section>
<%@include file="../include/footer.jsp"%>