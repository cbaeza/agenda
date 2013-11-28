<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendas - Show</title>
    </head>

    <body>
        <h1>Show Agenda</h1>
        <h2>Message : ${message}</h2>
        <p>
            <c:out value="ID : ${agenda.id}"/><br/>
            <c:out value="Title : ${agenda.title}"/><br/>
            <c:out value="User : ${agenda.user}"/><br/>
            <c:out value="Password : ${agenda.password}"/><br/>
            <c:out value="Url : ${agenda.url}"/><br/>
            <c:out value="Description : ${agenda.description}"/><br/>
            <c:out value="Create at : ${agenda.createdAt}"/><br/>
            <c:out value="Update at : ${agenda.updatedAt}"/><br/>
        </p>
        <p>
            <a href="/agenda/index">back</a>
        </p>
    </body>
</html>
