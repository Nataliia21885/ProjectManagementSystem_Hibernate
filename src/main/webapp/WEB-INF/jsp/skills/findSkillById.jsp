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
       <form action="/skills/id">
           <label for="id"> Skill id(use only digits): </label><br>
           <input type="text" id="id" name="id"><br>
           <button type="submit">Find</button>
       </form>
       </br>
       <c:if test="${not empty skill.id}">
       <table>
          <thead>
             <tr>
               <td>Skill id:</td>
               <td>Language:</td>
               <td>Level:</td>
             </tr>
          </thead>
          <tbody>
             <tr>
                <td>
                    <c:out value="${skill.id}"/>
                </td>
                <td>
                    <c:out value="${skill.language}"/>
                </td>
                <td>
                    <c:out value="${skill.level}"/>
                </td>
             </tr>
          </tbody>
       </table>
       </c:if>
       <c:if test="${empty skill.id}">
       <p>Skill with such id does not find</p>
       </c:if>
    </body>
  </html>