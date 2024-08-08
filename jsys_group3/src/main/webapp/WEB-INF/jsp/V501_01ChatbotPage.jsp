<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Chatbot</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_01Navbar.jsp" %>
	
		<!-- メインコンテンツ -->
	    <div class="container mt-5">
	        <h2 class="text-center">bot</h2>
	        
     		<%-- エラーメッセージがある場合、出力 --%>
	     	<h4 class="text-center text-danger mb-3">
				<c:forEach var="message" items="${sessionScope.messages}">
					<c:out value="${message.content}"/><br>
				</c:forEach>
	     	</h4>
	        
	        <form action="/jsys_group3/jsysFC" method="post">
	            <div class="mb-3">
	                <label for="username" class="form-label">入力</label>
	                <input type="text" class="form-control" id="username" name="userInput" required value="<c:out value="${ param.userInput }" />">
	            </div>
	            <button type="submit" class="btn btn-primary w-100" name="buttonId" value="V501_01_01">送信</button>
	        </form>
	    </div>
	    
	   <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>