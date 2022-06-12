<div>
    <table border="1" cellpadding="20">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>SecondName</th>
            <th>City</th>
            <th>Street</th>
            <th>Birthday</th>
            <th>Phones</th>
        </tr>

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
    </table>
</div>