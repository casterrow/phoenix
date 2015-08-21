
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!-- 引入jstl标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 获取根路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>欢迎登陆主页面</title>
		<script type="text/javascript" charset="UTF-8" src="${ctx}/script/jquery-1.11.0.js"></script>
		<script type="text/javascript" charset="UTF-8" src="${ctx}/script/search.js"></script>
	</head>
	<body>
		<h2>输入关键字，点击搜索就可以买到心仪的宝贝啦！</h2>
		
		
	</body>
</html>
