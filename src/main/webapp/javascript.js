var completeField;
var completeTable;
var autoRow;
var req, Req;
var isIE;

function init() {
    completeField = document.getElementById("complete-field");
    completeTable = document.getElementById("complete-table");
    autoRow = document.getElementById("auto-row");
}

function doCompletion(id) {
    completeField = document.getElementById(id);
    var url = "autocomplete?action=complete&id=" + escape(completeField.value);
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callback;
    req.send(null);
}

function search_trips() {
    from = document.getElementById("from").value;
    to = document.getElementById("to").value;
    date = document.getElementById("date").value;
    var url = "/SearchTrips?from=" + from + "&to=" + to + "&date=" + date;
    Req = initRequest();
    Req.open("GET", url, true);
    Req.onreadystatechange = callbackTrips;
    Req.send(null);
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function callbackTrips() {

    clearTable();


    if (Req.readyState == 4) {
        if (Req.status == 200) {
            buildTripTable(Req.responseXML);
        }
    }
}

function callback() {

    clearTable();


    if (req.readyState == 4) {
        if (req.status == 200) {
            parseMessages(req.responseXML);
        }
    }
}

function appendComposer(firstName) {
    option = document.createElement("option");
    option.setAttribute("value", firstName);
    document.getElementById("cities").appendChild(option);
}

function clearTable() {
    document.getElementById("cities").innerHTML = "";
}

function parseMessages(responseXML) {

    // no matches returned
    if (responseXML == null) {
        return false;
    } else {

        var composers = responseXML.getElementsByTagName("cities")[0];
        var actionTag = responseXML.getElementsByTagName("action")[0];
        var action = actionTag.getElementsByTagName("name")[0];
        if (action == "autocomplete") {
        }
        if (composers.childNodes.length > 0) {
            completeTable.setAttribute("bordercolor", "black");
            completeTable.setAttribute("border", "1");

            for (loop = 0; loop < composers.childNodes.length; loop++) {
                var composer = composers.childNodes[loop];
                var firstName = composer.getElementsByTagName("firstName")[0];
                var composerId = composer.getElementsByTagName("id")[0];
                appendComposer(firstName.childNodes[0].nodeValue);
            }
        }
        if (action == "trips") {
            buildTripTable(responseXML);
        }
    }
}
function buildTripTable(responseXML) {
    var trips = responseXML.getElementsByTagName("trips")[0];
    document.getElementById("tripsTable").innerHTML = "";
    if (trips.childNodes.length > 0) {
        for (j = 0; j < trips.childNodes.length; j++) {
            divRow = document.createElement("div");
            divRow.setAttribute("class", "row");
            divRow.setAttribute("onClick", "chooseTrip(this.id)");
            divColDateFrom = document.createElement("div");
            divColDateFrom.setAttribute("class", "col date");
            divRow.appendChild(divColDateFrom);
            bColDateFrom = document.createElement("b");
            h3ColDateFrom = document.createElement("h3");
            divColDateFrom.appendChild(bColDateFrom);
            divColDateFrom.appendChild(h3ColDateFrom);
            divColCFrom = document.createElement("div");
            divColCFrom.setAttribute("class", "col c");
            divRow.appendChild(divColCFrom);
            h2ColCFrom = document.createElement("h2");
            divColCFrom.appendChild(h2ColCFrom);
            divColDateTo = document.createElement("div");
            divColDateTo.setAttribute("class", "col date");
            divRow.appendChild(divColDateTo);
            bColDateTo = document.createElement("b");
            h3ColDateTo = document.createElement("h3");
            divColDateTo.appendChild(bColDateTo);
            divColDateTo.appendChild(h3ColDateTo);
            divColCTo = document.createElement("div");
            divColCTo.setAttribute("class", "col c");
            divRow.appendChild(divColCTo);
            h2ColCTo = document.createElement("h2");
            divColCTo.appendChild(h2ColCTo);
            divColTimeInWay = document.createElement("div");
            divColTimeInWay.setAttribute("class", "col time_in_way");
            h2ColTimeInWay = document.createElement("h2");
            divColTimeInWay.appendChild(h2ColTimeInWay);
            document.getElementById("tripsTable").appendChild(divRow);
            //divRow.appendChild(divColTimeInWay);

            divColCCost = document.createElement("div");
            divColCCost.setAttribute("class", "col c");
            h2ColCCost = document.createElement("h2");
            bColCCost = document.createElement("b");
            divColCCost.appendChild(h2ColCCost);
            h2ColCCost.appendChild(bColCCost);
            divRow.appendChild(divColCCost);

            trip = trips.childNodes[j];

            id = trip.getElementsByTagName("id")[0].childNodes[0].nodeValue;
            divRow.setAttribute("id", id);

            h3ColDateFrom.innerHTML = trip.getElementsByTagName("datefrom")[0].childNodes[0].nodeValue;
            h2ColCFrom.innerHTML = trip.getElementsByTagName("from")[0].childNodes[0].nodeValue;
            h3ColDateTo.innerHTML = trip.getElementsByTagName("dateto")[0].childNodes[0].nodeValue;
            h2ColCTo.innerHTML = trip.getElementsByTagName("to")[0].childNodes[0].nodeValue;
            bColDateFrom.innerHTML = trip.getElementsByTagName("datefromtime")[0].childNodes[0].nodeValue;
            bColDateTo.innerHTML = trip.getElementsByTagName("datetotime")[0].childNodes[0].nodeValue;
            bColCCost.innerHTML = "100 €";
        }
    }
}

function chooseTrip(id){
    document.getElementById("tripId").value = id;
    document.getElementById("sendIdButton").click();
}

function choosePlace(id){
    document.getElementById("placeId").value = id;
    document.getElementById("sendIdButton").click();
}
