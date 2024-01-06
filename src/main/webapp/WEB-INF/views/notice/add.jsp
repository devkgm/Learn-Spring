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
		<h1>상품추가</h1>
		<form action="./add" method="POST">
		  <div class="mb-3">
		    <label for="title" class="form-label">제목</label>
		    <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp">
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">본문</label>
		    <input type="text" class="form-control" id="desciprtion" name="description">
		  </div>

		  <button class="btn btn-primary">업로드</button>
		</form>
	</div>
	
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>