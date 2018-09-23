
<body>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <p></p>

    <div class="container">
        <c:forEach var="lf" items="${listaFilmova}">
            <div class="row">
                <div class="col-md-7">
                    <a href="./app?akcija=showmovie&movieID=${lf.filmID}">
                        <img class="img-fluid rounded mb-3 mb-md-0" src=${lf.poster} alt="">
                    </a>
                </div>
                <div class="col-md-5">
                    <h3>${lf.naziv} (${lf.godina})</h3>
                    <p>${lf.opis}</p>
                    <a class="btn btn-primary" href="./app?akcija=showmovie&movieID=${lf.filmID}">Rate
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
            <hr>

        </c:forEach>
    </div>
</body>

