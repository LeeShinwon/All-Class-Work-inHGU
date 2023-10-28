<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.my.subjectuser.SubjectUserDAO, com.mycompany.my.board.SubjectDAO,java.util.*"%>
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
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
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
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deleteok/' + id;
	}
	function go(semester){
		location.href=semester;
	}
	
	


</script>
</head>
<body>

<h1>게시판</h1>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="content">
<h2>졸업학점계산기</h2>
<table id="list" width="90%">
<tr>
	<th>아이디</th>
	<th>영역</th>
	<th>과목 명</th>
	<th>이수구분</th>
	<th>이수학점</th>
	<th>학기</th>
	<td>수정</td>
	<td>삭제</td>
	
</tr>
	
	<c:forEach items="${list}" var="u">
		<tr>
			<td>${u.userid}</td>
			<td>${u.area1}</td>
			<td>${u.subname}</td>
			<td>${u.separ}</td>
			<td>${u.credit}</td>
			<td>${u.semester}</td>

	
			
			<td><a href="editform/${u.seq}">수정 </a></td>
			<td><a href="javascript:delete_ok('${u.seq}')">삭제 </a></td>
		</tr>
	</c:forEach>
</table>
<br/><button type="button" onclick="location.href='add'">추가하기</button>

</div>



</body>
</html>