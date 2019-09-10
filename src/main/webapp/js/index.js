window.onload = function () {
    createTable();

    document.getElementById("reload").onclick = async() => {
        createTable();
    };
}

const createTable = async() => {
    var data = await startFetch("/CA-1/api/classmember/all");
    document.getElementById("tableData").innerHTML = data.map(x => "<tr><td><a href='" + x.link + "'>" + x.name + "</a></td><td>" + x.studentId + "</td><td>" + x.color + "</td></tr>").join(" ");
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