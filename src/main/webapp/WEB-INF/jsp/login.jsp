<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agendas - Login</title>
</head>

<body>
    <h1>Your personal agendas on Git Hub ---+++</h1>
    <h2>Message : ${message}</h2>

    <form:form method="POST" modelAttribute="user" action="/agenda/login/login">
       <table>
         <tr>
            <td><form:label path="name" />Name</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="password" />Password</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td colspan="2">
            <input type="submit" value="Log in!"/>
            </td>
        </tr>
       </table>
    </form:form>
</body>
