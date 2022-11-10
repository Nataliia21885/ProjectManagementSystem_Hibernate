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
       <form action="/developers/language">
           <label for="id"> Language: </label><br>
           <input type="text" id="language" name="language"><br>
           <button type="submit">Find</button>
       </form>
       </br>
       <c:if test="${not empty developersByLanguage}">
       <table>
          <thead>
             <tr>
               <td>Developer name:</td>
             </tr>
          </thead>
          <tbody>
           <c:forEach var="developer" items="${developersByLanguage}">
             <tr>
                <td>
                  <c:out value="${developer.name}"/>
                </td>
             </tr>
           </c:forEach>
          </tbody>
       </table>
        </c:if>
        <c:if test="${empty developersByLanguage}">
           <p>${message}</p>
        </c:if>
    </body>
  </html>