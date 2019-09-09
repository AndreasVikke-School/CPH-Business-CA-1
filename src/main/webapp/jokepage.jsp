<%@include file = "header.jsp" %>

<script src="jokepage.js"></script>

<div class="container-fluid">
    <h1>Joke Page</h1>

    <div id="alert" class="alert alert-danger" role="alert"></div>
    <form id="fetchJoke" class="container">
        <div class="row">
            <div class="col-sm">
                <input type="number" class="form-control" id="jokeid" placeholder="Joke id">
            </div>
            <div class="col-sm" >
                <button id="fetchJokeBtn" class="btn btn-dark">Fetch</button>
                <span id="buttonGroup">
                    <button endpoint="all" id="fetchAllJokesBtn" type="button" class="btn btn-dark">All</button>
                    <button endpoint="count" id="fetchJokeCountBtn" type="button" class="btn btn-dark">Count</button>
                    <button endpoint="random" id="fetchRandomJokesBtn" type="button" class="btn btn-dark">Random</button>
                </span>
            </div>
        </div>
        <br>
        <table class="table" id="table"></table>
    </form>
</div>

<%@include file = "footer.jsp" %>