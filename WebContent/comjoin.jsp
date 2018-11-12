<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int maxcom_no = (int)request.getAttribute("maxcom_no");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자동차 쇼핑몰</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>자동차 쇼핑몰</h1>
		</header>
		<nav>
			<ul class="navul1">
				<li><a href="MainServlet">쇼핑몰 홈</a></li>
				<li><a href="MallServlet">자동차 몰</a></li>
				<li><a href="SellRankServlet">판매 순위</a></li>
			</ul>
		</nav>
		<section>
			<form action="ComJoinServlet" method="post">
				<label for="com_no">회사번호</label><input id="com_no" name="com_no"
					type="text" value="<%=maxcom_no+1%>" /><br /> <label for="com_name">회사이름</label><input
					id="com_name" name="com_name" type="text" /><br /> <label
					for="com_addr">회사주소</label><input id="com_addr" name="com_addr"
					type="text" /><br />
				<button type="submit">회사등록</button>

			</form>
		</section>
		<footer>
			<p>CopyRight 한국IT교육원 TM</p>
		</footer>
	</div>
</body>
</html>