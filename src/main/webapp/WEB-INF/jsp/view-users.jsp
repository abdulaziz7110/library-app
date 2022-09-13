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
    <title>View Users</title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container text-center">

    <h1>..... USERS .....</h1>

    <a class="btn btn-outline-primary my-4" href="/users/add-form">+ Add new Category</a>
    <div class="row">
        <div class="col-md-6 offset-3">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">FullName</th>
                    <th scope="col">PhoneNumber</th>
                    <th scope="col">password</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>${user.id}</td>
                        <td>${user.fullName}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.password}</td>
                        <td>
                            <a class="btn btn-warning" href="/users/edit/${user.id}">EDIT</a>
                            <a class="btn btn-danger" href="/users/delete/${user.id}">DELETE</a>
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
