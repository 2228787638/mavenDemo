<%--
  Created by IntelliJ IDEA.
  User: yif
  Date: 2018/9/5
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户管理</title>
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
                <h1>员工系统</h1>
            </div>
        </div>

        <%--新增,删除按钮--%>
        <div class="row" style="margin-top: 20px;">
            <div class="col-md-12">
                <button class="btn-primary btn-sm" style="margin-left: 74%;">
                    <a href="/user/goToNewInsert">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"><font color = "white">新增</font></span>
                    </a>
                </button>
            </div>
        </div>
        <%--显示员工数据--%>
        <div class="row" style="margin-top: 20px">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <th>id</th>
                        <th>账号</th>
                        <th>密码</th>
                        <th>身份</th>
                        <th>部门</th>
                        <th>操作</th>
                    </tr>
                    <%--遍历数据--%>
                    <c:forEach items="${requestScope.userList.list}" var="emp">

                        <tr>
                            <th>${emp.id}</th>
                            <th>${emp.loginname}</th>
                            <th>${emp.password}</th>
                            <th>${emp.role}</th>
                            <th>${emp.departid}</th>
                            <th>
                                <button class="btn-primary btn-sm">
                                    <a href="/user/userModify?id=${emp.id}">
                                       <span class="glyphicon glyphicon-pencil" aria-hidden="true"><font color="white">编辑</font></span>
                                    </a>
                                </button>
                                <button class="btn-danger btn-sm">
                                    <a href="/user/userRemove?id=${emp.id}">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"><font color="white">删除</font></span>
                                    </a>
                                </button>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>

        <%--显示分页信息--%>
        <div class="row">
            <%--分页信息--%>
            <div class="col-md-6">
                当前第 ${requestScope.userList.pageNum } 页,总共 ${requestScope.userList.pages }
                页,总共 ${requestScope.userList.total } 条记录
            </div>
            <%--分页条信息--%>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <%--首页--%>
                        <li><a href="${APP_PATH}/user/userList?pageNum=1">首页</a></li>
                        <%--上一页--%>
                        <c:if test="${requestScope.userList.hasPreviousPage}">
                            <li>
                                <a href="${APP_PATH }/user/userList?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <%--当前页--%>
                        <c:forEach items="${requestScope.userList.navigatepageNums }" var="page_Num">
                            <c:if test="${page_Num == requestScope.userList.pageNum }">
                                <li class="active"><a href="#">${page_Num }</a></li>
                            </c:if>
                            <c:if test="${page_Num != requestScope.userList.pageNum }">
                                <li><a href="${APP_PATH }/user/userList?pageNum=${page_Num }">${page_Num }</a></li>
                            </c:if>

                        </c:forEach>
                        <%--下一页--%>
                        <c:if test="${requestScope.userList.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/user/userList?pageNum=${requestScope.userList.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <%--末页--%>
                        <li><a href="${APP_PATH}/user/userList?pageNum=${requestScope.userList.pages}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
