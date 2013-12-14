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

        <p>
            <a href="/agenda/index/new">Add new Agenda</a>
        </p>

        <c:forEach items="${agendas}" var="agenda">
        <hr>
            <p>
                <strong>ID:</strong> <a href="index/${agenda.id}">${agenda.id}</a><br/>
                <strong>Title:</strong> ${agenda.title}<br/>
                <strong>User:</strong> ${agenda.user}<br/>
                <strong>Password:</strong> ${agenda.password}<br/>
                <a href="${agenda.url}" target="_blank">GO TO SITE</a> <br/>
                <strong>Description:</strong> ${agenda.description}<br/>
                <strong>Create at: </strong> ${agenda.createdAt}<br/>
                <strong>Update at: </strong> ${agenda.updatedAt}<br/>
                <p>
                    <c:if test="${agendas_size == 1}"><a href="/agenda/index">All entries</a> | </c:if>
                    <a href="/agenda/edit/${agenda.id}">Edit</a><br/>
                </p>
            </p>
        </c:forEach>
    </body>
</html>
