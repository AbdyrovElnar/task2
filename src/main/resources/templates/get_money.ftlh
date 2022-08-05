<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <form method="post" action="/get_money">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

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

            </tr>
            </thead>
            <tbody>
            <#if transfer??>
                <tr>
                    <td>${transfer.date}</td>
                    <td>${transfer.fromKassa.name}</td>
                    <td>${transfer.fromCustomer}</td>
                    <td>${transfer.toKassa.name}</td>
                    <td>${transfer.toCustomer}</td>
                    <td>${transfer.currency.name}</td>
                    <td>${transfer.sum}</td>
                    <td>${transfer.comment}</td>
                    <td>${transfer.status}</td>
                </tr>
                <input type="hidden" name="transferId"
                       value="${transfer.id}"/>

            </#if>
            </tbody>
        </table>
        <div>
            <button type="submit" class="btn btn-primary">Получить</button>
        </div>
    </form>
</@main.renderWith>