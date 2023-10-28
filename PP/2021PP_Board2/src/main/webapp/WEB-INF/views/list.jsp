<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycompany.my.subjectuser.SubjectUserDAO, com.mycompany.my.board.SubjectDAO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
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
<link href="${path}/resources/css/simple-sidebar.css" rel="stylesheet" >
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
<script src="${path}/js/index.js"></script>

</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand selected_menu"><a
					href="/subjectuser/list">졸업 학점 관리</a></li>
				<li><a href="/course1">1학기</a></li>
				<li><a href="/course2">2학기</a></li>
				<li><a href="/course3">3학기</a></li>
				<li><a href="/course4">4학기</a></li>
				<li><a href="/course5">5학기</a></li>
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
						class="icon-reorder"></i></a> 기본학적
				</h1>
			</div>
			<!-- Keep all page content within the page-content inset div! -->
			<div class="page-content inset">

				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">이름</label> <input
							class="form-control" type="text" value=""> <small
							id="emailHelp" class="form-text text-muted">이름을 적어주세요.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">학년</label> <select
							class="form-control">
							<option>1학년</option>
							<option>2학년</option>
							<option>3학년</option>
							<option>4학년</option>
						</select> <small id="emailHelp" class="form-text text-muted">현재 학년을
							적어주세요.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">학기</label> <select
							class="form-control">
							<option>1학기</option>
							<option>2학기</option>
							<option>3학기
								</optionselected>
							<option>4학기</option>
							<option>5학기</option>
							<option>6학기</option>
							<option>7학기</option>
							<option>8학기</option>
							<option>9학기 이상</option>
						</select> <small id="emailHelp" class="form-text text-muted">총 학기를
							적어주세요.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">학부</label> <select
							class="form-control">
							<option>전산전자공학부</option>
							<option>공간환경시스템공학부</option>
							<option>기계제어공학부</option>
							<option>콘텐츠융합디자인학부</option>
							<option>커뮤니케이션학부</option>
							<option>생명공학부</option>
							<option>ICT융합학부</option>
							<option>경영경제학부</option>
							<option>법학부</option>
						</select> <small id="emailHelp" class="form-text text-muted">학부를
							입력해주세요.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" value="" placeholder="Enter email">
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">잔여 학점</label> <input
							class="form-control" type="text" value="130" readonly> <small
							id="emailHelp" class="form-text text-muted">졸업 전까지 채워야하는
							목표 학점</small>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1"
							checked> <label class="form-check-label"
							for="exampleCheck1">Check me out</label>
					</div>
					<button type="submit" class="btn btn-primary"
						onclick="alert('수정되었습니다!')">수정하기</button>
				</form>

			</div>
		</div>

	</div>

	<!-- JavaScript -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.js"></script>

	<!-- Custom JavaScript for the Menu Toggle -->
	<script>
		$(document)
				.ready(
						function() {
							document.getElementById("header").innerHTML = '<object type="text/html" data="header.html"></object>';
						})

		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("active");
		});
	</script>
</body>
</html>