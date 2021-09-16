# Prueba Tecnica Backend - ruleta

- Proycto realizado con Java8, maven, SpringBoot, MySQL

- En la carpeta [script_database](script_database) se encuentran los scripts de la base de datos creada MySQL. Estos deben ejecutance en el seguiente orden:
  
    1. [BD y creacion de tablas](script_database/script_ruleta_schema.sql)
    2. [Registros tabla usuarios](script_database/ruleta_usuarios.sql)
    3. [Registros tabla roles](script_database/ruleta_roles.sql) 
    4. [Registros tabla mesas](script_database/ruleta_mesas.sql)
    
- El archivo [application.properties](src/main/resources/application.properties) contiene la configuracion necesaria para hacer la conexion a base de datos

- Se utilizo la siguiente [extencion](chrome-extension://aejoelaoggembcahagimdiliamlcdmfm/index.html#requests) de Google Chrome para realizar consultas a los servicios:

Json para crear usuarios:

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



Json para crear mesas

{
  "id": 8,
  "disponible": "T",
  "apuesta": '',
  "resultadoUsuario": '',
  "resultadoFinal": '',
  "recaudoMesa": ,
  "recaudoUsuario": ,
  "usuarioGano": ''
}
