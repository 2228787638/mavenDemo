<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看部门用户人数</title>
    <!--bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 搭建显示页面 -->
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="text-align: center">
            <h1>显示部门用户</h1>
        </div>
    </div>

    <%--显示员工数据--%>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>id</th>
                    <th>账号</th>
                    <th>身份</th>
                </tr>
                <%--遍历数据--%>
                <c:forEach items="${requestScope.departList.list}" var="emp">
                    <tr>
                        <th>${emp.id}</th>
                        <th>${emp.loginname}</th>
                        <th>${emp.role}</th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<div class="row">
    <%--分页信息--%>
    <div class="col-md-6">
        当前第 ${requestScope.departList.pageNum } 页,总共 ${requestScope.departList.pages }
        页,总共 ${requestScope.departList.total } 条记录
    </div>
    <div class="col-md-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <%--上一页--%>
                <c:if test="${requestScope.displayDepartUser.hasPreviousPage}">
                    <li>
                        <a href="${APP_PATH }/depart/displayDepartUser?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <%--当前页--%>
                <c:forEach items="${requestScope.displayDepartUser.navigatepageNums }" var="page_Num">
                    <c:if test="${page_Num == requestScope.displayDepartUser.pageNum }">
                        <li class="active"><a href="#">${page_Num }</a></li>
                    </c:if>
                    <c:if test="${page_Num != requestScope.displayDepartUser.pageNum }">
                        <li><a href="${APP_PATH }/depart/displayDepartUser?pageNum=${page_Num }">${page_Num }</a></li>
                    </c:if>
                </c:forEach>
                <%--下一页--%>
                <c:if test="${requestScope.displayDepartUser.hasNextPage}">
                    <li>
                        <a href="${APP_PATH}/depart/displayDepartUser?pageNum=${requestScope.displayDepartUser.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
