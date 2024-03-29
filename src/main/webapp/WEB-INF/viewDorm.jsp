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
      <h1><c:out value="${thisDorm.name}" /> Students</h1>
      <a href="/" class="btn">Back To Home</a>
    </div>
    <hr />
    <div class="d-flex text-center card p-3 mb-3">
      <form action="/dorm/${thisDorm.id}/add-student" method="POST" modelAttribute="newDormStudent">
          <label class="form-label" for="students">Students:</label>
          <select name="students" class="form-select mb-3">
            <c:forEach var="student" items="${allStudents}">
                <c:if test="${student.dorm != thisDorm}">
                    <option value="${student.id}">
                      <c:out value="${student.name}" />
                      (<c:out value="${student.dorm.name}" />)
                    </option>
                </c:if>
            </c:forEach>
          </select>
          <button class="btn">Add</button>
        </div>
      </form>
    <div class="justify-content-center">
      <table class="table text-center" id="directory">
        <thead>
          <tr>
            <th>Dorm</th>
            <th>Actions</th>
          </tr>
        </thead>
        <c:forEach var="thisStudent" items="${thisDorm.students}">
          <tr>
            <td>
              <c:out value="${thisStudent.name}"></c:out>
            </td>
            <td>
              <a href="/student/${thisStudent.id}/delete/${thisDorm.id}" class="btn btn-action"
                >Remove</a
              >
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
