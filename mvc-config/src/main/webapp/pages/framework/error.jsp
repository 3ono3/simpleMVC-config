<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>系统错误</title>
</head>
<body>
    <p>
    <h2>系统错误</h2>

    <c:out value="${exception.message}"/>
    </p>
</body>
</html>
