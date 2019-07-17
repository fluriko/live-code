<%--
  Created by IntelliJ IDEA.
  User: insania
  Date: 2019-07-17
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>organizers</title>
</head>
<body>

<c:forEach items="${organizers}" var="organizer">
    <h2>${organizer.id} name: <a href="<c:url value="/organizer?o_id=${organizer.id}"/>">${organizer.firstName} ${organizer.lastName}</a></h2>
<h3>email: ${organizer.email}</h3>
    <a href="<c:url value="/editOrganizer?o_id=${organizer.id}"/>">edit</a>
    <a href="<c:url value="/deleteOrganizer?o_id=${organizer.id}"/>">delete</a>
</c:forEach>

</body>
</html>
