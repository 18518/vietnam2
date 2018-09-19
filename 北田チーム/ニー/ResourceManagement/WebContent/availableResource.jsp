<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>空き状況照会画面</title>
</head>
<jsp:useBean id="user" class="dto.EmployeeDTO" scope="session" />
<jsp:useBean id="now" class="dto.ReserveTermDTO" scope="session" />

<body>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<h2>空き状況照会画面</h2>
		社員名 <jsp:getProperty name="user" property="name" /> さん
		<br>
		<br>
		<input type="text" name="user" value="name">
		<br>
		<br>
		<input type="hidden" name="COMMAND" value="AVAIBLERESOURCE">
		<br>
		<br>
		貸出日時<select name = "lendYearAndMonth">
			<c:forEach var = "i" begin = "${now.month }" end ="12" step ="1">
					<option value = "${now.year}年${i}月">${now.year}年${i}月</option>
			</c:forEach>
			<c:forEach var = "i" begin = "1" end ="12" step ="1">
					<option value = "${now.year}年${i}月">${now.year + 1}年${i}月</option>
			</c:forEach>
		</select>

		<select name = "lendDate">
		<c:forEach var = "i" begin = "1" end ="31" step ="1">
			<option value ="${i}"> ${i}</option>
		</c:forEach>
		</select>

		日 <select name = "lendHour">
		<c:forEach var = "i" begin = "7" end ="21" step ="1">
			<option value = "${i}">${i}</option>
		</c:forEach>
		</select>
		時 <select name = "lendMinute">

			<option value = "0">0</option>
			<option  value ="15">15</option>
			<option value ="30">30</option>
			<option value = "45">45</option>
		</select> 分<br>

		返却日時 <select name = "returnYearAndMonth">
			<c:forEach var = "i" begin = "${now.month }" end ="12" step ="1">
						<option value = "${now.year}年${i}月">  ${now.year}年${i}月</option>
			</c:forEach>
			<c:forEach var = "i" begin = "1" end ="12" step ="1">
						<option value="${now.year + 1}年${i}月">${now.year + 1}年${i}月</option>
			</c:forEach>
		</select>

		 <select name = "returnDate">
			<c:forEach var = "i" begin = "1" end ="31" step = "1">
			<option value = "${i}">${i}</option>
		</c:forEach>
		</select>
		 日 <select name = "returnHour">
			<c:forEach var = "i" begin = "7" end ="22" step ="1">
			<option value = "${i}">${i}</option>
		</c:forEach>

		</select>
		 時 <select name = "returnMinute">
			<option value = "0">0</option>
			<option  value ="15">15</option>
			<option value ="30">30</option>
			<option value = "45">45</option>
		</select> 分<br>
		<br>
		種別<br>

	<p>
		<c:forEach  var = "resourceClass" items =" ${classes} ">
			${resourceClass.className}<br>

	 	</c:forEach>


	</p>

		<input type="submit" name="login" value="照会">
		<br>
		<br>
		<input type="hidden" name="COMMAND" value="AVAILABLERESOURCE">
		<br>
		<br>
	</form>

	<hr width="30%" align="left" />
	<br>
	<br>

	<form method="post" action="/ResourceManagement/ControllerServlet">
		<input type="submit" name="login" value="メニュー"><br>
		<br> <input type="hidden" name="COMMAND"
			value="MENU"><br>
		<br>
	</form>

</body>
</html>