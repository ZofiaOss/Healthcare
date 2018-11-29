<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <script>
        function confirmDelete(id, name) {
            if (confirm("Are you sure you want to delete this patient? \"" + name + "\"")) {
                    window.location.href = "/patients/delete/" + id;
            }
        }
    </script>
</head>
<body>
<div class="container">

    <h3 class="header">Patients</h3>

    <div class="card">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>PESEL</th>
                    <th>Address</th>
                    <th>Phone number</th>
                    <th>Email</th>
                    <th>Allergies</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="patient" items="${patients}">
                    <tr>
                        <td>${patient.name}</td>
                        <td>${patient.surname}</td>
                        <td>${patient.pesel}</td>
                        <td>${patient.streetNumber} ${patient.streetName},<br/>${patient.postCode}, ${patient.city},<br/>${patient.country}</td>
                        <td>${patient.phoneNumber}</td>
                        <td>${patient.email}</td>
                        <td>${patient.allergies}</td>
                        <td>
                            <a href="#"
                               onclick="confirmDelete(${patient.id}, '${patient.name}')" class="btn btn-danger">Delete</a>
                            <a href="/patients/update/${patient.id}" class="btn btn-success">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
</body>
</html>
