# Falabella Test 



1. El primer paso es la clonación del repositorio publico del proyecto en github:
```
git clone https://github.com/Bardo1/transTest.git
```


* Este test se desarrolló con el framework Spring Boot

Se trabajó con una base de datos embebida con h2




documentar cada clase

Se utiliza spring security para verificar los basic auth desde fuera con 
usuario:12345678
password:12345678

Se encriptan las contraseñas con ...bcrypt.BCryptPasswordEncoder



S e utilizó JSP

Para la mensajeria de publicación a la Cola MQ, Se utilizó 

ejecutar un servidor de RabbitMQ de facil acceso a través de una image docker generado con un docker-compose.yml

rabbitmq:
  image: rabbitmq:management
  ports:
    - "5672:5672"
    - "15672:15672"

Ejecutar el archivo de arranque
```
docker-compose up
```
Limpiar e instalar dependencias
```
mvn clean install

```
Ejecutar el componente
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
- Cloud Sql (Se utilizó la versión 5.7 de Mysql y se realizó la conexión con Spring)

- IAM, para las cuentas de servicio, y roles de asignación de perfil.




Ejemplo



Saludos y Gracias.

