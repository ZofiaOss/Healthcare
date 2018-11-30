<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <h3 class="header">Diagnoses</h3>

    <div class="card">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Diagnosis</th>
                    <th>Patient</th>

                </tr>
                <c:forEach var="diagnosis" items="${diagnoses}">
                    <tr>
                        <td>${diagnosis.name}</td>
                        <td>${diagnosis.patients.fullName}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/patients/home" title="Home" class="btn btn-secondary">Back</a>

        </div>
    </div>
</div>
</body>
</html>
