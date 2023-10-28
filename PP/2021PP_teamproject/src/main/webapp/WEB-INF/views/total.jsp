<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycompany.my.subjectuser.SubjectUserDAO, com.mycompany.my.board.SubjectDAO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>

<style>
* {
	box-sizing: border-box;
}
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}
/* Style the side navigation */
.sidenav {
	height: 100%;
	width: 200px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
}
/* Side navigation links */
.sidenav a {
	color: white;
	padding: 16px;
	text-decoration: none;
	display: block;
}
/* Change color on hover */
.sidenav a:hover {
	background-color: #ddd;
	color: black;
}
/* Style the content */
.content {
	margin-left: 200px;
	padding-left: 20px;
}
</style>

<style>
#list {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}
#list td, #list th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}
#list tr:nth-child(even) {
	background-color: #f2f2f2;
}
#list tr:hover {
	background-color: #ddd;
}
#list th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: black;
	color: white;
}
.content {
	margin-left: 200px;
	padding-left: 20px;
}
</style>
</head>
<body>

	<h1>게시판</h1>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div class="content">
		<h2>졸업학점계산기</h2>
		<table id="list" width="90%">
			<tr>
				<th>영역</th>
				<th>필요 학점</th>
				<th>이수 학점</th>
			</tr>
			<tr>
				<td>신앙 및 세계관</td>
				<td>9</td>
				<td>${list.one}</td>
			</tr>
			<tr>
				<td>인성 및 리더십</td>
				<td>6</td>
				<td>${list.two}</td>
			</tr>
			<tr>
				<td>영어1</td>
				<td>3~12</td>
				<td>${list.three}</td>
			</tr>
			<tr>
				<td>수학 및 기초과학</td>
				<td>18</td>
				<td>${list.four}</td>
			</tr>
			<tr>
				<td>ICT융합기초</td>
				<td>2</td>
				<td>${list.five}</td>
			</tr>
			<tr>
				<td>전문 교양</td>
				<td>5</td>
				<td>${list.six}</td>
			</tr>
			<tr>
				<td>전공(설계)</td>
				<td>60(12)</td>
				<td>${list.major}(${list.major_design})</td>
			</tr>
			<tr>
				<td>합계</td>
				<td>130</td>
				<td>${list.total}</td>
			</tr>
		</table>
		<br /> 졸업심사결과 : ${list.pass}
	</div>



</body>
</html>