<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="build.css">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
.inputstl {
	padding: 9px;
	border: solid 1px #460023;
	outline: 0;
	background: -webkit-gradient(linear, left top, left 25, from(#FFFFFF),
		color-stop(4%, #FFCEE7), to(#FFFFFF));
	background: -moz-linear-gradient(top, #FFFFFF, #FFCEE7 1px, #FFFFFF 25px);
	box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
	-moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
	-webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約確認画面</title>
</head>
<body>
	<div class="jumbotron form-group">
		<h2>予約確認画面</h2>
	</div>
	<br> 社員名：${employeeDTO.name }
	<br> 貸出日時： ${lendDateStr}
	<br> 返却日時： ${returnDateStr}
	<br>
	<br>


		<div class="panel-body">
			<div class="table-responsive">
				<table style="width: 30%"
					class="table table-striped table-bordered table-hover table-sm text-center">
					<thead>
						<tr style="background-color: pink">
							<td></td>
							<td>リソース名</td>
						</tr>
						</thead><thead>
						<c:forEach var="i" begin="1" end="${resourceDTO.size() }" step="1">
							<tr>
								<td>${i}</td>
								<td>${resourceDTO[i-1].resourceName }</td>
							</tr>
						</c:forEach>
						</thead>
				</table>
			</div>
		</div>

	<br>
	<br>

	<a href="/ResourceManagement/ControllerServlet?COMMAND=COMPLETE"><input
		type="button" value="予約" class="btn btn-info"></a>
	<input value="戻る" onclick="history.back();" type="button"
		class="btn btn-info">
	<hr>
	<a href="/ResourceManagement/ControllerServlet?COMMAND=MENU"><input
		type="button" value="メニュー" class="btn btn-info"></a>
</body>
</html>