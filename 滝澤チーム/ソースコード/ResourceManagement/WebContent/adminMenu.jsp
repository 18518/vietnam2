<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="build.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
.inputstl {
    padding: 9px;
    border: solid 1px #460023;
    outline: 0;
    background: -webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #FFCEE7), to(#FFFFFF));
    background: -moz-linear-gradient(top, #FFFFFF, #FFCEE7 1px, #FFFFFF 25px);
    box-shadow: rgba(0,0,0, 0.1) 0px 0px 8px;
    -moz-box-shadow: rgba(0,0,0, 0.1) 0px 0px 8px;
    -webkit-box-shadow: rgba(0,0,0, 0.1) 0px 0px 8px;

    }

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー画面</title>
</head>
<body>
<h2>メニュー画面</h2>
	こんにちは、${employeeDTO.name}さん
	<br><br>

	<a href="/ResourceManagement/ControllerServlet?COMMAND=AVAILABLE">空き状況照会/予約"</a>
	<br><br>

	<a href="/ResourceManagement/ControllerServlet?COMMAND=REFER">予約照会/取消</a>
	<br><br>

	<a href="/ResourceManagement/ControllerServlet?COMMAND=ADDRESOURCE">リソースの追加</a>
	<br><br>

	<a href="/ResourceManagement/ControllerServlet?COMMAND=DELETERESOURCE">リソースの削除</a>
	<br><br>
	<input value="戻る" onclick="history.back();" type="button">

	<hr>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<input type="submit" name="LOGOFF" value="ログオフ"> <input
			type="hidden" name="COMMAND" value="LOGOFF"><br>
	</form>
</body>
</html>