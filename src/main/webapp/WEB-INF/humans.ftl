<#-- @ftlvariable name="human.firstname" type="java.lang.String" -->
<div>
    <table class="datatable">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>City</th>
            <th>Street</th>
            <th>Birthday</th>
        </tr>
        <#list listHuman as human>
            <tr>
                <td>${human.firstname}</td>
                <td>${human.lastname}</td>
                <td>${human.city}</td>
                <td>${human.street}</td>
                <td>${human.birthday}</td>
            </tr>
        </#list>
    </table>
</div>