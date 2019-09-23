<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-group mt-3">
        <form action="/startup" method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="Enter name of company">
            </div>

            <div class="form-group">
                <input type="text" name="description" class="form-control" placeholder="Enter description">
            </div>

            <div class="form-group">
                <input type="number" name="coast" class="form-control" placeholder="Enter coast">
            </div>

            <div class="form-group">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="customFile" name="file">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form>
    </div>

    <div class="card-columns">
        <#list companies as company>
            <div class="card my-3" style="width: 18rem;">
                <#if company.filename??>
                    <img src="/img/${company.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <span>${company.getAuthorName()} </span>
                    <span>${company.getName()} </span>
                    <span>${company.getDescription()}</span>
                    <span>${company.getCoast()}</span>
                </div>
            </div>
        <#else >
            No company
        </#list>
    </div>
</@c.page>