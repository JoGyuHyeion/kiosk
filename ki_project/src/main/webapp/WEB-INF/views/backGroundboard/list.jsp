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
							<li><a href="#">manager</a></li>
							<li class="active">배경화면</li>
						</ol>
					</div>
					<h4 class="page-title">배경화면</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->
		<div class="portfolioContainer">

			<c:forEach items="${list}" var="com_bgImgVO">
				<div class="col-sm-6 col-md-4">
					<div class="thumb">
						<img width="600" height="400"
							src="${pageContext.request.contextPath}/resources/upload/${com_bgImgVO.bi_img}"
							class="thumb-img"
							onerror="this.src='/resources/assets/images/properties/1.jpg'">

						<div class="gal-detail">
							<h4>${com_bgImgVO.bi_name}</h4>
							<form
								action="/backGroundboard/removePage?bi_no=${com_bgImgVO.bi_no}"
								method="post">
								<button type="button"
									class="btn btn-custom btn-inline waves-effect waves-light"
									onclick="location.href='/backGroundboard/modifyPage${pageMaker.makeSearch(param.page)}&bi_no=${com_bgImgVO.bi_no}'">정보수정</button>
								<button type="submit"
									class="btn btn-danger btn-inline waves-effect waves-light">
									<i class="glyphicon glyphicon-trash"></i>삭제
								</button>
							</form>
						</div>
					</div>
				</div>


			</c:forEach>
		</div>
		<!-- end col -->
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
		<!-- end row -->
	</div>
</section>
<%@include file="../include/footer.jsp"%>