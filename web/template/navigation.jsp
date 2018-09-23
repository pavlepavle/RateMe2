<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Home</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./app?akcija=top10">Top10</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./app?akcija=notrated">Unrated</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Ratings
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                        <a class="dropdown-item" href="./app?akcija=yourratings1">1 Column Ratings</a>
                        <a class="dropdown-item" href="./app?akcija=yourratings2">2 Column Ratings</a>
                        <a class="dropdown-item" href="./app?akcija=yourratings3">3 Column Ratings</a>
                        <a class="dropdown-item" href="./app?akcija=yourratings4">4 Column Ratings</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./app?akcija=showusers">Promote User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="edituser.jsp">Edit Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./app?akcija=generatemovieform">Add Movie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./app?akcija=showmoviesadmin">Delete Movie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./app?akcija=logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

