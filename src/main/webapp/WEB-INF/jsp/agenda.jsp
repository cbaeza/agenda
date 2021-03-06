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

        <form:form method="POST" modelAttribute="agenda" action="/agenda/index/save">
           <table>

               <tr>
                  <td><form:label path="title" />Title</td>
                  <td><form:input path="title" /></td>
              </tr>
               <tr>
                <td><form:label path="user" />User</td>
                <td><form:input path="user" /></td>
              </tr>
              <tr>
                  <td><form:label path="password" />Password</td>
                  <td><form:input path="password" /></td>
              </tr>
              <tr>
                 <td><form:label path="url" />Url</td>
                 <td><form:input path="url" /></td>
              </tr>
              <tr>
               <td><form:label path="description" />Description</td>
               <td><form:textarea rows="5" path="description" /></td>
            </tr>
             <tr>
                <td colspan="2">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
           </table>
       </form:form>

        <p>
            <a href="/agenda/index">All entries</a>
        </p>
    </body>
</html>
