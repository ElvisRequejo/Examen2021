$(document).ready(function (){
	listarCliente();
});
function listarCliente(){
    $.get("cc",{"opc":1},function (data) {
        var x = JSON.parse(data);
        for(var i = 0;i<x.length;i++){
            $("#cliente").append("<option value='"+x[i].idcliente+"'>"+x[i].nombres+"</option>");
        }
    });
}


