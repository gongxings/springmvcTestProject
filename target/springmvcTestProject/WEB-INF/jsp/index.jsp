<%--
  Created by IntelliJ IDEA.
  User: daiwenkai
  Date: 2017/2/7
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>package apk</title>
</head>
<body>
<form action="/packagedApk" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>渠 道 号:</td>
            <td>
                <input type="text" name="channelNum" id="channelNum">
            </td>
        </tr>
        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="fileMsg" id="fileMsg"></td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
