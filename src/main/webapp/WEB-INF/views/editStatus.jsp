<%--
  Created by IntelliJ IDEA.
  User: insania
  Date: 2019-06-28
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit status</title>
</head>
<body>
<h2>Edit status</h2>

<spring:form modelAttribute="userToEventExt" action="/editStatus" method="post">
    <spring:input path="id" id="id" hidden="true"/>

    <spring:input path="userId" id="userId" hidden="true"/>

    <spring:input path="eventId" id="eventId" hidden="true"/>

    <spring:radiobuttons path="userStatus" items="${statuses}"/><br><br>

    <button type="submit">Submit</button>
</spring:form>

</body>
</html>
