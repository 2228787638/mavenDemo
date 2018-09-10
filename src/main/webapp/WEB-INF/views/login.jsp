<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/9
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <!--bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
${requestScope.message}
<br><br><br><br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/user/login" method="POST">
            <font color="red">${requestScope.message}</font>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">登录</h3>
                </div>
                <div class="panel-body">
                    <label class="control-label">账号: </label>
                    <input class="form-control" type="text" name="loginname" />
                    <br/>
                    <label class="control-label">密码: </label>
                    <input class="form-control" type="password" name="password" />
                    <br/>
                    <input type="submit" class="btn btn-primary" />
                </div>
            </div>
        </form>

    </div>
    <div class="col-md-4"></div>

</div>
</body>
</html>
