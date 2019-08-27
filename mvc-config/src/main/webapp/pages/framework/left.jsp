<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<link rel="stylesheet" href="${p}/pages/framework/style.css">
<style type="text/css">
    ul li {
        list-style: none;
        margin-top: 10px;
    }
    ul li a {
        color: #737373;
        text-decoration: none;
        font-weight: 300;
        font-size: 20px;
        line-height: 30px;
    }
</style>
<div class="layout__aside" style="background-color: #09ffa6; height:calc(100vh - 60px);">
    <ul>
        <shiro:hasPermission name="system:user">
            <li>
                <a href="${p}/user/index"><span <c:if test="${param.page == 'user'}">class="menu_active"</c:if> >用户管理</span></a>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="system:role">
            <li>
                <a href="${p}/role/index"><span <c:if test="${param.page == 'role'}">class="menu_active"</c:if> >角色管理</span></a>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="system:activity">
            <li>
                <a href="${p}/activity/index"><span <c:if test="${param.page == 'activity'}">class="menu_active"</c:if> >日志管理</span></a>
            </li>
        </shiro:hasPermission>
    </ul>
</div>
