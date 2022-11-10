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
      <h3 style="color:blue;">Create new skill:</h3>
        <form action="/skills" method="post">
            <label for="name"> Language: </label><br>
            <input type="text" id="language" name="language"><br>
            <label for="name"> Level: </label><br>
            <input type="text" id="level" name="level"><br>
            <button type="submit">Save</button>
        </form>
        </br>
    </body>
 </html>