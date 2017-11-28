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
                        <div class="col-sm-8">
                            <form role="form">
                                <label class=" col-md-2 control-label" for="search_bcd">국코드</label>
                                <select id="search_bcd" name="search_bcd" class="form-control">
                                    <c:forEach items="${bureauService}" var="com_bureauVO">
                                        <option value="${com_bureauVO.bureau_cd}">${com_bureauVO.bureau_name}</option>

                                    </c:forEach>

                                </select>
                            </form>
                        </div>

                    </div>
                    <div class="row">
                        <div class="table-responsive col-md-8 ">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>과코드</td>
                                        <td>과명칭</td>
                                        <td>사용여부</td>
                                    </tr>
                                </thead>
                            
                                <tbody>
                                <c:forEach items="${bcd}" var="com_sectionVO" varStatus="status">
                                    <tr>
                                        <td><input type="text" class="form-control section_cd" size="6" 
                                                   value="${com_sectionVO.section_cd}" readonly="readonly"></td>
                                        <td><input type="text" class="form-control section_name" size="40"
                                                   value="${com_sectionVO.section_name}"></td>
                                        <td>
                                            <div style="padding: 5px">
                                                <input type="checkbox" class="section_use" name="section_use" switch="none" id="section_use${status.index}"
                                                       <c:if test = "${com_sectionVO.section_use eq '1'}">checked</c:if> />
                                                       <label for="section_use${status.index}" data-on-label="On" data-off-label="Off"></label>
                                            </div>
                                        </td>
                                        <td><a class="table-action-btn h2 removeBtn" value ="${com_sectionVO.section_fullcode}" ><i
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
                                                <button data-toggle="modal" id="addSection" data-target="#sectionModal"
                                                        class="btn btn-warning waves-effect w-md waves-light m-b-5">
                                                    <i class="fa fa-plus-circle"></i> 과추가
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
        <div class="modal fade" id="sectionModal" tabindex="-1" role="dialog"
             aria-labelledby="sectionModalModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="imageModalLabel">과정보</h4>
                    </div>
                    <div></div>
                    <div class="modal-body">
                        <form action="/section/insert" method="post">
                            <div class="form-group">
                                <label for="image" class="control-label">과코트</label> 
                                <input type="text" id="section_cd" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="image" class="control-label">과명칭</label> 
                                <input type="text" id="section_name" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="image" class="control-label">사용여부</label> 
                                <div style="padding: 5px">
                                <input type="checkbox" class="new_section_use" name="new_section_use" switch="none" id="new_section_use"/>
                                <label for="new_section_use" data-on-label="On" data-off-label="Off"></label>
                                </div>
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
            	        $("#section_cd").val(" ");
            	        $("#section_name").val(" ");
            	        $("#new_section_use").prop('checked',false)
            	 });
            	
            	 $("#btnSave").click(function(){
            		 var bcd = $("#search_bcd option:selected").val();
            		 var jsonArr = new Array();
            		 
            		 for(var i=0; i<$(".section_cd").length; i++){
            			 var jsonObj = new Object();
            			 jsonObj.bureau_cd = bcd;
            			 jsonObj.section_cd = $(".section_cd").eq(i).val();
            			 jsonObj.section_name = $(".section_name").eq(i).val();
            			 jsonObj.section_use = 	($(".section_use").eq(i).prop('checked')?1:0);
            			 jsonObj.section_fullcode = jsonObj.bureau_cd + "-" + jsonObj.section_cd;
            			 jsonArr.push(jsonObj);
            			
            			 }    	     
	        
            	         $.ajax({
                			url: '/section/listUpdate/'+bcd,
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
                		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                		       }
            	         }); 
            	 });
            	
            	$("#search_bcd").change(function () {
            		var bcd = $("#search_bcd option:selected").val();
            		var url = "/myinfoboard/section?bcd="+ bcd;
            		location.href = url;
            		});
            	
            	var value = "${param.bcd}";
            	
            	$("#search_bcd > option[value=" + value + "]").attr("selected", true);
            	
            	$("#btnAdd").click(function () {
            		$("#section_cd").val(" ");
          	        $("#section_name").val(" ");
          	        $("#new_section_use").prop('checked',false)
            		var bureau_cd = $("#search_bcd option:selected").val();
            		var section_name = $("#section_name").val();
            		var section_cd = $("#section_cd").val();
            		var section_use = ($("#new_section_use").prop('checked')?1:0);     
            	
            		$.ajax({
            			url: '/section/insert',
            			type: 'post',
            			headers: {
            				"Content-Type": "application/json",
            				"X-HTTP-Method-Override": "POST"
            				},
            				dataType:'text',
            				data: JSON.stringify({
            					"bureau_cd": bureau_cd,
            					"section_cd": section_cd,
            					"section_name": section_name,
            					"section_type" : 1,
            					"section_use" : section_use,
            					"section_fullcode" : bureau_cd+"-"+section_cd,
            					}),
            					
            					success: function (data) {
            						if (data == 'SUCCESS') {
            							alert("추가 되었습니다.");
            							location.reload();
            						}
            					},
            					error : function(error) {
            						alert("과코드가 중복됩니다.");
									$("#section_cd").val("");
									$("#section_cd").focus();
            				    }
            				});
            		});
            	            	
            	$(".removeBtn").click(function () {
            		var section_cd = $(this).attr("value");
            		$.ajax({
            			url: '/section/del/'+section_cd,
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