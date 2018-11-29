<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<%--@elvariable id="doctor" type="java"--%>
<form:form method="post" modelAttribute="doctor">

    <div class="container">

        <h3 class="header">Login</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="loginId">Login (email):</label>
                    <form:input type="text" path="email" id="loginId" class="form-control"/>
                    <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <form:input type="password" path="password" id="passwordId" class="form-control"/>
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <c:if test="${loginFailed == true}">
                    <div class="error" style="padding-bottom: 20px">Incorrect data</div>
                    <a href="/doctors/add" class="btn btn-primary">Register</a>
                </c:if>

                <input type="submit" class="btn btn-primary" value="Login">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
