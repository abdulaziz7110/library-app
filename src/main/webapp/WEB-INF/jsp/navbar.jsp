<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 02/08/22
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<!--NAVIGATION BAR | SAYTNI MENYU QISMI-->
<nav class="navbar navbar-light bg-light">

    <div class="logo">
        <h1 class="text-warning"> LIBRARY-APP </h1>
    </div>
    <div class="menu">
        <ul class="d-flex">
            <li class="mx-3"><a href="/books">Books</a></li>
            <li class="mx-3"><a href="/language">Languages</a></li>
            <li class="mx-3"><a href="/category" >Categories</a></li>
            <li class="mx-3"><a href="/author">Authors</a></li>
            <li class="mx-3"><a href="/users">Users</a></li>
            <li class="mx-3"><a href="/record">Record</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
