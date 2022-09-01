<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2022/8/25
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户翻页</title>
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/jq-paginator.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <table class="table">
        <tr class="active">
            <th>用户名</th>
            <th>age</th>
            <th>sex</th>
            <th>birth</th>
            <th>操作</th>
        </tr>
        <tbody id="tab">

        </tbody>
        <tr class="btn btn-light">
            <td colspan="8">
                <ul class="pagination" id="pagination1"></ul>
        </tr>
    </table>
    <script>
        var total = 0;
        var totalPages = 0;
        var visiblePages = 2;
        var currentPage = 0;

        $(document).ready(function(){
            //第一次访问。初始化方法
            showPage(-1);

            $('#pagination1').jqPaginator({
                totalPages: totalPages,//总条数
                visiblePages: visiblePages,//总页数
                currentPage: currentPage,//显示分页的按钮数
                totalCounts: total,//当前页码
                first: '<li class="first"><a href="javascript:void(0);">第一页 </a></li>',
                prev: '<li class="prev"><a href="javascript:void(0);">前一页 </a></li>',
                next: '<li class="next"><a href="javascript:void(0);">下一页 </a></li>',
                last: '<li class="last"><a href="javascript:void(0);">最后一页 </a></li>',
                page: '<li class="page"><a href="javascript:void(0);">{{page}} </a></li>',
                onPageChange: function (num) {
                    //num代表改变过后的页码。
                    showPage(num);
                }
            });
        });

        function showPage(pageNum) {
            $.ajax({
                url: "user/userPage/" + pageNum + "/2",
                type: "GET",
                async:false,//同步请求
                dataType: "json",
                success:function (data) {
                    if (pageNum==-1){
                        total = data.total;
                        totalPages = data.pages;
                        currentPage = data.pageNum;
                    }

                    $('#tab').html("");

                    var str='';
                    for (var i=0;i<data.list.length;i++){
                        str += "<tr>" +
                            "<td>" + data.list[i].userName + "</td>" +
                            "<td>" + data.list[i].userAge + "</td>" +
                            "<td>" + data.list[i].userSex + "</td>" +
                            "<td>" + data.list[i].userBirthday + "</td>" +
                            "<td>" +
                            "<button type='button'>删除</button>" +
                            "<button type='button'>修改</button>" +
                            "</td>" +
                            "</tr>";
                    }
                    $("#tab").append(str);
                },
                error:function () {
                    alert("error")

                }
            });

        }
    </script>
</body>
</html>
