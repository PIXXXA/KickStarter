<#import "parts/common.ftl" as c>

<@c.page>
    <h5>${username}</h5>
    ${message?ifExists}

    <div class="form-group">
        <label for="exampleInputPassword1"> Password: </label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
               name="password"/>
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1"> Email: </label>
        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="some@some.com"
               name="email" value="${email!''}"/>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    <button type="submit" class="btn btn-primary">Save</button>

    </form>

</@c.page>