<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <h3 class="header">Welcome</h3>

    <div class="card">
        <div class="card-body">

            <div class="list-group">
                <a href="/patients/update/{id}" class="list-group-item list-group-item-action">Update your details</a>
                <a href="/patients/list/{id}" class="list-group-item list-group-item-action">View your patients</a>
                <a href="/prescriptions/list/{id}" class="list-group-item list-group-item-action">View your prescriptions</a>
                <a href="/diagnoses/list/{id}" class="list-group-item list-group-item-action">View your diagnoses</a>
            </div>

        </div>
    </div>
</div>
</body>
</html>
