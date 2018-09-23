<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<body id="LoginForm">
    <div class="container">

        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h1>Register</h1>
                    <p>Please enter username and password</p>
                </div>
                <div class="error-register">
                    <c:forEach var="greska" items="${listaGresaka}">
                        <p>${greska}</p>
                    </c:forEach>
                </div>
                <form id="Login" action="./app" method="POST">

                    <div class="form-group">


                        <input type="text" name="username" class="form-control" id="inputText" required="true" placeholder="Username">

                    </div>

                    <div class="form-group">

                        <input type="password" name="password" class="form-control" id="inputPassword" required="true" placeholder="Password">

                    </div>
                    <div class="form-group">

                        <input type="password" name="password_repeat" class="form-control" id="inputPassword" required="true" placeholder="Repeat password">

                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Register</button>
                    <input type="hidden" name="akcija" value="register" />


                </form>
            </div>

        </div></div></div>

</body>
