<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->

<section class="wrapper">

	<form role="form" action="modifyPage" method="post">

		<input type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
			type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<div class="container">
		<!-- Page-Title -->
		<div class="row">
			<div class="col-sm-12">
				<div class="page-title-box">
					<div class="btn-group pull-right">
						<ol class="breadcrumb hide-phone p-0 m-0">
							<li><a href="#">디지털 조직도</a></li>
							<li><a href="#">공지관리</a></li>
							<li class="active">공지조회</li>
						</ol>
					</div>
					<h4 class="page-title">
						공지조회 <small>공지를 조회 할 수 있습니다.</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<div class="row">
						<form role="form" method="get">
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" id="search-input" class="form-control"
										name="keyword" placeholder="Please Name">
								</div>
							</div>
							<div class="col-sm-1">
								<button type="submit" class="btn btn-danger">
									<i class="fa fa-search" id="serch"> 찾기</i>
								</button>
							</div>
						</form>
						<div class="col-sm-1">
							<a href="/noticeboard/register" class="btn btn-primary ">작성</a>
						</div>
					</div>

					<div class="table-responsive">
						<table class="table table-hover mails m-0 table table-actions-bar">
							<thead>
								<tr>
									<th>편집</th>
									<th>No</th>
									<th>부서</th>
									<th>제목</th>
									<th>노출기간</th>
									<th>작성시간</th>
									<th>삭제</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="com_boardVO">

									<tr class="">
										<td><a
											href="/noticeboard/modifyPage${pageMaker.makeSearch(param.page)}&bbs_no=${com_boardVO.bbs_no}"
											class="btn btn-default"><i
												class="glyphicon glyphicon-glass glyphicon-edit"></i></a></td>

										<td>${com_boardVO.bbs_no}</td>

										<td>${com_boardVO.section_cd}</td>

										<td><a
											href="/noticeboard/readPage?bbs_no=${com_boardVO.bbs_no}">${com_boardVO.bbs_title}</a></td>

										<td>${com_boardVO.bbs_exp_sdt}~${com_boardVO.bbs_exp_edt}</td>

										<td>${com_boardVO.bbs_ndt}</td>
										<td><form action="/noticeboard/removePage" method="post">
												<input type="hidden" name="bbs_no"
													value="${com_boardVO.bbs_no}">
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
			$(document).ready(
					function() {

						$('#searchBtn').on(
								"click",
								function(event) {

									self.location = "list"
											+ '${pageMaker.makeQuery(1)}'
											+ "&keyword="
											+ $('#keywordInput').val();

								});

					});
		</script>
	</div>
</section>
<%@include file="../include/footer.jsp"%>