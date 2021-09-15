window.addEventListener('DOMContentLoaded', event => {
    alert(3232);
   ('#tablaUsuarios').DataTable();
    cargarUsuarios();

});


async function cargarUsuarios() {

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();

  console.log(usuarios);

}