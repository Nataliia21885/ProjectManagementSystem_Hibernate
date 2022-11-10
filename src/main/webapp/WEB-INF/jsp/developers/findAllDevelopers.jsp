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
     <h3 style="color:blue;">All developers:</h3>
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
            <c:forEach var="developer" items="${developers}">
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
             </c:forEach>
          </tbody>
       </table>
    </body>
  </html>