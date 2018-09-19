<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body>
<form method="post" action="/ResourceManagement/ControllerServlet">
<h2>予約確認画面</h2>
社員名 :<jsp:getProperty name="user" property="name" />
	<br><br>
貸出日時　：<jsp:getProperty name="lendDate" property="year" />年
		<jsp:getProperty name="lendDate" property="month" />月
		<jsp:getProperty name="lendDate" property="day" />日
		<jsp:getProperty name="lendDate" property="hour" />時
		<jsp:getProperty name="lendDate" property="minuter" />分
		<br><br>
返却日時　：${returnDate.year}年
		${returnDate.month}月
		${returnDate.hour}時
		${returnDate.day}日
		${returnDate.minuter}分
		<br><br>
<table border=3 bordercolor="black">
  <tr>
    <td bgcolor= " grey"></td>
    <td text="black" bgcolor="grey">リソース名</td>
  </tr>
  </tr>
  	<td>１</td>
    <td>プロジェクター</td>
  <tr>
  <tr>
    <td>２</td>
    <td>レーザーポインター０１</td> 
  </tr>
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