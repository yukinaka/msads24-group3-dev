<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- フッター -->
<footer class="footer">
	<div class="container">
	    <p class="mb-0">&copy; <span id="current-year"></span> げんきdeいちばん社. All rights reserved.</p>
	</div>
</footer>

<!-- 現在の年を表示するスクリプト -->
<script>
    document.getElementById('current-year').textContent = new Date().getFullYear();
</script>