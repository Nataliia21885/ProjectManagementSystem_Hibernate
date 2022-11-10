<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </head>
    <body>
      <c:import url="/WEB-INF/jsp/navigation.jsp"/>
      <h3 style="color:blue;">Update developer:</h3>
      <form action="/developers/upd" method="post">
          <label for="id"> Developer id(use only digits): </label><br>
          <input type="text" id="id" name="id"><br>
          <label for="name"> Developer name: </label><br>
          <input type="text" id="name" name="name"><br>
          <label for="name"> Age(use only digits): </label><br>
          <input type="text" id="age" name="age"><br>
          <label for="name"> Sex(male/female): </label><br>
          <input type="text" id="sex" name="sex"><br>
          <label for="name"> Salary(use only digits): </label><br>
          <input type="text" id="salary" name="salary"><br>
          <button type="submit">Update</button>
      </form>
      </br>
    </body>
  </html>

