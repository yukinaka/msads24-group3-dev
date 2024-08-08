<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先別集計メニュー</title>
	
	    <%@ include file="Temp.jsp" %>
	</head>
	
	<body>
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_05Navbar.jsp" %>
	    
	    <div class="container text-center mt-5">
	        <h2 class="my-4">得意先別集計メニュー</h2>
	
			<form action="/jsys_group3/jsysFC" method="post">
		        <div class="btn-group-vertical">
		            <button type="submit" class="btn btn-info my-2" name="buttonId" value="V101_04_01">期間内受注集計</button>
		            <button type="submit" class="btn btn-info my-2" name="buttonId" value="V101_04_02">商品別受注集計</button>
		        </div>
		    </form>
		    
	    </div>
	    
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	
	</body>
</html>
