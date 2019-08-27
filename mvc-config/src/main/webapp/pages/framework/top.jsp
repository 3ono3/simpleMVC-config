<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<style>

    .nav_container {
        background-color: #373D41;
        height: 60px;
        width: 100%;
    }

    .logo {
        cursor: pointer;
        height: 100%;
        width: 264px;
        background: url("${p}/static/img/index_logo.png") 20px 17px;
        background-size: 182px 35px;
        background-repeat: no-repeat;
        float: left;
    }

    .menu {
        float: left;
        height: 100%;
        margin-left: 100px;
    }

    .menu span {
        height: 100%;
        cursor: pointer;
        display: inline-block;
        line-height: 60px;
        color: white;
        font-family: 微软雅黑 黑体;
        font-size: 15px;
        padding-right: 15px;
        padding-left: 15px;

    }

    .menu_active {
        background-color: #3288C8;
        font-weight: 300;
        font-size: 20px;
    }

    .dpa {
        color: #ffffff;
        cursor: pointer;
        text-decoration: none;
        display: inline-block;
        width: 150px;
    }

    .dpa:hover {
        color: #377bb5;
        text-decoration: none;
    }

    .user {
        float: right;
        width: 200px;
        height: 100%;
        line-height: 60px;
        color: white;
        font-family: 微软雅黑 黑体;
        font-size: 15px;
    }

    table {
        font-size: 12px;
    }
</style>

<div class="nav_container">
    <div class="logo"></div>
    <div class="menu">
        <a href="${p}/index/"><span <c:if test="${param.page == 'index'}">class="menu_active"</c:if> >首页</span></a>
        <shiro:hasPermission name="system:user">
        <a href="${p}/user/"><span <c:if test="${param.page == 'user'}">class="menu_active"</c:if> >用户管理</span></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="system:role">
        <a href="${p}/role/"><span <c:if test="${param.page == 'role'}">class="menu_active"</c:if> >角色管理</span></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="system:activity">
        <a href="${p}/activity/"><span <c:if test="${param.page == 'activity'}">class="menu_active"</c:if> >日志管理</span></a>
        </shiro:hasPermission>
    </div>
    <div class="user dropdown">
        <div></div>
        <span>欢迎: </span>
        <a data-toggle="dropdown">
            <shiro:principal property="name"/>
        <span class="caret"></span>
        </a>
        <shiro:authenticated>
            <a href="${p}/logout" style="color: #ffffff;font-size: 14px;line-height: 20px;margin: 16px; text-decoration: none">注销</a>
        </shiro:authenticated>

            <%--<li><a href="#">注销1</a></li>--%>

    </div>
</div>