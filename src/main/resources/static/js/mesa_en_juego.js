$(document).ready(function() {
    if (localStorage.idMesa == ''){
        window.location.href = 'mesas_disponibles.html';
    }
    console.log(localStorage.idMesa);
    cargarTitulo();
    cargarApuestas();
});

async function cargarTitulo(){
    document.querySelector('#mesaEnJuegoTitulo').outerHTML = '<h1>Mesa numero '+ localStorage.idMesa +'</h1>';
}


async function cargarApuestas(){

    let select = '<select name="apuesta" id="apuesta">';
    for (var i=0; i<37; i++){
        var color;
        if(i%2 == 0 || i==0){
            color = "Rojo";
        } else {
            color = "Negro";
        }

        option =  '<option value="'+ i +'">'+ i +' - '+ color +'</option>';

        select +=option;
    }

    select +=  '</select>';
    document.querySelector('#divApuesta').outerHTML = select;
}

async function girarRuleta(){
    var dinero = parseFloat(document.getElementById('dinero').value);
    const apuestaUsuario = parseInt(document.getElementById('apuesta').value);
    var tipoApuesta = document.getElementById('tipoApuesta').value;

    console.log('dinero = ' + dinero);
    if (dinero>10000){
        alert('El valor de la apuesta debe ser menor a $10.000');
        location.reload();
    }
    localStorage.apuesta = dinero;
    generarResultado(apuestaUsuario, tipoApuesta);
}

async function generarResultado(apuestaUsuario, tipoApuesta){
    let path = '/generar_resultado';
    const request = await fetch(path, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorizarion': localStorage.token
        }
    });
    const respuestaGanadora = await request.json();
    obtenerGanador(respuestaGanadora, apuestaUsuario, tipoApuesta)
}

async function obtenerGanador(respuestaGanadora, apuestaUsuario, tipoApuesta){
    if(tipoApuesta == 'Numero'){
        if (parseInt(respuestaGanadora.numero) == parseInt(apuestaUsuario)){

            localStorage.recaudoUsuario = parseFloat(localStorage.apuesta) + parseFloat(localStorage.apuesta)*0.1;
            localStorage.recaudoMesa =  0 - parseFloat(localStorage.apuesta)*0.1;
            localStorage.usuarioGano = 'T';
            return;
        }
        localStorage.recaudoMesa =  parseFloat(localStorage.apuesta);
        localStorage.recaudoUsuario = 0;
        localStorage.usuarioGano = 'F';
        return;
    } else(parseInt(respuestaGanadora.numero)%2 == 0 || parseInt(respuestaGanadora.numero) == 0){
        if(parseInt(apuestaUsuario)%2 == 0 || parseInt(apuestaUsuario) == 0){

            localStorage.recaudoUsuario = parseFloat(localStorage.apuesta) + parseFloat(localStorage.apuesta)*0.25;
            localStorage.recaudoMesa =  0 - parseFloat(localStorage.recaudoUsuario);
            localStorage.usuarioGano = 'T';
            return;
        }
    }
    localStorage.recaudoMesa =  parseFloat(localStorage.apuesta);
    localStorage.recaudoUsuario = 0;
    localStorage.usuarioGano = 'F';
    return;
}

async function guardarReultados(){

    let path = '/guardar_resultado/'+localStorage.idUsuario;
    const request = await fetch(path, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorizarion': localStorage.token
        }
    });
}