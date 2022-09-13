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
    <title>view Books </title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container text-center">

    <h1>======= BOOKS ========</h1>

    <a class="btn btn-outline-primary my-4" href="/books/get-form">+ Add new book</a>
    <div class="row">
        <div class="col-md-6 offset-3">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${kitoblar}" var="bookDto" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>
                            <a href="/books/about/${bookDto.id}">${bookDto.title}</a>
                        </td>
                        <td>
                            <c:forEach items="${bookDto.authorDtoList}" var="author">
                                <a href="/authors/about/${author.authorId}">${author.authorFullName}</a> |
                            </c:forEach>
                        </td>
                        <td>
                            <a class="btn btn-warning" href="/books/edit/${bookDto.id}">EDIT</a>
                            <a class="btn btn-danger" href="/books/delete/${bookDto.id}">DELETE</a>
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
