<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2022/8/28
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript"src="../static/js/jquery.min.js"></script>
</head>
<body>
<shiro:hasAnyRoles name="admin,teacher,student">
    <a href="#" onclick="queryStudent()">查看学生</a>
</shiro:hasAnyRoles>

<shiro:hasAnyRoles name="admin,teacher,student">
    <a href="#">删除学生</a>
    <a href="#">修改学生</a>
    <a href="#" onclick="queryteacher()">查看老师</a>
</shiro:hasAnyRoles>

<shiro:hasAnyRoles name="admin">
    <a href="#">修改老师</a>
    <a href="#">删除老师</a>
</shiro:hasAnyRoles>

    <script>
        function queryStudent() {
            $.ajax({
                url: "../student/query/2",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    if (data.message == "noPermission"){
                        window.location.href="../sys/error"
                    }else {
                        console.log(data);
                        console.log("query success");
                    }
                }
            });

        }
    </script>
    <script>
        function queryteacher() {
            $.ajax({
                url: "../Teacher/query/2",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    if (data.message == "noPermission"){
                        window.location.href="../sys/error"
                    }else {
                        console.log(data);
                        console.log("query success");
                    }
                }
            });

        }
    </script>
</body>
</html>
