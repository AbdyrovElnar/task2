<#macro renderWith title="CRUD MVC приложение для переводов" scripts=[] styles=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/main.css">
        <link rel="stylesheet" href="/css/dropdown_style.css">

        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <nav class="navbar navbar-expand-lg navbar navbar-light"style="background-color: #e3f2fd;">
        <a class="navbar-brand" href="#">Переводы</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="/">Главная <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="/uniq">Получить перевод</a>
                <a class="nav-item nav-link" href="/kassa/create">Добавить кассу</a>
                <a class="nav-item nav-link" href="/currency/create">Добавить валюту</a>
                <a class="nav-item nav-link" href="/login">Войти</a>
                <div class="px-4 logout-btn d-flex align-items-center">
                    <form action="/logout" method="post">
                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                   value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <button type="submit" class="btn btn-danger" id="logOut">
                            <i class="bi bi-door-open-fill"></i> Выйти
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </nav>

    <div class="content">
        <div class="container">
            <#nested>
        </div>
    </div>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>

</#macro>