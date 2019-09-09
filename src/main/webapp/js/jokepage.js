window.onload = () => {
    document.getElementById("buttonGroup").onclick = async(e) => {
        createTable(await fetchUrl("api/joke/" + e.target.getAttribute("endpoint")));
    }

    document.getElementById("fetchJoke").onsubmit = async(e) => {
        e.preventDefault();
        var id = document.getElementById("jokeid").value;
        var alert = document.getElementById("alert");
        alert.style.display = "none";

        try {
            createTable(await fetchUrl("api/joke/" + Number(id)));
        } catch(ex) {
            document.getElementById("alert").innerHTML = "Input is not a number";
            alert.style.display = "block";
        }
    }
}

function theadClick() {
    var field = this.innerHTML.toLowerCase();
    if(typeof dataout[0][field] === "number")
        dataout.sort(sort_by(field, parseInt));
    else
        dataout.sort(sort_by(field, function(a){return a.toUpperCase()}));
    createTable(dataout);
}

var sort_by = function(field, primer){
    var key = primer ? 
        function(x) {return primer(x[field])} : 
        function(x) {return x[field]};
 
    return function (a, b) {
        return a = key(a), b = key(b), ((a > b) - (b > a));
      } 
 }

const createTable = (a) => {
    // Check if argument is array og single object
    var single = !Array.isArray(a);
    
    // Find table node and clear the content of it
    const myNode = document.getElementById("table");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }

    // Create new header for table and insert new row
    var header = document.getElementById("table").createTHead().insertRow(0);

    // Interate over all the keys of the first object in the array, and add a new cell with the name
    for(i = 0; i < Object.keys(single ? a : a[0]).length; i++) {
        var cell = document.createElement("th");
        var name = Object.keys(single ? a : a[0])[i]
        cell.innerHTML = name[0].toUpperCase() + name.substring(1);
        cell.onclick = theadClick;
        header.appendChild(cell);
    }

    // Create new footer for table
    var body = document.getElementById("table").createTFoot();

    // Iterate over all the objects in the array and add a new row to the footer with the values
    for(i = 0; i < (single ? 1 : a.length); i++) {
        var row = body.insertRow(body.rows.length);
        for(y = 0; y < Object.keys(single ? a : a[0]).length; y++){
            row.insertCell(body.rows[i].cells.length).innerHTML = single ? a[Object.keys(a)[y]] : a[i][Object.keys(a[0])[y]];
        }
    }
}

var dataout;

const fetchUrl = async(url) => {
    await fetch(url)
    .then(res => res.json())
    .then(data => {
        dataout = data;
    });
    return dataout;
}