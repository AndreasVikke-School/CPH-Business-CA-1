<%@include file = "header.jsp" %>

<script src="js/index.js"></script>

<div class="indexContainer">
<h4>Members (loaded from a REST API)</h4>
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
<button type="button" class="btn btn-dark" id="reload">Reload Names</button>
</div>

<%@include file = "footer.jsp" %>