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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>


	<style>
		* {
			margin: 0;
			padding: 0;
			transition: all 0.3s ease-out;
		}

		td {
			background: white;
			border: 1px solid #ccc;
			padding: 10px;
		}

		body {
			background: url(/resources/assets/images/sort/background-img.jpg) 0 0 no-repeat;
			background-size: cover;
		}

		.body-margin {
			padding: 20px;
			padding-left: 190px;
		}

		.item {
			display: inline-block;
			color: white;
			width: 125px;
			padding: 10px 0;
			margin: 2px;
			text-align: center;
			background-color: #ff9e47;
		}

		.item_text {
			background: #3a9884;
			text-align: center;
			color: white;
			padding: 5px;
		}

		.item_text h4 {
			border: 1px solid rgba(255, 255, 255, 0.45);
			padding: 20px;
			font-weight: 100;
			font-size: 20px;
		}

		.item_list {
			padding: 10px;
			padding-bottom: 0;
		}

		.item_view {
			float: left;
			margin: 10px;
			text-align: center;
			background: rgba(255, 255, 255, 0.88);
		}

		.item_view2 {
			position: fixed;
			top: 0;
			left: 0;
			width: 135px;
			padding: 15px;
			height: 100%;
			background: rgba(0, 0, 0, 0.38);

		}

		.member_top {
			width: 300px;
			height: 80px;
			border: 1px solid #ccc;
			border-radius: 3px;
			background: white;
		}

		.member_sub {
			width: 150px;
			height: 60px;
			border: 1px solid#ccc;
			border-radius: 3px;
			background: white;
		}

		.table {
			word-break: break-all;
			padding: 20;
			border: none;
		}

		.plus-button {
			width: 30px;
			height: 30px;
			display: block;
			margin: 0 auto;
			margin-top: 20px;
			margin-bottom: 20px;
			border: 1px solid #e30015;
			background: url(/resources/assets/images/sort/plus-icon.png) 5px 5px no-repeat;
			background-color: white;
		}

		.plus-button:hover {
			background: url(/resources/assets/images/sort/plus-icon2.png) 5px 5px no-repeat;
			background-color: #e30015;
		}

		.bottom-button {
			display: inline-block;
			position: fixed;
			bottom: 20px;
			left: 50%;
			margin-left: -154px;
			background: rgba(0, 0, 0, 0.38);
			padding: 10px 30px;
			border-radius: 30px;
		}

		.back-button {
			display: inline-block;
			float: left;
			background: url(/resources/assets/images/sort/back-white.png) 0 0 no-repeat;
			color: white;
			padding: 7px 0 7px 45px;
			margin-right: 30px;
			cursor: pointer;
		}

		.back-button:hover {
			color: #ff9e47;
			background: url(/resources/assets/images/sort/back-over.png) 0 0 no-repeat;
		}

		.save-button {
			display: inline-block;
			float: left;
			background: url(/resources/assets/images/sort/save-white.png) 0 0 no-repeat;
			color: white;
			padding: 7px 0 7px 45px;
			cursor: pointer;
		}

		.save-button:hover {
			color: #ff9e47;
			background: url(/resources/assets/images/sort/save-over.png) 0 0 no-repeat;
		}

		/*Horizontal scrollbar - set width of overview or make it expand horizontal like below*/

	</style>
	<script>
		function allowDrop(ev) {
			ev.preventDefault();

		}

		function drag(ev) {
			var a = ev.dataTransfer.setData("text", ev.target.id);
		}

		function drop(ev) {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text");
			alert(data);

			ev.target.appendChild(document.getElementById(data));
			var abc = ev.target.getElementById();
			alert(abc);


		}

	</script>
</head>

