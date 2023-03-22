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
    /WEB-INF/view/show.jsp,显示request作用域中的数据<br>
    <h3>myname数据：${myname}</h3>
    <h3>myage数据：${myage}</h3>
</body>
</html>
