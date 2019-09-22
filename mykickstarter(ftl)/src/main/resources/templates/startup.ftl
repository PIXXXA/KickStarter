<#import "parts/common.ftl" as c>

<@c.page>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new company
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form action="/startup" method="post">
                <div class="form-group">
                    <div class="custom-file">
                        <input type="text" name="name" placeholder="Enter name of company">
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="description" placeholder="Enter description">
                </div>
                <div class="form-group">
                    <input type="number" name="coast" placeholder="Enter coast">
                </div>
                <div class="form-group">
                    <button type="submit">Send</button>
                </div>
            </form>
        </div>
    </div>

    <p> ${company.getName()}</p>

</@c.page>