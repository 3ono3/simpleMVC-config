<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <c:import url="./framework/layout_import.jsp" charEncoding="UTF-8"></c:import>
    <title>用户登录</title>

    <style type="text/css">
        .wrap {
            height: 100%;
            width: 100%;
            /*background: linear-gradient(to bottom, #31363A 0%, #6b7073 100%);*/
            background: url("${p}/static/img/login_back.jpg") no-repeat;
        }

        .center {
            background-color: rgba(255,255,255,0.6);
            width: 300px;
            height: 300px;
            position:absolute;
            top:0;
            left:0;
            right:0;
            bottom:0;
            margin:auto;
        }
        .inputDiv {
            text-align: center;
            margin-top: 20px;
        }
        .inputText {
            font-size: 18px;
            line-height: 22px;
            border-radius: 10px;
            margin-left: 6px;
        }

    </style>


</head>
<body>
<div class="wrap">
    <div class="center">
            <form action="${p}/login" method="post" >
                <div style="text-align: center">
                    <label style="font-size: 24px;font-family: 黑体;line-height: 40px; display:block" >欢迎访问</label>
                </div>
                <div class="inputDiv">
                    <label style="font-size: 18px">账号</label>
                    <input class="inputText"  placeholder="account" name="account">
                </div>
                <div class="inputDiv">
                    <label style="font-size: 18px">密码</label>
                    <input class="inputText" type="password" placeholder="password" name="password">
                </div>
                <div class="form-group" style="text-align: center; margin-top: 30px;">
                    <button style="width: 90%;font-size: 20px" type="submit" class="btn btn-primary ">提交</button>
                </div>
                <c:if test="${not empty tip}">
                    <div class="error-msg">${tip}</div>
                </c:if>
            </form>

    </div>
</div>
</body>
</html>
