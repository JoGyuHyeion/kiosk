<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!--  Main content -->

<section class="wrapper">

	<form role="form" action="modifyPage" method="post">
		<input type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
			type='hidden' name='searchType' value="${cri.searchType}"> <input
			type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<div class="container">

		<!-- PageTitle -->
		<div class="row">
			<div class="col-sm-12">
				<div class="page-title-box">
					<div class="btn-group pull-right">
						<ol class="breadcrumb hide-phone p-0 m-0">
							<li><a href="#">공지관리</a></li>
							<li class="active">공지조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						공지조회 <small>공지사항을 조회 할 수 있습니다.</small>
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
								<div class=form-group">
									<input type="text" id="search-input" class="form=control"
										placeholder="Please search keyword">
								</div>
							</form>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-danger" id="searchBtn">
								<i class="fa fa-search"> 찾기</i>
							</button>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-hover mails m-0 table-actions-bar">
							<thead>
								<tr>
									<th>편집</th>
									<th>상태</th>
									<th>일렬번호</th>
									<th>부서</th>
									<th>제목</th>
									<th>노출기간</th>
									<th>조회수</th>
									<th>작성시간</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="com_boardVO">
									<tr class="active">
										<td><a
											href="/noticeboard/modifyPage${pageMaker.makeSearch(param.page)}&bbs_no=${com_boardVO.bbs_no}"
											class="table-action-btn h2"><i
												class="mdi mdi-pencil-box-outline text-success"></i></a></td>

										<td>${com_boardVO.bbs_state}</td>

										<td>${com_boardVO.bbs_no}</td>

										<td>${com_boardVO.section_cd}</td>

										<td>${com_boardVO.bbs_title}</td>

										<td>${com_boardVO.bbs_exp_sdt}~${com_boardVO.bbs_exp_edt}</td>

										<td>${com_boardVO.bbs_hits}</td>

										<td>${com_boardVO.bbs_ndt}</td>
									<tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- end table responsive -->
				</div>
				<!-- end card-box -->

				<div class="text-right">
					<ul class="pagination pagination-split m-t-0">
						<li class="disabled"><a href="#"><i
								class="fa fa-angle-left"></i></a></li>
						<c:if test="${pageMarker.prev}">
							<li><a
								href="list${pageMaker.makeSearch(pageMaker.startPage - 1 }">&laquo;</a></li>
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
						<li><a href="#"><i class="fa fa-angle-right"></i></a></li>

					</ul>
				</div>
			</div>
			<!-- end col -->
		</div>		
		<!-- end row -->
	</div>
	<script>
		var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리가 완료되었습니다.");
		}
	</script>

	<script>
		$(document).ready(
				function() {

					$('#searchBtn').on(
							"click",
							function(event) {

								self.location = "list"
										+ '${pageMaker.makeQuery(1)}'
										+ "&searchType="
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val();

							});

					$('#newBtn').on("click", function(evt) {

						self.location = "register";

					});

				});
	</script>
</section>
<%@include file="../include/footer.jsp"%>