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
    <title>View Author</title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container text-center">

    <h1>******* Author *******</h1>

    <a class="btn btn-outline-primary my-4" href="/author/get-form">+ Add new Author</a>
    <div class="row">
        <div class="col-md-6 offset-3">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authorList}" var="author" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>${author.id}</td>
                        <td>${author.fullName}</td>
                        <td>${author.age}</td>
                        <td>
                            <a class="btn btn-warning" href="/author/edit/${author.id}">EDIT</a>
                            <a class="btn btn-danger" href="/author/delete/${author.id}">DELETE</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
</div>


</body>
</html>
