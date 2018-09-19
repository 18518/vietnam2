<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>予約取り消し完了画面</h2><br>
予約を取り消しました。<br>
<form method="get" action="/ResourceManagement/ControllerServlet">
	<input type ="hidden"name="COMMAND"value="MENU">
	<input type ="submit"name="MENU"value="メニュー" style="width: 57px; ">
</form><br>
</body>
</html>