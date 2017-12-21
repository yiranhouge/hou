<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>添加用户</title>
</head>
<body>
<div class="breadcrumb">
    <span class="crust"><a href="${basePath}/" class="crumb">首页</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="${basePath}/user" class="crumb">用户管理</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="" class="crumb">添加用户</a><span class="arrow"><span>&gt;</span></span></span>
</div>
<div id="main">
    <form id="form" method="post">
        <input id="userId" type="hidden" name="userId" value="${user.id}">
        <table border="1">
            <caption>添加用户</caption>
            <tr>
                <td>帐号：<font color="#cc0000">*</font></td>
                <td><input id="username" type="text" name="username" placeholder="必填" required="true" maxlength="20"
                           autofocus value=""/></td>
            </tr>
            <tr>
                <td>密码：<font color="#cc0000">*</font></td>
                <td><input id="password" type="password" name="password" placeholder="必填" required="true" maxlength="20"
                           value=""/></td>
            </tr>
            <tr>
                <td>昵称：<font color="#cc0000">*</font></td>
                <td><input id="nickname" type="text" name="nickname" placeholder="必填" required="true" maxlength="20"
                           value=""/></td>
            </tr>

            <tr>
                <td>性别：</td>
                <td>
                    <select id="sex" name="sex">
                        <option value="0">-请选择-</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a href="${basePath}/user">取消</a>　<input type="submit" value="保存"/></td>
            </tr>
        </table>
    </form>
    <form id="form2" action="${basePath}/user/upload" method="post" enctype="multipart/form-data">
        <table border="1">
            <caption>修改头像</caption>
            <tr>
                <td>头像：</td>
                <td><input id="file" type="file" name="file"/></td>
            </tr>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="上传"/></td>
            </tr>
        </table>
    </form>
</div>
<form:errors path="*" cssStyle="color:red"/>
<form:errors path="username" cssClass="errorClass"/>
</body>
</html>
