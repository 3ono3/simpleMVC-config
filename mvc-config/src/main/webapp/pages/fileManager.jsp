<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <c:import url="./framework/top.jsp" charEncoding="UTF-8"/>
    <meta charset="utf-8">
    <title>文件管理</title>
</head>
<link rel="stylesheet" href="${p}/pages/framework/style.css">
<body style="padding: 0;margin: 0;">
    <div class="layout">
        <c:import url="./framework/left.jsp" charEncoding="UTF-8"/>
        <div class="layout__main">
            <form method="POST" action="/file/upload" enctype="multipart/form-data" style="margin-top: 20px">
                File to upload: <input type="file" name="file">
                <input type="submit" value="Upload">
            </form>
            <c:if test="${not empty uploadResult}">
                <div class="error-msg">${uploadResult}</div>
            </c:if>
        </div>
    </div>
</body>
</html>
