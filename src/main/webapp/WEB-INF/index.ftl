<div id="header">
    <h2>FreeMarker Spring MVC Hello World</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add Human</legend>
        <form name="human" action="humans/add_human" method="post">
            Firstname : <input type="text" name="firstname"/><br/>
            Lastname : <input type="text" name="lastname"/><br/>
            City : <input type="text" name="city"/><br/>
            Street : <input type="text" name="street"/><br/>
            Birthday : <input type="text" name="birthday"/><br/>
            <input type="submit" value="Save"/><br/>
        </form>
    </fieldset>
    <#--    <h5>${Human}</h5>-->
    <table class="datatable">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>City</th>
            <th>Street</th>
            <th>Birthday</th>
        </tr>
        <#---->
        <#list listHuman as human>
            <tr>
                <td>${human.firstname}</td>
                <td>${human.lastname}</td>
                <td>${human.city}</td>
                <td>${human.street}</td>
                <td>${human.birthday}</td>
            </tr>
        </#list>
        <#---->
    </table>
</div>