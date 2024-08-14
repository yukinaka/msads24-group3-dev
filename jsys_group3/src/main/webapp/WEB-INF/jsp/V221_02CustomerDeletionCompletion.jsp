<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先削除完了</title>

	    <%@ include file="Temp.jsp" %>

	</head>

	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container text-center mt-5">
		    <h4 class="my-5">削除が完了しました。</h4>
		    <form action="/jsys_group3/jsysFC" method="post">
		    	<button type="submit" class="btn btn-primary" name="buttonId" value="V221_02_01">得意先一覧画面へ戻る</button>
			</form>
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>
