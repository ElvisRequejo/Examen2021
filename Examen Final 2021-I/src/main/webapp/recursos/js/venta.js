$(document).ready(function () {
    listarVenta();
    limpiar();
});
function listarVenta() {

    $.get("ec", {"opc": 1}, function (data) {
        var x = JSON.parse(data);
        $("#tablita tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $("#tablita").append("<tr><td>" + (i + 1) + "</td><td>" + x[i].sucursal + "</td><td>" + x[i].venta + "</td><td><a href='#' onclick='editar(" + x[i].idventa + ")' class='edit'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='del(" + x[i].idventa + ")' class='del'><i class='fas fa-trash-alt'></i></a></td></tr>");
        }
    });
}
function agregar() {
    $("#myModal").modal('show');
}
function add() {
    if ($("#id").val() === '0') {
        var id = $("#id").val();
        var idsucur = $("#sucursal").val();
        var venta = $("#venta").val();
        /**/
        if (idsucur !== 0 && venta !== "") {
            $.post("ec", {"idsucur": idsucur, "venta": venta, "opc": 2}, function (data) {
                listarVenta();
                limpiar();
                $("#myModal").modal('hide');
                bootbox.alert({
                    message: "La venta " + venta + " registrado correctamente...!",
                    backdrop: true
                });
            });
        } else {
            bootbox.alert({
                message: "No se ha seleccionado sucursal o no sea ingresado una venta..!",
                backdrop: true
            });
        }
        /**/
    } else {
        actualizar();
    }
}
function del(x) {
    bootbox.confirm({
        message: "Realmente desea eliminar ?",
        buttons: {
            confirm: {
                label: 'Yes',
                className: 'btn-success'
            },
            cancel: {
                label: 'No',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.get("ec", {"idvent": x, "opc": 4}, function () {
                    listarVenta();
                    bootbox.alert({
                        message: "La venta ha sido eliminado correctamente...!",
                        backdrop: true
                    });
                });
            } else {
                bootbox.alert({
                    message: "No se eliminó la venta",
                    size: 'small'
                });
                limpiar();
            }

        }
    });

}
function editar(x) {
    $.get("ec", {"opc": 5, "idvent": x}, function (data) {
        var x = JSON.parse(data);
        $("#venta").val(x.fecha);
        $("#sucursal").val(x.idsucursal);
        $("#id").val(x.idventa);
    });
    $("#myModal").modal('show');
}
function limpiar() {
    $("#sucursal").val(0);
    $("#venta").val("");
    $("#id").val(0);
}
function actualizar() {
    var idvent = $("#id").val();
    var venta = $("#venta").val();
    var idsucur = $("#sucursal").val();
    bootbox.confirm({
        message: "Realmente desea modificar la venta " + venta + "?",
        buttons: {
            confirm: {
                label: 'Yes',
                className: 'btn-success'
            },
            cancel: {
                label: 'No',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.post("ec", {"idvent": idvent, "venta": venta, "idsucur": idsucur, "opc": 3}, function () {
                    listarVenta();
                    limpiar();
                    bootbox.alert({
                        message: "La venta " + venta + " ha sido modificado correctamente...!",
                        backdrop: true
                    });
                });
            } else {
                bootbox.alert({
                    message: "No se modificó la venta " + venta + "!",
                    size: 'small'
                });
                limpiar();
            }

        }
    });


    $("#myModal").modal('hide');

}
