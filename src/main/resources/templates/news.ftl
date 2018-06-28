<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">
    <div class="row">
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
                    <p class="card-text">Новостей нет, но вы держитесь!</p>
                </div>
            </div>
        </#if>
        </div>
    </div>
</div>

</@c.page>