<body>
					<table class="table table-hover mails m-0 table table-actions-bar">
							<thead>
								<tr>
									<th>부서</th>
									<th>팀</th>
									<th>직위</th>
									<th>이름</th>

								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="com_staffVO">
									
									<tr class="">
										
										
										<td id="real_use_dep_nm${com_staffVO.st_no}">
											${com_staffVO.real_use_dep_nm}</td>

										<td id="class_nm${com_staffVO.st_no}">${com_staffVO.class_nm}</td>

										<td>${com_staffVO.posit_nm}</td>

										<td id="usr_nm${com_staffVO.st_no}">${com_staffVO.usr_nm}</td>
										<td>${com_staffVO.st_sort}</td>
										<td>${com_staffVO.team_cd}</td>

									

									
									</tr>
								</c:forEach>
							</tbody>
						</table>



	<div class="item_view2" ondrop="drop(event)" ondragover="allowDrop(event)">
	<c:forEach items="${list}" var="com_staffVO">
		<div draggable="true" ondragstart="drag(event)" id="drag1" class="item">${com_staffVO.usr_nm}</div>
	</c:forEach>
	</div>
	<div class="body-margin ">
		<div class="item_view ">
			<div class="item_text">
				<h4>Item0</h4>
			</div>
			<div class="item_list">
				<table class="table" id="tb_list_0" border="">
					<tbody>
						<tr id="tr_0">
							<td class="member_top" ondrop="drop(event)" ondragover="allowDrop(event)">
								<input type="text" hidden value="1">
								<p id= "top"></p>]
							</td>
						</tr>
					</tbody>
				</table>
				<input class="plus-button" type="button" name="button" onclick="add_item_0()"></input>
			</div>
		</div>
		<div class="item_view ">
			<div class="item_text">
				<h4>Item1</h4>
			</div>
			<div class="item_list">
				<table class="table" id="tb_list_1" border="">
					<thead>
						<tr id="tr_0" class="member_top">
							<td colspan="2" class="member_top" ondrop="drop(event)" ondragover="allowDrop(event)">
								<input type="text" hidden value="1">
							</td>
						</tr>
					</thead>
					<tbody>
						<tr id="tr_1">
							<td class="member_sub" ondrop="drop(event)" ondragover="allowDrop(event)">
								<p id="2"></p>
							</td>
							<td class="member_sub" ondrop="drop(event)" ondragover="allowDrop(event)">
								<p id="3"></p>
							</td>
						</tr>
						<tr id="tr_2">
							<td class="member_sub" ondrop="drop(event)" ondragover="allowDrop(event)">
								<p id="4"></p>
							</td>
							<td class="member_sub" ondrop="drop(event)" ondragover="allowDrop(event)">
								<p id="5"></p>
							</td>
						</tr>
						<tr id="tr_3">
							<td class="member_sub" ondrop="drop(event)" ondragover="allowDrop(event)">
								<p id="6"></p>
							</td>
							<td class="member_sub" ondrop="drop(event)" ondragover="allowDrop(event)">
								<p id="7"></p>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<input class="plus-button" type="button" name="button" onclick="add_item_1(1)"></input>
		</div>

	</div>
	<div class="bottom-button">
		<div class="back-button">
			뒤로가기
		</div>
		<div class="save-button">
			저장하기
		</div>
	</div>
	<script type="text/javascript">
		v
		
		function add_item_0() {
			var x = 1;
			var table = document.getElementById("tb_list_0");
			var row = table.rows.length;
			alert(row);
			if (row > 2)
				return alert("2개이상 안됨");
			table.insertRow(-1).insertCell().setAttribute('class', "member_top");
			table.setAttribute('ondrop', "drop(event)");
			table.setAttribute('ondragover', "allowDrop(event)");
			x++;
		}

	
		function add_item_1(value) {
			var x = 1;
			var i = 6;
			var value = 0;
			var t_1 = 2 + (i * x);
			var t_2 = 3 + (i * x);
			var t_3 = 4 + (i * x);
			var t_4 = 5 + (i * x);
			var t_5 = 6 + (i * x);
			var t_6 = 7 + (i * x);

			var tr_0 = document.getElementById("tr_0");
			var tr_1 = document.getElementById("tr_1");
			var tr_2 = document.getElementById("tr_2");
			var tr_3 = document.getElementById("tr_3");
			var table = document.getElementById("tb_list_" + value);
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
			cell_1.setAttribute('id', t_1);
			cell_1.setAttribute('class', "member_sub")
			cell_1.setAttribute('ondrop', "drop(event)");
			cell_1.setAttribute('ondragover', "allowDrop(event)");

			// cell_1.innerHTML = "'" + t_1 + "'<p id='" + t_1 + "'></p><input type='button' name='button' onclick='add_item()'>'" + t_1 + "'</input>";
			var cell_1 = tr_1.insertCell(-1);
			cell_1.setAttribute('id', t_2);
			cell_1.setAttribute('class', "member_sub")
			cell_1.setAttribute('ondrop', "drop(event)");
			cell_1.setAttribute('ondragover', "allowDrop(event)");

			// cell_1.innerHTML = "'" + t_2 + "'<p id='" + t_2 + "'></p><input type='button' name='button' onclick='add_item()'>'" + t_2 + "'</input>";

			var cell_2 = tr_2.insertCell(-1);
			cell_2.innerHTML = x;


			var cell_2 = tr_2.insertCell(-1);
			cell_2.setAttribute('id', t_3);
			cell_2.setAttribute('class', "member_sub")
			cell_2.setAttribute('ondrop', "drop(event)");
			cell_2.setAttribute('ondragover', "allowDrop(event)");

			// cell_2.innerHTML = "'" + t_3 + "'<p id='" + t_3 + "'></p> <button type='button' name='button'>추가</button><button type='button' name='button'>삭제</button>";
			var cell_2 = tr_2.insertCell(-1);
			cell_2.setAttribute('id', t_4);
			cell_2.setAttribute('class', "member_sub")
			cell_2.setAttribute('ondrop', "drop(event)");
			cell_2.setAttribute('ondragover', "allowDrop(event)");

			// cell_2.innerHTML = "'" + t_4 + "'<p id='" + t_4 + "'></p> <button type='button' name='button'>추가</button><button type='button' name='button'>삭제</button>";

			var cell_3 = tr_3.insertCell(-1);
			cell_3.innerHTML = "|";

			var cell_3 = tr_3.insertCell(-1);
			cell_3.setAttribute('id', t_5);
			cell_3.setAttribute('class', "member_sub")
			cell_3.setAttribute('ondrop', "drop(event)");
			cell_3.setAttribute('ondragover', "allowDrop(event)");

			// cell_3.innerHTML = "'" + t_5 + "'<p id='" + t_5 + "'></p> <button type='button' name='button'>추가</button><button type='button' name='button'>삭제</button>";
			var cell_3 = tr_3.insertCell(-1);
			cell_3.setAttribute('id', t_6);
			cell_3.setAttribute('class', "member_sub")
			cell_3.setAttribute('ondrop', "drop(event)");
			cell_3.setAttribute('ondragover', "allowDrop(event)");

			// cell_3.innerHTML = "'" + t_6 + "'<p id='" + t_6 + "'></p> <button type='button' name='button'>추가</button><button type='button' name='button'>삭제</button>";

			x++;

			// var cell = currentRow.insertCell();
			// cell.innerHTML = "<input id='btn' type ='button' value='Picture file' class='btn btn-danger'  onClick = 'BtnClick(" + row + ")'/><input id = 'file" + row + "' type='file' class='file_input_hidden' name='img[]' onChange='ChangeText(this, " + row + ")' accept='image/*' />";
		}

	
	</script>
</body>

</html>