window.onload = function () {
    document.getElementById("reload").onclick = async() => {
        var data = await startFetch("/CA-1/api/classmember/all");
        document.getElementById("tableData").innerHTML = data.map(x => "<tr><td>" + x.name + "</td><td>" + x.studentId + "</td><td>" + x.color + "</td></tr>").join(" ");
    };
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