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
		<h1>Regions Update</h1>
		<form action="./update" method="post">
		<input type="hidden" class="form-control" id="region_id" name="region_id" value="${dto.region_id }">
		  <div class="mb-3">
		    <label for="region_name" class="form-label">지역이름을 입력하세요.</label>
		    <input type="text" class="form-control" id="region_name" name="region_name" value="${dto.region_name }">
		  </div>
		  <button type="submit" class="btn btn-primary">업데이트</button>
		</form>
	</div>
	
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>