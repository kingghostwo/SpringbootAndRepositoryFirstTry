<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2022/8/21
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<form action="file/upload"
      method="post" enctype="multipart/form-data">
    选择文件<input type="file"name="file"width="120px">
    <input type="submit" value="上传">
</form>
<hr/>
<a href="${pageContext.request.contextPath }/file/download?filename=IDCardFront.jpg">download</a>
</body>
</html>
