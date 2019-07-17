<%--
  Created by IntelliJ IDEA.
  User: insania
  Date: 2019-07-03
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>add event</title>
</head>
<body>
<h2>add new event</h2>
<spring:form modelAttribute="eventExt" action="/addEvent" method="post">

<label for="name">name</label>
<spring:input path="name" id="name"/><br><br>

<label>Organizer:</label>
    <c:forEach var="user" items="${users}">
        <form:radiobutton path="organizerId" value="${user.id}" checked="true"/>
        <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/>
    </c:forEach>
    <br><br>

    <label>invite users:</label>
    <c:forEach var="user" items="${users}">
        <form:checkbox path="userIds" value="${user.id}" multiple="true"/>
        <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/>
    </c:forEach>

    <br><br>

<button type="submit">submit</button>
</spring:form>
</body>
</html>
