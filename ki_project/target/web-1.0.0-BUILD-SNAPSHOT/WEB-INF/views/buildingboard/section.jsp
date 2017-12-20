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

                    <div class="row">
                        <div class="table-responsive col-md-8 ">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>건물명</td>                          
                                        <td>삭제</td>
                                    </tr>
                                </thead>
                            
                                <tbody>
                                <c:forEach items="${buildingList}" var="BuildingVO">
                                    <tr>
                                        <td><input type="text" class="form-control building_name" size="40"
                                                   value="${BuildingVO.building_name}"></td>
                
                                        <td><a class="table-action-btn h2 bu_type removeBtn" value ="${BuildingVO.bu_type}" ><i
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
                                                <button data-toggle="modal" id="addBuilding" data-target="#buildingModal"
                                                        class="btn btn-warning waves-effect w-md waves-light m-b-5">
                                                    <i class="fa fa-plus-circle"></i> 건물추가
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
        <div class="modal fade" id="buildingModal" tabindex="-1" role="dialog"
             aria-labelledby="buildingModalModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="imageModalLabel">건물정보</h4>
                    </div>
                    <div></div>
                    <div class="modal-body">
                        <form action="/building/insert" method="post">
                            <div class="form-group">
                                <label for="image" class="control-label">건물명</label> 
                                <input type="text" id="building_name" maxlength="20" placeholder="건물명(20자 이내)" class="form-control">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="closeModal" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btnAdd">건물추가</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {

            	
            	 $('#addBuilding').on('click', function () {
            	        $("#building_name").val("");
            	 });
            	
            	 $("#btnSave").click(function(){
            		 var jsonArr = new Array();
            		
            		 for(var i=0; i<$(".building_name").length; i++){
            			 var jsonObj = new Object();
            			 jsonObj.building_name = $(".building_name").eq(i).val();
            			 jsonObj.bu_type = $(".bu_type").eq(i).attr("value");
            			 jsonArr.push(jsonObj);
            			 }    	     
            	         $.ajax({
                			url: '/building/listUpdate/all',
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
                						location.reload();
                					}
                				},
            					
                				error:function(request,status,error){
                				alert("수정 실패 되었습니다.");
                		       // alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                		       }
            	         }); 
            	 });
            	
            	
            	$("#btnAdd").click(function () {
          
            		var building_name = $("#building_name").val();
            	
            		$.ajax({
            			url: '/building/insert',
            			type: 'post',
            			headers: {
            				"Content-Type": "application/json",
            				"X-HTTP-Method-Override": "POST"
            				},
            				dataType:'text',
            				data: JSON.stringify({
            					"building_name": building_name,
            					}),
            					
            					success: function (data) {
            						if (data == 'SUCCESS') {
            							alert("추가 되었습니다.");
            							$('#buildingModal .close').click();
            							location.reload();
            						}
            					},
            					error : function(error) {
            						alert("건물명이 중복됩니다.");
									$("#building_name").val("");
									$("#building_name").focus();
            				    }
            				});
            		});
            	            	
            	$(".removeBtn").click(function () {
            		var bu_type=  $(this).attr("value");
            		
            		//$(this).closest("tr").remove();
            		
            		$.ajax({
            			url: '/building/del/'+bu_type,
            			type: 'DELETE',
            			success: function (data) {
            				if (data == 'SUCCESS') {
            				
            						alert("삭제 되었습니다.");
            						location.reload();
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