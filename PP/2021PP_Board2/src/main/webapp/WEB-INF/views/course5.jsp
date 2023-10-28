<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycompany.my.subjectuser.SubjectUserDAO, com.mycompany.my.board.SubjectDAO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Schedule Program</title>

<!-- Bootstrap core CSS -->
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${path}/resources/css/simple-sidebar.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
<script src="${path}/resources/js/index.js"></script>

</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="/subjectuser/list">졸업 학점
						관리</a></li>
				<li><a href="/course1">1학기</a></li>
				<li><a href="/course2">2학기</a></li>
				<li><a href="/course3">3학기</a></li>
				<li><a href="/course4">4학기</a></li>
				<li class="selected_menu"><a href="/course5">5학기</a></li>
				<li><a href="/course6">6학기</a></li>
				<li><a href="/course7">7학기</a></li>
				<li><a href="/course8">8학기</a></li>
				<li><a href="/course9">졸업학점</a></li>
			</ul>
		</div>

		<!-- Page content -->
		<div id="page-content-wrapper">
			<div class="content-header">
				<h1>
					<a id="menu-toggle" href="#" class="btn btn-default"><i
						class="icon-reorder"></i></a> 5학기
				</h1>
			</div>
			<button type="button" class="btn btn-success" style="float: right;"
				onclick="addRow(this);">추가</button>
			<!-- Keep all page content within the page-content inset div! -->
			<div class="page-content inset">
				<table class="table" id="mytable">
					<thead>
						<tr>
							<th scope="col" width="40%">수업명</th>
							<th scope="col" width="30%">학점</th>
							<th scope="col" width="15%">저장</th>
							<th scope="col" width="15%">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="u">
							<tr>
								<td>${u.subname}</td>
								<td>${u.credit}</td>
								<td><button type="button" class="btn btn-primary"
										onclick="save(this);">저장</button></td>
								<td><button type="button" class="btn btn-danger"
										onclick="deleteRow(this);">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div
					style="border-top: 1px solid #e3e3e3; padding-top: 1rem; width: 100%; text-align: right;">
					5학기 총 학점 : <input type="number" class="form-control" id="total"
						placeholder="총 학점" value="0"
						style="width: auto; display: inline-block;" readonly>
				</div>
				<button type="button" class="btn btn-warning"
					onclick="alert('저장되었습니다!');">저장</button>
			</div>
		</div>

	</div>

	<!-- JavaScript -->
	<script src="${path}/resources/js/jquery-1.10.2.js"></script>
	<script src="${path}/resources/js/bootstrap.js"></script>

	<!-- Custom JavaScript for the Menu Toggle -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("active");
		});
	</script>
</body>
</html>