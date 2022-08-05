<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <form action="/currency/create" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group col-md-4">
            <label for="currencyName">Введите название валюты</label>
            <input type="text" name="currencyName" class="form-control" id="currencyName" placeholder="Введите название валюты">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Создать</button>
        </div>

    </form>

</@main.renderWith>