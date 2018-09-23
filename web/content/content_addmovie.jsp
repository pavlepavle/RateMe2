<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<body>
    <form id="addmovieform" class="addmovieform" onsubmit="return validateGenreAndRole()"  action="./app" method="POST">
        <div class="main-div">
            <div class="panel">
                <h1>Add Movie</h1>
            </div>
            <div class="por">
                <p> ${porukaAM} </p>
            </div>
            <div class="greske">
                <c:forEach var="greska" items="${listaGresaka}">
                    <p>${greska}</p>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col">
                    <input type="text" name="title" required="required" class="form-control" placeholder="Title">
                </div>
                <div class="col">
                    <input type="text" name="year" required="required" class="form-control" placeholder="Year">
                </div>
                <div class="col">
                    <input type="text" name="duration" required="required" class="form-control" placeholder="Duration"">
                </div>
            </div>
            <div class="row">

                <div class="col">
                    <textarea class="form-control" required="required" name="plot" rows="2" placeholder="Plot" id="comment"></textarea>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#selectGenre" aria-expanded="false" aria-controls="selectGenre">
                        Select Genres
                    </button>
                    <p style="color: red;"id = "text"></p>
                </div>

                <div class="col">
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#addRole" aria-expanded="false" aria-controls="addRole">
                        Add Role
                    </button>
                    <p style="color: red;" id = "text2"></p>
                </div>
            </div>

            <div class="collapse" id="selectGenre">
                <div class="card card-body">
                    <div class="flexy">
                        <p class="genreError"></p>
                        <c:forEach var="z" items="${listaZanrova}">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="zanrovi" id="zanrovi" type="checkbox" id="inlineCheckbox1" value=${z.zanrID}>
                                <label class="form-check-label" for="inlineCheckbox1">${z.naziv}</label>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="collapse" id="addRole">
                <!-- <div class="card card-body">

                     <label class="form-check-label">Add role</label>
                     <div class="addrole">
                         <div class="row">
                             <div class="col">
                                 <input type="text" class="form-control" placeholder="Name">
                             </div>
                             <div class="col">


                                 <input type="text" class="form-control" placeholder="Role Type">

                             </div>
                             <div class="col">
                                 <input type="text" class="form-control" placeholder="Role Name">
                             </div>
                             <div class="col">
                                 <button type="submit" style="font-size: 15px; font-weight: bold;"  class="btn btn-outline-primary">+</button>
                             </div>
                         </div>
                         <table class="table">
                             <thead class="thead-dark">
                                 <tr>
                                     <th scope="col">#</th>
                                     <th scope="col">Name</th>
                                     <th scope="col">Role Type</th>
                                     <th scope="col">Role Name</th>
                                 </tr>
                             </thead>
                             <tbody>
                                 <tr>
                                     <th scope="row">1</th>
                                     <td></td>
                                     <td></td>
                                     <td></td>
                                 </tr>
                             </tbody>
                         </table>
                     </div>
                 </div>
             </div> -->
                <table id="myTable" class=" table order-list">
                    <thead>
                        <tr>
                            <td>Name</td>
                            <td>Role Type</td>
                            <td>Role Name</td>
                            <td><input type="button" class="btn-primary" id="addrow" value="Add Row" /></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="col-sm-4">
                            </td>
                            <td class="col-sm-4">
                            </td>
                            <td class="col-sm-3">
                            </td>
                            <td class="col-sm-2"><a class="deleteRow"></a>
                            </td>
                        </tr>
                    </tbody>           

                    <input type="hidden"  name="brojUloga" id="brojUloga" value="0">           
                </table>
            </div>
            <input type="submit" class="btn btn-info" id="addMovie" value="Add Movie" />
            <input type="hidden" name="akcija" value="addmovie" />
        </div>
    </form>
</body>
