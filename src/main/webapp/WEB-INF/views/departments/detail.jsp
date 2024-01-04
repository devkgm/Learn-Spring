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
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	<div class="container-sm">
		<h1>Department Detail</h1>
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

				<tr>
					<td>${requestScope.dto.department_id }</td>
					<td>${requestScope.dto.department_name }</td>
					<td>${requestScope.dto.manager_id }</td>
					<td>${requestScope.dto.lacation_id }</td>
				</tr>

			</tbody>
		</table>
	</div>
	<script>
		function handleClick (id) {
			location.href = "./departments/detail?id="+id;
		}
	</script>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>