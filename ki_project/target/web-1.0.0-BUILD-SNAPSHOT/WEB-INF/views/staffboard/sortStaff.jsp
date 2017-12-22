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
							<li class="active">자리이동</li>
						</ol>
					</div>
					<h4 class="page-title">
						자리이동 <small>자리 이동을 할 수 있습니다.</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<form action="sortPage" method="post" onsubmit="return formCheck()">
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

					
						<div class="col-sm-1">
							<button type = "submit" class="btn btn-danger" id="sortBtn">
								<i class="fa fa-search"> 편집하기</i>
							</button>
						</div>
					</div>
					</form>

				</div>
				<!-- end card-box -->



			</div>
			<!-- end col -->


		</div>
		<!-- end row -->

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
//					var url = "/staffboard/moveStaff?section_cd="+ section_cd;
					
					$.getJSON("/staff/getTeams/"+section_cd, function(data) {
						var str="";
						console.log(data.length);
						console.log(data);
						str+="<option value=none>전체</option>";
						$(data).each(function(){
							str+="<option value=\""+this.team_cd+"\">"+this.team_nm+"</option>";
							console.log(str);
						});
						$("#team_cd").html(str);
					});
				//	location.href = url;
				});
				
				$("#sortBtn").on("click",function(event) {
					var section_cd = $("#section_cd option:selected").val();		
					var team_cd = $("#team_cd option:selected").val();
									
					//alert(section_cd +"/"+ team_cd);
					
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
			
			function formCheck() {
				if ($.trim($("#section_cd").val()) == "none") {
					alert("근무 부서를 선택하세요");
					$("#section_cd").focus();
					return false;
				} else if ($.trim($("#team_cd").val()) == "none") {
					alert("근무 팀을 선택하세요");
					$("#class_nm").focus();
					return false;
				} 
				return true;

			}
		</script>
	</div>
</section>


<%@include file="../include/footer.jsp"%>