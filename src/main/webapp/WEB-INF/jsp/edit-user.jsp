<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 08/09/22
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit User</title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">

    <%--    SCRIPTS     --%>
    <script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>


</head>
<body>

<div class="container text-center">

    <h1>======= Edit Book ========</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/users/edit/hhh" method="post">

                <input name="id" hidden value="${id} ">

                <div class="mb-3">
                    <label for="language1" class="form-label">FullName</label>
                    <input name="fullName" type="text" class="form-control" id="language1">
                </div>
                <div class="mb-3">
                    <label for="language" class="form-label">PhoneNumber</label>
                    <input name="phoneNumber" type="text" class="form-control" id="language">
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input name="password" type="text" class="form-control" id="password">
                </div>

                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
