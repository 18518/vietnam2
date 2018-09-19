<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー画面</title>
</head>
<jsp:useBean id="user" class="dto.EmployeeDTO" scope="session" />

<body>

	<h2>メニュー画面</h2>
	こんにちは、<jsp:getProperty name="user" property="name" />さん
	<br><br>

	<a href="/ResourceManagement/ControllerServlet"
		name="AVAILABLERESOURCES">空き状況照会/予約</a>
	<br><br>
	<a href="/ResourceManagement/ControllerServlet" name="CANCEAL">予約照会/取消</a>
	<br><br>

	<hr>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<input type="submit" name="LOGOFF" value="ログオフ"> <input
			type="hidden" name="COMMAND" value="LOGOFF"><br>
	</form>

</body>
</html>