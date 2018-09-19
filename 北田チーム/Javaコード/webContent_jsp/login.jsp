<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form method="post" action="/ResourceManagement/ControllerServlet">
<h2>ログイン</h2>
会員コード<input type="text" name="EMPID"><br><br>
パスワード<input type="text" name="PASSWD"><br>
<input type="hidden" name="COMMAND" value="LOGIN"><br>

<input type="submit" name="login" value="ログイン">
</form>

</body>
</html>