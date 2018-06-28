<#import "parts/common.ftl" as c>

<@c.page>
<div class="row w-100">
    <div class="col-2 text-center">
        <img src="image/logo.png" width="100" height="100" class="shadow rounded mt-5 " alt=""><br />
        Подписчиков: ${Subscribers}<br/>
        Подписок: ${Subscriptions}
    </div>
    <div class="col-9  mt-5 ">

        <form class="form-group text-right">
            <#if errorMessage??>
            <div class="text-left text-danger">${errorMessage}</div></#if>
            <textarea id="redex" maxlength="255" name="text" rows="2" style="resize: none" class="w-100 shadow rounded form-control z-depth-1" placeholder="Text"></textarea>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" formaction="/" formmethod="post" class="btn btn-primary mt-2">Send</button>
        </form>
    </div>
    <#if thinks??>
        <#list thinks as think>
            <div class="card w-70 mb-3 text-center float-right" style="margin-left: 18%; margin-right: 10%;width: 70%">
                <button type="button" class="close" aria-label="Close"></button>
                <div class="card-body">
                    <p class="card-text">${think.getText()}</p>
                </div>
            </div>
        </#list>
    </#if>

</div>

</@c.page>
