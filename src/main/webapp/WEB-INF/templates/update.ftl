<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html" lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html">
    <title>index page</title>
</head>
<body>

<div id="header">
    <h2>Update data</h2>
</div>
<style>
    .field {
        clear: both;
        text-align: right;
        line-height: 25px;
    }
    body{
        background: aquamarine;
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
        <form name="human" action="/humans/update" method="post">
            <fieldset>
                <legend>Update Human</legend>
                <input type="hidden" name="id" id="id" value="${human.id}" >
                <div class="field">
                    <label for="firstname">Firstname : </label>
                    <input type="text" name="firstname" id="firstname" value="${human.firstname}"/><br/>
                </div>
                <div class="field">
                    <label for="lastname">Lastname :</label>
                    <input type="text" name="lastname" id="lastname" value="${human.lastname}"/><br/>
                </div>
                <div class="field">
                    <label for="city">City :</label>
                    <input type="text" name="city" id="city" value="${human.city}"/><br/>
                </div>
                <div class="field">
                    <label for="street">Street :</label>
                    <input type="text" name="street" id="street" value="${human.street}"/><br/>
                </div>
                <div class="field">
                    <label for="birthday">Birthday :</label>
                    <input type="text" name="birthday" id="birthday" value="${human.birthday}"/><br/>
                </div>
                <div class="field">
                    <label for="phone">Phone :</label></br>
                    <#list human.phoneDtoList as phone>
                        <ul>
                            <li>
<#--                                <form action="/phones/update">-->
                                    <input type="hidden" name="phoneDtoList[${phone?index}].id" value="${phone.id}">
                                    <input type="text" name="phoneDtoList[${phone?index}].phoneNumber" id="phone" value="${phone.phoneNumber}">
<#--                                    <input type="submit" value="Update">-->
<#--                                </form>-->
                            </li>
                        </ul>
                    </#list>
                </div>
                <input type="submit" value="Save" id="save"/><br/>
            </fieldset>
        </form>
        <fieldset>
            <legend> Add new phone number</legend>
            <div>
                <form action="/phone/add" method="post">
                    <label for="phone">Phone :</label>
                    <input type="hidden" name="id" value="${human.id}"><br/>
                    <input type="text" name="phone" id="phone">
                    <input type="submit" value="Add">
                </form>
            </div>
        </fieldset>
    </div>
</div>