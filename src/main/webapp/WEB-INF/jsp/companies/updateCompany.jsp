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
        <form action="/companies/update">
                   <label for="id"> Company id(use only digits): </label><br>
                   <input type="text" id="id" name="id"><br>
                   <label for="name"> Company name: </label><br>
                   <input type="text" id="name" name="name"><br>
                   <label for="hrm"> HRM: </label><br>
                   <input type="text" id="hrm" name="hrm"><br>
                   <button type="submit">Update</button>
        </form>
        </br>
        <c:if test="${not empty updatedCompany}">
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
                               <c:out value="${updatedCompany.name}"/>
                           </td>
                           <td>
                               <c:out value="${updatedCompany.hrm}"/>
                           </td>
                       </tr>
           </tbody>
        </table>
        <p>Company is updated successfully</p>
         </c:if>
          <c:if test="${empty updatedCompany}">
             <p>${message}</p>
          </c:if>
    </body>
  </html>