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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/">Navbar</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/regions/list">Regions</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/departments/list">Departments</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
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
			location.href = "/departments/detail?id="+id;
		}
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>