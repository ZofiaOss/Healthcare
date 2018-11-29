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

<%--@elvariable id="prescription" type="java"--%>
<form:form method="post" modelAttribute="prescription">

    <div class="container">

        <h3 class="header">Request prescription</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="nameId">Drug name:</label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/>
                    <form:errors path="name" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="doseId">Dose:</label>
                    <form:input type="text" path="dose" id="doseId" class="form-control"/>
                    <form:errors path="dose" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="quantityId">Quantity:</label>
                    <form:input type="text" path="quantity" id="quantityId" class="form-control"/>
                    <form:errors path="quantity" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="patientId">Patient:</label>
                    <form:select path="patient.id" items="${patients}" itemLabel="fullName" itemValue="id" id="patientId" class="form-control"/>
                    <form:errors path="patient" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="doctorId">Doctor:</label>
                    <form:select path="doctor.id" items="${doctors}" itemLabel="fullName" itemValue="id" id="doctorId" class="form-control"/>
                    <form:errors path="doctor" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="pendingId">Pending:</label>
                    <form:checkbox path="pending" value="false" id="pendingId"/>
                    <form:errors path="pending" element="div" cssClass="error"/>
                </div>



                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
