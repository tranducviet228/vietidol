<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sp/admin/seachnamecategory" method="GET">
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
				<th>Id</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${list}">
				<tr>
					<th>${category.getId()}</th>
					<th>${category.getName() }</th>
					<th><a href="/sp/admin/deleteCategory?id=${category.getId()}">Delete</a>|<a
						href="/sp/admin/updatecategory?id=${category.getId()}">Edit</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>