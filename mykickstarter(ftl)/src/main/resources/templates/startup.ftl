<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-group mt-3">
        <form action="/startup" method="post">

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
                <button type="submit" class="btn btn-primary">Send</button>
            </div>

        </form>
    </div>
<#--<p> ${company.getName()}</p>-->
</@c.page>