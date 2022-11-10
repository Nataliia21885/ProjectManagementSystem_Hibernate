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
        <form action="/customers/create">
             <label for="name"> Customer name: </label><br>
             <input type="text" id="name" name="name"><br>
             <label for="name"> Contact: </label><br>
             <input type="text" id="contact" name="contact"><br>
            <button type="submit">Save</button>
        </form>
        </br>
        <c:if test="${not empty customer}">
        <table>
            <thead>
                    <tr>
                        <td>Customer name:</td>
                        <td>Contact:</td>
                    </tr>
            </thead>
        <tbody>
            <tr>
                <td>
                    <c:out value="${customer.name}"/>
                </td>
                <td>
                    <c:out value="${customer.contact}"/>
                </td>
            </tr>
        </tbody>
        </table>
        <p>${message}</p>
        </c:if>
        <c:if test="${empty customer}">
        <p>${message}</p>
        </c:if>
    </body>
  </html>