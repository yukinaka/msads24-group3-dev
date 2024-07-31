<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>期間内受注集計画面</title>
	</head>
	
	<body style="text-align: center">
		<h2>期間内の受注集計</h2>
		
		<form action="/jsys/jsysFC" method="post">
			From : <input type="date" name="firstDay">
			To : <input type="date" name="LastDay"><br>
			<button type="submit" name="buttonId" value="V301_01_01">集計</button><br>
		</form>
		
		
		<h4 style="color: red">エラーメッセージエリア</h4>
		
		
		<table border="1" style="margin: 0 auto; border-collapse: collapse;">
			<tr>
				<td>得意先コード</td>
				<td>得意先名</td>
				<td>得意先別合計金額</td>
			</tr>
			<tr>
				<td>KA0001</td>
				<td>Aストア</td>
				<td>500000</td>
			</tr>
			<tr>
				<td>KA0015</td>
				<td>Oストア</td>
				<td>30000</td>
			</tr>
			<tr>
			</tr>
			<tr style="background-color: aqua;">
				<td></td>
				<td>総計</td>
				<td>530000</td>
			</tr>
			
		</table>
		
		
	</body>
</html>