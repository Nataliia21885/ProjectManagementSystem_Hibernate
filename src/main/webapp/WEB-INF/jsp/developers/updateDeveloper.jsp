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
        <form action="/developers/update">
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
        <c:if test="${not empty updatedDeveloper}">
        <table>
            <thead>
                     <tr>
                        <td>Developer name:</td>
                        <td>Age:</td>
                        <td>Sex:</td>
                        <td>Salary:</td>
                     </tr>
            </thead>
           <tbody>
                       <tr>
                           <td>
                               <c:out value="${updatedDeveloper.name}"/>
                           </td>
                           <td>
                               <c:out value="${updatedDeveloper.age}"/>
                           </td>
                           <td>
                               <c:out value="${updatedDeveloper.sex}"/>
                           </td>
                           <td>
                               <c:out value="${updatedDeveloper.salary}"/>
                           </td>
                       </tr>
           </tbody>
        </table>
        <p>Developer is updated successfully</p>
         </c:if>
          <c:if test="${empty updatedDeveloper}">
             <p>${message}</p>
          </c:if>
    </body>
  </html>