<%@include file="header.jsp" %>

<script src="js/carpage.js"></script>

<div class="container-fluid">
    <hr />
    <h1>Our Cars for Sale</h1>
    <hr />
    <div id="alert" class="alert alert-danger" role="alert"></div>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <input type="text" class="label" id="carMake" placeholder="Make">
                <button id="carBtn" class="btn btn-dark">Get cars with make</button>
                <button id="carAll" class="btn btn-dark">All</button>
            </div>
        </div>
        <br>
        <table class="table" id="cars"></table>
    </div>
</div>

<%@include file="footer.jsp" %>