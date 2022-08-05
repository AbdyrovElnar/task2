<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <form action="/uniq" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group col-md-4">
            <label for="uniqCode">Введите уникальный код</label>
            <input type="text" name="uniqCode" class="form-control" id="uniqCode" placeholder="Введите уникальный код">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Отправить</button>
        </div>

    </form>

</@main.renderWith>