window.onload = async() => {
    var data = await startFetch("/CA-1/api/car/all");
    document.getElementById("cars").innerHTML = "<thead class=table-dark><tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr></thead>" + data.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");
    document.getElementsByTagName("th").onclick = theadClick();
    
    document.getElementById("carAll").onclick = async() => {
        var data = await startFetch("/CA-1/api/car/all");
        var alert = document.getElementById("alert");
        alert.style.display = "none";  
        document.getElementById("cars").innerHTML = "<thead class=table-dark><tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr></thead>" + data.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");
    };


    document.getElementById("carBtn").onclick = async() => {
        var data = await startFetch("/CA-1/api/car/all");
        var data = data.filter(x => x.make === document.getElementById("carMake").value);
        var alert = document.getElementById("alert");
        alert.style.display = "none";   
        if (data.length == 0) {
            document.getElementById("alert").innerHTML = "No car exists with this make: " + document.getElementById("carMake").value;
            alert.style.display = "block";
        }


        document.getElementById("cars").innerHTML = "<thead class=table-dark><tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr></thead>" + data.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");
    };

};

function theadClick() {
    var field = this.innerHTML.toLowerCase();
    if(typeof dataout[0][field] === "number")
        dataout.sort(sort_by(field, parseInt));
    else
        dataout.sort(sort_by(field, function(a){return a.toUpperCase()}));
    console.log(dataOut);
    document.getElementById("cars").innerHTML = "<thead class=table-dark><tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr></thead>" + dataOut.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");
}

var sort_by = function(field, primer){
    var key = primer ? 
        function(x) {return primer(x[field])} : 
        function(x) {return x[field]};
 
    return function (a, b) {
        return a = key(a), b = key(b), ((a > b) - (b > a));
      } 
 }

var dataOut;

const startFetch = async(url) => {
    await fetch(url)
            .then(res => res.json())
            .then(data => {
                dataOut = data;
            });
    return dataOut;
};