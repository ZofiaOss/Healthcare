<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forr" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<%--@elvariable id="patient" type="java"--%>
<form:form method="post" modelAttribute="patient">

    <div class="container">

        <h3 class="header">Register</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="nameId">Name:</label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/>
                    <form:errors path="name" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="surnameId">Surname:</label>
                    <form:input type="text" path="surname" id="surnameId" class="form-control"/>
                    <form:errors path="surname" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="peselId">PESEL:</label>
                    <form:input type="text" path="pesel" id="peselId" class="form-control"/>
                    <form:errors path="pesel" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="streetNameId">Street name:</label>
                    <form:input type="text" path="streetName" id="streetNameId" class="form-control"/>
                    <form:errors path="streetName" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="streetNumberId">Street number:</label>
                    <form:input type="text" path="streetNumber" id="streetNumberId" class="form-control"/>
                    <form:errors path="streetNumber" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="cityId">City:</label>
                    <form:input type="text" path="city" id="cityId" class="form-control"/>
                    <form:errors path="city" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="postCodeId">Post code:</label>
                    <form:input type="text" path="postCode" id="postCodeId" class="form-control"/>
                    <form:errors path="postCode" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="countryId">Country:</label>
                    <form:input type="text" path="country" id="countryId" class="form-control"/>
                    <form:errors path="country" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="phoneNumberId">Phone number:</label>
                    <form:input type="text" path="phoneNumber" id="phoneNumberId" class="form-control"/>
                    <form:errors path="phoneNumber" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <form:input type="text" path="email"  id="emailId" class="form-control"/>
                    <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <%--<div class="form-group">--%>
                    <%--<label for="allergiesId">Allergies:</label>--%>
                    <%--<form:input type="text" path="allergies"  id="allergiesId" class="form-control"/>--%>
                    <%--<form:errors path="allergies" element="div" cssClass="error"/>--%>
                <%--</div>--%>

                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
