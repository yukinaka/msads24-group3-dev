<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- ナビゲーションバー -->
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
		                <a class="nav-link active" aria-current="page" href="#">メインメニュー</a>
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

<!-- BootstrapのJavaScriptファイル -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

