<body>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 

    <p></p>

    <div class="container">
        <p style="color: green">${poruka}</p>
        <form id="promoteuser" action="./app" method="POST">
            <table class="table table-striped table-hover">

                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Username</th>
                        <th scope="col">Administrator</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="k" items="${listaKorisnika}">
                        <tr>
                            <td>${k.username}</td>
                            <td>${k.administrator}</td>
                            <td><button type="submit" name="b23" class="btn btn-secondary" value=${k.username}>Promote</button></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <input type="hidden" name="akcija" value="promoteuser">
        </form>
    </div>
</body>

