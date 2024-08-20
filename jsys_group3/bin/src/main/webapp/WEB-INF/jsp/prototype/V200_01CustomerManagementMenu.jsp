<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>得意先管理メニュー画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
	</head>
	
	<body style="text-align: center;">
		<!-- Navbar.jspをinclude -->
		<%@ include file="Navbar.jsp" %>
		
		<h2>得意先管理メニュー</h2>

		<div style="text-align: right">
			<form action="/jsys/jsysFC" method="post"><button type="submit" name="buttonId" value="V200_01_01">メインメニューへ戻る</button></form>
		</div>		
		
		<form action="/jsys/jsysFC" method="post"><button type="submit" name="buttonId" value="V200_01_02">得意先検索</button></form>
		<form action="/jsys/jsysFC" method="post"><button disabled="disabled" type="button" name="buttonId" value="V200_01_03">得意先登録</button></form>
		<form action="/jsys/jsysFC" method="post"><button disabled="disabled" type="button" name="buttonId" value="V200_01_04">得意先削除</button></form>
		<form action="/jsys/jsysFC" method="post"><button disabled="disabled" type="button" name="buttonId" value="V200_01_05">得意先変更</button></form>
		<form action="/jsys/jsysFC" method="post"><button type="button" name="buttonId" value="V200_01_06">得意先一覧</button></form>
	
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
	</body>
</html>