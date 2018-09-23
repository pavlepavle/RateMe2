<body id="LoginForm">
    <div class="container">

        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h1>Login</h1>
                    <p>Please enter your username and password</p>
                    <div class="error">
                        <b><h2>${signalLogin}</h2></b>
                    </div>
                    <h4 style="color: green">${signal}</h4>

                </div>
                <form id="Login" action="./app" method="POST">

                    <div class="form-group">


                        <input type="text" name="username" class="form-control" id="inputText" placeholder="Username">

                    </div>

                    <div class="form-group">

                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">

                    </div>
                    <div class="forgot">
                        <a href="register.jsp">Don't have account? Register now!</a>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                    <input type="hidden" name="akcija" value="login" />


                </form>
            </div>

        </div></div></div>

</body>
