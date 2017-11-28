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
							<li><a href="#"></a></li>
							<li class="active">동영상조회</li>
						</ol>
					</div>
					<h4 class="page-title">동영상조회</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->




		<c:forEach items="${list}" var="com_videoVO">
			<div class="col-md-4 col-sm-6">
				<div class="property-card">
					<div class="property-image"
						style="background: url('/resources/assets/images/properties/6.jpg') center center/cover no-repeat;">
						<video>
							<source src="${pageContext.request.contextPath}${uploadPath}${com_videoVO.vi_video}" type="video/mp4">			
							<source src="movie.ogg" type="video/ogg">
						</video>
						
					</div>

					<div class="property-content">
						<div class="listingInfo">
							<p></p>
							<div class="">

								<h3 class="text-overflow">
									<a href="/movieboard/readPage?vi_no=${com_videoVO.vi_no}" class="text-dark">${com_videoVO.vi_name}</a>
								</h3>

								<div class="m-t-20" style="text-align: center">

									<form
										action="/movieboard/removePage?vi_no=${com_videoVO.vi_no}"
										method="post">
										<button type="button"
											class="btn btn-custom btn-inline waves-effect waves-light"
											onclick="location.href='/movieboard/modifyPage${pageMaker.makeSearch(param.page)}&vi_no=${com_videoVO.vi_no}'">정보수정</button>

										<button type="submit"
											class="btn btn-danger btn-inline waves-effect waves-light">
											<i class="glyphicon glyphicon-trash"></i>삭제
										</button>
									</form>
								</div>

							</div>
						</div>
						<!-- end. Card actions -->
					</div>
					<!-- /inner row -->
				</div>
				<!-- End property item -->
			</div>
		</c:forEach>

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
	</div>
	<!-- end row -->

</section>



<%@include file="../include/footer.jsp"%>