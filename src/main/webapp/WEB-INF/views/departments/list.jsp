<%@page import="com.devkgm.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../commons/bootstrap_css.jsp"></c:import>
<style>
	tr:hover {
		cursor:pointer
	}
</style>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	<div class="container-sm">
		<h1>Department List</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>MANAGER_ID</th>
					<th>LACATION_ID</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="dto">
					<tr onclick="handleClick(${pageScope.dto.department_id })">
						<td>${pageScope.dto.department_id }</td>
						<td>${pageScope.dto.department_name }</td>
						<td>${pageScope.dto.manager_id }</td>
						<td>${pageScope.dto.lacation_id }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		function handleClick (id) {
			location.href = "./departments/"+id;
		}
	</script>
	<c:import url="../commons/bootstrap_css.jsp"></c:import>
</body>
</html>