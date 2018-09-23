
<body>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <p></p>

    <div class="container">
        <table class="table table-striped table-hover">



            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Average Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="l" items="${lista_top10}">
                    <tr>
                        <td></td>
                        <td><a href="./app?akcija=showmovie&movieID=${l.filmID}">${l.naziv} (${l.godina})</td>
                        <td>${l.ocena}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>
</body>

