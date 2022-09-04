<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>index page</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css"/>

</head>

<body>

<div class="container">

    <div id="header">
        <h2>Phonebook</h2>
    </div>


    <div class="row">
        <div class="col col-6">
            <p>
                <button class="btn btn-info" type="button" data-bs-toggle="collapse"
                        data-bs-target="#create_collapsible"
                        aria-expanded="false" aria-controls="create_collapsible">
                    Create person
                </button>
            </p>
            <form name="human" action="/humans/add" method="post">
                <fieldset class="collapse" id="create_collapsible">
                    <legend>Add Human</legend>
                    <div class="row">
                        <div class="col col-6">
                            <label class="form-label" for="firstname">Firstname : </label>
                            <input tabindex="1" type="text" class="form-control" name="firstname" id="firstname"
                                   required/><br/>
                        </div>
                        <div class="col col-6">
                            <label class="form-label" for="lastname">Lastname :</label>
                            <input tabindex="2" type="text" class="form-control" name="lastname" id="lastname"
                                   required/><br/>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col col-4">
                            <label class="form-label" for="city">City :</label>
                            <input tabindex="3" type="text" class="form-control" name="city" id="city" required/><br/>
                        </div>
                        <div class="col col-4">
                            <label class="form-label" for="street">Street :</label>
                            <input tabindex="4" type="text" class="form-control" name="street" id="street"/><br/>
                        </div>
                        <div class="col col-4">
                            <label class="form-label" for="birthday">Birthday :</label>
                            <input tabindex="5" type="date" pattern="yyyy-MM-dd" min="1950-12-31" class="form-control"
                                   name="birthday" id="birthday" required/><br/>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col col-6">
                            <label class="form-label" for="phone">Phone :</label>
                            <input tabindex="6" type="text" placeholder="phone number +375(xx)xxxxxxx"
                                   pattern="\s{0,}\+{1,1}375\s{0,}(([2]{1}([5]{1}|[9]{1}))|([3]{1}[3]{1})|([4]{1}[4]{1}))\s{0,}[0-9]{3,3}\s{0,}[0-9]{4,4}"
                                   class="form-control" name="phone" id="phone" required/><br/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </fieldset>
            </form>
        </div>
    </div>
    <div class="row" style="margin-top: 20px;">
        <div class="col">

            <table class="table table-striped table-bordered">
                <thead>

                <tr>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>City</th>
                    <th>Street</th>
                    <th>Birthday</th>
                    <th>Phones</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>

                <#list listHuman as humans>
                    <tr>
                        <td>${humans.firstname}</td>
                        <td>${humans.lastname}</td>
                        <td>${humans.city}</td>
                        <td>${humans.street}</td>
                        <td>${humans.birthday}</td>
                        <td><#list humans.phoneDtoList as phone>
                                <ul>
                                    <li>${phone.phoneNumber}</li>
                                </ul>
                            </#list>
                        </td>
                        <td>
                            <a class="btn btn-info" href="/humans/update/${humans.id}"><i class="bi bi-pencil"></i></a>
                        </td>
                        <td>
                            <form name="del" action="/humans/delete" method="post"
                                  onsubmit="return confirm('Are you sure?')">
                                <input type="hidden" name="id" value="${humans.id}">
                                <button type="submit" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
