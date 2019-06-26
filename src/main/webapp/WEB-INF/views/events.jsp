<%--
  Created by IntelliJ IDEA.
  User: insania
  Date: 2019-06-26
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All events</title>
</head>
<body>
<h2>
    All events here:
</h2>

<c:forEach var="event" items="${events}">
    <h4>Id: <c:out value="${event.id}"/> </h4>
    <h5>Name: <c:out value="${event.name}"/> </h5>
    <h5>Users: </h5>
    <c:forEach var="user" items="${event.users}">
    <h5><c:out value="${user.id}"/>
        <c:out value="${user.firstName}"/>
        <c:out value="${user.lastName}"/>
    </h5>
    </c:forEach>
</c:forEach>
</body>
</html>
