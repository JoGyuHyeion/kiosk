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
							<li><a href="#">직원관리</a></li>
							<li class="active">직원조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						직원조회 <small>직원을 조회 할 수 있습니다.</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<div class="row">
					
					<c:if test="${0 eq userVO.auth}">
						<div class="col-sm-3">
							<select name="section_cd" id="section_cd" class="form-control">
								<c:forEach items="${sectionService}" var="com_sectionVO">
									<option value="${com_sectionVO.section_fullcode}">${com_sectionVO.section_fullpath}</option>
								</c:forEach>
							</select>
						</div>
					</c:if>
					
						<div class="col-sm-4">
							<form role="form">
								<div class="form-group">
									<input type="text" id="search-input" class="form-control" name="keyword" placeholder="Please Name">
									<input type='hidden' name='page' value="${cri.page}"> 
									<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
									<input type='hidden' name='section_cd' value="${cri.section_cd}"> 	

								</div>
							</form>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-danger" id="searchBtn">
								<i class="fa fa-search"> 찾기</i>
							</button>
						</div>
						<a href="/staff2board/register" class="btn btn-primary ">작성</a>
					</div>

					<div class="table-responsive">
						<table class="table table-hover mails m-0 table table-actions-bar">
							<thead>
								<tr>
									<th>편집</th>
									<th>사진</th>
									<th>부서</th>
									<th>팀</th>
									<th>직위</th>
									<th>이름</th>
									<th>전화번호</th>
									<th>Update</th>
									<th>삭제</th>

								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="com_staff2VO">
									<%-- 						
									<tr class="active">
										<td><a
											href="/staff2board/modifyPage${pageMaker.makeSearch(param.page)}&st_no=${com_staff2VO.st_no}"
											class="table-action-btn h2"><i
												class="mdi mdi-pencil-box-outline text-success"></i></a></td>
 									--%>
									<tr class="">
										<td><a
											href="/staff2board/modifyPage${pageMaker.makeSearch(param.page)}&st_no=${com_staff2VO.st_no}"
											class="btn btn-default"><i
												class="glyphicon glyphicon-glass glyphicon-edit"></i></a></td>
										<td><img
											src="/resources/assets/images/users/avatar-2.jpg"
											alt="contact-img" title="contact-img" class=" thumb-sm" /></td>

										<td>${com_staff2VO.real_use_dep_nm}</td>

										<td>${com_staff2VO.team_cd}</td>

										<td>${com_staff2VO.posit_nm}</td>

										<td><a
											href="/staff2board/readPage?st_no=${com_staff2VO.st_no}">${com_staff2VO.usr_nm}</a></td>

										<td>${com_staff2VO.telno}</td>

										<td>${com_staff2VO.st_edt}</td>
										<td><form action="/staff2board/removePage" method="post">
												<input type="hidden" name="st_no" value="${com_staff2VO.st_no}">
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
				
				$("#section_cd").change(function () {
					var section_cd = $("#section_cd option:selected").val();
					
					var url = "/staff2board/list?section_cd="+ section_cd;
				
					location.href = url;
					});
				
				var value = "${param.section_cd}";
				
				$("#section_cd > option[value=" + value + "]").attr("selected", true);
				
				});
		</script>
	</div>
</section>


<%@include file="../include/footer.jsp"%>