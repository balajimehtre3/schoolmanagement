<%@page import="School_Management.Teacher"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="School_Management.Student"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delet Teacher Details</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 3px solid #bbb;
}

li:last-child {
	border-right: 3px solid #bbb;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 34px 36px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
	align-content: left;
}

.active {
	background-color: #04AA6D;
}
</style>
<style type="text/css">
td:hover {
	content-align: center;
	color: green;
	font-size: 23px;
}

th {
	align: center;
	color: red;
}
</style>

</head>
<body>
	<div>
		<ul>
			<li><a href="AddTeacher.html">Add Teacher</a></li>
			<li><a href="UpdateTeacher.jsp">Update Teacher</a></li>
			<li><a href="DeletTeacher.jsp">Delete Teacher</a></li>
			<li><a href="ViewTeacher.jsp">View Teacher</a></li>
			<li><a href="Final.html">Main Menu</a></li>
		</ul>
	</div>
	<br>
	<div>
		<h1 align="center">*** Teacher Details ***</h1>

		<%
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("School_Management");
		%>
		<%
		EntityManager em = emf.createEntityManager();
		%>
		<%
		Query q = em.createQuery("select a from Teacher a");
		%>
		<%
		List<Teacher> ls = q.getResultList();
		%>

		<table align="center" cellpadding="12px" border="10px">

			<th>ID</th>
			<th>NAME</th>
			<th>SUBJECT</th>
			<th>SALARY</th>

			<%
			for (Teacher s : ls) {
			%>
			<form action="DeletTeacher" method="post">
				<tr align="center">
					<td><input type="hidden" name="ID" value="<%=s.getId()%>"><%=s.getId()%></td>
					<td><input type="hidden" name="NAME" value="<%=s.getName()%>"><%=s.getName()%></td>
					<td><input type="hidden" name="STREAM"
						value="<%=s.getSubject()%>"><%=s.getSubject()%></td>
					<td><input type="hidden" name="FESS" value="<%=s.getSalarys()%>"><%=s.getSalarys()%></td>
					<td><input type="submit" value="Delete"></td>
				</tr>
			</form>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>