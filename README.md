# servicio-cuenta-cliente
Micro servicio de cuentas y movimiento asincrónica

# Definicion de la Arquitectura principal para comunicación de Microservicios por Eventos para una entidad Bancaria

![image-modeloArquitecturaEventBus](img/SoftwareArchitectureEventBus.png)

# Imagen de una persona cliente asincrónica, este conecta con rabbitMQ manejando colas, para funcionar con cuentas y movimientos.

## Tener descargado rabbitMQ con: 

### latest RabbitMQ 3.12
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management

## Realizar el pull de este micro en la versión 0.0.2-SNAPSHOT:

## Después ejecutar con la ip de el rabbitmq:

docker run --network bridge -d --name serviciocliente -p 8089:8089 --env IP_RABBIT=172.17.0.2 santbetv/microservice-docker-serviciocliente:0.0.2-SNAPSHOT
