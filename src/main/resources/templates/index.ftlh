<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith>
    <form action="/" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group col-md-4" style="width: 250px">
            <select name="fromKassa" required="required" id="kassa_from">
                <#if select_kassa??>
                    <option value="">Выберите кассу отправитель</option>
                    <#list select_kassa as kassa>
                        <option value="${kassa.id}">${kassa.name}</option>
                    </#list>
                </#if>
            </select>
        </div>

        <div class="form-group col-md-4" style="width: 250px">
            <select name="toKassa" id="kassa_to" required="required">
                <#if select_kassa??>
                    <option value="">Выберите кассу получатель</option>
                    <#list select_kassa as kassa>
                        <option value="${kassa.id}">${kassa.name}</option>
                    </#list>
                </#if>
            </select>
        </div>

        <div class="form-group col-md-4" style="width: 250px">
            <select name="currency" id="currency" required="required">
                <#if select_currency??>
                    <option value="">Выберите валюту перевода</option>
                    <#list select_currency as currency>
                        <option value="${currency.id}">${currency.name}</option>
                    </#list>
                </#if>
            </select>
        </div>

        <div class="form-group col-md-4">
            <label for="sendSum">Сумма отправки</label>
            <input type="number" name="sum" class="form-control" id="sendSum" placeholder="Введите сумму отправки">
        </div>

        <div class="form-group col-md-4">
            <label for="customerFrom">Клиент отправитель</label>
            <input type="text" name="fromCustomer" class="form-control" id="customerFrom" placeholder="Введите клиента">
        </div>

        <div class="form-group col-md-4">
            <label for="customerFrom">Номер клиента отправителя</label>
            <input type="text" name="fromPhoneNumber" class="form-control" id="telNumberFrom"
                   placeholder="Введите номер отправителя">
        </div>

        <div class="form-group col-md-4">
            <label for="customerFrom">Клиент получатель</label>
            <input type="text" name="toCustomer" class="form-control" id="customerTo" placeholder="Введите клиента">
        </div>

        <div class="form-group col-md-4">
            <label for="customerFrom">Номер клиента получателя</label>
            <input type="text" name="toPhoneNumber" class="form-control" id="telNumberTo"
                   placeholder="Введите номер получателя">
        </div>

        <div class="form-group col-md-4">
            <label for="customerFrom">Комментарий</label>
            <input type="text" name="comment" class="form-control" id="comment"
                   placeholder="Введите комментарий">
        </div>

        <div>
            <button type="submit" class="btn btn-primary">Отправить</button>
        </div>
    </form>
</@main.renderWith>