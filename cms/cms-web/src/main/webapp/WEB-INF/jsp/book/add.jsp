<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/main.css?v=201509231"/>
    <title>添加书籍</title>
</head>
<body>
<div class="breadcrumb">
    <span class="crust"><a href="${pageContext.request.contextPath}/" class="crumb">首页</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="${pageContext.request.contextPath}/user" class="crumb">用户管理</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="${pageContext.request.contextPath}/user/list" class="crumb">用户列表</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="${pageContext.request.contextPath}/book/list/${user.id}" class="crumb">书籍列表</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="" class="crumb">添加书籍</a><span class="arrow"><span>&gt;</span></span></span>
</div>
<div id="main">
    <form id="form" method="post">
        <input id="userId" type="hidden" name="userId" value="${user.id}">
        <table border="1">
            <caption>添加书籍</caption>
            <tr>
                <td>账号:</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td>昵称:</td>
                <td>${user.nickname}</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><c:if test="${user.sex} == 1">男</c:if><c:if test="${user.sex} == 2">女</c:if></td>
            </tr>
            <tr>
                <td>书名:<font color="#cc0000">*</font></td>
                <td><input id="name" type="text" name="name" placeholder="必填" required="true" maxlength="20" autofocus
                           value=""></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="${pageContext.request.contextPath}/book/list/${user.id}">取消</a>　
                    <input type="submit" value="保存"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
