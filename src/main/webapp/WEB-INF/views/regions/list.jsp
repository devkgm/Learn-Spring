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
<style>
	tr:hover {
		cursor:pointer
	}
</style>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	<div  class="container-sm">
		<h1>Regions List</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr onclick="handleClick(${pageScope.dto.region_id})">
					<td>${pageScope.dto.region_id}</td>
					<td>${pageScope.dto.region_name}</td>
				</tr>
			</c:forEach>
	
			</tbody>
		</table>
		<a class="btn btn-primary" href="./regions/add">지역추가</a>
	</div>
	<div class="toast-container position-fixed bottom-1 end-1 p-3">
	  <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
	    <div class="toast-header">
	      <strong class="me-auto">알림</strong>
	      <small>${date}</small>
	      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
	    </div>
	    <div class="toast-body">
	      글이 추가되었습니다.
	    </div>
	  </div>
	</div>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
	<script>
		function handleClick(id){
			location.href = "./regions/"+id;
		}
		
		
		const toastLiveExample = document.getElementById('liveToast')

		let msg = "${msg}"
		if(msg){
			const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
		  	toastBootstrap.show()
		}
	</script>
	</script>
	
</body>
</html>