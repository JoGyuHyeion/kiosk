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
                                        <li class="active">팀관리</li>
                                    </ol>
                                </div>
                                <h4 class="page-title">
                                    팀관리 <small>팀 <code>관리</code> 할 수 있습니다.
                                    </small>
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card-box">
                            
                            
					<c:if test="${0 eq login.auth}">
    						<div class="col-sm-8">
                            	<form role="form">
                               	 <label class=" col-md-2 control-label" for="search_team">부서</label>
                              	  <select id="search_team" name="search_team" class="form-control">
                                     <c:forEach items="${list}" var="com_sectionVO">
                                        <option value="${com_sectionVO.section_fullcode}">${com_sectionVO.section_fullpath}</option>
                                    </c:forEach>
                                </select>
                           		 </form>
                       		 </div>
					</c:if>


                                <div class="row">
                                    <div class="table-responsive col-md-8 ">
                                    
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                	<td>부서</td>
                                                    <td>팀코드</td>
                                                    <td>팀명칭</td>
                                                    <td>팀순위</td>
                                                    <td>사용여부</td>
                                                    <td>삭제</td>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach items="${teamList}" var="com_teamVO" varStatus="status">
												<input type="hidden" class="form-control section_cd" size="3" value="${com_teamVO.section_cd}" readonly="readonly">
												
                                                <tr>
                                                 	<td><input type="text" class="form-control sectionName" size="10" value=" ${com_teamVO.section_name}" readonly="readonly"></td>
                                                    <td><input type="text" class="form-control team_cd" size="3" value="${com_teamVO.team_cd}" readonly="readonly"></td>
                                                    <td><input type="text" class="form-control team_nm" size="40" value="${com_teamVO.team_nm}"></td>
                                                    <td><input type="number" min="1" max="50" class="form-control team_sort" size="3" value="${com_teamVO.team_sort}"></td>
                                                <c:set var="team_use" value="${com_teamVO.team_use}" />
                                                <td>
                                                 	<div style="padding: 5px">
                                                        <input type="checkbox" class="team_use" name="team_use" switch="none" id="team_use${status.index}" value="${com_teamVO.team_use}"
                                                               <c:if test = "${com_teamVO.team_use eq '1'}">checked</c:if> />
                                                        <label for="team_use${status.index}" data-on-label="On" data-off-label="Off"></label>
                                                    </div>
                                               </td>
                                                <td><a class="table-action-btn h2 removeBtn" value ="${com_teamVO.team_cd}"><i
                                                            class="mdi mdi-close-box-outline text-danger"></i></a></td>
                                                </tr>

                                            </c:forEach>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <td colspan="4">
                                                        <div class="form-group" style="text-align: center">
                                                            <button type="button" id="btnSave" class="btn btn-primary waves-effect w-md waves-light m-b-5">저장</button>
                                                            <button data-toggle="modal" data-target="#teamModal" id="modalAddTeam" class="btn btn-warning waves-effect w-md waves-light m-b-5" href="#teamAdd">
                                                                <i class="fa fa-plus-circle"></i> 팀추가
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
                </div>
                <!-- end card-box -->
            </div>
            <!-- end col -->
        </div>
        <!-- modal  -->
        <div class="modal fade" id="teamModal" tabindex="-1" role="dialog"
             aria-labelledby="temaModalModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="imageModalLabel">팀정보</h4>
                    </div>
                    <div></div>
                    <div class="modal-body">
                        <!-- <form class="form-horizontal" action="modifypage" method="post"> -->
                          <form class="form-horizontal">
                        <input type="hidden" id="section_cd" name="section_cd" value="${login.section_fullcode}">
                        
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="team_cd">팀코드</label>
                                <div class="col-sm-10">
                                    <input type="text" id="team_cd" name="team_cd" maxlength="3" placeholder="팀코드 ex) T08" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="team_nm">팀명</label>
                                <div class="col-sm-10">
                                    <input type="text" id="team_nm" name="team_nm" maxlength="30" placeholder="팀명(30자 이내)" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="new_team_use">사용여부</label>
                                <div class="col-sm-10">
                                    <input type="checkbox" name="new_team_use" switch="none" id="new_team_use"/>
                       				<label for="new_team_use" data-on-label="On" data-off-label="Off"></label>
                                </div>
                            </div>
                            
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btnAdd">과추가</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
 
            $(document).ready(function () {
            	
            var section_cd="${param.section_cd}";
            
            
            if(section_cd == ""|| section_cd =="none"){
            	
            	$("#modalAddTeam").hide();
            	
            }else if(section_cd!=""){
            	
            	$("#search_team").val(section_cd);
            	
            }
            	
            	$("#search_team").change( function () {
					var search_team = $("#search_team option:selected").val();
					location.href="/myinfoboard/team?section_cd="+search_team;
            	});
            	
            	
            	 $('#addSection').on('click', function () {
         	        $("#section_cd").val("");
         	        $("#section_name").val("");
         	        $("#new_section_use").prop('checked',false)
            	 });
            	 
            	 $("#btnSave").click(function(){
            		 var section_cd =($("#section_cd").val()=="none"?$("#search_team").val():$("#section_cd").val());
            		 var jsonArr = new Array();
            		 
            		 for(var i=0; i<$(".team_cd").length; i++){
            			 var jsonObj = new Object();
            			 jsonObj.section_cd =  $(".section_cd").eq(i).val();
            			 jsonObj.team_cd = $(".team_cd").eq(i).val();
            			 jsonObj.team_nm = $(".team_nm").eq(i).val();
            			 jsonObj.team_sort = $(".team_sort").eq(i).val();
            			 jsonObj.team_use = ($(".team_use").eq(i).prop('checked')?1:0);
            			 jsonArr.push(jsonObj);
            		 }    	     
            		 //alert(JSON.stringify(jsonArr));
            	          $.ajax({
                			url: '/team/listUpdate/'+section_cd,
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
                		        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                		       }
            	         });  
            	 });
            	 
                       	 
                $('#teamAdd').on('show.bs.modal', function (event) {
                        	        
                    $("#section_name").val("");
                    $("#section_name").focus();

                    var button = $(event.relatedTarget)
                    var recipient = button.data('whatever')
                    var modal = $(this)
                    modal.find('.modal-body input').val(recipient)

                });

                $("#btnAdd").click(function () {
                	var section_cd =($("#section_cd").val()=="none"?$("#search_team").val():$("#section_cd").val());
            		var team_cd = $("#team_cd").val();
            		var team_nm = $("#team_nm").val();
            		var new_team_use = ($("#new_team_use").prop('checked')?1:0);     
            	
            		 $.ajax({
            			url: '/team/insert',
            			type: 'post',
            			headers: {
            				"Content-Type": "application/json",
            				"X-HTTP-Method-Override": "POST"
            				},
            				dataType:'text',
            				data: JSON.stringify({
            					"section_cd": section_cd,
            					"team_cd": team_cd,
            					"team_nm": team_nm,
            					"team_use" : new_team_use,
            				}),
            				success: function (data) {
            					if (data == 'SUCCESS') {
            						alert("추가 되었습니다.");
            			
            						location.reload();
            					}
            				},
            				error : function(error) {
            					alert("팀코드가 중복됩니다.");
            					$("#team_cd").val("");
            					$("#team_cd").focus();
            				}
            		 }); 
                });

                $(".removeBtn").click(function () {
            		var section_cd =($("#section_cd").val()=="none"?$("#search_team").val():$("#section_cd").val());
            		//alert(section_cd);
            		//$(this).closest("tr").remove();
            		var team_cd = $(this).attr("value");
            		  $.ajax({
            			url: '/team/del/'+section_cd+'/'+team_cd,
            			type: 'DELETE',
            			success: function (data) {
            				if (data == 'SUCCESS') {
            						alert("삭제 되었습니다.");
            						location.reload();
            					}
            			},
            			error : function(error) {
    						alert("삭제가 실패되었습니다.");
    				    }
            		});  
            	});

            });
        </script>
        <!-- end row -->
        <%@include file="../include/footer.jsp"%>