<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品別受注集計画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
		<!-- ブートストラップのCSSをインクルード -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		
	</head>
	
	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_05Navbar.jsp" %>
		
		<div class="container">
		
			<div class="text-center">
				<h2>商品別受注集計</h2>
			</div>
			
			<%-- エラーメッセージテキストエリア --%>
			<div class="text-center text-danger">
				<h4>エラーメッセージエリア</h4>
			</div>
			
			<%-- 得意先コード・得意先名で集計検索 
			datalistを利用して入力可能プルダウンを作成 --%>
			
			<div class="text-center">
				<form action="./jsysFC" method="post" class="form-inline justify-content-center">
					<div class="form-group mr-2">
						<label for="CustomerCodeName" class="mr-2">得意先コード・得意先名：</label>
						<input list="CustomerCodeNameList" id="CustomerCodeName" name="CustomerCodeName" class="form-control" />
						<datalist id="CustomerCodeNameList">
							<option value="KA0001 Aストア"></option>
							<option value="KA0002 Bストア"></option>
							<option value="KA0003 Cストア"></option>
							<option value="KA0004 Dストア"></option>
							<option value="KA0005 Eストア"></option>
							<option value="KA0006 Fストア"></option>
						</datalist>
					</div>
					<button type="submit" class="btn btn-primary">集計</button>
				</form>
			</div>
			

			
			<table class="table table-bordered table-striped table-hover mt-4">
	 			<thead class="thead-dark">
	 				<tr>
						<th>商品コード</th>
						<th>商品名</th>
						<th>合計数量</th>
						<th>単価</th>
						<th>商品別合計金額</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>BX0001</td>
						<td>にんにく</td>
						<td>100</td>
						<td>50</td>
						<td>5000</td>
					</tr>
					<tr>
						<td colspan="3"></td>
						<td>総計：</td>
						<td>10000</td>
					</tr>
				</tbody>
			</table>
		
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
		<!-- ブートストラップのJSと依存関係をインクルード -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
	</body>
</html>