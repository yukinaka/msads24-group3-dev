<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得意先登録</title>

    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>

    <%-- 埋め込みスタイルシート（入力規則違反はピンクで表示） --%>
    <style type="text/css">
        input:invalid {
            background-color: pink;
        }
    </style>

</head>

<body>
    <!-- Navbar.jspをinclude -->
    <%@ include file="V400_03Navbar.jsp" %>

    <%-- 見出し --%>
    <div class="container mt-5">
        <h2 class="text-center">得意先登録</h2>
        
   		<%-- エラーメッセージがある場合、出力 --%>
     	<h4 class="text-center text-danger mb-3">
			<c:out value="${requestScope.errorMessage}"/>
			<c:forEach var="message" items="${requestScope.errorMessageList}">
				<c:out value="${message}"/><br>
			</c:forEach>
     	</h4>        

        <%-- フォーム領域 --%>
        <form action="/jsys_group3/jsysFC" method="post">
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-10">
			    	<label for="telNo1" class="text-left form-label">得意先名</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="custName" name="custName" maxlength="32" title="得意先名は32文字以内で入力してください。">
					</div>
			    </div>
			 </div>
            
            <div class="row row-cols-auto mb-3">
			    <div class="col-6">
			    	<label for="telNo1" class="text-left form-label">電話番号1</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="telNo1" name="telNo1-1" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1-2" pattern="^[0-9]{4}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1-3" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
            
            <div class="row row-cols-auto mb-3">
			    <div class="col-6">
			    	<label for="telNo1" class="text-left form-label">電話番号2</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="telNo2" name="telNo2-1" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo2" name="telNo2-2" pattern="^[0-9]{4}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo2" name="telNo2-3" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
            
            <div class="row row-cols-auto mb-3">
			    <div class="col-6">
			    	<label for="telNo1" class="text-left form-label">電話番号3</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="telNo3" name="telNo3-1" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo3" name="telNo3-2" pattern="^[0-9]{4}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo3" name="telNo3-3" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
            
            <div class="row row-cols-auto">
			    <div class="col-3">
			    	<label for="telNo1" class="text-left form-label">郵便番号1</label>
	                <div class="input-group mb-2">
		                <input type="text" class="form-control" id="postalCode1" name="postalCode1-1" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="postalCode1" name="postalCode1-2" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-10">
			    	<label for="telNo1" class="text-left form-label">住所1</label>
	                <div class="input-group mb-3">
	                	<input type="text" class="form-control" id="address1" name="address1" maxlength="40" title="住所は40文字以内で入力してください。">
					</div>
			    </div>
			 </div>
			 
            <div class="row row-cols-auto">
			    <div class="col-3">
			    	<label for="telNo1" class="text-left form-label">郵便番号2</label>
	                <div class="input-group mb-2">
		                <input type="text" class="form-control" id="postalCode2" name="postalCode2-1" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="postalCode2" name="postalCode2-2" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-10">
			    	<label for="telNo1" class="text-left form-label">住所2</label>
	                <div class="input-group mb-3">
	                	<input type="text" class="form-control" id="address2" name="address2" maxlength="40" title="住所は40文字以内で入力してください。">
					</div>
			    </div>
			 </div>
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-2">
			    	<label for="telNo1" class="text-left form-label">割引率</label>
	                <div class="input-group mb-3">
	                	<input type="text" class="form-control" id="discountRate" name="discountRate" pattern="^[1-9]?[0-9]$" title="割引率は0~99までの整数値で入力してください。">
	                	<span class="input-group-text">%</span>
					</div>
			    </div>
			 </div>
			 
            <div class="text-center">
			    <button type="submit" class="btn btn-primary mb-5" name="buttonId" value="V201_01_01">登録</button>
            </div>
        </form>
    </div>

    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>

</body>
</html>
