<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>500</title>
</head>
<body>
    <center style="margin:50px auto">
        <p>错误代码：500<%//request.getAttribute("javax.servlet.error.status.code")%></p>
        <p>您访问的页面有问题</p>
        <p>错误原因：${error.message}</p>
        <p>错误内容：${error}</p>
        <p><!--页面将在<span id="stime">5</span>秒后-->跳转到<a href="${pageContext.request.contextPath}/">首页</a>！</p>
    </center>
</body>
</html>
