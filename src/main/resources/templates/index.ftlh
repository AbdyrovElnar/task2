<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith>

<#--    <label class="fieldlabels mt-3">Выберите кассу отправитель:</label>-->
    <div class="select-box">
        <div class="options-container">
            <#if select_kassa??>
                <#list select_kassa as kassa>
                    <div class="option">
                        <input type="radio" class="radio radio-input" id="category_${kassa.id}"
                               name="categoryId" value="${kassa.id}"/>
                        <label for="category_${kassa.id}">${kassa.name}</label>
                    </div>
                </#list>
            </#if>
        </div>

        <div class="selected">
            Выберите кассу отправитель
        </div>

        <div class="search-box">
            <input type="text" placeholder="Start Typing..."/>
        </div>
    </div>

</@main.renderWith>