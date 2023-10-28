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
				<li><a href="/course5">5학기</a></li>
				<li><a href="/course6">6학기</a></li>
				<li><a href="/course7">7학기</a></li>
				<li><a href="/course8">8학기</a></li>
				<li class="selected_menu"><a href="/course9">졸업학점</a></li>
			</ul>
		</div>

		<!-- Page content -->
		<div id="page-content-wrapper">
			<div class="content-header">
				<h1>
					<a id="menu-toggle" href="#" class="btn btn-default"><i
						class="icon-reorder"></i></a> 총 학점 계산
				</h1>
			</div>
			<!-- Keep all page content within the page-content inset div! -->
			<div class="page-content inset">
				<table class="table" id="mytable">
					<thead>
						<tr>
							<th scope="col" width="40%">학기</th>
							<th scope="col" width="40%">학기별 학점</th>
							<th scope="col" width="10%">초기화</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='1학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='5' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='2학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='5' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='3학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='0' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='4학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='0' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='5학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='0' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='6학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='0' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='7학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='0' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="학기"
								id='title' value='8학기'
								style="border-style: none; box-shadow: none; background-color: white;"
								readonly /></td>
							<td><input type="number" class="form-control"
								placeholder="학점" id="study-score" value='0' readonly /></td>
							<td><button type="button" class="btn btn-light"
									onclick='reset(this)'>초기화</button></td>
						</tr>
					</tbody>
				</table>
				<div
					style="border-top: 1px solid #e3e3e3; padding-top: 1rem; width: 100%; text-align: right;">
					총 학점 : <input type="number" class="form-control" id="total"
						placeholder="총 학점" value="10"
						style="width: auto; display: inline-block;" readonly>
				</div>
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