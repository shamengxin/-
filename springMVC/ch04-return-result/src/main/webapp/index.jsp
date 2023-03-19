<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>请求方式</title>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <p>控制器方法返回String-逻辑视图名称</p>
    <form action="return-string-view1.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <br>
    <p>控制器方法返回String-完整视图路径</p>
    <form action="return-string-view2.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

    <br>
    <br>
    <button id="btnAjax">发起ajax请求</button>
</body>
</html>
