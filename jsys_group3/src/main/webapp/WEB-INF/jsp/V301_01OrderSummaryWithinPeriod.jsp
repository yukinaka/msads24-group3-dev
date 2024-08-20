<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>期間内受注集計画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
		<style>
			.form-group {
			    display: flex;
			    align-items: center;
			    gap: 10px; /* 要素間のスペースを追加 */
			}
		</style>
		
	</head>
	
	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_05Navbar.jsp" %>
		
		<div class="container text-center mt-5">
	        <h2>期間内の受注集計</h2>
	
	        <form action="/jsys_group3/jsysFC" method="post" class="my-4">
	            <div class="form-row justify-content-center">
	                
	                <div class="form-group">
			            <input type="date" class="form-control" id="firstDay" name="firstDay">～
			            <input type="date" class="form-control" id="lastDay" name="lastDay">
			            <button type="submit" class="btn btn-primary text-nowrap" name="buttonId" value="V301_01_01">集計</button>
			        </div>
	            </div>
		        
	        </form>
	       
	        <%-- エラーメッセージがある場合、出力 --%>
	        <h4 class="text-danger">
	        	<c:out value="${requestScope.errorMessage}"/>
	        	<c:forEach var="message" items="${requestScope.errorMessageList}">
					<c:out value="${message}"/><br>
				</c:forEach>
	        </h4>
	        
	        <br>
	        <br>
	
	        <table class="table table-bordered table-striped mt-4">
	            <thead>
	                <tr>
	                    <th>得意先コード</th>
	                    <th>得意先名</th>
	                    <th>得意先別合計金額</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="periodSummary" items="${requestScope.periodSummaryList}">
	               	 	<tr>
	                    	<td><c:out value="${periodSummary.custCode}"/></td>
	                    	<td><c:out value="${periodSummary.custName}"/></td>
	                    	<td><c:out value="${periodSummary.totalPricePerCust}"/></td>
	                	</tr>
	                </c:forEach>
	                <c:if test="${ requestScope.periodSummaryList != null }">
	                	<tr style="background-color: aqua;">
	                    	<td></td>
	                    	<td>総計</td>
	                    	<td><c:out value="${requestScope.total}"/></td>
	                	</tr>
	                </c:if>
	            </tbody>
	        </table>
	    </div>
    
    	<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>

	    <script>
	        function setDayOfPreviousMonth() {
	            // 現在の日付を取得
	            let today = new Date();
	            // 先月の月末を計算
	            today.setMonth(today.getMonth(), 0);
	            // 年月日の形式で値を取得
	            let formattedDate = today.toISOString().split('T')[0];
	            // カレンダー入力フォームに設定
	            document.getElementById('lastDay').value = formattedDate;
	            
	            // 先月の初日を計算
	            today.setMonth(today.getMonth(), 1);
	            // 年月日の形式で値を取得
	            formattedDate = today.toISOString().split('T')[0];
	            // カレンダー入力フォームに設定
	            document.getElementById('firstDay').value = formattedDate;
	            
	        }
	        // ページ読み込み時に自動的に設定
	        window.onload = setDayOfPreviousMonth;
	    </script>
		
	</body>
</html>