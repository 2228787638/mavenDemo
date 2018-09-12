<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看部门用户人数</title>
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/depart/departDisplayUser" method="POST">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">显示部门用户</h3>
                </div>
                <div class="panel-body">
                    <h3 class="panel-title">Id</h3>
                    Id:

                    <h3 class="panel-title">Loginname</h3>

                </div>
                <div class="panel-body">
                    <input type="text" name="id" hidden value="${requestScope.depart.id}"/><br/>
                    <input type="text" name="departname" hidden value="${requestScope.depart.departname}"/><br/>
                    <input type="text" name="description" hidden value="${requestScope.depart.description}"/><br/>
                    <input type="text" name="personcount" hidden value="${requestScope.depart.personcount}"/><br/>
                    <input type="submit" hidden value="submit"/>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
