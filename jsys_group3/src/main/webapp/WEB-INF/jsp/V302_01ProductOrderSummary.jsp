<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri = "jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品別受注集計画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_05Navbar.jsp" %>
		
<div class="container text-center mt-5">
    <h2>商品別受注集計</h2>
    
    <form action="/jsys_group3/jsysFC" method="post" class="my-4">
        <div class="d-flex flex-column align-items-center">
            <label for="CustomerCodeName" class="form-label mb-2">得意先コード・得意先名を入力し、選択してください。</label>
            <div class="d-flex">
                <input list="CustomerCodeNameList" id="CustomerCodeName" name="CustomerCodeName" class="form-control me-2" style="width: 300px;" value="<c:out value='${ requestScope.custCodeName }' />"/>
                <datalist id="CustomerCodeNameList" name="CustomerCodeNameList">
                    <c:forEach var="customer" items="${ requestScope.custList }">
                        <option value="<c:out value='${ customer.custCode }'/> : <c:out value='${ customer.custName }'/>"></option>
                    </c:forEach>
                </datalist>
                <button type="submit" class="btn btn-primary text-nowrap" name="buttonId" value="V302_01_01">集計</button>
            </div>
        </div>
    </form>
</div>




			

	        
			<%-- エラーメッセージがある場合、出力 --%>
	        <h4 class="text-danger">
	        	<c:out value="${requestScope.errorMessage}"/>
	        	<c:forEach var="message" items="${requestScope.errorMessageList}">
					<c:out value="${message}"/><br>
				</c:forEach>
	        </h4>
			
			<c:if test="${requestScope.productSummaryList != null}">
				<table class="table table-bordered table-striped mt-4 text-start">
		            <thead>
		                <tr>
							<th>商品コード</th>
							<th>商品名</th>
							<th>合計数量</th>
							<th>単価</th>
							<th>商品別合計金額</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="productSummary" items="${requestScope.productSummaryList}">
		               	 	<tr>
		                    	<td><c:out value="${ productSummary.itemCode }"/></td>
		                    	<td><c:out value="${ productSummary.itemName }"/></td>
		                    	<td><c:out value="${ productSummary.totalNum }"/></td>
		                    	<td><c:out value="${ productSummary.itemPrice }"/></td>
		                    	<td><c:out value="${ productSummary.totalPricePerItem }"/></td>
		                	</tr>
		                </c:forEach>
						
						<tr style="background-color: aqua;">
							<td colspan="3"></td>
							<td>総計：</td>
							<td><c:out value="${requestScope.total}"/></td>
						</tr>
					</tbody>
		        </table>
		    </c:if>
		
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>