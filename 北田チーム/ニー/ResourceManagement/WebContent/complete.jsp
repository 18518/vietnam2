<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約完了画面</title>
</head>
<body>


<form method= "post" action= "/ResourceManagement/ControllerServlet">
	<input type="submit" name="menu" value="メニュー"><br><br>
	<input type="hidden" name="COMMAND" value = "MENU">
</form>
</body>
</html>