<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>得意先登録確認画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container mt-5">
			<div class="text-center">
				<h2>登録確認</h2>
				<p class="mt-3">以下の得意先を登録します。よろしいですか？</p>
			 
				<div class="row justify-content-center">
					<div class="col-md-8">
					    <div class="table-responsive">
						     <table class="text-start table table-bordered table-striped border-light">
								<tbody>
									<tr>
									   	<th>登録先名</th>
										<td>Aストア</td>
									</tr>
									<tr>
										<th>電話番号1</th>
										<td><c:out value="${ requestScope.customer.phone1 }" default = "045-128-3581"/></td>
									</tr>
									<tr>
										<th>電話番号2</th>
										<td></td>
									</tr>
									<tr>
										<th>電話番号3</th>
										<td></td>
									</tr>
									<tr>
										<th>郵便番号1</th>
										<td><c:out value="${ requestScope.customer.postalCode1 }" default = "220-0001"/></td>
									</tr>
									<tr>
										<th>住所1</th>
										<td><c:out value="${ requestScope.customer.address1 }" default = "横浜市西区北幸２－１"/></td>
									</tr>
									<tr>
										<th>郵便番号2</th>
										<td><c:out value="${ requestScope.customer.postalCode2 }" default = "220-0002"/></td>
									</tr>
									<tr>
										<th>住所2</th>
										<td><c:out value="${ requestScope.customer.address2 }" default = "横浜市西区北幸２－５"/></td>
									</tr>
									<tr>
									 	<th>割引率</th>
									 	<td><c:out value="${ requestScope.customer.discountRate }" default = "0%"/></td>
									</tr>
								 </tbody>
						    </table>
					    </div>
						    
					    <div class="mt-3">
					    	<button class="btn btn-primary">はい</button>
					    	<button class="btn btn-secondary">キャンセル</button>
						</div>
					  
					</div>
				</div>
			</div>
		
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>
