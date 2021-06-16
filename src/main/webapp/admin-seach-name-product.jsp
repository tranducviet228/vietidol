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
	<form action="/sp/admin/seachnameproduct" method="GET">
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
				<th>Price</th>
				<th>Quantity</th>
				<th>NameCategory</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${listP}">
				<tr>
					<th>${product.getId()}</th>
					<th>${product.getName()}</th>
					<th>${product.getPrice()}</th>
					<th>${product.getQuantity()}</th>
					<th>${product.getCategory().getName()}</th>
					<th><a href="/sp/admin/deleteProduct?id=${product.getId()}">Delete</a>|<a
						href="/sp/admin/updateproduct?id=${product.getId()}">Edit</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>