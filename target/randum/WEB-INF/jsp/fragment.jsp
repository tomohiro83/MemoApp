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
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/lay.css">
<link rel="stylesheet" href="/css/color.css">
<link rel="stylesheet"
	href="/fontawesome-free-5.15.3-web/css/all.min.css">

<title>FRAGMENTS</title>
</head>
<body>
	<div class="total">
		<!-- メニューバー -->
		<div class="f_top">
			<a class="bt f_home" href="/Goto?check=home"><i class="fas fa-backward fa-2x"></i></a>
			<p class="main_title">${title.title}</p>
		</div>

		<!-- 日付 -->
		<div class="f_middle">
			<a class="bt trash del" href="/GotoAsk?check=title&title=${title.title}"><i class="fas fa-trash fa-2x"></i></a>
			<a class="bt re_name" href="/GotoEdit?check=title&title=${title.title}"><i class="fas fa-eraser fa-2x"></i></a>
			<a class="bt f_array" href="/GotoReverse?check=${title.title}"><i class="fas fa-retweet fa-2x"></i></a>
			<a class="bt f_make" href="/GotoFragmentWrite"><i class="fas fa-marker fa-2x"></i></a>
		</div>

		<!-- タイトル一覧 -->
		<div class="f_under">
				
			<div class="f_con">
				<c:choose>
					<c:when test="${not empty fragment }">
						 <c:forEach var="obj" items="${fragment}">
							<div class="contents">
							
							<!-- 作成時刻 -->
								<div class="time">${obj.day}</div>
								
							<!-- 内容 -->
								<div class="word">${obj.fragment}</div>
								
							<!-- 編集ボタン -->
								<div class="edit">
									<a href="/GotoAsk?check=frag&id=${obj.id}&title=${title.title}" class="bt2 del"><i class="fas fa-trash"></i></a>
									<a href="/GotoEdit?id=${obj.id}&check=frag" class="bt2"><i class="far fa-edit"></i></a>
								</div>
								
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="no_data">NO DATA</p>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>

	</div>

</body>
</html>