<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/6
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
    <!--bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
${requestScope.message}
<form action="/user/userInsert" method="POST">
    <div class="col-sm-9 col-md-6 col-lg-4" style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444,
                                                   inset -1px 1px 1px #444;">
        <p>Login name:
            <div class="col-xs-3 col-sm-3">
            <input class="form-control" type="text" name="loginname" />
            </div>
            <br/>
        </p>
        <br/>
        <p>Password:
            <div class="col-xs-3 col-sm-3">
            <input class="form-control" type="text" name="password" />
            </div>
            <br/>
        </p>
        <br/>
        <input type="submit" class="btn btn-primary" />
    </div>
</form>
</body>
</html>
