<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <form action="/balance" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group col-md-4" style="width: 250px">
            <select name="fromKassa" required="required" id="fromKassa">
                <#if select_kassa??>
                    <option value="">Выберите кассу отправитель</option>
                    <#list select_kassa as kassa>
                        <option value="${kassa.id}">${kassa.name}</option>
                    </#list>
                </#if>
            </select>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Получить данные</button>
        </div>

    </form>
    <#if balance??>
        <input type="text" class="mt-3" readonly value="${balance!''}">
    </#if>


</@main.renderWith>