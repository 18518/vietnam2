<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約照会画面</title>
<body><h2>予約照会画面</h2>
</head>
<body>

<form method="get" action="/ResourceManagement/ControllerServlet">
予約番号<input type="text"name="RESERVEID" size="20" maxlength="20"><br>


		<input type="submit" name="referDetail" value="照会">
		<input type="hidden" name="COMMAND" value="referDetail"><br>
	</form>
	<form>
		method="post" action="/ResourceManagement/ControllerServlet">
		<input type="submit" name="MENU" value="メニュー">
		<input type="hidden"name="COMMAND" value="MENU"><br>
	</form>
</body>
</html>