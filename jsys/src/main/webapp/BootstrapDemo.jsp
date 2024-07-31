<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Bootstrap demo</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		
		<style>
	        .login-container {
	            max-width: 400px;
	            margin: 50px auto;
	        }
	        .footer {
	            background-color: #f8f9fa;
	            padding: 1rem 0;
	            text-align: center;
	        }
	        .user-info {
	            color: #ffffff; /* ユーザー情報のテキスト色 */
	        }
	        .btn-outline-light {
	            border-color: #ffffff;
	            color: #ffffff;
	        }
	        .btn-outline-light:hover {
	            background-color: #ffffff;
	            color: #000000;
	        }
    	</style>
	</head>
	
	<body>
	
		<!-- ヘッダー -->
		<header>
			<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
			 	<div class="container-fluid ms-5">
			    	<a class="navbar-brand fst-italic" href="#">販売支援システム</a>
			    	
			    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				        <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarNav">
				        <ul class="navbar-nav">
				            <li class="nav-item">
				                <a class="nav-link active" aria-current="page" href="#">ホーム</a>
				            </li>
				            <li class="nav-item">
				                <a class="nav-link" href="#">機能</a>
				            </li>
				            <li class="nav-item">
				                <a class="nav-link" href="#">価格</a>
				            </li>
				            <li class="nav-item">
				                <a class="nav-link" href="#">お問い合わせ</a>
				            </li>
				        </ul>
				    </div>
			        
		            <!-- ユーザー情報とログアウトボタン -->
		            <div class="d-flex align-items-center ms-5">
		                <span class="user-info me-3">ログイン中: <strong>従業員番号</strong></span>
		                <form action="logoutServlet" method="post" class="d-inline">
		                    <button type="submit" class="btn btn-outline-light">ログアウト</button>
		                </form>
		            </div>
			    </div>			
			
			</nav>
			
		</header>

		<!-- メインコンテンツ -->
	    <div class="container">
	        <div class="login-container">
	            <h2 class="text-center">ログイン</h2>
	            <form action="loginServlet" method="post">
	                <div class="mb-3">
	                    <label for="username" class="form-label">従業員番号</label>
	                    <input type="text" class="form-control" id="username" name="username" required>
	                </div>
	                <div class="mb-3">
	                    <label for="password" class="form-label">パスワード</label>
	                    <input type="password" class="form-control" id="password" name="password" required>
	                </div>
	                <button type="submit" class="btn btn-primary w-100">ログイン</button>
	            </form>
	        </div>
	    </div>		
	    
	    
	     <!-- フッター -->
	     <!-- 
	    <footer class="footer">
	        <div class="container">
	            <p class="mb-0">&copy; <span id="current-year"></span> げんきdeいちばん社. All rights reserved.</p>
	        </div>
	    </footer>
	     -->
    
    	<!-- BootstrapのJavaScriptファイル -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
		
		<!-- 現在の年を表示するスクリプト -->
	    <script>
	        document.getElementById('current-year').textContent = new Date().getFullYear();
	    </script>
	</body>
</html>