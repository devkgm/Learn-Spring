<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>상품</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>RATE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.id }</td>
					<td>${dto.name }</td>
					<td>${dto.description }</td>
					<td>${dto.rate }%</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>