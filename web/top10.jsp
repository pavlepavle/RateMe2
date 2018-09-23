<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var = "user" scope = "session" value = "${ulogovan_korisnik}"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top 10 Movies!</title>
        <link rel="stylesheet" href="css/table.css">
    </head>
    <body>
        <jsp:include page="./template/template.jsp">
            <jsp:param name="content" value="content_top10"></jsp:param>
        </jsp:include>
    </body>

</html>

