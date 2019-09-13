<%@include file = "header.jsp" %>

<script src="js/index.js"></script>

<div class="container-fluid">
    <hr />
    <h1>Members (loaded from a REST API)</h1>
    <hr />
    <div class="container">
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Student Id</th>
                    <th scope="col">Color</th>
                </tr>
            </thead>
            <tbody id="tableData">
                <tr>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>xxx</td>
                </tr>
                <tr>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>xxx</td>
                </tr>
            </tbody>
        </table>
        <div class="reloadbtn">
            <button type="button" class="btn btn-dark" id="reload">Reload Names</button>
        </div>    
    </div>
    <br /><br />
    <hr />
    <h1>Links</h1>
    <hr />
    <div class="contracts">
    <div class="links-list list-group mx-auto">
        <a href="groupcontractA&M.jsp" class="list-group-item list-group-item-action">Our group contract & What we did together <br> (Andreas & Martin)</a>
        <a href="https://github.com/AndreasVikke/CPH-Business-CA-1" class="list-group-item list-group-item-action">Github Andreas & Martin</a>
        </div>
    <div class="links-list list-group mx-auto">
        <a href="groupcontractA&W.jsp" class="list-group-item list-group-item-action">Our group contract & What we did together <br> (Asger & William)</a>
        <a href="https://github.com/WSHuusfeldt/ca-1/tree/developer" class="list-group-item list-group-item-action">Github Asger & William</a>
    </div>
    </div>
</div>


<%@include file = "footer.jsp" %>