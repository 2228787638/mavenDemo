<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门编辑</title>
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/depart/departModified" method="POST">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">编辑部门</h3>
                </div>
                <div class="panel-body">
                    <input type="text" name="id" hidden value="${requestScope.depart.id}"/><br/>
                    Departname:  <input type="text" name="departname" value="${requestScope.depart.departname}"/><br/>
                    Description: <input type="text" name="description" value="${requestScope.depart.description}"/><br/>
                    Personcount: <input type="text" name="personcount" value="${requestScope.depart.personcount}"/><br/>
                    <input type="submit" value="submit"/>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
