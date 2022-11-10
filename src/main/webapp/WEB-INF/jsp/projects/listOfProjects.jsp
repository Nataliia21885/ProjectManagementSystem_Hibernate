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
     <h3 style="color:blue;">List of projects:</h3>
     <c:if test="${not empty projects}">
       <table>
          <thead>
             <tr>
               <td>Date of creation:</td>
               <td>Project name:</td>
               <td>Developers amount:</td>
             </tr>
          </thead>
          <tbody>
            <c:forEach var="project" items="${projects}">
             <tr>
                <c:forEach var="projects" items="${project}">
                <td>
                   <c:out value="${projects}"/>
                </td>
                </c:forEach>
             </tr>
             </c:forEach>
          </tbody>
       </table>
        </c:if>
        <c:if test="${empty projects}">
           <p>You enter wrong format. Please, try again</p>
        </c:if>
    </body>
  </html>