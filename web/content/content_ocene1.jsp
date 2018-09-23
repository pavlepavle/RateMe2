
<body>

    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <jsp:useBean id="ulogovan_korisnik" scope="session" class="model.Korisnik" />

    <p></p>
    <div class="container">
        <c:forEach var="o" items="${listaOcena}">
            <div class="row">
                <div class="col-md-7">
                    <a href="./app?akcija=showmovie&movieID=${o.film.filmID}">
                        <img class="img-fluid rounded mb-3 mb-md-0" src=${o.film.poster} alt="">
                    </a>
                </div>
                <div class="col-md-5">
                    <h3>${o.film.naziv} (${o.film.godina})</h3>
                    <h5>Your rate: ${o.ocena}</h5>
                    <p>${o.film.opis}</p>
                    <a class="btn btn-primary" href="./app?akcija=showmovie&movieID=${o.film.filmID}">Rate
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
            <hr>
        </c:forEach>
    </div>
</body>

