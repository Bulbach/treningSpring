<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>One person</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css"/>
</head>

<body>

<div class="container">
    <div id="header">
        <h2>New Person</h2>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>SecondName</th>
                    <th>City</th>
                    <th>Street</th>
                    <th>Birthday</th>
                    <th>Phones</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>${human.id}</td>
                    <td>${human.lastname}</td>
                    <td>${human.firstname}</td>
                    <td>${human.city}</td>
                    <td>${human.street}</td>
                    <td>${human.birthday}</td>
                    <td><#list human.phoneDtoList as phone>
                            <ul>
                                <li>${phone.phoneNumber}</li>
                            </ul>
                        </#list>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <a class="btn btn-info" href="/humans/home">Home </a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</div>
</body>
</html>