<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendas - Show</title>
    </head>

    <body>
        <h1>Your personal agendas on Git Hub ---+++</h1>
        <h2>Message : ${message}</h2>
        <h2>Spring form</h2>

        <form:form method="POST" modelAttribute="agenda">
           <table>
               <tr>
                   <td><form:label path="id" />ID</td>
                   <td><form:input path="id" /></td>
               </tr>
               <tr>
                  <td><form:label path="title" />TITLE</td>
                  <td><form:input path="title" /></td>
              </tr>
               <tr>
                <td><form:label path="user" />USER</td>
                <td><form:input path="user" /></td>
              </tr>
              <tr>
                  <td><form:label path="password" />PASSWORD</td>
                  <td><form:input path="password" /></td>
              </tr>
              <tr>
                 <td><form:label path="url" />URL</td>
                 <td><form:input path="url" /></td>
              </tr>
              <tr>
               <td><form:label path="description" />DESCRIPTION</td>
               <td><form:input path="description" /></td>
            </tr>
            <tr>
               <td><form:label path="updatedAt" />Last update</td>
               <td><form:input path="updatedAt" /></td>
            </tr>
           </table>
       </form:form>

        <p>
            <a href="/agenda/index">back</a>
        </p>
    </body>
</html>
