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

        <h1 class="header">Lorem ipsum clinic</h1>

        <div class="card">
            <div class="card-body">


                <a href="/patients/login" title="Home" class="btn btn-dark">Login</a>
                <a href="/patients/add" title="Home" class="btn btn-secondary">Register</a>
                <a href="/doctors/login" title="Home" class="btn btn-light">Staff login</a>

                    <br/>
                    <br/>
                <h4>About us</h4>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Bibendum arcu vitae elementum curabitur vitae nunc sed velit. Sagittis vitae et leo duis ut. Lectus vestibulum mattis ullamcorper velit sed. Risus nullam eget felis eget nunc lobortis. Vel pharetra vel turpis nunc eget lorem dolor sed. Sed enim ut sem viverra aliquet eget. Gravida cum sociis natoque penatibus et magnis. In massa tempor nec feugiat nisl pretium. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Nulla pharetra diam sit amet nisl suscipit adipiscing.
                <br/>
                <br/>
                <h4>Our Team</h4>
                <table class="table table-hover">
                    <tr>
                        <th style="width:20%">Doctor</th>
                        <th style="width:20%">Email</th>
                        <th>Information</th>

                    </tr>
                    <c:forEach var="doctor" items="${doctors}">
                        <tr>
                            <td>${doctor.fullName}</td>
                            <td>${doctor.email}</td>
                            <td>${doctor.bio}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div>
                <h4>Contact us</h4>
                    reception@lorem-ipsum.co.uk<br/>
                    079 1520 2491<br/><br/>
                    Lorem Ipsum Clinic<br/>
                    102  Castledore Road<br/>
                    TULLICH<br/>
                    AB55 2QW<br/>
                    England<br/><br/>

                </div>
                <div>
                <h4>Opening hours</h4>
                Monday - Friday: 8:00 - 17:00<br/>
                Saturday: 8:00 - 13:00<br/>
                    Sunday: Closed<br/><br/>
                </div>


            </div>
        </div>

    </div>

</body>
</html>
