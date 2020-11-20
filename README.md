# TransBank Test 


* El primer paso es la clonación del repositorio público del proyecto en github:
```
git clone https://github.com/Bardo1/transTest.git
```
* Este componente se desarrolló con el framework Spring Boot en ámbito principal 

* las clases java dentro de la aplicación están con una sintaxis y formato en lenguaje inglés para conservar el estándar global. Exceptuando la descripción de las clases para javadoc, lo que está en español

* Se trabajó con una base de datos embebida con h2 para la persistencia de la entidad usuario y la entidad venta

### Login, validación de usuario y seguridad

* Se utiliza spring security para verificar los request y la validación de basic auth de los usuarios.
A continuación el usuario que ya está registrado al momento de arrancar la aplicación:
```
usuario:12345678
password:12345678
```
* Se puede acceder al interfaz de login al colocar el siguiente endpoint en el navegador:
```
http://localhost:8081/login
```
* Una vez dentro y como forma de comprobar la seguridad es ejecutando el despliegue de las ventas ya almacenadas. Con el siguiente comando a tráves del navegador
```
http://localhost:8081/v1/listSale
```
* A nivel de seguridad se encriptan las contraseñas con la funcion bcrypt que nos proporciona Spring Security, lo que nos permite crear un hash de la contraseña y poder almacenarla en la base de dato de una forma un poco mas segura.

* Para las vistas del login se utilizó un proyecto estándar encontrado con Java Server Pages, por la facilidad de implementación (Podia hacerlo con otras tecnologias mas complejas con Angular)

### Cola y publicación (Es necesario tener este servicio arriba antes del ejecutar el componente de Spring)

* Para la mensajeria de publicación a la cola MQ, se utilizó RabbitMQ, lo que me permitió generar una cola estándar de fácil acceso que se define dentro de la clase "WebApplication". Además también se implementó un receptor, a la escucha de la cola, que permite imprimir en la sección de logs el resultado del mensaje decodificado en base64.

* Se implementó un servidor de RabbitMQ de fácil acceso a través de una imagen docker, generado con un docker-compose.yml.
Este es el detalle del archivo:
```
rabbitmq:
  image: rabbitmq:management
  ports:
    - "5672:5672"
    - "15672:15672"
```
Se debe ejecutar el archivo de arranque para levantar el servicio. Para esto, es necesario posicionarse en la linea de comando a nivel del archivo y correr el siguiente comando.
(Solo basta con ejecutar esto para que esté arriba)
```
docker-compose up
```
Limpiar e instalar dependencias de Spring
```
mvn clean install
```
Ejecutar el componente de Spring
```
mvn spring-boot:run
```

### Test

* La app se puede ejecutar en el localhost en el puerto 8081
* Se agregaron test unitario con la librería de Junit y Mockito. Se pueden probar de forma independiente con el comando:
```
mvn clean test
```
* Se habilitó la interfaz de swagger para la documentación de los métodos mas importantes y se puede acceder a través de la siguiente url: 
```
http://localhost:8081/swagger-ui.html#/
```
* En el repositorio viene incluido el archivo postman, que contiene las url de las peticiones del servicio, en ambiente localhost.
Además añadir, que estas peticiones, tanto verbos http GET, como POST, vienen ya con las credenciales de basic auth, lo que permite realizar las llamadas
a los endpoint definidos sin problemas.


Eso.

Saludos y Gracias.

Atento a cualquier feedback de mejoramiento.
