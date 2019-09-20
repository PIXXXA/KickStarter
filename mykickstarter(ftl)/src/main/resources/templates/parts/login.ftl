<#macro login path isRegisterForm>

    <form action="${path}" method="post">

        <div class="form-group">
            <label for="exampleInputEmail1"> User Name : </label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email" name="username"/>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <div class="form-group">
            <label for="exampleInputPassword1"> Password: </label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                   name="password"/>
        </div>

        <#if !isRegisterForm>
            <div class="form-group">
                <label for="exampleInputEmail1"> Email: </label>
                <input type="email" class="form-control" id="exampleInputPassword1" placeholder="some@some.com"
                       name="email"/>
            </div>
        </#if>

        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <#if !isRegisterForm>
            <a href="/registration" class="btn btn-primary">
                Registation
            </a>
        </#if>

        <button type="submit" class="btn btn-primary">
            <#if isRegisterForm>
                Create
            <#else>
                Sign In
            </#if>
        </button>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-primary">Sign Out</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>