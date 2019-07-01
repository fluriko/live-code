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
    <h4>EVENT ID: <c:out value="${event.id}"/> </h4>
    <h5>Name: <c:out value="${event.name}"/> </h5>
    <h5>Users: </h5>
    <c:forEach var="userToEvents" items="${event.userToEvents}">
    <h5><c:out value="${userToEvents.user.id}"/>,
        <c:out value="${userToEvents.user.firstName}"/>
        <c:out value="${userToEvents.user.lastName}"/>,
        <c:out value="${userToEvents.status}"/>
        <a href="<c:url value="/editStatus?ute_id=${userToEvents.id}"/>">Edit status</a>
    </h5>
    </c:forEach>
</c:forEach>
</body>
</html>
