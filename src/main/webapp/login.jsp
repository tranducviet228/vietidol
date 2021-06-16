<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>đăng nhập</title>
<link rel="stylesheet" href="/sp/style.css">
</head>
<body>
<form action="/sp/login" method="POST">
        <h2>Đăng nhập</h2>
        <br>
        <div class="user">
            <Label class="user-lable">Tên đăng nhập</Label>
            <input class="user-input" type="text" name="username" placeholder="Nhập tên đăng nhập">
        </div>
        <br>
        <div class="pass">
            <Label class="pass-lable">Mật khẩu</Label>
            <input class="pass-input" type="password" name="password" placeholder="Nhập mật khẩu">
        </div>
        <br>
        <div class="button">
            <Button name="Submit">Đăng nhập</Button>
        </div>
    </form>
</body>
</html>