
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!-- 引入jstl标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 获取根路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>产品搜索页面</title>
		<script type="text/javascript" charset="UTF-8" src="script/jquery-1.11.0.js"></script>
		<script type="text/javascript" charset="UTF-8" src="script/search.js"></script>
	</head>
	<body>
		<input id="search" type="text" name="keywords" />
		<input id="click" type="button" value="搜索" />
		
		
	</body>
</html>
