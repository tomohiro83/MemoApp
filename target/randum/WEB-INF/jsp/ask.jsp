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
<link rel="stylesheet" href="/css/a_main.css">
<link rel="stylesheet" href="/css/a_lay.css">
<link rel="stylesheet" href="/css/a_color.css">
<link rel="stylesheet" href="/fontawesome-free-5.15.3-web/css/all.min.css">

<title>DELETE</title>
</head>
<body>
	<div class="total">
		<div class="message">
			<p class="word1">${ask}</p>
			<p class="word2">${ask2}</p>
		</div>
		<div class="judge">
			<a href="/GotoDelete?check=${check }&id=${id}&title=${title}" class="bt yes"><i class="far fa-circle fa-2x"></i></a>
			<a href="/Goto?check=${check}&title=${title}" class="bt no"><i class="fas fa-times fa-2x"></i></a>
		</div>
	</div>
</body>
</html>