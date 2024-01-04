<%@page import="com.devkgm.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../commons/bootstrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	<div  class="container-sm">
		<h1>Regions Detail</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
				</tr>
			</thead>
			<tbody>	
				<tr>
					<td>${requestScope.dto.region_id}</td>
					<td>${requestScope.dto.region_name}</td>
				</tr>
			</tbody>
		</table>
		<a type="button" class="btn btn-secondary" href="./edit">수정</a>
		<button type="button" class="btn btn-danger" onclick="handleDeleteBtn(${requestScope.dto.region_id})">삭제</button>
	</div>
	<script>
		function handleDeleteBtn  (id){
			fetch("./regions/"+id,{method: "DELETE"});
		}
	</script>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>