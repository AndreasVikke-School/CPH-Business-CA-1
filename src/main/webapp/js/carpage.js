window.onload = async() => {
    var data = await startFetch("/CA-1/api/car/all");
    createTable(data);
    
    document.getElementById("carAll").onclick = async() => {
        var data = await startFetch("/CA-1/api/car/all");
        var alert = document.getElementById("alert");
        alert.style.display = "none";  
        createTable(data);
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

        createTable(data);
    };

};

const createTable = async(data) => {
    document.getElementById("cars").innerHTML = "<thead class=table-dark><tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr></thead>" + data.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");
    document.getElementsByTagName("tr")[0].onclick = function() {
        theadClick();
    }
}

const theadClick = () => {
    var field = this.event.target.innerHTML.toLowerCase();
    if(typeof dataOut[0][field] === "number")
        dataOut.sort(sort_by(field, parseInt));
    else
        dataOut.sort(sort_by(field, function(a){return a.toUpperCase()}));
    createTable(dataOut);
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