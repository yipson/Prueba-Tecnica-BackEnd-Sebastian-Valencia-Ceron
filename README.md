# Prueba Tecnica Backend - ruleta

- Proycto realizado con Java8, maven, SpringBoot, MySQL

- En la carpeta [script_database](script_database) se encuentran los scripts de la base de datos creada MySQL. Estos deben ejecutance en el seguiente orden:
  
    1. [BD y creacion de tablas](script_database/script_ruleta_schema.sql)
    2. [Registros tabla usuarios](script_database/ruleta_usuarios.sql)
    3. [Registros tabla roles](script_database/ruleta_roles.sql) 
    4. [Registros tabla mesas](script_database/ruleta_mesas.sql)
    
- El archivo [application.properties](src/main/resources/application.properties) contiene la configuracion necesaria para hacer la conexion a base de datos

- Se utilizo la siguiente [extencion](chrome-extension://aejoelaoggembcahagimdiliamlcdmfm/index.html#requests) de Google Chrome para realizar consultas a los servicios:

Crear usuarios. PATH = '/api_usuario/create':

{
  "nombre": "alberto",
  "email": "alberto@mail.com",
  "password": "1234",
  "roles": [
    {
      "nombre": "ROLE_USER"
    }
  ]	
}


Listar usuarios. PATH = '/api_usuario/listado'. method = GET

Listar mesas. PATH = '/api_mesa/listado'. method = POST


Generar resultado de ruleta. PATH = '/generar_resultado'. method = GET


Listar todas las mesas. PATH = '/api_mesa/listado'. method = GET

Listar mesas disponibles. PATH = '/mesas/disponibles'. method = GET

Retornar mesa en juego. PATH = '/mesa_actual/{id}'. method = GET

Crear mesas. PATH = '/api_mesa/create'. method = POST

{
"id": null,
"disponible": "T",
"apuesta": null,
"resultadoUsuario": null,
"resultadoFinal": null,
"recaudoMesa": null,
"recauUsuario": null,
"usuarioGano": null
}
