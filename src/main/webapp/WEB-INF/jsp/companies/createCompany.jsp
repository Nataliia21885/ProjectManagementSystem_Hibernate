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
        <form action="/companies/create">
            <label for="name"> Company name: </label><br>
            <input type="text" id="name" name="name"><br>
            <label for="name"> HRM: </label><br>
            <input type="text" id="hrm" name="hrm"><br>
            <button type="submit">Save</button>
        </form>
        </br>
        <c:if test="${not empty company}">
        <table>
            <thead>
                    <tr>
                        <td>Company name:</td>
                        <td>HRM:</td>
                    </tr>
            </thead>
        <tbody>
            <tr>
                <td>
                    <c:out value="${company.name}"/>
                </td>
                <td>
                    <c:out value="${company.hrm}"/>
                </td>
            </tr>
        </tbody>
        </table>
        <p>${message}</p>
        </c:if>
        <c:if test="${empty company}">
        <p>${message}</p>
        </c:if>
    </body>
  </html>