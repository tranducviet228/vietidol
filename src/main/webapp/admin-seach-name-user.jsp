<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sp/admin/seachnameuser" method="GET">
		<div>
			<Label>Nhập tên tìm kiếm:</Label> <input type="text" name="name"
				placeholder="nhập name...">
		</div>
		<div>
			<button type="submit">OK</button>
		</div>
	</form>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>UerName</th>
				<th>Passwword</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${listU }">
				<tr>
					<th>${u.getId()}</th>
					<th>${u.getName()}</th>
					<th>${u.getUsername()}</th>
					<th>${u.getPassword()}</th>
					<th>${u.getRole()}</th>
					<th><a href="/sp/admin/deleteuser?id=${u.getId()}">Delete</a>|<a
						href="/sp/admin/updateuser?id=${u.getId()}">Edit</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>