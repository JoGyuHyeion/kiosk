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
							<li class="active">부서이동</li>
						</ol>
					</div>
					<h4 class="page-title">
						부서이동 <small>부서 이동을 할 수 있습니다.</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<div class="row">

						<c:if test="${0 eq login.auth}">
							<!-- section_cd -->
							<div class="col-sm-3">
								<select name="section_cd" id="section_cd" class="form-control">
									<c:forEach items="${sectionService}" var="com_sectionVO">
										<option value="${com_sectionVO.section_fullcode}">${com_sectionVO.section_fullpath}</option>
									</c:forEach>
								</select>
							</div>

							<!-- team_cd -->
							<div class="col-sm-3">
								<select name="team_cd" id="team_cd" class="form-control">
									<option value="">::근무팀을 선택하여 주세요!</option>
								</select>
							</div>
						</c:if>

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
					</div>

					<div class="table-responsive">
						<table class="table table-hover mails m-0 table table-actions-bar">
							<thead>
								<tr>
									<th>사진</th>
									<th>부서</th>
									<th>팀</th>
									<th>직위</th>
									<th>이름</th>
									<th>부서이동</th>

								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="com_staffVO">
									<%-- 						
									<tr class="active">
										<td><a
											href="/staffboard/modifyPage${pageMaker.makeSearch(param.page)}&st_no=${com_staffVO.st_no}"
											class="table-action-btn h2"><i
												class="mdi mdi-pencil-box-outline text-success"></i></a></td>
 									--%>
									<tr class="">

										<td><img
											src="${pageContext.request.contextPath}${uploadPath}${com_staffVO.img_filenm}"
											alt="contact-img" title="contact-img" class=" thumb-sm"
											onerror="this.src='/resources/assets/images/users/avatar-2.jpg'" /></td>

										<td id="real_use_dep_nm${com_staffVO.st_no}">
											${com_staffVO.real_use_dep_nm}</td>

										<td id="class_nm${com_staffVO.st_no}">${com_staffVO.class_nm}</td>

										<td>${com_staffVO.posit_nm}</td>

										<td id="usr_nm${com_staffVO.st_no}">${com_staffVO.usr_nm}</td>

										<td>
											<button type="submit" class="btn btn-default move_btn"
												data-toggle="modal" data-target="#moveModal"
												value="${com_staffVO.st_no}">
												<i class="glyphicon glyphicon-glass glyphicon-trash"></i>
											</button>
										</td>
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

		<!-- modal  -->
		<div class="modal fade" id="moveModal" tabindex="-1" role="dialog"
			aria-labelledby="imageModalModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="imageModalLabel">부서이동</h4>
					</div>
					<div></div>
					<form  method="post"
						enctype="multipart/form-data" class= "form-horizontal">
						<div class="modal-body">

							<div class="form-group">
								<input type="hidden" id="st_no" name="st_no">
								<table
									class="table table-hover mails m-0 table table-actions-bar">
									<thead>
										<tr>
											<th>부서</th>
											<th>팀</th>
											<th>이름</th>

										</tr>
									</thead>

									<tbody>
										<tr>
											<td id="real_use_dep_nm"></td>
											<td id="class_nm"></td>
											<td id="usr_nm"></td>

										</tr>
									</tbody>
								</table>
							</div>
							<!-- section_cd -->
							<div class="form-group">
								<label class="col-md-2 control-label">근무부서</label>
								<div class="col-md-7">
									<select name="real_use_dep_nm" id="real_use_dep_nm"
										class="form-control section_cd">
										<c:forEach items="${sectionService}" var="com_sectionVO">
											<option value="${com_sectionVO.section_fullcode}">${com_sectionVO.section_fullpath}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<!-- team_cd -->
							<div class="form-group">
								<label class="col-md-2 control-label">근무팀</label>
								<div class="col-md-7">
									<select name="class_nm" id="class_nm"
										class="form-control class_nm">
										<option value="">::근무팀을 선택하여 주세요!</option>
									</select>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" id="modify" class="btn btn-primary">이동</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script>
			// 익명 즉시실행함수(immediately-invoked function expression)
			// Javascript 대가이신 더글라스 클락포트의 권장 표기법
			(function() {
				var result = '${msg}';
				if (result == 'SUCCESS') {
					alert("처리가 완료되었습니다.");
				}
			}());

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
					var url = "/staffboard/moveStaff?section_cd="+ section_cd;
					
					/*$.getJSON("/staff/getTeams/"+section_cd, function(data) {
						var str="";
						console.log(data.length);
						console.log(data);
						str+="<option value=none>전체</option>";
						$(data).each(function(){
							str+="<option value=\""+this.team_cd+"\">"+this.team_nm+"</option>";
							console.log(str);
						});
						$("#team_cd").html(str);
					});*/
					location.href = url;
				});
				
				//modal 
				$(".section_cd").change(function() {
					
					var section_cd = $(".section_cd option:selected").val();
					$.getJSON("/staff/getTeams/"+ section_cd,function(data) {
						var str = "";
						console.log(data.length);
						console.log(data);
						$(data).each(function() {
							str += "<option value=\""+this.team_nm+"\">"+ this.team_nm+ "</option>";
							console.log(str);
						});
						$(".class_nm").html(str);
					});
				});
								
				//modal in 
				$('.move_btn').click(function() {
					
					var st_no = $(this).val();
					var real_use_dep_nm = $("#real_use_dep_nm"+ st_no.toString()).text();
					var class_nm = $("#class_nm"+ st_no.toString()).text();
					var usr_nm = $("#usr_nm"+ st_no.toString()).text();
					
					$("#moveModal").find('#st_no').val(st_no);
					$("#moveModal").find('#real_use_dep_nm').text(real_use_dep_nm);
					$("#moveModal").find('#class_nm').text(class_nm);
					$("#moveModal").find('#usr_nm').text(usr_nm);
				});

				$("#team_cd").change(function() {

					var section_cd = $("#section_cd option:selected").val();
					var team_cd = $("#team_cd option:selected").val();
					var url = "/staffboard/moveStaff?section_cd="+ section_cd+ "&team_cd="+ team_cd;
					location.href = url;
				});
				
				var section_cd = "${param.section_cd}";
				$("#section_cd > option[value="+ section_cd + "]").attr("selected", true);
								
				
				$.getJSON("/staff/getTeams/" + section_cd,function(data) {
					
					var str = "";
					console.log(data.length);
					console.log(data);
					str += "<option value=none>전체</option>";
					$(data).each(function() {
						str += "<option value=\""+this.team_cd+"\">"+ this.team_nm+ "</option>";console.log(str);
					});

													
					$("#team_cd").html(str);
					var team_cd = "${param.team_cd}";
					if (team_cd != "") {
						$("#team_cd").val(team_cd);
					}
				});
			
			});
		</script>
	</div>
</section>


<%@include file="../include/footer.jsp"%>