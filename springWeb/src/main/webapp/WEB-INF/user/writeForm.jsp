<%--
  Created by IntelliJ IDEA.
  User: jangjihun
  Date: 3/21/24
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">

        table{
            border-collapse: collapse;
        }

        th,td{
            padding: 5px;
        }

        #writeForm div {
            font-size: 8pt;
            font-weight: bold;
            color: red;
        }



    </style>

</head>
<body>

    <a href=''><img src="../image/green.gif"  height="50" width="50"> </a>
    <form id="writeForm">

        <table border="1">
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" id="name">
                    <div id="nameDiv"></div>
                </td>
            </tr>

            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" name="id" id="id">
                    <div id="idDiv"></div>
                </td>
            </tr>

            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" name="pwd" id="pwd">
                    <div id="pwdDiv"></div>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="입력" id="writeBtn">
                    <input type="reset" value="취소">
                </td>
            </tr>

        </table>

    </form>


    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="../js/write.js"></script>


</body>
</html>
