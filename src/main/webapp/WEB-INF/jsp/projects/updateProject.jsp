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
        <form action="/projects/update">
                   <label for="id"> Project id(use only digits): </label><br>
                   <input type="text" id="id" name="id"><br>
                   <label for="name"> Project name: </label><br>
                   <input type="text" id="projectName" name="projectName"><br>
                   <label for="name"> Country: </label><br>
                   <input type="text" id="country" name="country"><br>
                   <label for="name"> Cost(use only digits): </label><br>
                   <input type="text" id="cost" name="cost"><br>
                   <label for="name"> Date of creation(in format: YY-MM-DD): </label><br>
                   <input type="text" id="dateOfCreation" name="dateOfCreation"><br>
                   <button type="submit">Update</button>
        </form>
        </br>
        <c:if test="${not empty updatedProject}">
        <table>
            <thead>
                     <tr>
                        <td>Project name:</td>
                        <td>Country:</td>
                        <td>Cost:</td>
                        <td>Date of creation:</td>
                     </tr>
            </thead>
           <tbody>
                     <tr>
                         <td>
                             <c:out value="${updatedProject.projectName}"/>
                         </td>
                         <td>
                             <c:out value="${updatedProject.country}"/>
                         </td>
                         <td>
                            <c:out value="${updatedProject.cost}"/>
                         </td>
                         <td>
                            <c:out value="${updatedProject.dateOfCreation}"/>
                         </td>
                     </tr>
           </tbody>
        </table>
        <p>Project is updated successfully</p>
         </c:if>
          <c:if test="${empty updatedProject}">
             <p>${message}</p>
          </c:if>
    </body>
  </html>