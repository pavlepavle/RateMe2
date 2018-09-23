<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var = "user" scope = "session" value = "${ulogovan_korisnik}"/>
<c:if test="${empty user}">
    <c:redirect url = "login.jsp"/>
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rate Movies!</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="./template/template.jsp">
            <jsp:param name="content" value="content_promoteuser"></jsp:param>
        </jsp:include>
    </body>

</html>

