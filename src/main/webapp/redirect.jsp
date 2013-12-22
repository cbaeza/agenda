<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%-- response.sendRedirect("index.htm"); --%>
<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<c:redirect url="login.htm"/>
