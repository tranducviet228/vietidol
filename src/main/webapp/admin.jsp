<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang admin</title>
</head>
<body>
	<form action="/sp/admin/adduser" method="get">
		<div>
			<button type="submit"
				style="display: inline;; background-color: blue; padding: 5px; border-radius: 5px;">
				Adduser</button>
		</div>
	</form>
	<form action="/sp/admin/deleteuser" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: red; padding: 5px; border-radius: 5px;">
				Deleteuser</button>
		</div>
	</form>
	<form action="/sp/admin/updateUser" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: yellow; padding: 5px; border-radius: 5px;">
				Updateuser</button>
		</div>
	</form>
	<form action="/sp/admin/seachnameuser" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: green; padding: 5px; border-radius: 5px;">
				SeachName</button>
		</div>
	</form>
	<form action="/sp/admin/addProduct" method="get">
		<div>
			<button type="submit"
				style="display: inline;; background-color: blue; padding: 5px; border-radius: 5px;">
				AddProduct</button>
		</div>
	</form>
	<form action="/sp/admin/deleteProduct" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: red; padding: 5px; border-radius: 5px;">
				DeleteProduct</button>
		</div>
	</form>
	<form action="/sp/admin/updateProduct" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: yellow; padding: 5px; border-radius: 5px;">
				UpdateProduct</button>
		</div>
	</form>
	<form action="/sp/admin/seachnameproduct" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: green; padding: 5px; border-radius: 5px;">
				SeachNameProduct</button>
		</div>
	</form>
	<form action="/sp/admin/addCategory" method="get">
		<div>
			<button type="submit"
				style="display: inline;; background-color: blue; padding: 5px; border-radius: 5px;">
				AddCategory</button>
		</div>
	</form>
	<form action="/sp/admin/deleteCategory" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: red; padding: 5px; border-radius: 5px;">
				DeleteCategory</button>
		</div>
	</form>
	<form action="/sp/admin/updateCategory" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: yellow; padding: 5px; border-radius: 5px;">
				UpdateCategory</button>
		</div>
	</form>
	<form action="/sp/admin/seachnamecategory" method="get">
		<div>
			<button type="submit"
				style="display: inline-block; background-color: green; padding: 5px; border-radius: 5px;">
				SeachNameCategory</button>
		</div>
	</form>
</body>
</html>