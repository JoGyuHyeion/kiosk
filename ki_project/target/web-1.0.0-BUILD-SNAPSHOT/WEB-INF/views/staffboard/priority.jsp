<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                                        <li>
                                            <a href="#">디지털 조직도</a>
                                        </li>
                                        <li>
                                            <a href="#">기초설정</a>
                                        </li>
                                        <li class="active">직원 순위관리</li>
                                    </ol>
                                </div>
                                <h4 class="page-title">
                                    직원 순위관리
                                    <small>직원
                                        <code>순위관리</code> 할 수 있습니다.
                                    </small>
                                </h4>
                            </div>
                        </div>
                    </div>
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
                                                <input type="text" id="search-input" class="form-control" name="keyword" placeholder="Please Name">
                                                <input type='hidden' name='page' value="${cri.page}">
                                                <input type='hidden' name='perPageNum' value="${cri.perPageNum}">
                                                <input type='hidden' name='section_cd' value="${cri.section_cd}">
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
                                                <th>직원 순위</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                        <c:forEach items="${list}" var="com_staffVO">

                                            <tr class="">

                                                <td>
                                                    <img src="${pageContext.request.contextPath}${uploadPath}${com_staffVO.img_filenm}" alt="contact-img" title="contact-img"
                                                         class=" thumb-sm" onerror="this.src='/resources/assets/images/users/avatar-2.jpg'"
                                                         />
                                                </td>
                                                <td id="real_use_dep_nm${com_staffVO.st_no}">${com_staffVO.real_use_dep_nm}</td>
                                                <td id="class_nm${com_staffVO.st_no}">${com_staffVO.class_nm}</td>
                                                <td>${com_staffVO.posit_nm}</td>
                                                <td id="usr_nm${com_staffVO.st_no}">${com_staffVO.usr_nm}</td>
                                                <td>
                                                    <input type="number" min="1" max="50" class="form-control st_sort" size="3" value="${com_staffVO.st_sort}">
                                                    <input type='hidden' class='st_no' value="${com_staffVO.st_no}">
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td colspan="4">
                                                    <div class="form-group" style="text-align: center">
                                                        <button type="button" id="btnSave" class="btn btn-primary waves-effect w-md waves-light m-b-5">저장</button>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                                <!-- end table responsive -->
                            </div>
                            <!-- end card-box -->
                            <div class="text-right">
                                <ul class="pagination pagination-split m-t-0">

                                    <c:if test="${pageMaker.prev}">
                                        <li><a
                                                href="priority${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
                                    </c:if>

                                    <c:forEach begin="${pageMaker.startPage }"
                                               end="${pageMaker.endPage }" var="idx">
                                        <li
                                    <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                                    <a href="priority${pageMaker.makeSearch(idx)}">${idx}</a>
                                    </li>
                                </c:forEach>

                                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                    <li><a
                                            href="priority${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
                                </c:if>

                            </ul>
                        </div>
                    </div>
                    <!-- end col -->
                </div>
                <!-- end row -->
            </div>
            <!-- end card-box -->
        </div>
        <!-- end col -->
    </div>

    <script>

        $(document).ready(function () {
            
            $("#section_cd").change(function () {

                var section_cd = $("#section_cd option:selected").val();
                var url = "/staffboard/priority?section_cd=" + section_cd;
                location.href = url;
            });

            $("#team_cd").change(function () {

                var section_cd = $("#section_cd option:selected").val();
                var team_cd = $("#team_cd option:selected").val();
                var url = "/staffboard/priority?section_cd=" + section_cd + "&team_cd=" + team_cd;
                location.href = url;
            });
            
            var section_cd = "${param.section_cd}";
            $("#section_cd > option[value=" + section_cd + "]").attr("selected", true);

            $.getJSON("/staff/getTeams/" + section_cd, function (data) {
            	
                var str = "";
                console.log(data.length);
                console.log(data);
                str += "<option value=none>전체</option>";
                $(data).each(function () {
                    str += "<option value=\"" + this.team_cd + "\">" + this.team_nm + "</option>";
                    console.log(str);
                });


                $("#team_cd").html(str);
                var team_cd = "${param.team_cd}";
                if (team_cd != "") {
                    $("#team_cd").val(team_cd);
                }
            });

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
            
            $('#searchBtn').on("click",function(event) {
				self.location = "priority"
				+ '${pageMaker.makeQuery(1)}'
				+ "&section_cd="
				+ $("select option:selected").val()
				+ "&keyword="
				+ $('#search-input').val();
			});
            
        });
    </script>
    <!-- end row -->
    <%@include file="../include/footer.jsp"%>