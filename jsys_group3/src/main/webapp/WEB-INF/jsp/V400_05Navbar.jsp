<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- ナビゲーションバー -->
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
	 	<div class="container-fluid ms-5">
	    	<a class="navbar-brand fst-italic" href="#">販売支援システム（得意先別集計）</a>
	    	
	    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		        <ul class="navbar-nav">
		            <li class="nav-item">
		                <form action="/jsys_group3/jsysFC" method="post">
		                	<button type="submit" class="btn btn-primary" name="buttonId" value="V101_02">メインメニュー</button>
		                </form>
		            </li>
		        </ul>
		    </div>
	        
            <!-- ユーザー情報とログアウトボタン -->
            <div class="d-flex align-items-center ms-5">
                <span class="user-info me-3">ログイン中: <strong><c:out value="${ sessionScope.loginEmployee.empNo }" /></strong></span>
                <form action="/jsys_group3/jsysFC" method="post" class="d-inline">
                    <button type="submit" class="btn btn-outline-light" name="buttonId" value="V101_99_01">ログアウト</button>
                </form>
            </div>
	    </div>			
	
	</nav>
	
</header>

<!-- BootstrapのJavaScriptファイル -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

