<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
<title>空き状況照会画面</title>
</head>
<body>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<h2>空き状況照会画面</h2>
		社員名
		<input type="text" name="なまえ" value="山田太郎">
		<br>
		<br>
		<input type="hidden" name="COMMAND" value="AVAILABLERESOURCE">
		<br>
		<br>
		貸出日時<select>
			<option>2018年12月</option>
			<option>2018年11月</option>
			<option>2018年10月</option>
			<option>2018年9月</option>
			<option>2018年8月</option>
			<option>2018年7月</option>
			<option>2018年6月</option>
			<option>2018年5月</option>
			<option>2018年4月</option>
			<option>2018年3月</option>
			<option>2018年2月</option>
			<option>2018年1月</option>
		</select> <select>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>
			<option>24</option>
			<option>25</option>
			<option>26</option>
			<option>27</option>
			<option>28</option>
			<option>29</option>
			<option>30</option>
			<option>31</option>
		</select> 日 <select>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>
		</select> 時 <select>
			<option>0</option>
			<option>15</option>
			<option>30</option>
			<option>45</option>
		</select> 分<br>
		返却日時 <select>
			<option>2018年12月</option>
			<option>2018年11月</option>
			<option>2018年10月</option>
			<option>2018年9月</option>
			<option>2018年8月</option>
			<option>2018年7月</option>
			<option>2018年6月</option>
			<option>2018年5月</option>
			<option>2018年4月</option>
			<option>2018年3月</option>
			<option>2018年2月</option>
			<option>2018年1月</option>
		</select> <select>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>
			<option>24</option>
			<option>25</option>
			<option>26</option>
			<option>27</option>
			<option>28</option>
			<option>29</option>
			<option>30</option>
			<option>31</option>

		</select> 日 <select>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>

		</select> 時 <select>
			<option>0</option>
			<option>15</option>
			<option>30</option>
			<option>45</option>
		</select> 分<br>
		<br>
		種別<br>
		<p>
			<input type="checkbox"> 会議室<br> <input type="checkbox">
			プロジェクター<br> <input type="checkbox"> マイク・スピーカーセット<br>
			<input type="checkbox"> レーザーポインタ<br> <input
				type="checkbox"> WiFiルータNEC<br> <input type="checkbox">
			WiFiルータGLOCALNET<br> <input type="checkbox">
			WiFiルータHUAWEI<br> <input type="checkbox"> 出張用iPadMiniセット<br>
			<br>
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