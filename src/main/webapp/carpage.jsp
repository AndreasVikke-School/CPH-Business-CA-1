<%@include file="header.jsp" %>

<script src="js/carpage.js"></script>

<div class="container-fluid">
    <h1>Our Cars for Sale</h1>
    <div class="container">
        <table class="table" id="cars"></table>
        <input type="text" class="form-control" id="jokeid" placeholder="Make">
        <button id="carBtn" class="btn btn-dark">ModelFilter</button>
    </div>
</div>

<%@include file="footer.jsp" %>