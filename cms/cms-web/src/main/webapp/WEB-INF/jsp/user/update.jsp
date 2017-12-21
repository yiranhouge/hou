<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title><spring:message code="user.list"/></title>
</head>
<body>
<div class="breadcrumb">
    <span class="crust"><a href="${basePath}/" class="crumb">首页</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="${basePath}/user" class="crumb">用户管理</a><span
            class="arrow"><span>&gt;</span></span></span>
    <span class="crust"><a href="" class="crumb">用户列表</a><span class="arrow"><span>&gt;</span></span></span>
</div>
<div id="main">
    <table id="datagrid" class="datagrid" border="1">
        <caption><i class="fa fa-list-ol"></i>用户列表 <a href="${basePath}/user/add">添加</a></caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>账号</th>
                <th>密码</th>
                <th>昵称</th>
                <th>性别</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.nickname}</td>
                    <td>
                        <c:if test="${user.sex==1}">男</c:if>
                        <c:if test="${user.sex==2}">女</c:if>
                    </td>
                    <td>
                        ${user.time}
                    </td>
                    <td>
                        <a href="${basePath}/book/list/${user.id}">书籍管理</a>
                        <a href="${basePath}/user/update/${user.id}">修改</a>
                        <a href="${basePath}/user/delete/${user.id}" onclick="return confirm('确认删除吗？');">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pages">${paginator.html}</div>
</div>
</body>
</html>
