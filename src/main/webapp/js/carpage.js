window.onload = function() {
    startFetch();


};

function startFetch() {
fetch("/CA-1/api/car/all")
  .then(res => res.json())
  .then(data => {
      console.log(data)
      document.getElementById("carsH").innerHTML = "<tr><th scope=col>Id</th><th scope=col>Year</th><th scope=col>Make</th><th scope=col>Model</th><th scope=col>Price</th></tr>";
      document.getElementById("cars").innerHTML =  data.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");
});
};