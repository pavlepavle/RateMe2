
<body>

    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <jsp:useBean id="ulogovan_korisnik" scope="session" class="model.Korisnik" />

    <p></p>
    <div class="container">
        <div class="row">
            <c:forEach var="o" items="${listaOcena}">
                <div class="col-lg-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <a href="./app?akcija=showmovie&movieID=${o.film.filmID}"><img class="card-img-top" src=${o.film.poster} alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="./app?akcija=showmovie&movieID=${o.film.filmID}">${o.film.naziv} (${o.film.godina})</a>
                            </h4>
                            <h5>Your rate: ${o.ocena}</h5>
                            <p class="card-text">${o.film.opis}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>

