<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>show</title>
</head>
<body>
    /WEB-INF/view/other.jsp,显示request作用域中的数据<br>
    <h3>msg数据：${msg}</h3>
    <h3>fun数据：${fun}</h3>
</body>
</html>
