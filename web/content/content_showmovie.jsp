<body>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <jsp:useBean id="ulogovan_korisnik" scope="session" class="model.Korisnik" />
    <jsp:useBean id="ocena" scope="session" class="model.Ocena" />
    
    
    <div class="container">

        <h1 class="mt-4 mb-3">${ocena.film.naziv}
            <small>(${ocena.film.godina})</small>
        </h1>



        <div class="row">

            <div class="col-md-8">

                <img class="img-fluid" src=${ocena.film.poster} alt="">

            </div>

            <div class="col-md-4">

                <h3 class="my-3">Plot</h3>
                <p>${ocena.film.opis}</p>

                <h3 class="my-3">Cast</h3>

                <ul>
                    <li>Lorem Ipsum</li>
                    <li>Dolor Sit Amet</li>
                    <li>Consectetur</li>
                    <li>Adipiscing Elit</li>
                </ul>
                <h3 class="my-3">Rating</h3>
                <form name="form_rating" id="form_rating" action="./app" method="POST">
                    <div class="rating">
                        <input type="radio" <c:if test = "${ocena.ocena == 5}"> checked="true" </c:if> id="star5" name="rating" value="5" required="true" /><label for="star5" title="5">5 stars</label>
                        <input type="radio" <c:if test = "${ocena.ocena == 4}"> checked="true" </c:if> id="star4" name="rating" value="4" /><label for="star4" title="4">4 stars</label>
                        <input type="radio" <c:if test = "${ocena.ocena == 3}"> checked="true" </c:if> id="star3" name="rating" value="3" /><label for="star3" title="3">3 stars</label>
                        <input type="radio" <c:if test = "${ocena.ocena == 2}"> checked="true" </c:if> id="star2" name="rating" value="2" /><label for="star2" title="2">2 stars</label>
                        <input type="radio" <c:if test = "${ocena.ocena == 1}"> checked="true" </c:if> id="star1" name="rating" value="1" /><label for="star1" title="1">1 star</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Rate</button>
                    <input type="hidden" name="filmID" value=${ocena.film.filmID}>
                    <input type="hidden" name="akcija" value="ratemovie" /> 
                </form>
            </div>



        </div>
        <br>

    </div>
</body>

