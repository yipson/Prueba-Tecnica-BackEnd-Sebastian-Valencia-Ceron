$(document).ready(function() {
    localStorage.clear();
});

async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('username').value;
    datos.password = document.getElementById('password').value;

    const request = await fetch('api_login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorizarion': localStorage.token
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await request.text();
    const respuestaArray = respuesta.split(',');
    console.log(respuesta);
    console.log(respuestaArray);
    if (respuesta != 'FAIL'){
        localStorage.token = respuestaArray[0];
        localStorage.idUsuario = respuestaArray[1];
        localStorage.rol = respuestaArray[2]
        localStorage.email = datos.email;
        localStorage.idMesa = '';
        window.location.href = 'mesas_disponibles.html'
    } else {
        alert("Credenciales incorrectas, Reintentar");
    }
}
