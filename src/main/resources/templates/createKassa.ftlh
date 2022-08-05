<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <form action="/kassa/create" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group col-md-4">
            <label for="kassaName">Введите название кассы</label>
            <input type="text" name="kassaName" class="form-control" id="kassaName" placeholder="Введите название кассы">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Создать</button>
        </div>

    </form>

</@main.renderWith>