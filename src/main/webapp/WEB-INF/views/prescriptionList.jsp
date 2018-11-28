<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <script>
        function confirmDelete(id, name) {
            if (confirm("Are you sure you want to delete this prescription request? \"" + name + "\"")) {
                window.location.href = "/prescriptions/delete/" + id;
            }
        }
    </script>
</head>
<body>
<div class="container">

    <h3 class="header">Prescriptions</h3>

    <div class="card">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Dose</th>
                    <th>Quantity</th>
                    <th>Patient</th>
                    <th>Doctor</th>
                    <th>Pending</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="prescription" items="${prescriptions}">
                    <tr>
                        <td>${prescription.name}</td>
                        <td>${prescription.dose}</td>
                        <td>${prescription.quantity}</td>
                        <td>${prescription.patient.fullName}</td>
                        <td>${prescription.doctor.fullName}</td>
                        <td>${prescription.pending}</td>
                        <td>
                            <a href="#"
                               onclick="confirmDelete(${prescription.id}, '${prescription.name}')" class="btn btn-danger">Delete</a>
                            <a href="/books/update/${prescription.id}" class="btn btn-success">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
</body>
</html>
