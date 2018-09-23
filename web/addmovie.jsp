<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
        <link rel="stylesheet" href="css/addmovie.css">

        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

        <script src="js/skripta.js"></script>

    </head>
    <body>
        <jsp:include page="./template/template.jsp">
            <jsp:param name="content" value="content_addmovie"></jsp:param>
        </jsp:include>
    </body>
</html>

