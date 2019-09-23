<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">CrowdFunding</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/home">Comments </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/startup">Company </a>
            </li>
            <#if  isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User List </a>
                </li>
            </#if>
            <#if  user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Profile</a>
                </li>
            </#if>
        </ul>

        <#--class="spinner-border" role="status"-->

        <div class="navbar-text mr-3">
            <div class="badge badge-primary ">
                <div class="w-100 p-2" style="color: #000000;">
                    ${name}
                </div>
            </div>
        </div>
        <#if name!="unknown">
            <@l.logout/>
        <#else>
            <a href="/login" class="btn btn-primary">Registation</a>
        </#if>
    </div>
</nav>