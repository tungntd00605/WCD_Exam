<%@ page import="com.exam.entity.Phone" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP ENVY
  Date: 8/10/2019
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Phone</title>
</head>
<body>
    <h1>Phone list:</h1>
    <ul>
        <c:forEach var="phone" items="${phones}">
            <li>id: ${phone.id} - name: ${phone.name} - brand: ${phone.getBrandString()} - price: ${phone.price} - description: ${phone.description}</li>
            <%--<li>id: ${phone.id} - name: ${phone.name} - description: ${phone.description}</li>--%>
        </c:forEach>

    </ul>
</body>
</html>
