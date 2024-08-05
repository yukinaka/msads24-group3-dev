<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先復元確認</title>
	    
	    <%@ include file="Temp.jsp" %>
	    
	</head>

	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container text-center mt-5">
		    <h2>得意先復元確認</h2>
		    <p class="mt-3">以下の得意先を復元します。よろしいですか？</p>
		
		    <table class="table table-bordered table-striped text-start w-50 mx-auto">
		        <tbody>
		            <tr>
		                <th scope="row">得意先名</th>
		                <td>Aストア</td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号1</th>
		                <td>045-128-3581</td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号2</th>
		                <td>045-128-3582</td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号3</th>
		                <td>045-128-3583</td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号1</th>
		                <td>220-0001</td>
		            </tr>
		            <tr>
		                <th scope="row">住所1</th>
		                <td>横浜市西区北幸２－１</td>
		            </tr>
		             <tr>
		                <th scope="row">郵便番号2</th>
		                <td>220-0002</td>
		            </tr>
		            <tr>
		                <th scope="row">住所2</th>
		                <td>横浜市西区北幸２－２</td>
		            </tr>
		            <tr>
		                <th scope="row">割引率</th>
		                <td>0%</td>
		            </tr>
		        </tbody>
		    </table>
		
		    <div class="mt-3">
		        <button type="button" class="btn btn-success mr-2" name="buttonId" value="restore">はい</button>
		        <button type="button" class="btn btn-secondary" name="buttonId" value="cancel">キャンセル</button>
		    </div>
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>
