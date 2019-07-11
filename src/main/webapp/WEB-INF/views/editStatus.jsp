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


<spring:form modelAttribute="userToEventExt" action="/editStatus" method="post">
<label for="id">id</label>
    <spring:input path="id" id="id"/>

    <label for="userId">user id</label>
    <spring:input path="userId" id="userId"/>

    <label for="eventId">event id</label>
    <spring:input path="eventId" id="eventId"/>

    <label for="userStatus">status</label>
    <%--<spring:radiobuttons path="userStatus" items="${statuses}"/><br><br>
--%>
<spring:input path="userStatus" id="userStatus"/>

    <button type="submit">Submit</button>
</spring:form>
</body>
</html>
