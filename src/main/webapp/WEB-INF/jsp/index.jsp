<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendas - Index</title>
    </head>

    <body>
        <h1>Your personal agendas on Git Hub ---+++</h1>
        <h2>Message : ${message}</h2>
        <h2>Agendas : ${agendas_size}</h2>
            <c:forEach items="${agendas}" var="agenda">
                <p>
                <c:out value="ID: "/><a href="index/${agenda.id}">${agenda.id}</a><br/>
                <c:out value="Title : ${agenda.title}"/><br/>
                <c:out value="User : ${agenda.user}"/><br/>
                <c:out value="Password : ${agenda.password}"/><br/>
                <c:out value="Url : ${agenda.url}"/><br/>
                <c:out value="Description : ${agenda.description}"/><br/>
                <c:out value="Create at : ${agenda.createdAt}"/><br/>
                <c:out value="Update at : ${agenda.updatedAt}"/><br/>
                </p>
            </c:forEach>
        <p>
            <a href="/agenda/index">all entries</a>
        </p>
    </body>
</html>
