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
    <title>view Language</title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container text-center">

    <h1>******* Record *******</h1>

    <a class="btn btn-outline-primary my-4" href="/record/get-form">+ Add new Record</a>
    <div class="row">
        <div class="col-md-8 offset-2">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">User</th>
                    <th scope="col">Is_returned</th>
                    <th scope="col">DateTime</th>
                    <th scope="col">Books</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${recordList}" var="record" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>${record.userFullname}</td>
                        <td>${record.returned}</td>
                        <td>${record.dateTime}</td>
                        <c:forEach items="${record.bookList}" var="book">
                        <td>${book.title} |</td>
                        </c:forEach>
                        <td>
                            <a class="btn btn-warning" href="/record/edit/${record.recordId}">EDIT</a>
                            <a class="btn btn-danger" href="/record/delete/${record.recordId}">DELETE</a>
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
