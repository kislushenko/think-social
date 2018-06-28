<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">
    <div class="row">
        <div class="col-3 text-center bg-light">
            <img src="image/logo.png" width="100" height="100" class="shadow rounded  mt-5 " alt=""><br />
            <#if isSubscriptions>
                <a class="btn btn-primary mt-2" href="/user/unsubscribe/${userChanel.id}" role="button">Отписаться</a>
            <#else>
                <a class="btn btn-primary mt-2" href="/user/subscribe/${userChanel.id}" role="button">Подписаться</a>
            </#if><br />
            Подписчиков: ${Subscribers}<br/>
            Подписок: ${Subscriptions}
        </div>
        <div class="col-sm bg-danger mt-5">
        <#if thinks??>
            <#list thinks as think>
                <div class="card w-60 mb-1 mx-auto text-center " style="width: 100%">
                    <div class="card-body">
                        <p class="card-text">${think.getText()}</p>
                    </div>
                </div>
            </#list>
        <#else>
            <div class="card w-60  mb-1 mx-auto text-center" style="width: 100%">
                <div class="card-body">
                    <p class="card-text">У данного пользователя отсутствуют опубликованные мысли.</p>
                </div>
            </div>
        </#if>
        </div>
    </div>
</div>

</@c.page>
