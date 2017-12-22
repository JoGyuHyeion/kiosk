<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title></title>
<link href="/resources/assets/css/draganddrop.css" rel="stylesheet"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>


<style>

/*Horizontal scrollbar - set width of overview or make it expand horizontal like below*/
</style>
<script>
	
</script>
</head>

<body>

	<c:out value="${sort_max}"></c:out>
	<div class="item_view2" ondrop="drop(event)"
		ondragover="allowDrop(event)" id="view">
		<input type="hidden" id="view_no" name="view_no" value="99" />
<c:forEach items="${list}" var="com_staffVO">
			<c:set var="team_nm" value="${com_staffVO.class_nm}"></c:set>
			<c:set var="st_sort" value="${com_staffVO.st_sort}"></c:set>
			<c:if test="${st_sort eq 99}">
				<div draggable="true" ondragstart="drag(event)" ondrop="item()" id="${com_staffVO.st_no}" class="item">${com_staffVO.usr_nm}
					<input id='st_no' name='st_no' class='st_no' value='${com_staffVO.st_no}' type='hidden' />
					<input id='st_sort' name='st_sort' class='st_sort' value='${com_staffVO.st_sort}' type='hidden' />
				</div>

			</c:if>
		</c:forEach>
		
	</div>
	<div class="body-margin ">
		<c:set var="team_cd" value="${team_cd}" />
		<c:choose>
			<c:when test="${team_cd eq 'T00'}">
				<div class="item_view ">
					<div class="item_text">
						<h4>${team_nm}</h4>
					</div>
					<div class="item_list">
						<table class="table" id="tb_list_0" border="">
							<tbody>

								<tr id="tr_0">
									<td id="td_0" class="member_top" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="0" /></td>
								</tr>
								<tr id="tr_1">
									<td id="td_1" class="member_top" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="1" /></td>
								</tr>
								<tr id="tr_2">
									<td id="td_2" class="member_top" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="2" /></td>
								</tr>
								<c:forEach items="${list}" var="com_staffVO">
									<script>
										var sort = ${com_staffVO.st_sort};
										$("#tr_"+sort).find(".member_top").append("<div  draggable='true' ondragstart='drag(event)' id='${com_staffVO.st_no}' class='item'>${com_staffVO.usr_nm}<input id ='st_no' name = 'st_no' class ='st_no' value ='${com_staffVO.st_no}' type='hidden'/><input id ='st_sort' name = 'st_sort' class ='st_sort' value ='${com_staffVO.st_sort}' type='hidden'/></div>");

									</script>
								</c:forEach>
							</tbody>
						</table>
						<!--	<input class="plus-button" type="button" name="button"
							onclick="add_item_0()"></input>-->
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="item_view ">
					<div class="item_text">
						<h4>${team_nm}</h4>
					</div>
					<div class="item_list">
						<table class="table" id="tb_list" border="">
							<thead>
								<tr id="tr_0" class="member_top">
									<td id="td_0" colspan="2" class="member_top"
										ondrop="drop(event)" ondragover="allowDrop(event)"><input
										type="hidden" id="view_no" name="view_no" value="0" /></td>
									</td>
								</tr>
							</thead>
							<tbody>
								<tr id="tr_1">
									<td id="td_1" class="member_sub" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="1" /></td>
									<td id="td_2" class="member_sub" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="2" /></td>
								</tr>
								<tr id="tr_2">
									<td id="td_3" class="member_sub" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="3" /></td>
									<td id="td_4" class="member_sub" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="4" /></td>
								</tr>
								<tr id="tr_3">
									<td id="td_5" class="member_sub" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="5" /></td>
									<td id="td_6" class="member_sub" ondrop="drop(event)"
										ondragover="allowDrop(event)"><input type="hidden"
										id="view_no" name="view_no" value="6" /></td>
								</tr>
							</tbody>
							<script>
								var x = 1;
						
								function add_item() {
									var i = 6;
									var value = 0;
									var t_1 = 1 + (i * x);
									var t_2 = 2 + (i * x);
									var t_3 = 3 + (i * x);
									var t_4 = 4 + (i * x);
									var t_5 = 5 + (i * x);
									var t_6 = 6 + (i * x);
						
									var tr_0 = document.getElementById("tr_0");
									var tr_1 = document.getElementById("tr_1");
									var tr_2 = document.getElementById("tr_2");
									var tr_3 = document.getElementById("tr_3");
									var table = document.getElementById("tb_list");
									// alert("tb_list_"+value);
									var row = table.rows.length;
									if (row > 9)
										return alert("10개이상 안됨");
									false;
						
									// 개수당+6
									if (t_6 == 97) {
										alert("초과 불가");
									}
									var cell_1 = tr_1.insertCell(-1);
									cell_1.innerHTML = "|";
						
									var cell_1 = tr_1.insertCell(-1);
									cell_1.setAttribute('id', "td_"+t_1);
									cell_1.setAttribute('class', "member_sub")
									cell_1.setAttribute('ondrop', "drop(event)");
									cell_1.setAttribute('ondragover', "allowDrop(event)");
									cell_1.setAttribute('ondragover', "allowDrop(event)");
						
									cell_1.innerHTML = "<input type='hidden' id='view_no' name='view_no' value='"+t_1+"' />";
											
									var cell_1 = tr_1.insertCell(-1);
									cell_1.setAttribute('id', "td_"+t_2);
									cell_1.setAttribute('class', "member_sub")
									cell_1.setAttribute('ondrop', "drop(event)");
									cell_1.setAttribute('ondragover', "allowDrop(event)");
						
									cell_1.innerHTML = "<input type='hidden' id='view_no' name='view_no' value='"+t_2+"' />";
						
									var cell_2 = tr_2.insertCell(-1);
									cell_2.innerHTML = x;
						
									var cell_2 = tr_2.insertCell(-1);
									cell_2.setAttribute('id', "td_"+t_3);
									cell_2.setAttribute('class', "member_sub")
									cell_2.setAttribute('ondrop', "drop(event)");
									cell_2.setAttribute('ondragover', "allowDrop(event)");
						
									cell_2.innerHTML = "<input type='hidden' id='view_no' name='view_no' value='"+t_3+"' />";
									var cell_2 = tr_2.insertCell(-1);
									cell_2.setAttribute('id', "td_"+t_4);
									cell_2.setAttribute('class', "member_sub")
									cell_2.setAttribute('ondrop', "drop(event)");
									cell_2.setAttribute('ondragover', "allowDrop(event)");
						
									cell_2.innerHTML = "<input type='hidden' id='view_no' name='view_no' value='"+t_4+"' />";
						
									var cell_3 = tr_3.insertCell(-1);
									cell_3.innerHTML = "|";
						
									var cell_3 = tr_3.insertCell(-1);
									cell_3.setAttribute('id', "td_"+t_5);
									cell_3.setAttribute('class', "member_sub")
									cell_3.setAttribute('ondrop', "drop(event)");
									cell_3.setAttribute('ondragover', "allowDrop(event)");
						
									cell_3.innerHTML = "<input type='hidden' id='view_no' name='view_no' value='"+t_5+"' />";
									var cell_3 = tr_3.insertCell(-1);
									cell_3.setAttribute('id', "td_"+t_6);
									cell_3.setAttribute('class', "member_sub")
									cell_3.setAttribute('ondrop', "drop(event)");
									cell_3.setAttribute('ondragover', "allowDrop(event)");
						
									cell_3.innerHTML = "<input type='hidden' id='view_no' name='view_no' value='"+t_6+"' />";
						
									x++;
						
									}
								</script>
							<script>
							var sort_max=${sort_max};
							
							var innerClick = Math.round(sort_max /6)+1;
								for (i = 1; i < innerClick; i++) {
									add_item();
								}			
								 
							</script>

							<c:forEach items="${list}" var="com_staffVO">
								<script>
									var sort = ${com_staffVO.st_sort};

									
									$("#td_"+sort).append(
											"<div draggable='true' ondragstart='drag(event)' id='${com_staffVO.st_no}' class='item'>${com_staffVO.usr_nm}<input id ='st_no' name = 'st_no' class ='st_no' value ='${com_staffVO.st_no}' type='hidden'/><input id ='st_sort' name = 'st_sort' class ='st_sort' value ='${com_staffVO.st_sort}' type='hidden'/></div>");

								</script>
							</c:forEach>
						</table>
					</div>
					<input class="plus-button" type="button" name="button"
						onclick="add_item()"></input>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	<div class="bottom-button">
		<div class="back-button" id="back">뒤로가기</div>
		<div class="save-button" id="btnSave">저장하기</div>
	</div>
	<!-- Save / Back-->
	<script>
	  $(document).ready(function () {
		  $("#btnSave").click(function () {
              var jsonArr = new Array();

              for (var i = 0; i < $(".st_sort").length; i++) {
                  var jsonObj = new Object();
                  jsonObj.st_no = $(".st_no").eq(i).val();
                  jsonObj.st_sort = $(".st_sort").eq(i).val();
                  jsonArr.push(jsonObj);
              }
               $.ajax({
                  url: '/staff/sortListUpdate/0',
                  type: 'PUT',
                  headers: {
                      "Content-Type": "application/json",
                      "X-HTTP-Method-Override": "PUT"
                  },
                  dataType: 'text',
                  data: JSON.stringify(jsonArr),

                  success: function (data) {
                      if (data == 'SUCCESS') {
                          alert("수정 되었습니다.");
                          location.reload();
                      }
                  },

                  error: function (request, status, error) {
                      alert("수정 실패 되었습니다.");
                      //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                  }
              });
          });
		  
		  $("#back").on("click",function() {
				self.location = "/staffboard/sortStaff?page=1&perPageNum=10";
			});
	     });
	</script>

	<!-- innerHtml -->


	<!-- DragDrop -->
	<script type="text/javascript">
	 $(document).ready(function () {
				
	$(".item").droppable({
			disabled: "true"
			});
	 
	 });
		function allowDrop(ev) {
			ev.preventDefault();

		}

		function drag(ev) {
			var a = ev.dataTransfer.setData("text", ev.target.id);

		}

		function drop(ev) {
			ev.preventDefault();
			if(ev.target.className == "item"){
				ev.target.appendChild(document.getElementById());
			}
			if(ev.target.id != "view"){
				var count =$(ev.target).find(".item").length;
				if(count > 0){
					ev.target.appendChild(document.getElementById());
					//alert("NOT");
				}
				else{
				var data = ev.dataTransfer.getData("text");
				var view =  ev.target.id;
				var view_no = $("#"+view).find("#view_no").val();
				$("#"+data).find("input[id=st_sort]:hidden").val(view_no);
				//alert("oK");
				}
				
			}
			else
				
			var data = ev.dataTransfer.getData("text");
			//	alert(data);
			//alert(ev.target.id);
			var view =  ev.target.id;
			var view_no = $("#"+view).find("#view_no").val();
			//var view_no = $(ev.target.tagName).children().val();
			$("#"+data).find("input[id=st_sort]:hidden").val(view_no);
				
			ev.target.appendChild(document.getElementById(data));
			
	
			
	
		}
		
		function item() {
			
			return false;
			
		}


	</script>
</body>

</html>