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
        <form action="/customers/update">
                   <label for="id"> Customer id(use only digits): </label><br>
                   <input type="text" id="id" name="id"><br>
                   <label for="name"> Customer name: </label><br>
                   <input type="text" id="name" name="name"><br>
                   <label for="hrm"> Contact: </label><br>
                   <input type="text" id="contact" name="contact"><br>
                   <button type="submit">Update</button>
        </form>
        </br>
        <c:if test="${not empty updatedCustomer}">
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
                               <c:out value="${updatedCustomer.name}"/>
                           </td>
                           <td>
                               <c:out value="${updatedCustomer.contact}"/>
                           </td>
                       </tr>
           </tbody>
        </table>
        <p>Customer is updated successfully</p>
         </c:if>
          <c:if test="${empty updatedCustomer}">
             <p>${message}</p>
          </c:if>
    </body>
  </html>