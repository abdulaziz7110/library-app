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
    <title>Book FORM</title>
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

    <h1>======= ADD NEW BOOK ========</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/books" method="post">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">Title</label>
                    <input name="title" type="text" class="form-control" id="bookTitle">
                </div>

                <div class="mb-3">
                    <label for="bookDescription" class="form-label">Description</label>
                    <input name="description" type="text" class="form-control" id="bookDescription">
                </div>

                <div class="mb-3">
                    <label for="isbn" class="form-label">ISBN</label>
                    <input name="isbn" type="number" class="form-control" id="isbn">
                </div>



                <div class="form-group">
                    <label for="authorsIds">Authors:</label>
                    <select id="authorsIds"
                            class="selectpicker form-control"
                            multiple
                            aria-label="Please select authors"
                            data-live-search="true"
                            name="authorsIds"
                    >
                        <c:forEach items="${authorList}" var="val">
                            <option value="${val.authorId}">${val.authorFullName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="categoryId">Category:</label>
                    <select required class="form-control" id="categoryId" name="categoryId">
                        <option selected disabled value="0">Select category:</option>
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="categoryId">Language:</label>
                    <select required class="form-control" id="language" name="languageId">
                        <option selected disabled value="0">Select category:</option>
                        <c:forEach items="${languageList}" var="language">
                            <option value="${language.id}">${language.name}</option>
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
