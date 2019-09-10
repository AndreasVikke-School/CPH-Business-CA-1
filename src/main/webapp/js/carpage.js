window.onload = async() => {
    var data = await startFetch("/CA-1/api/car/all");
    document.getElementById("cars").innerHTML = "<thead class=table-dark><tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr></thead>" + data.map(x => "<tr><td>" + x.id + "</td><td>" + x.year + "</td><td>" + x.make + "</td><td>" + x.model + "</td><td>" + x.price + "</td></tr>").join(" ");

};

var dataOut;

const startFetch = async(url) => {
    await fetch(url)
            .then(res => res.json())
            .then(data => {
                dataOut = data;
            });
            return dataOut;
};