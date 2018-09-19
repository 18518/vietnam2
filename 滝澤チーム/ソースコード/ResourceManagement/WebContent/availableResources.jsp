<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>空き状況照会画面</title>
</head>
<body>
<div class="jumbotron form-group">
	<h2>空き状況照会画面</h2>
	</div>
	社員名：${employeeDTO.name }
	<br>
	<form action="/ResourceManagement/ControllerServlet"
		method="post">

		貸出日時
		 <select name="LendDateYearMonth">

			<option value="${reserveTerm.year}${reserveTerm.month}">${reserveTerm.year}年${reserveTerm.month}</option>
			<c:forEach var="i" begin="${reserveTerm.month+1}" end="12" step="1">
				<option value="${reserveTerm.year}${i}">${reserveTerm.year}年${i}</option>
			</c:forEach>
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${reserveTerm.year+1}${i}">${reserveTerm.year+1}年${i}</option>
			</c:forEach>

		</select>月 <select name=LendDateDay>
			<!--  c:forEach var="i" begin="${reserveTerm.day}" end ="30" step="1"-->
			<c:forEach var="i" begin="1" end="31" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>日 <select name=LendDateHour>
			<!--c:forEach var="i" begin="${reserveTerm.hour}" end ="23" step="1"-->
			<c:forEach var="i" begin="1" end="23" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>時 <select name=LendDateMinute>
			<c:forEach var="i" begin="0" end="45" step="15">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>分<br> 返却日時 <select name="ReturnDateYearMonth">
			<option value="${reserveTerm.year}${reserveTerm.month}">${reserveTerm.year}年${reserveTerm.month}</option>
			<c:forEach var="i" begin="${reserveTerm.month+1}" end="12" step="1">
				<option value="${reserveTerm.year}${i}">${reserveTerm.year}年${i}</option>
			</c:forEach>
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${reserveTerm.year+1}${i}">${reserveTerm.year+1}年${i}</option>
			</c:forEach>
		</select>月 <select name=ReturnDateDay>
			<!--  c:forEach var="i" begin="${reserveTerm.day}" end ="30" step="1"-->
			<c:forEach var="i" begin="1" end="31" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>日 <select name=ReturnDateHour>
			<!--c:forEach var="i" begin="${reserveTerm.hour}" end ="23" step="1"-->
			<c:forEach var="i" begin="1" end="23" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>時 <select name=ReturnDateMinute>
			<c:forEach var="i" begin="0" end="45" step="15">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>分<br>

		 種別<br>

		<c:forEach var="resourceClass" items="${resourceClassDTO }">
			<input type="checkbox" name="classId"
				value="${resourceClass.classId }">${resourceClass.className}<br>
		</c:forEach>
		<input type="hidden" name="COMMAND" value="RESERVE">
		<br>
		<input type="submit" name="login" value="照会" class="btn btn-info">
		<input value="戻る" onclick="history.back();" type="button" class="btn btn-info"></form>

		<hr>
		<a href="/ResourceManagement/ControllerServlet?COMMAND=MENU"><input type="button" value="メニュー" class="btn btn-info"></a>

</body>
</html>