<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Dorm Homepage</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
    <!-- FONTS -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;800&family=Playfair+Display:wght@800&display=swap"
      rel="stylesheet"
    />
    <!--  -->
  </head>
  <body>
    <div class="d-flex justify-content-between align-items-center">
      <h1 class="mb-0">Dorms</h1>
      <a href="/" class="btn">Back To Home</a>
    </div>
    <hr />
    <div class="d-flex justify-content-start align-items-sm-baseline mb-4">
      <a href="/dorm/new" class="btn me-3">Add a new Dorm</a>
      <a href="/student/new" class="btn">Add a new Student</a>
    </div>
    <div class="justify-content-center">
      <table class="table text-center" id="directory">
        <thead>
          <tr>
            <th>Dorm</th>
            <th>Actions</th>
          </tr>
        </thead>
        <c:forEach var="dorm" items="${allDorms}">
          <tr>
            <td>
              <c:out value="${dorm.name}"></c:out>
            </td>
            <td>
              <a href="/dorm/${dorm.id}" class="btn btn-action">See Students</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
