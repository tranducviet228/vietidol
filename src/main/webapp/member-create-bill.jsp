<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/sp/member/createbill" method="POST">
            <div>
                <Label>nhập id đơn hàng: <input type="text" name="id"
                    required autofocus placeholder="nhập id đơn hàng">
                </Label>
            </div>
            <div>
                <Label>số lượng sản phẩm:</Label> <input type="text" name="quantity"
                    placeholder="nhập vào số lượng">
            </div>
            <div>
                <Label>giá sản phẩm:</Label> <input type="text" name="price"
                    placeholder="nhập vào giá tiền">
            </div>
            <div>
                <Label>Ngày mua:</Label>
                <input type="text" name="date">
            </div>
            <div>
                <Label>id sản phẩm</Label> <input type="text" name="idproduct"
                    placeholder="nhập id sản phẩm">
            </div>
            <div>
                <button type="submit">Thêm</button>
            </div>
    </form>
</body>
</html>