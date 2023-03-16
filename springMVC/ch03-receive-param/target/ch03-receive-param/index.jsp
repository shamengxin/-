<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>请求方式</title>
</head>
<body>
    <p>逐个接收请求参数</p>
    <form action="receive-property.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>

        <input type="submit" value="提交参数">
    </form>
</body>
</html>
