<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->

<section class="content-wrapper">

	<form role="form" action="modifyPage" method="post">

		<input type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
			type='hidden' name='searchType' value="${cri.searchType}"> <input
			type='hidden' name='keyword' value="${cri.keyword}">

	</form>
	<div class="container-fluid">

		<ol class="breadcrumb">
			<div class="row">
				<div class="col-sm-12 col-md-3">
					<select name="" id="" class="form-control form-control-sm">
						<option value="">전체관리자</option>
						<option value="">efg</option>
					</select>
				</div>

				<div class="col-sm-12 col-md-3">
					<select name="" id="" class="form-control form-control-sm">
						<option value="">::근무팀을 선택하여 주세요!</option>
						<option value="">efg</option>
					</select>
				</div>

				<div class="col-sm-12 col-md-3">
					<input type="text" class="form-control" value="검색어">
				</div>

				<div class="col-sm-12 col-md-3">
					<button class="btn btn-primary">검색</button>
				</div>
			</div>

		</ol>

		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-table"></i>직원목록
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>편집</th>
								<th>사진</th>
								<th>부서</th>
								<th>팀</th>
								<th>직위</th>
								<th>성명</th>
								<th>이메일</th>
								<th>사무명</th>
								<th>전화번호</th>
								<th>Update</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="com_staffVO">

								<tr>
									<td><a
										href="/sboard/modifyPage${pageMaker.makeSearch(param.page)}&st_no=${com_staffVO.st_no}">수정</a></td>

									<td>${com_staffVO.img_filenm}</td>
									<td>${com_staffVO.section_cd}</td>
									<td>${com_staffVO.st_team}</td>
									<td>${com_staffVO.st_job}</td>
									<td>${com_staffVO.st_nm}</td>
									<td>${com_staffVO.st_email}</td>
									<td>${com_staffVO.st_profile}</td>
									<td>${com_staffVO.st_tel}</td>
									<td>${com_staffVO.st_edt }</td>
								</tr>

							</c:forEach>
						<tbody>
					</table>


					<div class="row">
						<div class="box-footer">

							<div class="text-center">
								<ul class="pagination">

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
					</div>
				</div>
			</div>
		</div>



	</div>
	</div>





	<div class="box-footer">

		<div class="text-center">
			<ul class="pagination">

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
	<!-- /.box-footer-->
	</div>
	</div>
	<!--/.col (left) -->

	</div>
	<!-- /.row -->

</section>
<!-- /.content -->


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
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});
</script>

<%@include file="../include/footer.jsp"%>
