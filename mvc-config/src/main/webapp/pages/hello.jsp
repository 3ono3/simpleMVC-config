<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <c:import url="./framework/top.jsp" charEncoding="UTF-8"></c:import>
    <meta charset="utf-8">
    <title>Hello</title>
</head>
<body class="error-page">
<section>
    <div class="container ">
        <h1>hello-world</h1>
        <h2>${haha}</h2>
    </div>
</section>
</body>
</html>
