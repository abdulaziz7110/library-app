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
    <title>Author FORM</title>
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

    <h1>======= ADD Author ========</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/author" method="post">

                <div class="mb-3">
                    <label for="fullname" class="form-label">Fullname</label>
                    <input name="fullName" type="text" class="form-control" id="fullname">
                </div>

                <div class="mb-3">
                    <label for="bookDescription" class="form-label">Age:</label>
                    <input name="age" type="number" class="form-control" id="bookDescription">
                </div>

                <div class="mb-3">
                    <label for="isbn" class="form-label">Biography</label>
                    <input name="biography" type="text" class="form-control" id="isbn">
                </div>

                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
