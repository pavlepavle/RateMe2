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
        <title>Ratings 2 columns</title>
    </head>
    <body>
        <jsp:include page="./template/template.jsp">
            <jsp:param name="content" value="content_ocene2"></jsp:param>
        </jsp:include>
    </body>
</html>