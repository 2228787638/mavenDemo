<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/7
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<form action="/user/userModified" method="POST">
   <input type="text" name="id" hidden value="${requestScope.user.id}"/><br/>
    账号: <input type="text" name="loginname" value="${requestScope.user.loginname}"/><br/>
    密码: <input type="text" name="password" value="${requestScope.user.password}"/><br/>
    身份: <input type="text" name="role" value="${requestScope.user.role}"/><br/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
