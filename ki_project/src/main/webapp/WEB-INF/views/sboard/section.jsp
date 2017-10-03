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

		
<!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <h2>과관리</h2>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <h4>과목록</h4>
          <select name="" id="" class="form-control col-md-4">
            <option value="">기업</option>  
            <option value="">기업</option>  
            <option value="">기업</option>  
            <option value="">기업</option>  
          </select></div>
        <div class="card-body">


          <div class="col-md-6">
            <table class="table" id="dataTable" cellspacing="0">
              <thead>
                <tr>
                  <th>과코드</th>
                  <th>과명칭</th>
                  <th>사용여부</th>
                  <th>팀</th>
                  <th> </th>

                </tr>
              </thead>
              <tbody>
                <tr>
                  <th><input type="text" value="123" class="form-control"></th>
                  <th><input type="text" value="기업 지원과" class="form-control"></th>
                  <th><input type="checkbox" value="1" class="form-control"></th>
                  <th><input type="button" value="X" class="btn-info"></th>
                </tr>
                <tr>
                  <th><input type="text" value="123" class="form-control"></th>
                  <th><input type="text" value="기업 지원과" class="form-control"></th>
                  <th><input type="checkbox" value="1" class="form-control"></th>
                  <th><input type="button" value="X" class="btn-info"></th>
                </tr>
                <tr>
                  <th><input type="text" value="123" class="form-control"></th>
                  <th><input type="text" value="기업 지원과" class="form-control"></th>
                  <th><input type="checkbox" value="1" class="form-control"></th>
                  <th><input type="button" value="X" class="btn-info"></th>
                </tr>
                <tr>
                  <th><input type="text" value="123" class="form-control"></th>
                  <th><input type="text" value="기업 지원과" class="form-control"></th>
                  <th><input type="checkbox" value="1" class="form-control"></th>
                  <th><input type="button" value="X" class="btn-info"></th>
                </tr>
                <tr>
                  <th><input type="text" value="123" class="form-control"></th>
                  <th><input type="text" value="기업 지원과" class="form-control"></th>
                  <th><input type="checkbox" value="1" class="form-control"></th>
                  <th><input type="button" value="X" class="btn-info"></th>
                </tr>

              </tbody>
            </table>
            <div class="form-group" style="text-align:center;">
                <button class="btn btn-primary">저장</button>
                <button class="btn btn-success">+과추가</button>
                
    
              </div>
          </div>
          

        </div>
      </div>
      <div class="card-footer small text-muted">과관리</div>





	</div>


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
