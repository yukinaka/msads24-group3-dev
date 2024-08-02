<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>得意先変更</title>
	
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

<<<<<<< HEAD
	<!-- Navbar.jspをinclude -->
	<%@ include file="V400_03Navbar.jsp" %>
	
	<div class="container mt-5">
		<h2 class="text-center">得意先変更</h2>
		<h4 class="text-center text-danger mb-3">エラーメッセージエリア</h4>
		
		<%-- フォーム領域 --%>
		<form action="/jsys/V201_02CustomerRegistrationConfirmation" method="post">
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-10">
			    	<label for="telNo1" class="text-left form-label">得意先名</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="custName" name="custName" value="Aストア" maxlength="32" title="得意先名は32文字以内で入力してください。">
					</div>
			    </div>
			 </div>
=======
<!-- Navbar.jspをinclude -->
<%@ include file="V400_03Navbar.jsp" %>

<div class="container mt-5">
  <h2 class="text-center">得意先変更</h2>
  
<br>  
<div style="text-align:center" >
<font color="red">
<h4>エラーメッセージエリア</h4>
</font>
</div>
<br> 
  <form action="" method="post">
    <div class="row justify-content-center">
      <div class="col-md-8 col-lg-6">
        <div class="card p-4">
        <div class="form-group-row">
          <div class="card-body">
            <div class="mb-3">
              <label for="customerCode" class="form-label">得意先コード</label>
              <input type="text" class="form-control" id="customerCode" name="customerCode" value="KA6000" required>
            </div>
            <div class="mb-3">
              <label for="customerName" class="form-label">得意先名</label>
              <input type="text" class="form-control" id="customerName" name="customerName" maxlength="32" title="得意先名は32文字以内で入力してください。" value="KA商事" required>
            </div>
            <div class="mb-3">
              <label for="phoneNumber" class="form-label">電話番号1</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{5}$" title="電話番号は数字13桁で入力してください。" value="000" required>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{5}$" title="電話番号は数字13桁で入力してください。" value="000" required>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{5}$" title="電話番号は数字13桁で入力してください。" value="000" required>
            </div>
             <div class="mb-3">
              <label for="phoneNumber" class="form-label">電話番号2</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。"value="KA6000"  >
            </div>
             <div class="mb-3">
              <label for="phoneNumber" class="form-label">電話番号3</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。" >
            </div>
            <div class="mb-3">
              <label for="postalCode" class="form-label">郵便番号1</label>
              <input type="text" class="form-control" id="postalCode" name="postalCode" pattern="^[0-9]{7}$" title="郵便番号は7桁で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="address" class="form-label">住所1</label>
              <input type="text" class="form-control" id="address" name="address" maxlength="40" title="住所は40文字以内で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="postalCode" class="form-label">郵便番号2</label>
              <input type="text" class="form-control" id="postalCode" name="postalCode" pattern="^[0-9]{7}$" title="郵便番号は7桁で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="address" class="form-label">住所2</label>
              <input type="text" class="form-control" id="address" name="address" maxlength="40" title="住所は40文字以内で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="discountRate" class="form-label">割引率</label>
              <input type="text" class="form-control" id="discountRate" name="discountRate" pattern="^[0-9]{1,2}$" title="割引率は0~99までの整数値で入力してください。" required>
            </div>
>>>>>>> origin/tai5
            
            <div class="row row-cols-auto mb-3">
			    <div class="col-7">
			    	<label for="telNo1" class="text-left form-label">電話番号1</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="telNo1" name="telNo1" value="045" pattern="^[0-9]{2-3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" value="128" pattern="^[0-9]{3-4}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" value="3581" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
            
            <div class="row row-cols-auto mb-3">
			    <div class="col-7">
			    	<label for="telNo1" class="text-left form-label">電話番号2</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{2-3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{3-4}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
            
            <div class="row row-cols-auto mb-3">
			    <div class="col-7">
			    	<label for="telNo1" class="text-left form-label">電話番号3</label>
	                <div class="input-group mb-3">
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{2-3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{3-4}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
            
            <div class="row row-cols-auto">
			    <div class="col-3">
			    	<label for="telNo1" class="text-left form-label">郵便番号1</label>
	                <div class="input-group mb-2">
		                <input type="text" class="form-control" id="telNo1" name="telNo1" value="220" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" value="0001" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-10">
			    	<label for="telNo1" class="text-left form-label">住所1</label>
	                <div class="input-group mb-3">
	                	<input type="text" class="form-control" id="address1" name="address1" value="横浜市西区北幸2-1" maxlength="40" title="住所は40文字以内で入力してください。">
					</div>
			    </div>
			 </div>
			 
            <div class="row row-cols-auto">
			    <div class="col-3">
			    	<label for="telNo1" class="text-left form-label">郵便番号2</label>
	                <div class="input-group mb-2">
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{3}$">
		    			<span class="input-group-text">-</span>
		                <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{4}$">
					</div>
			    </div>
			</div>
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-10">
			    	<label for="telNo1" class="text-left form-label">住所2</label>
	                <div class="input-group mb-3">
	                	<input type="text" class="form-control" id="address1" name="address1" maxlength="40" title="住所は40文字以内で入力してください。">
					</div>
			    </div>
			 </div>
        
            <div class="row row-cols-auto mb-3">
			    <div class="col-2">
			    	<label for="telNo1" class="text-left form-label">割引率</label>
	                <div class="input-group mb-3">
	                	<input type="text" class="form-control" id="discountRate" name="discountRate" value = "0" pattern="^[1-9]?[0-9]$" title="割引率は0~99までの整数値で入力してください。">
	                	<span class="input-group-text">%</span>
					</div>
			    </div>
			 </div>
			 
            <div class="text-center">
			    <button type="submit" class="btn btn-primary mb-5">変更</button>
            </div>
        </form>
	</div>
	
	<br>
    <br>
    <br>
	
	<!-- Footer.jspをinclude -->
	<%@ include file="Footer.jsp" %>
	
</body>
</html>