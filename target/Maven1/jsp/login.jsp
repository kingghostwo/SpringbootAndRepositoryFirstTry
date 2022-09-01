<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2022/8/25
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript"src="../static/js/jquery.min.js"></script>
</head>
<body>
    <span>账号：</span>
    <input type="text" id="userName" name="userName">
    <br>
    <span>密码：</span>
    <input type="password" id="userPassword" name="userPassword">
    <br>
    <input type="button" value="登录" onclick="login()">
<script>
    function login() {
        var userName = $("#userName").val();
        var userPassword = $("#userPassword").val();
        console.log(userName)
        console.log(userPassword)
        $.ajax({
            url:"../sys/login",
            type:"GET",
            dataType:"json",
            data:{"userName":userName,"userPassword":userPassword},
            success:function (data) {
                console.log(data);
                if (data.status=="200"){
                    window.location.href="../sys/index";
                }
            },
            error:function(data){
                alert("error")
            }
        });

    }
</script>
</body>
</html>
