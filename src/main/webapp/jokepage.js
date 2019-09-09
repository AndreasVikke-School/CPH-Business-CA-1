window.onload = () => {
    document.getElementById("buttonGroup").onclick = async(e) => {
        createTable(await fetchUrl("api/joke/" + e.target.getAttribute("endpoint")));
    }

    document.getElementById("fetchJoke").onsubmit = async(e) => {
        e.preventDefault();
        createTable(await fetchUrl("api/joke/" + document.getElementById("jokeid").value));
    }
}

const createTable = (a) => {
    // Check if argument is array og single object
    var single = a.length == undefined ? true : false;
    
    // Find table node and clear the content of it
    const myNode = document.getElementById("table");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }

    // Create new header for table and insert new row
    var header = document.getElementById("table").createTHead();
    var headRow = header.insertRow(0);

    // Interate over all the keys of the first object in the array, and add a new cell with the name
    for(i = 0; i < Object.keys(single ? a : a[0]).length; i++) {
        var cell = document.createElement("th");
        var name = Object.keys(single ? a : a[0])[i]
        cell.innerHTML = name[0].toUpperCase() + name.substring(1);
        headRow.appendChild(cell);
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

const fetchUrl = async(url) => {
    var dataout;
    await fetch(url)
    .then(res => res.json())
    .then(data => {
        dataout = data;
    });
    return dataout;
}