<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <label for="filter">Выберите фильтрацию:</label>
    <form action="/transfers" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <select name="filter" id="filter">
        <option value="dateDesc">По дате возр</option>
        <option value="sumDesc">По сумме возр</option>
            <option value="dateAsc">По дате убыв</option>
            <option value="sumAsc">По сумме убыв</option>
    </select>
    <div>
        <button type="submit">Фильтрация</button>
    </div>
    </form>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Дата</th>
                <th scope="col">Касса отправитель</th>
                <th scope="col">Клиент отправитель</th>
                <th scope="col">Касса получатель</th>
                <th scope="col">Клиент получатель</th>
                <th scope="col">Валюта</th>
                <th scope="col">Сумма</th>
                <th scope="col">Комментарий</th>
                <th scope="col">Статус</th>
                <th scope="col">Код активации</th>

            </tr>
            </thead>
            <tbody>
            <#if transfer??>
                    <#list transfer as transf>

                <tr>
                    <td>${transf.date}</td>
                    <td>${transf.fromKassa.name}</td>
                    <td>${transf.fromCustomer}</td>
                    <td>${transf.toKassa.name}</td>
                    <td>${transf.toCustomer}</td>
                    <td>${transf.currency.name}</td>
                    <td>${transf.sum}</td>
                    <td>${transf.comment}</td>
                    <td>${transf.status}</td>
                    <#if kassa==transf.fromKassa.name>
                    <td>${transf.uuid}</td>
                    </#if>
                </tr>
                </#list>
            </#if>
            </tbody>
        </table>
</@main.renderWith>