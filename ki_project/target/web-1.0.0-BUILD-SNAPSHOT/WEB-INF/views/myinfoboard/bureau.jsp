<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="wrapper">


    <div class="container">


        <div class="row">
            <div class="col-lg-12">
                <div class="card-box">
                                    <!-- Page-Title -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="btn-group pull-right">
                                    <ol class="breadcrumb hide-phone p-0 m-0">
                                        <li><a href="#">디지털 조직도</a></li>
                                        <li><a href="#">기초설정</a></li>
                                        <li class="active">부서관리</li>
                                    </ol>
                                </div>
                                <h4 class="page-title">
                                    부서관리 <small>부서 <code>관리</code> 할 수 있습니다.
                                    </small>
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-8">
                           
                        </div>

                    </div>
                    <div class="row">
                        <div class="table-responsive col-md-8 ">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>부서코드</td>
                                        <td>부서명칭</td>
                                        <td>삭제</td>
                                 
                                    </tr>
                                </thead>
                            
                                <tbody>
                                <c:forEach items="${bureauService}" var="com_bureauVO" varStatus="status" >
                                    <tr>
                                        <td><input type="text" class="form-control bureau_cd" size="6" 
                                                   value="${com_bureauVO.bureau_cd}" readonly="readonly"></td>
                                        <td><input type="text" class="form-control bureau_name" size="40"
                                                   value="${com_bureauVO.bureau_name}"></td>
                                     
                                        <td><a class="table-action-btn h2 removeBtn" value ="${com_bureauVO.bureau_cd}" ><i
                                                    class="mdi mdi-close-box-outline text-danger"></i></a></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                                                                                               
                                <tfoot>
                                    <tr>
                                        <td colspan="4">
                                            <div class="form-group" style="text-align: center">
                                                <button type="button" id="btnSave"
                                                        class="btn btn-primary waves-effect w-md waves-light m-b-5">저장</button>
                                                <button data-toggle="modal" id="addSection" data-target="#bureauModal"
                                                        class="btn btn-warning waves-effect w-md waves-light m-b-5">
                                                    <i class="fa fa-plus-circle"></i> 부서추가
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- end table responsive -->
                    </div>
                </div>
                <!-- end card-box -->
            </div>
            <!-- end col -->
        </div>
        <!-- end row -->
        <!-- modal  -->
        <div class="modal fade" id="bureauModal" tabindex="-1" role="dialog"
             aria-labelledby="bureauModalModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="imageModalLabel">부서정보</h4>
                    </div>
                    <div></div>
                    <div class="modal-body">
                        <form action="/section/insert" method="post">
                            <div class="form-group">
                                <label for="image" class="control-label">부서코트</label> 
                                <input type="text" id="bureau_cd" maxlength="4" placeholder="ex) K023" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="image" class="control-label">부서명칭</label> 
                                <input type="text" id="bureau_name" maxlength="30" placeholder="부서명칭(30자 이내)" class="form-control">
                            </div>
                        
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="closeModal" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btnAdd">과추가</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
            	
            	 $('#addSection').on('click', function () {
            	        $("#bureau_cd").val("");
            	        $("#bureau_name").val("");
            	 });
            	
            	 $("#btnSave").click(function(){
            		 var jsonArr = new Array();
            		 
            		 for(var i=0; i<$(".bureau_cd").length; i++){
            			 var jsonObj = new Object();
            			 jsonObj.bureau_cd = $(".bureau_cd").eq(i).val();
            			 jsonObj.bureau_name = $(".bureau_name").eq(i).val();
            			 jsonArr.push(jsonObj);
            			
            			 }    	     
	        
            	         $.ajax({
                			url: '/bureau/listUpdate/bureau',
                			type: 'PUT',
                			headers: {
                				"Content-Type": "application/json",
                				"X-HTTP-Method-Override": "PUT"
                				},
                				dataType:'text',
                				data: JSON.stringify(jsonArr),
                				
                				success: function (data) {
                					if (data == 'SUCCESS') {
                						alert("수정 되었습니다.");
                						//location.reload();
                					}
                				},
            					
                				error:function(request,status,error){
                				alert("수정 실패 되었습니다.");
                		       // alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                		       }
            	         }); 
            	 });
            	
            	
            	$("#btnAdd").click(function () {
          
            		var bureau_name = $("#bureau_name").val();
            		var bureau_cd = $("#bureau_cd").val();
            	
            		$.ajax({
            			url: '/bureau/insert',
            			type: 'post',
            			headers: {
            				"Content-Type": "application/json",
            				"X-HTTP-Method-Override": "POST"
            				},
            				dataType:'text',
            				data: JSON.stringify({
            					"bureau_cd": bureau_cd,
            					"bureau_name": bureau_name,
            					}),
            					
            					success: function (data) {
            						if (data == 'SUCCESS') {
            							alert("추가 되었습니다.");
            							$('#bureauModal .close').click();
            							var str = '<tr>'+
            							'<td><input type="text" class="form-control bureau_cd" size="6"  value="'+bureau_cd+'" readonly="readonly"></td>'+
            							'<td><input type="text" class="form-control bureau_name" size="40"value="'+bureau_name+'"></td>'+
            							'<td><a class="table-action-btn h2 removeBtn" value ="'+bureau_cd+'" >'+
            							'<i class="mdi mdi-close-box-outline text-danger"></i></a></td>'+
            							'</tr>';
            							$("tbody").append(str);
            							//location.reload();
            						}
            					},
            					error : function(error) {
            						alert("부서코드가 중복 및 길게 작성되었습니다.");
									$("#bureau_cd").val("");
									$("#bureau_cd").focus();
            				    }
            				});
            		});
            	            	
            	$(".removeBtn").click(function () {
            		
            		var bureau_cd = $(this).attr("value");
            		$(this).closest("tr").remove();
            		$.ajax({
            			url: '/bureau/del/'+bureau_cd,
            			type: 'DELETE',
            			success: function (data) {
            				if (data == 'SUCCESS') {
            						
            						//location.reload();
            						alert("삭제 되었습니다.");
            					}
            			},
            			error : function(error) {
    						alert("삭제 실패되었습니다.");
    				    }
            		}); 
            	});
            	$.urlParam = function (name) {
            		var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
            		return results[1] || 0;
            	}
            });
        </script>


        <!-- end row -->
        <%@include file="../include/footer.jsp"%>