<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html">
    <title>index page</title>
</head>
<body>

<div id="header">
    <h2>FreeMarker Spring MVC Hello World</h2>
</div>
<style>
    .field {
        clear: both;
        text-align: right;
        line-height: 25px;
    }

    label {
        float: left;
        padding-right: 10px;
        font-weight: bold;
    }

    .main {
        width: 25%;
        /*float: left*/
    }

    .content {
        /*float: left;*/
    }
</style>
<div class="content">
    <div class="main">
        <form name="human" action="/humans/add" method="post">
            <fieldset>
                <legend>Add Human</legend>
                <div class="field">
                    <label for="firstname">Firstname : </label>
                    <input type="text" name="firstname" id="firstname"/><br/>
                </div>
                <div class="field">
                    <label for="lastname">Lastname :</label>
                    <input type="text" name="lastname" id="lastname"/><br/>
                </div>
                <div class="field">
                    <label for="city">City :</label>
                    <input type="text" name="city" id="city"/><br/>
                </div>
                <div class="field">
                    <label for="street">Street :</label>
                    <input type="text" name="street" id="street"/><br/>
                </div>
                <div class="field">
                    <label for="birthday">Birthday :</label>
                    <input type="text" name="birthday" id="birthday"/><br/>
                </div>
                <div class="field">
                    <label for="phone">Phone :</label>
                    <input type="text" name="phone" id="phone"><br/>
                </div>
                <input type="submit" value="Save" id="save"/><br/>
            </fieldset>
        </form>
    </div>
</div>
<div class="content">

    <table border="1" cellpadding="20">
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
        <#---->
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
                    <form name="update" method="post" action="/humans/update">
                        <input type="hidden" name="firstname" value=${humans.firstname}>
                        <input type="hidden" name="lastname" value=${humans.lastname}>
                        <input type="hidden" name="city" value=${humans.city}>
                        <input type="hidden" name="street" value=${humans.street}>
                        <input type="hidden" name="birthday" value=${humans.birthday}>
                        <#--                        <input type="hidden" name="phoneDtoList" value=${humans.phoneDtoList}>-->
                        <button type="submit" class="button">Update</button>
                    </form>
                </td>
                <td>
                    <form name="del" action="/humans/delete" method="post">
                        <input type="hidden" name="id" value="${humans.id}">
                        <button type="submit" class="button">Delete</button>
                    </form>
                    <#--                    <a href="/humans/delete/?${humans.id}" >Delete</a>-->
                </td>
            </tr>
        </#list>
        <#---->
    </table>
</div>
</body>
