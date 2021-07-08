<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- EL式を有効にする、という記述↓ -->				
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 maximum-scale=1.0, minimum-scale=1.0">
	
<link rel="icon" href="/img/favicon.ico" id="favicon">
	
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/w_main.css">
<link rel="stylesheet" href="/css/w_lay.css">
<link rel="stylesheet" href="/css/w_color.css">
<link rel="stylesheet"
	href="/fontawesome-free-5.15.3-web/css/all.min.css">
<title>TITLE</title>
</head>
<body>
	<div class="total">
		<!-- メニューバー -->
		<div class="top">
			<a class="bt home" href="/Goto?check=home"><i class="fas fa-backward fa-2x"></i></a> 
			<p>タイトル作成</p>
		</div>
		<!-- テキストエリア -->
		<div class="t_area">
			<form action="/GotoPG?check=0" method="post" class="area">
				<textarea name="contents" autofocus></textarea>
				<br>
				<button type="submit" class="bt">
					<i class="fas fa-plus fa-2x bt2"></i>
				</button>
			</form>
		</div>
	</div>
</body>
</html>