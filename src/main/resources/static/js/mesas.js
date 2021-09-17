$(document).ready(function() {
    localStorage.idMesa = '';
    cargarMesas();
    $('#tablaMesasDisponibles').DataTable();
});

async function agregarMesa(){
    const path = '/api_mesa/create'+localStorage.rol;
    const request = await fetch(path, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorizarion': localStorage.token
        }
    });
    location.reload();
}

//Retorna el listado de mesas del controlador de mesas
async function cargarMesas() {

    if (localStorage.rol == 'ROLE_USER' || localStorage.rol == 'ROLE_ADMIN'){

        const request = await fetch('/mesas/disponibles', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorizarion': localStorage.token
            }
        });
        const mesas = await request.json();

        let listadoMesasHtml = '';
        for(let mesa of mesas){
            let mesaHtml = '<tr><td>'+ mesa.id +'</td><td>Esperando tu participacion...</td><td><a onclick="buscarMesa('
                           + mesa.id +')" href="#">jugar</a></td></tr>';
            listadoMesasHtml += mesaHtml;
        }
        document.querySelector('#tablaMesasDisponibles tbody').outerHTML = listadoMesasHtml;

    }
}


async function buscarMesa(idMesa) {
    let path = '/mesa_actual/'+idMesa;
    console.log(path)
    const request = await fetch(path, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorizarion': localStorage.token
        }
    });
    let mesa = await request.json();
    if(mesa != null){
        localStorage.idMesa = idMesa;
        window.location.href = 'mesa_en_juego.html';
    }else{
        alert('Mesa no disponible');
    }
}


