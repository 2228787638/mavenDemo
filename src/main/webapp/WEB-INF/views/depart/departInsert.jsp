<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
    <!--bootstrap-->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
${requestScope.message}
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/depart/departInsert" method="POST">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">新增部门</h3>
                </div>
                <div class="panel-body">
                    <label class="control-label">Department: </label>
                    <input class="form-control" type="text" name="departname" />
                    <br/>
                    <label class="control-label">Description: </label>
                    <input class="form-control" type="text" name="description"/>
                    <br/>
                    <label class="control-label">Personcount: </label>
                    <input class="form-control" type="text" name="personcount"/>
                    <br/>
                    <input type="submit" class="btn btn-primary"/>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>
