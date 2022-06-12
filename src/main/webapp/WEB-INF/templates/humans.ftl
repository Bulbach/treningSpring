<#-- @ftlvariable name="human.firstname" type="java.lang.String" -->
<div>
    <table border="1" cellpadding="20">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>City</th>
            <th>Street</th>
            <th>Birthday</th>
            <th>Phones</th>
        </tr>
        <#list listHuman as human>
            <tr>
                <td>${human.firstname}</td>
                <td>${human.lastname}</td>
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
        </#list>
    </table>
</div>