<%@include file = "header.jsp" %>

<script src="js/index.js"></script>

<div class="container-fluid">
    <h1>Members (loaded from a REST API)</h1>
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
</div>

<%@include file = "footer.jsp" %>