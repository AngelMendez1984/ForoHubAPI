# ForoHub REST API
Este proyecto es una API REST para un foro desarrollado con Spring Boot 3. La API permite la creación, actualización y eliminación de temas en el foro.

## Características
- Crear, leer, actualizar y eliminar temas del foro.
-Gestión de usuarios: autenticación.
- Crear y eliminar tópicos.
- Validación de entradas y manejo de excepciones.
## Requisitos
- Java 17 o superior.
- Maven 3.8.1 o superior.
- Spring Boot 3.
- Postman o Insomnia.
- Postgre o MySql para manejo de base de datos.
## Funciones

![image](https://github.com/user-attachments/assets/937bc6e2-4014-4c54-87dd-6b0eac42f7f8)

## Login de usuario

La API REST maneja varias rquest, como se muestra en la imágen, para hacer uso de las mismas es necesario autenticarse con un usuario y contraseña dado de alta en la base de datos de usuarios, 
el cual debe ser mandado en el body de la request en formato Json como se muestra en la imagen 
a la direccion https://localhost8080/login, con esto se consigue un Bearer Token como se muestra en la siguiente imagen, dicho Token tiene una vigencia de dos horas y con él es posible utilizar las demás funciones.

![image](https://github.com/user-attachments/assets/cc55201b-5a9a-420d-9f70-9f5c4889dc03)


## Listado de tópicos

Al realizar un get a la direccion https://localhost8080/login, incluyendo el Token en el apartado de autenticación se obtiene un listado con los tópicos existentes.

![image](https://github.com/user-attachments/assets/2aa2066f-5e56-4cf6-bfe0-87cf272d2525)

## Registro de tópicos

Para registrar un tópico es necesario hacer un Post a la direccion https://localhost8080/topicos con un json que contenga la información mostrada en la imagen, ninguno de los cuales puede ser nulo o blank, 
de serlo se indicará que no es posible registrar el tópico por falta de información obligatoria. Además de que los tópicos y mensajes deben ser únicos, no se permiten tópicos y/o mensajes repetidos.

![image](https://github.com/user-attachments/assets/21cd02b3-b840-453f-b8f0-672a3f65be99)

## Actualización de tópicos


Para actualizar un tópico se sigue la misma regla del punto anterior, con la única diferencia de que es necesario el indicar el id del tópico que se quiere actualizar, haciendo un Post a la direccion https://localhost8080/topicos/id, 
con la misma información solicitada en el proceso de registro de tópicos.

## Detallar tópico

Esta función permite visualizar solamente uno de los tópicos registrados, para ello debes de hacer un Get a la dirección https://localhost/topicos/id, dicha solicitud debe apuntar al id de un tópico existente.

## Borrar tópico

En este caso se hace un borrado físico de la base de datos, lo que significa que un tópico borrado no puede ser recuperado, así que esta función debe ser usada con precaución, para ello es necesario realizar un Delete a la direccion https://localhost8080/topicos/id,
igual que en el punto anterior el id del tópico debe existir para evitar errores de funcionamiento. Como se muestra en la imagen, al borrar un tópico se obtiene la respuesta 204 No content.

![image](https://github.com/user-attachments/assets/dacf6a2a-5a29-4b4e-932d-db4feaec5518)








