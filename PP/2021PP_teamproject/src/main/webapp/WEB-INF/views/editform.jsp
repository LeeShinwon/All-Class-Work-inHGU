<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page
	import="com.mycompany.my.subjectuser.SubjectUserDAO, com.mycompany.my.board.SubjectDAO,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="content">
<h2>수정</h2>


	<form:form commandName="subjectVO" action="../editok" method="post" id="list">
		<form:hidden path="seq" />
		<table>
			<tr>
				<tr><td>아이디</td><td><form:input path="userid"/></td></tr>
				<tr><td>영역1</td><td><form:input path="area1"/></td></tr>
				<tr><td>영역2</td><td><form:input path="area2"/></td></tr>
				<tr><td>영역3</td><td><form:input path="area3"/></td></tr>
				<tr><td>과목명</td><td><form:input path="subname"/></td></tr>
				<tr><td>이수구분</td><td><form:input path="separ"/></td></tr>
				<tr><td>학점</td><td><form:input path="credit"/></td></tr>
				<tr><td>BSM</td><td><form:input path="bsm"/></td></tr>
				<tr><td>전문교양</td><td><form:input path="pro"/></td></tr>
				<tr><td>설계학점</td><td><form:input path="design"/></td></tr>	
				<tr><td>학기</td><td><form:input path="semester"/></td></tr>	
			</tr>
</table>
<input type="submit" value="수정하기" />

<input type="button" value="취소하기" onclick="history.back()" />

</form:form>
</div>

</body>
</html>