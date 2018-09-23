<body>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <p>${porukaDelete}</p>

    <div class="container">
        <table class="table table-striped table-hover">



            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="f" items="${listaFilmova}">
                <form action="./app" method="POST">
                    <tr>
                        <td></td>
                        <td><a href="./app?akcija=showmovie&movieID=${f.filmID}">${f.naziv} (${f.godina})</td>
                        <td><button type="submit" class="btn btn-primary">Delete</button></td>
                    </tr>
                    <input type="hidden" name="filmID" value=${f.filmID} />
                    <input type="hidden" name="akcija" value="deletemovie" />
                </form>
            </c:forEach>
            </tbody>

        </table>
    </div>
</body>

