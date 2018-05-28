<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload page</title>
</head>
<body>

<p>Common file upload example</p>
<form action="file.upload" enctype="multipart/form-data" method="POST">
<input type = "file" name = "file"><br>
    <input type="text" name = "test">
        <input type = "submit" value="Upload File"><br>
</form>

</body>
</html>