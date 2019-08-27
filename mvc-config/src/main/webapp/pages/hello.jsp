<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <c:import url="./framework/top.jsp" charEncoding="UTF-8"/>
    <meta charset="utf-8">
    <title>Hello</title>
</head>
<link rel="stylesheet" href="${p}/pages/framework/style.css">
<body class="error-page">
    <div class="layout">
        <c:import url="./framework/left.jsp" charEncoding="UTF-8"/>
        <div class="layout__main">
            <h1 class="br">hello-world</h1>
            <h2>${haha}</h2>
        </div>
    </div>

</body>
</html>
