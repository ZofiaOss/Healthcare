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
<%--@elvariable id="diagnosis" type="java"--%>
<form:form method="post" modelAttribute="diagnosis">

    <div class="container">

        <h3 class="header">Diagnosis</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="diagnosisId">Diagnosis:</label>
                    <form:textarea path="name" rows="5" cols="20" id="diagnosisId" class="form-control"/>
                    <form:errors path="name" element="div" cssClass="error"/>
                </div>

                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
