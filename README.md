# TransBank Test 


1. El primer paso es la clonación del repositorio publico del proyecto en github:
```
git clone https://github.com/Bardo1/transTest.git
```
* Este test se desarrolló con el framework Spring Boot

* las clases java dentro de la aplicación están con una sintaxis y formato en lenguaje inglés para conservar el standar global. Exceptuando la descripción de las clases para javadoc, lo que está en español

* Se trabajó con una base de datos embebida con h2 para la persistencia de la entidad usuario y la entidad venta

* Se utiliza spring security para verificar los request y la validación de basic auth de los usuarios.
A continuación el usuario que ya está registrado al momento de arrancar la aplicación:
```
usuario:12345678
password:12345678
```
* A nivel de seguridad se encriptan las contraseñas con la funcion bcrypt que nos proporciona Spring Security, lo que nos permite crear un hash de la contraseña y poder almacenarla en la base de dato de una forma un poco mas segura.

* Login, Se utilizó JSP

* Para la mensajeria de publicación a la Cola MQ, Se utilizó....Listener

ejecutar un servidor de RabbitMQ de facil acceso a través de una imagen docker generado con un docker-compose.yml
```
rabbitmq:
  image: rabbitmq:management
  ports:
    - "5672:5672"
    - "15672:15672"
```
Ejecutar el archivo de arranque, para levantar el servicio. (Solo basta con ejecutar este comando)
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

* Se agregaron test unitario con la librería de Junit y Mockito
* Se habilitó la interfaz de swagger
* En el repositorio viene incluido el archivo postman, que contiene las url de las peticiones del servicio, tanto para ambiente local, como para ambiente GCP


### Se utilizaron servicios de GCP como:

- Pub/Sub (Se generó el tópico indicado a través de la plataforma, el canal de conexión y envió a través de Spring)
Nota: Saqué el canal de suscripción del componente de spring, ya que no me lo pidieron, aunque igual dejé el canal de suscripción activado en la plataforma.

- IAM, para las cuentas de servicio, y roles de asignación de perfil.


Saludos y Gracias.

