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
    <title>Project Name here</title>
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
      <h1 class="mb-0">Add a new student</h1>
      <a href="/" class="btn">Back To Home</a>
    </div>
    <hr />
    <div class="card p-3">
      <form:form
        action="/student/create"
        method="POST"
        modelAttribute="newStudent"
      >
        <div class="d-flex align-items-center mb-3">
          <form:label for="name" path="name" class="me-4 col-2"
            >Name:
          </form:label>
          <form:input type="text" class="form-control" for="name" path="name" />
        </div>
        <div class="d-flex align-items-center mb-3">
          <form:label for="dorm" path="dorm" class="me-4 col-2"
            >Name:
          </form:label>
          <select name="dorm" class="form-select">
            <c:forEach var="dorm" items="${allDorms}">
              <option value="${dorm.id}">
                <c:out value="${dorm.name}"></c:out>
              </option>
            </c:forEach>
          </select>
        </div>
        <div class="d-grid">
          <form:errors
            path="name"
            class="alert alert-danger mb-3"
          ></form:errors>
          <button class="btn">Add Student</button>
        </div>
      </form:form>
    </div>
  </body>
</html>
