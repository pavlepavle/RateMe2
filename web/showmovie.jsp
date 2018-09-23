
<c:set var = "user" scope = "session" value = "${ulogovan_korisnik}"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/ratings.css">
    </head>
    <body>
        <jsp:include page="./template/template.jsp">
            <jsp:param name="content" value="content_showmovie"></jsp:param>
        </jsp:include>
    </body>
</html>