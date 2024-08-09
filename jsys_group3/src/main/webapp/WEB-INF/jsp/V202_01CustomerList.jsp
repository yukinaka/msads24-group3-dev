<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>得意先一覧</title>
	    
	    <!-- Temp.jspをinclude -->
	    <%@ include file="Temp.jsp" %>
	</head>
	
	<body>
	
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_03Navbar.jsp" %>
	
	    <div class="container mt-5">
	        <h2 class="text-center">得意先一覧</h2>
	        
	   		<%-- エラーメッセージがある場合、出力 --%>
	     	<h4 class="text-center text-danger mb-3">
				<c:out value="${requestScope.errorMessage}"/>
				<c:forEach var="message" items="${requestScope.errorMessageList}">
					<c:out value="${message}"/><br>
				</c:forEach>
	     	</h4> 	      
	     	  
	       <br>
	        
	        <div class="d-flex justify-content-center mb-4">
	            <form class="d-flex" action="/jsys_group3/jsysFC" method="post">
	                <input class="form-control me-2" type="search" name="custStr" placeholder="検索" aria-label="Search">
	                <button class="btn btn-primary text-nowrap" type="submit" name="buttonId" value="V202_01_01">検索</button>
	                <div class="form-check ms-3">
	                    <input class="form-check-input" type="checkbox" name="ckbutton" value="true">
	                    <label class="form-check-label text-nowrap" for="ckbutton">
	                       削除済み項目も含める
	                    </label>
	                    <input class="form-check-input" type="checkbox" name="ckbutton" value="false">
	                    <label class="form-check-label text-nowrap" for="ckbutton">
	                       削除済み項目も含めない
	                    </label>
	                </div>
	            </form>
	        </div>
	        
	        <p class="text-center text-muted">
	            ※削除済み項目も検索したい場合は「削除済み項目も含める」にチェックを入れてください。
	        </p>
	
	
	        <div class="table-responsive">
	            <table class="table table-bordered text-start">
	                <thead>
	                    <tr>
	                        <th>得意先コード</th>
	                        <th>
	                        	<div class="btn-group" role="group">
								    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle"
								        data-bs-toggle="dropdown" aria-expanded="false">得意先名</button>
								    <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
								      <li><div class="dropdown-item"><button class="btn" type="submit" name="buttonId" value="V202_01_02">昇順</button></div></li>
								      <li><div class="dropdown-item"><button class="btn" type="submit" name="buttonId" value="V202_01_03">降順</button></div></li>
								    </ul>
								  </div>
	                        </th>
	                        <th>電話番号</th>
	                        <th>郵便番号</th>
	                        <th>住所</th>
	                        <th>割引率</th>
	                        <th>最終更新者</th>
	                    </tr>
	                </thead>
	                
               		<c:if test="${ requestScope.checkbox == true }">
	                	<c:forEach var="customer" items="${ requestScope.custList }">
			                <tbody>
			                    <tr>
			                    	<td>
				                    	<form action="/jsys_group3/jsysFC" method="post">
						                    <input type="hidden" name="custCode" value="<c:out value="${ customer.custCode }" />">
						                    <input type="hidden" name="custName" value="<c:out value="${ customer.custName }" />">
									 		<input type="hidden" name="telNo1" value="<c:out value="${ customer.telNo1 }" />">
									 		<input type="hidden" name="telNo2" value="<c:out value="${ customer.telNo2 }" />">
									 		<input type="hidden" name="telNo3" value="<c:out value="${ customer.telNo3 }" />">
									 		<input type="hidden" name="postalCode1" value="<c:out value="${ customer.postalCode1 }" />">
									 		<input type="hidden" name="address1" value="<c:out value="${ customer.address1 }" />">
									 		<input type="hidden" name="postalCode2" value="<c:out value="${ customer.postalCode2 }" />">
									 		<input type="hidden" name="address2" value="<c:out value="${ customer.address2 }" />">
									 		<input type="hidden" name="discountRate" value="<c:out value="${ customer.discountRate }" />">
									 		<input type="hidden" name="deleteFlag" value="<c:out value="${ customer.deleteFlag }" />">
					                        <button type="submit" class="btn btn-light" name="buttonId" value="V202_01_06"><c:out value="${ customer.custCode }" /></button>
					                    </form>
			                    	</td>
			                        <td><c:out value="${ customer.custName }" /></td>
			                        <td><c:out value="${ customer.telNo1 }" /></td>
			                        <td><c:out value="${ customer.postalCode1 }" /></td>
			                        <td><c:out value="${ customer.address1 }" /></td>
			                        <td style="text-align:right"><c:out value="${ customer.discountRate }" />%</td>
			                        <td><c:out value="${ customer.lastUpdateBy }" /></td>
			                    </tr>
			                </tbody>
	                	</c:forEach>
               		</c:if>
               		
               		<c:if test="${ requestScope.checkbox == false }">
	                	<c:forEach var="customer" items="${ requestScope.custList }">
		               		<c:if test="${ customer.deleteFlag == false }">
				                <tbody>
				                    <tr>
				                    	<td>
					                    	<form action="/jsys_group3/jsysFC" method="post">
							                    <input type="hidden" name="custCode" value="<c:out value="${ customer.custCode }" />">
							                    <input type="hidden" name="custName" value="<c:out value="${ customer.custName }" />">
										 		<input type="hidden" name="telNo1" value="<c:out value="${ customer.telNo1 }" />">
										 		<input type="hidden" name="telNo2" value="<c:out value="${ customer.telNo2 }" />">
										 		<input type="hidden" name="telNo3" value="<c:out value="${ customer.telNo3 }" />">
										 		<input type="hidden" name="postalCode1" value="<c:out value="${ customer.postalCode1 }" />">
										 		<input type="hidden" name="address1" value="<c:out value="${ customer.address1 }" />">
										 		<input type="hidden" name="postalCode2" value="<c:out value="${ customer.postalCode2 }" />">
										 		<input type="hidden" name="address2" value="<c:out value="${ customer.address2 }" />">
										 		<input type="hidden" name="discountRate" value="<c:out value="${ customer.discountRate }" />">
										 		<input type="hidden" name="deleteFlag" value="<c:out value="${ customer.deleteFlag }" />">
						                        <button type="submit" class="btn btn-light" name="buttonId" value="V202_01_06"><c:out value="${ customer.custCode }" /></button>
						                    </form>
				                    	</td>
				                        <td><c:out value="${ customer.custName }" /></td>
				                        <td><c:out value="${ customer.telNo1 }" /></td>
				                        <td><c:out value="${ customer.postalCode1 }" /></td>
				                        <td><c:out value="${ customer.address1 }" /></td>
				                        <td style="text-align:right"><c:out value="${ customer.discountRate }" />%</td>
				                        <td><c:out value="${ customer.lastUpdateBy }" /></td>
				                    </tr>
				                </tbody>
				            </c:if>
	                	</c:forEach>
               		</c:if>
               		
               		
	            </table>
	        </div>
	        
			
			<nav aria-label="...">
			  <ul class="pagination justify-content-center my-3">
			    <li class="page-item disabled">
			      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">前ページ</a>
			    </li>
			    <li class="page-item active" aria-current="page">
			      <a class="page-link" href="#">1</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#">2</a>
			    </li>
			    <li class="page-item">
			      <a class="page-link" href="#">3</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#">次ページ</a>
			    </li>
			  </ul>
			</nav>
	
	
	    </div>
	
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	
	    <!-- Bootstrap JS CDN -->
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>