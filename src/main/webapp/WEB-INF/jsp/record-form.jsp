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
  <title>Record FORM</title>
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

  <h1>======= ADD NEW Record ========</h1>

  <div class="row">
    <div class="col-md-6 offset-3">
      <form action="/record" method="post">

        <div class="form-group">
          <label for="categoryId">Category:</label>
          <select required class="form-control" id="categoryId" name="userId">
            <option selected disabled value="0">Select User:</option>
            <c:forEach items="${userList}" var="user">
              <option value="${user.id}">${user.fullName}</option>
            </c:forEach>
          </select>
        </div>

        <br>

        <div class="form-group">
          <label for="kkk">Authors:</label>
          <select id="kkk"
                  class="selectpicker form-control"
                  multiple
                  aria-label="Please select authors"
                  data-live-search="true"
                  name="bookIds"
          >
            <c:forEach items="${bookList}" var="book">
              <option value="${book.id}">${book.title}</option>
            </c:forEach>
          </select>
        </div>

        <button type="submit" class="btn btn-primary">Saqlash</button>
      </form>
    </div>
  </div>
</div>


</body>
</html>
