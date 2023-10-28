<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${path}/resources/css/simple-sidebar.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>

<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li class="sidebar-brand"><a href="/subjectuser/list">졸업 학점
				관리</a></li>
		<li class="selected_menu"><a href="/course1">1학기</a></li>
		<li><a href="/course2">2학기</a></li>
		<li><a href="/course3">3학기</a></li>
		<li><a href="/course4">4학기</a></li>
		<li><a href="/course5">5학기</a></li>
		<li><a href="/course6">6학기</a></li>
		<li><a href="/course7">7학기</a></li>
		<li><a href="/course8">8학기</a></li>
		<li><a href="/course9">졸업학점</a></li>
	</ul>
	<button type="button" class="btn btn-secondary btn-block"
		style="position: absolute; bottom: 0;">add</button>
</div>

<!-- JavaScript -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
</html>