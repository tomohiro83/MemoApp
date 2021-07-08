<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page
	import="java.util.List,
					util.Today,
					dao.Record,
					model.Fragments"%>

<%
String today = Today.get();
Boolean check = false;

/* 並べ替えを経由した場合はこの値を持っているはず */
String reverse = (String)request.getAttribute("reverse");


if(reverse == null){
	
	List<Fragments> list = Record.getTitle();

	if(!list.isEmpty()){
			check = true;
			session.setAttribute("titles", list);
		}

/* スコープにリストがすでに入っているので */
}else if(reverse.equals("yes")){
	
	check = true;
}

%>
<!-- EL式を有効にする、という記述↓ -->				
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 maximum-scale=1.0, minimum-scale=1.0">

<meta name="apple-mobile-web-app-title" content="備忘録">

<link rel="icon" href="img/favicon.ico" id="favicon">
<link rel="apple-touch-icon" sizes="180x180" href="img/icon.png">

<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/lay.css">
<link rel="stylesheet" href="css/color.css">
<link rel="stylesheet"
	href="fontawesome-free-5.15.3-web/css/all.min.css">

<title>HOME</title>
</head>
<body>
	<div class="total">
		<!-- HOMEと日付 -->
		<div class="top">
			
			<p class="today"><%=today%></p>
		</div>

		<!-- メニュー -->
		<div class="middle">
			<a class="bt array" href="/GotoReverse?check=all_titles"><i class="fas fa-retweet fa-2x"></i></a>
			<a class="bt make" href="/Goto?check=write"><i class="fas fa-book fa-2x"></i></a>
		</div>

		<!-- タイトル一覧 -->
		<div class="under">
				
			<div class="t_con">
				<c:choose>
					<c:when test="<%=check %>">
						 <c:forEach var="word" items="${titles}">
							<a class="title" href="/GotoFragment?title=${word.title}">${word.title}</a>
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
