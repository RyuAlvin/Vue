<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>表单get请求</h1>
<div>
    <form action="${rc.contextPath}/test1" method="get">
        <div>
            <label for="user-name-label">
                用户名：
            </label>
            <input id="user-name-label" type="text" name="username">
        </div>
        <div>
            <label for="password-label">
                密码：
            </label>
            <input id="password-label" type="text" name="password">
        </div>
        <div>
            <input type="submit" value="get提交">
        </div>
    </form>
</div>
<h1>表单post请求，enctype="application/x-www-form-urlencoded"</h1>
<div>
    <form action="${rc.contextPath}/test2" method="post" enctype="application/x-www-form-urlencoded">
        <div>
            <label for="user-name-label">
                用户名：
            </label>
            <input id="user-name-label" type="text" name="username">
        </div>
        <div>
            <label for="password-label">
                密码：
            </label>
            <input id="password-label" type="text" name="password">
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
</div>
<h1>表单post请求，enctype="multipart/form-data"</h1>
<div>
    <form action="${rc.contextPath}/testUpload" method="post" enctype="multipart/form-data">
        <div>
            <label for="file-label">
                选择要上传的文件：
            </label>
            <input id="file-label" type="file" name="file" multiple="multiple">
        </div>
        <div>
            <label for="user-name-label">
                用户名：
            </label>
            <input id="user-name-label" type="text" name="username">
        </div>
        <div>
            <label for="password-label">
                密码：
            </label>
            <input id="password-label" type="text" name="password">
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>