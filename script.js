function changeAdminPanel(id){
	document.getElementById("adminContent").innerHTML = document.getElementById("new" + id.substring(3)).innerHTML;
}

function createPayForm(){
	desc = "";
	desc += document.getElementById('surname').value + " ";
	desc += document.getElementById('name').value + ", ";
	desc += document.getElementById('from_station').innerHTML + "-";
	desc += document.getElementById('to_station').innerHTML + ", ";
	desc += document.getElementById('from_date').innerHTML + "-";
	desc += document.getElementById('to_date').innerHTML + "";
	alert(desc);
	document.getElementsByName('ik_desc').value = desc;
}




function chooseTrip(id){
	document.getElementById('tripId').value = id;
	document.getElementById('sendTripId').click();
}

function SendPost() {
    //отправляю POST запрос и получаю ответ
    $$a({
        type:'post',//тип запроса: get,post либо head
        url:'http://comicat.com.ua/',//url адрес файла обработчика
        data:{'z':'qwerr'},//параметры запроса
        response:'text',//тип возвращаемого ответа text либо xml
        success:function (data) {//возвращаемый результат от сервера
		alert();
            $$('result',$$('result').innerHTML+'<br />'+data);
        }
    });
}

