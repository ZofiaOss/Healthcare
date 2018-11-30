<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forr" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<%--@elvariable id="doctor" type="java"--%>
<form:form method="post" modelAttribute="doctor">

    <div class="container">

        <h3 class="header">Register</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="loginId">Email (will be used as login):</label>
                    <form:input type="text" path="email"  id="loginId" class="form-control"/>
                    <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <form:input type="password" path="password"  id="passwordId" class="form-control"/>
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="fullNameId">Full name:</label>
                    <form:input type="text" path="fullName" id="fullNameId" class="form-control"/>
                    <form:errors path="fullName" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="bioId">Bio:</label>
                    <form:textarea path="bio" rows="5" cols="20" id="bioId" class="form-control"/>
                    <form:errors path="bio" element="div" cssClass="error"/>
                </div>

                <form:hidden path="id" value="${doctor.id}" />

                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
