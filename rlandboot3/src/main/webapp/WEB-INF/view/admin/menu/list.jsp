<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>admin 메뉴 목록 페이지</h1>
	<nav>
		<h1>페이저</h1>
		<form action="">
			<label>size</label>
			<select name="s">
				<option value="10">10</option>
				<option>20</option>
				<option>50</option>
			</select>
			<input type="submit" value="변경">
		</form>
		<ul>
		<c:forEach var="n" begin="1" end="5">
			<li><a href="list?p=${n}&q=hello">${n}</a></li>
		</c:forEach>
		</ul>
	</nav>
</body>
</html>