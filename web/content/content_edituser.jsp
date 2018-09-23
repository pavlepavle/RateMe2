<jsp:useBean id="ulogovan_korisnik" scope="session" class="model.Korisnik" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<body id="LoginForm">
    <div class="container">

        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h1>Edit Profile</h1>
                    <h6 style="color: green">${poruka}</h6>
                </div>
                <div class="error-register">
                    <c:forEach var="greska" items="${listaGresaka}">
                        <p>${greska}</p>
                    </c:forEach>
                </div>
                <form id="Login" action="./app" method="POST">

                    <div class="form-group">


                        <input type="text" name="username" class="form-control" id="inputText" required="true" placeholder="Username" value=${ulogovan_korisnik.username}>

                    </div>

                    <div class="form-group">

                        <input type="password" name="password" class="form-control" id="inputPassword" required="true" placeholder="Password" value=${ulogovan_korisnik.password}>

                    </div>
                    <div class="form-group">

                        <input type="password" name="password_repeat" class="form-control" id="inputPassword" required="true" placeholder="Repeat password" value=${ulogovan_korisnik.password}>

                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Edit</button>
                    <input type="hidden" name="akcija" value="edituser" />


                </form>
            </div>

        </div></div></div>

</body>
