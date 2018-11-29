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

    <h3 class="header">Doctors</h3>

    <div class="card">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Full name</th>
                    <th>Email</th>
                    <th>Description</th>

                </tr>
                <c:forEach var="doctor" items="${doctors}">
                    <tr>
                        <td>${doctor.fullName}</td>
                        <td>${doctor.email}</td>
                        <td>${doctor.bio}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
</body>
</html>
