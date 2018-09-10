<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/9
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
<form action="/user/register" method="POST">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">注册</h3>
        </div>
        <div class="panel-body">
            <label class="control-lable">用户名：</label>
            <input class="form-control" type="text" name="loginname" />
            <br/>
            <label class="control-label">密码：</label>
            <input class="form-control" type="text" name="password" />
            <br/>
            <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
            <input type="submit" class="btn btn-primary" />
        </div>
    </div>
</form>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>
