$(document).ready(function (){
	listarSucursal();
});
function listarSucursal(){
    $.get("sc",{"opc":1},function (data) {
        var x = JSON.parse(data);
        for(var i = 0;i<x.length;i++){
            $("#sucursal").append("<option value='"+x[i].idsucursal+"'>"+x[i].nomsucursal+"</option>");
        }
    });
}


