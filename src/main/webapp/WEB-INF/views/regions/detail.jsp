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
		<form id="frm" action="../delete" method="post">
			<input hidden="true" value="${requestScope.dto.region_id}" name="region_id">
		</form>
		<button data-region-id="${requestScope.dto.region_id}" id="mod" type="button" class="btn btn-secondary">수정</button>
		<button id="del" type="button" class="btn btn-danger">삭제</button>
	</div>

	<script src="../../resources/js/regionDetail.js"></script>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>