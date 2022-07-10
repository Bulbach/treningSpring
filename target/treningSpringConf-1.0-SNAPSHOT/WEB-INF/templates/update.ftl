<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>update page</title>
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
        <h2>Update data</h2>
    </div>

    <div class="row">
        <div class="col col-6">

            <form name="human" action="/humans/update" method="post">
                <fieldset id="create_collapsible">
                    <legend>Update Human</legend>
                    <input type="hidden" name="id" id="id" value="${human.id}">
                    <div class="row">
                        <div class="col col-6">
                            <label class="form-label" for="firstname">Firstname : </label>
                            <input type="text" class="form-control" name="firstname" id="firstname"
                                   value="${human.firstname}"/><br/>
                        </div>
                        <div class="col col-6">
                            <label class="form-label" for="lastname">Lastname :</label>
                            <input type="text" class="form-control" name="lastname" id="lastname"
                                   value="${human.lastname}"/><br/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col col-4">
                            <label class="form-label" for="city">City :</label>
                            <input type="text" class="form-control" name="city" id="city" value="${human.city}"/><br/>
                        </div>
                        <div class="col col-4">
                            <label class="form-label" for="street">Street :</label>
                            <input type="text" class="form-control" name="street" id="street"
                                   value="${human.street}"/><br/>
                        </div>
                        <div class="col col-4">
                            <label class="form-label" for="birthday">Birthday :</label>
                            <input type="date" class="form-control" name="birthday" id="birthday"
                                   pattern="yyyy-MM-dd" min="1950-12-31" value="${human.birthday}"/><br/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col col-6">
                            <label class="form-label" for="phone">Phone :</label><br>
                            <ul>
                                <#list human.phoneDtoList as phone>
                                    <li>
                                        <input type="hidden" name="phoneDtoList[${phone?index}].id" value="${phone.id}">
                                        <input type="text" class="form-control"
                                               name="phoneDtoList[${phone?index}].phoneNumber" id="phone"
                                               value="${phone.phoneNumber}">
                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </fieldset>
            </form>
            <fieldset>
                <legend> Add new phone number</legend>
                <div class="row">
                    <div class="col col-6">
                        <form action="/phone/add" method="post">
                            <label class="form-label" for="phone">Phone :</label>
                            <input type="hidden" name="id" value="${human.id}"><br/>
                            <input type="text" class="form-control" placeholder="phone number +375(xx)xxxxxxx"
                                   name="phone" id="phone"
                                   pattern="\s{0,}\+{1,1}375\s{0,}(([2]{1}([5]{1}|[9]{1}))|([3]{1}[3]{1})|([4]{1}[4]{1}))\s{0,}[0-9]{3,3}\s{0,}[0-9]{4,4}"
                                   required>
                            <input class="btn btn-primary" type="submit" value="Add">
                        </form>
                    </div>
                </div>
            </fieldset>
            <div>
                <a class="btn btn-primary" href="/humans/home" style="margin-top: 40px">Home </a>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</div>
</body>
</html>