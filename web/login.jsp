

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
       <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <jsp:include page="./template/template.jsp">
            <jsp:param name="content" value="content_login"></jsp:param>
        </jsp:include>
    </body>

</html>

