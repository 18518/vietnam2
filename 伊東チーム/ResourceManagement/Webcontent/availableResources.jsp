<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>空き状況照会画面</title>
</head>
<body>
<h2>空き状況照会画面</h2>
<br>
	社員名：${employee.name}
	<br>
	<br>
<form method="post" action="/ResourceManagement/ControllerServlet">

貸出日時：
	<select name="LEND_YEAR_MONTH">
	<option value="${reserveTermDTO.year}年${reserveTermDTO.month}月">${reserveTermDTO.year}年${reserveTermDTO.month}月</option>

	<c:forEach var="i" begin="${reserveTermDTO.month+1}" end="12" step="1">
	<option value="${reserveTermDTO.year}年${i}月">${reserveTermDTO.year}年${i}月</option>
 	</c:forEach>

 	<c:forEach var="i" begin="1" end="12" step="1">
	<option value="${reserveTermDTO.year+1}年${i}月">${reserveTermDTO.year+1}年${i}月</option>
 	</c:forEach>
	</select>


	<select name="LEND_DAY">
	<option value="${reserveTermDTO.day}">${reserveTermDTO.day}</option>
	<c:forEach var="i" begin="1" end="31" step="1">
	<option value="${i}">${i}</option>
 	</c:forEach>
	</select>日

	<select name="LEND_HOUR">
	<option value="${reserveTermDTO.hour}">${reserveTermDTO.hour}</option>
	<c:forEach var="i" begin="0" end="24" step="1">
	<option value="${i}">${i}</option>
 	</c:forEach>
	</select>時

	<select name="LEND_MINUTE">
	<option value="${reserveTermDTO.minute}">${reserveTermDTO.minute}</option>
	<option value="00">00</option>
	<option value="15">15</option>
	<option value="30">30</option>
	<option value="45">45</option>
	</select>分

	<br>
返却日時：
	<select name="RETURN_YEAR_MONTH">
	<option value="${reserveTermDTO.year}年${reserveTermDTO.month}月">${reserveTermDTO.year}年${reserveTermDTO.month}月</option>

	<c:forEach var="i" begin="${reserveTermDTO.month+1}" end="12" step="1">
	<option value="${reserveTermDTO.year}年${i}月">${reserveTermDTO.year}年${i}月</option>
 	</c:forEach>

 	<c:forEach var="i" begin="1" end="12" step="1">
	<option value="${reserveTermDTO.year+1}年${i}月">${reserveTermDTO.year+1}年${i}月</option>
 	</c:forEach>
	</select>


	<select name="RETURN_DAY">
	<option value="${reserveTermDTO.day}">${reserveTermDTO.day}</option>
	<c:forEach var="i" begin="1" end="31" step="1">
	<option value="${i}">${i}</option>
 	</c:forEach>
	</select>日

	<select name="RETURN_HOUR">
	<option value="${reserveTermDTO.hour+1}">${reserveTermDTO.hour+1}</option>
	<c:forEach var="i" begin="0" end="24" step="1">
	<option value="${i}">${i}</option>
 	</c:forEach>
	</select>時

		<select name="RETURN_MINUTE">
	<option value="${reserveTermDTO.minute}">${reserveTermDTO.minute}</option>
	<option value="00">00</option>
	<option value="15">15</option>
	<option value="30">30</option>
	<option value="45">45</option>
	</select>分
<br>
種別	<table>
	<c:forEach var="i" begin="0" end="${classDTOs.size()-1}" step="1">
	<tr>
	<td>
	<input type="checkbox" name="class" value="${classDTOs[i].classId}"></td>
	<td>${classDTOs[i].className}</td>
	</tr>
	</c:forEach>
	</table>
<br>
<br>
	<input type="hidden" name="COMMAND" value="RESERVE">
	<input type="submit" name="syoukai" value="照会">
</form>
<hr>
<form method="get" action="/ResourceManagement/ControllerServlet">
	<input type="hidden" name="COMMAND" value="MENU">
	<input type="submit" name="MENU" value="メニュー">
</form>
</body>
</html>