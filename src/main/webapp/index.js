window.onload = function() {
document.getElementById("reload").addEventListener("click", function(){
   startFetch("/CA-1/api/classmember/all");
    });
}

function startFetch(url) {
fetch(url)
  .then(res => res.json())
  .then(data => {
      document.getElementById("tableData").innerHTML =  data.map(x => "<tr><td>" + x.name + "</td><td>" + x.studentId + "</td><td>" + x.color + "</td></tr>");
});
};