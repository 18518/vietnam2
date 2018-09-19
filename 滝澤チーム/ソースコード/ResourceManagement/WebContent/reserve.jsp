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
<title>リソース選択画面</title>

</head>
<body>
	<div class="jumbotron form-group">
		<h2>リソース選択画面</h2>
	</div>
	<br> 貸出日時： ${lendDateStr}
	<br> 返却日時： ${returnDateStr}
	<br>
	<br>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<div class="panel-body">
			<div class="table-responsive">
				<table style="width: 30%"
					class="table table-striped table-bordered table-hover table-sm text-center">
					<thead>
						<tr style="background-color: pink;">
							<th></th>
							<th class="text-center">リソース名</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reserveServiceDTO}" var="res">
							<tr>
								<td><input type="checkbox" name="lendResource"
									value="${res.resourceId}"></td>
								<td>${res.resourceName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<br> <input type="hidden" name="COMMAND" value="CONFIRM">
		<input type="submit" name="CONFIRM" value="確認" class="btn btn-info">
		<input value="戻る" onclick="history.back();" type="button"
			class="btn btn-info">
	</form>
	<hr>
	<a href="/ResourceManagement/ControllerServlet?COMMAND=MENU"><input
		type="button" class="btn btn-info" value="メニュー"></a>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
</html>