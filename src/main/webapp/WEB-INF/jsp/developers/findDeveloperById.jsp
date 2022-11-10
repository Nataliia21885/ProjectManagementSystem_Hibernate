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
       <form action="/developers/id">
           <label for="id"> Developer id(use only digits): </label><br>
           <input type="text" id="id" name="id"><br>
           <button type="submit">Find</button>
       </form>
       </br>
       <c:if test="${not empty developer.id}">
       <table>
          <thead>
             <tr>
               <td>Developer id:</td>
               <td>Developer name:</td>
               <td>Age:</td>
               <td>Sex:</td>
               <td>Salary:</td>
             </tr>
          </thead>
          <tbody>
             <tr>
                <td>
                    <c:out value="${developer.id}"/>
                </td>
                <td>
                    <c:out value="${developer.name}"/>
                </td>
                <td>
                    <c:out value="${developer.age}"/>
                </td>
                <td>
                    <c:out value="${developer.sex}"/>
                </td>
                <td>
                    <c:out value="${developer.salary}"/>
                </td>
             </tr>
          </tbody>
       </table>
       </c:if>
       <c:if test="${empty developer.id}">
       <p>Developer with such id does not find</p>
       </c:if>
    </body>
  </html>