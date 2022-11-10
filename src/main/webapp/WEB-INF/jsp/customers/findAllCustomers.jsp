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
     <h3 style="color:blue;">All customers:</h3>
       <table>
          <thead>
             <tr>
               <td>Customer id:</td>
               <td>Customer name:</td>
               <td>Contact:</td>
             </tr>
          </thead>
          <tbody>
            <c:forEach var="customer" items="${customers}">
             <tr>
                <td>
                    <c:out value="${customer.id}"/>
                </td>
                <td>
                    <c:out value="${customer.name}"/>
                </td>
                <td>
                    <c:out value="${customer.contact}"/>
                </td>
             </tr>
             </c:forEach>
          </tbody>
       </table>
    </body>
  </html>