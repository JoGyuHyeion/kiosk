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
							<li><a href="#">계정관리</a></li>
							<li class="active">계정조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						계정조회 <small>계정을 조회 할 수 있습니다.</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<div class="row">

						<div class="col-sm-4">
							<form role="form">
								<div class="form-group">
									<input type="text" id="search-input" class="form-control"
										name="keyword" placeholder="Please Name"> <input
										type='hidden' name='page' value="${cri.page}"> <input
										type='hidden' name='perPageNum' value="${cri.perPageNum}">
									<input type='hidden' name='section_cd'
										value="${cri.section_cd}">

								</div>
							</form>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-danger" id="searchBtn">
								<i class="fa fa-search"> 찾기</i>
							</button>
						</div>
						<a href="/userboard/register" class="btn btn-primary ">작성</a>
					</div>

					<div class="table-responsive">
						<table class="table table-hover mails m-0 table table-actions-bar">
							<thead>
								<tr>
									<th>편집</th>
									<th>id</th>
									<th>password</th>
									<th>name</th>
									<th>auth</th>
									<th>section_fullcode</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="userVO">
							
									<tr class="">
										<td>
											<a href="/userboard/modifyPage${pageMaker.makeSearch(param.page)}&modifyId=${userVO.id}" class="btn btn-default">
												<i class="glyphicon glyphicon-glass glyphicon-edit"></i>
											</a>
										</td>
										
										<td>${userVO.id}</td>
										
										<td>${userVO.password}</td>

										<td>${userVO.name}</td>

										<td>${userVO.auth}</td>

										<td>${userVO.section_fullcode}</td>

										<td><form action="/userboard/removePage" method="post">
												<input type="hidden" name="id"
													value="${userVO.id}">
												<button type="submit" class="btn btn-default">
													<i class="glyphicon glyphicon-glass glyphicon-trash"></i>
												</button>
											</form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- end table responsive -->
				</div>
				<!-- end card-box -->

				<div class="text-right">
					<ul class="pagination pagination-split m-t-0">

						<c:if test="${pageMaker.prev}">
							<li><a
								href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a
								href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
						</c:if>

					</ul>
				</div>

			</div>
			<!-- end col -->


		</div>
		<!-- end row -->

		<script>
			var result = '${msg}';

			if (result == 'SUCCESS') {
				alert("처리가 완료되었습니다.");
			}
		</script>

		<script>
			$(document).ready(function() {
				$('#searchBtn').on("click",function(event) {
					self.location = "list"
					+ '${pageMaker.makeQuery(1)}'
					+ "&section_cd="
					+ $("select option:selected").val()
					+ "&keyword="
					+ $('#search-input').val();
					
				});
				
				$("#section_cd").change(function() {
					var section_cd = $("#section_cd option:selected").val();
					var url = "/userboard/list?section_cd="+ section_cd;
					location.href = url;
				});

				var value = "${param.section_cd}";
						
				$("#section_cd > option[value=" + value + "]").attr("selected", true);
			});
		</script>
	</div>
</section>


<%@include file="../include/footer.jsp"%>