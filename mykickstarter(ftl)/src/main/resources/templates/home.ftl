<#import "parts/common.ftl" as c>
<@c.page>

    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/home" class="form-inline">
                <input type="text" name="filter" class="form-control" placeholder="Search on comments"
                       value="${filter?ifExists}">
                <button type="submit" class="btn btn-primary ml-3">Submit</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new comment
    </a>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form action="/home" method="post" enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="customFile" name="file">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid','')}"
                           value="<#if comment??>${comment.text}</#if>" name="text" placeholder="Add comment">
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${ textError}
                        </div>
                    </#if>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Send</button>
                </div>

            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list comments as comment>
            <div class="card my-3" style="width: 18rem;">
                <#if comment.filename??>
                    <img src="/img/${comment.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <span>${comment.getText()}</span>
                </div>
                <div class="card-footer text-muted">
                    ${comment.getAuthorName()}
                </div>
            </div>
        <#else >
            No comments
        </#list>
    </div>
</@c.page>
