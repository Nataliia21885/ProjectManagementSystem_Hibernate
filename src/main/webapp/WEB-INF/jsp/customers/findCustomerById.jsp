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
       <form action="/customers/id">
           <label for="id"> Customer id(use only digits): </label><br>
           <input type="text" id="id" name="id"><br>
           <button type="submit">Find</button>
       </form>
       </br>
       <c:if test="${not empty customer.id}">
       <table>
          <thead>
             <tr>
               <td>Customer id:</td>
               <td>Customer name:</td>
               <td>Contact:</td>
             </tr>
          </thead>
          <tbody>
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
          </tbody>
       </table>
       </c:if>
       <c:if test="${empty customer.id}">
       <p>Customer with such id does not find</p>
       </c:if>
    </body>
  </html>