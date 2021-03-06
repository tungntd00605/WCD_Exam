<%--
  Created by IntelliJ IDEA.
  User: HP ENVY
  Date: 8/10/2019
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Phone Form</title>
</head>
<body>
    <h1>Add Phone Form</h1>
    <form action="/phone/add" method="post">
        <div>
            <label> Name</label>
            <input type="text" name="name">
        </div>
        <p id="name-message"></p>
        <div>
            <label> Brand</label>
            <select name="brand">
                <c:forEach var="brand" items="${brands}">
                    <option value="${brand.getValue()}">${brand.toString()}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label> Price</label>
            <input type="number" name="price">
            <p id="price-message"></p>
        </div>
        <div>
            <label> Description</label>
            <input type="text" name="description">
        </div>
        <p id="description-message"></p>
        <div>
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
        </div>
    </form>
</body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/core.js"></script>
<script>
    $(document).
</script>
</html>
