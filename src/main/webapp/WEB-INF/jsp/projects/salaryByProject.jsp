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
       <form action="/projects/salary">
           <label for="id"> Project name: </label><br>
           <input type="text" id="projectName" name="projectName"><br>
           <button type="submit">Find</button>
       </form>
       </br>
      <c:if test="${not empty salary}">
       <table>
          <thead>
             <tr>
               <td>Salary:</td>
             </tr>
          </thead>
          <tbody>
             <tr>
                <td>
                    <c:out value="${salary}"/>
                </td>
             </tr>
          </tbody>
       </table>
       </c:if>
       <c:if test="${empty salary}">
       <p>You enter wrong format. Please, try again</p>
       </c:if>
    </body>
  </html>