<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>予約確認画面</title>
<style>
        table, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
        }
	
</style>
</head>
<jsp:useBean id="user" class="dto.EmployeeDTO" scope="session" />
<jsp:useBean id="lendDate" class="dto.ReserveTermDTO" scope="session" />
<jsp:useBean id="returnDate" class="dto.ReserveTermDTO" scope="session" />
<%--<jsp:useBean id="resources" class="dto.ResourceDTO" scope="session" /> --%>
<%--<jsp:useBean id="resources" class="java.util.ArrayList<dto.ResourceDTO>
"  type="java.util.ArrayList<dto.ResourceDTO>" scope="session" /> --%>

<body>
<form method="post" action="/ResourceManagement/ControllerServlet">
<h2>予約確認画面</h2>
社員名 :<jsp:getProperty name="user" property="name" />
	<br><br>
貸出日時　：<jsp:getProperty name="lendDate" property="year" />年
		<jsp:getProperty name="lendDate" property="month" />月
		<jsp:getProperty name="lendDate" property="day" />日
		<jsp:getProperty name="lendDate" property="hour" />時
		<jsp:getProperty name="lendDate" property="minute" />分
		<br><br>
返却日時　：${returnDate.year}年
		${returnDate.month}月
		${returnDate.hour}時
		${returnDate.day}日
		${returnDate.minute}分
		<br><br>
		
		
		
<table border=3 bordercolor="black">
  <tr>
    <td bgcolor= " grey"></td>
    <td text="black" bgcolor="grey">リソース名</td>
  </tr>
 <c:forEach var = "resource" items = "${RESOURCES}">
  <tr>
  	<td>${resource.resourceId}</td>
    <td>${resource.resourceName}</td>
  </tr>
  </c:forEach>
</table> <br><br>
<div class="dropdown">
        <button value="予約" class="dropbtn">予約</button>
        <input type="hidden"name="COMMAND"value="CONFIRM">
        </form>
       
       <form method="post" action="/ResourceManagement/ControllerServlet">
       <button value="戻る" class="dropbtn">戻る</button>
       <input type="hidden"name="COMMAND"value="AVAILABLERESOURCE">
       </form>     
       	
</div>
<hr  width="30%" align="left" />  <br><br>
<div class="dropdown">
		<form method="post" action="/ResourceManagement/ControllerServlet">
       	<button value="メニュー" class="dropbtn">メニュー</button>
       	<input type="hidden"name="COMMAND"value="MENU">
       	</form>
</div>
</body>
</html>