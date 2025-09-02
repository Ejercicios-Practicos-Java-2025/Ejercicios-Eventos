# events (Proyecto básico Kafka + Spring Boot)

## Requisitos
- Docker + Docker Compose
- Java 17
- Maven 3.9+

# Levantar Kafka (v1)
```bash
docker compose up -d
```

UI opcional: http://localhost:8085

## Ejecutar la app
```bash
mvn spring-boot:run
```

## Probar publicación de eventos
```bash
curl -X POST http://localhost:8080/orders   -H "Content-Type: application/json"   -d '{"orderId":"O-1001","customerId":"C-2001","amount":1500.00}'
```



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------



# Cómo ejecutarlo rápido

## 1.- Levanta Kafka:
docker compose up -d

## 2.- Ejecuta la app:
mvn spring-boot:run

## 3.- Publica un evento:
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{"orderId":"O-1001","customerId":"C-2001","amount":1500.00}'


## Consola del consumidor:

✅ Consumido orderId=O-1001 amount=1500.00



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------



# Levantar KAFKA con DOCKER

## Levantar KAFKA con DOCKER (Infraestructura)
$ docker compose up -d
(El archivo "docker-compose.yml" debe estar en la misma posicion para que lo vea el comando "docker compose up -d")

## Ejemplo
C:\Workspaces\angel\docker\dockerCompose\Kafka>docker compose up -d
time="2025-08-26T18:12:54-06:00" level=warning msg="C:\\Workspaces\\angel\\docker\\dockerCompose\\Kafka\\docker-compose.yml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Running 23/23
 ✔ zookeeper Pulled                                                                                                                                                                                          61.4s
   ✔ 22ebf0e44c85 Pull complete                                                                                                                                                                              10.7s
   ✔ 00b33c871d26 Pull complete                                                                                                                                                                              55.0s
   ✔ 6b11e56702ad Pull complete                                                                                                                                                                              55.2s
   ✔ 53d69aa7d3fc Pull complete                                                                                                                                                                              55.3s
   ✔ a3ab11953ef9 Pull complete                                                                                                                                                                              55.9s
   ✔ 91ef9543149d Pull complete                                                                                                                                                                              56.0s
   ✔ c52916c1316e Pull complete                                                                                                                                                                              56.1s
   ✔ 7a1cb9ad7f75 Pull complete                                                                                                                                                                              58.6s
   ✔ 0a92c7dea7af Pull complete                                                                                                                                                                              58.7s
 ✔ kafka Pulled                                                                                                                                                                                              61.5s
   ✔ 2ec4f59af178 Pull complete                                                                                                                                                                              56.0s
   ✔ 8b7e81cd5ef1 Pull complete                                                                                                                                                                              56.1s
   ✔ d93f69e96600 Pull complete                                                                                                                                                                              58.6s
   ✔ bbb9d15c45a1 Pull complete                                                                                                                                                                              58.7s
 ✔ kafka-ui Pulled                                                                                                                                                                                           39.9s
   ✔ 0ce1dd7918a4 Pull complete                                                                                                                                                                              24.0s
   ✔ 396900a6066f Pull complete                                                                                                                                                                              35.7s
   ✔ f86135b615e8 Pull complete                                                                                                                                                                              35.7s
   ✔ 7efc01291e39 Pull complete                                                                                                                                                                              35.8s
   ✔ 03798d644f93 Pull complete                                                                                                                                                                              35.9s
   ✔ 61256e5d038d Pull complete                                                                                                                                                                              35.9s
   ✔ 4f27eecc6d58 Pull complete                                                                                                                                                                              37.2s
[+] Running 4/4
 ✔ Network kafka_default        Created                                                                                                                                                                       0.2s
 ✔ Container kafka-zookeeper-1  Started                                                                                                                                                                       2.2s
 ✔ Container kafka-kafka-1      Started                                                                                                                                                                       2.1s
 ✔ Container kafka-kafka-ui-1   Started                                                                                                                                                                       3.0s

C:\Workspaces\angel\docker\dockerCompose\Kafka>
C:\Workspaces\angel\docker\dockerCompose\Kafka>
C:\Workspaces\angel\docker\dockerCompose\Kafka>


## Contenedores de KAFKA
C:\Users\angel>docker ps
CONTAINER ID   IMAGE                               COMMAND                  CREATED          STATUS                PORTS                                         NAMES
c7bf9bf26d92   provectuslabs/kafka-ui:latest       "/bin/sh -c 'java --…"   13 minutes ago   Up 13 minutes         0.0.0.0:8085->8080/tcp, [::]:8085->8080/tcp   kafka-kafka-ui-1

f83ce8b47233   confluentinc/cp-kafka:7.6.1         "/etc/confluent/dock…"   13 minutes ago   Up 13 minutes         0.0.0.0:9092->9092/tcp, [::]:9092->9092/tcp   kafka-kafka-1

e1f8392c447d   confluentinc/cp-zookeeper:7.6.1     "/etc/confluent/dock…"   13 minutes ago   Up 13 minutes         0.0.0.0:2181->2181/tcp, [::]:2181->2181/tcp   kafka-zookeeper-1

660d9994b2d0   angel85/oracle-database:18.4.0-xe   "/bin/sh -c 'exec $O…"   5 weeks ago      Up 3 days (healthy)   0.0.0.0:1521->1521/tcp, [::]:1521->1521/tcp   ora18xe


## Validar Consola WEB Kafka
http://localhost:8085/



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------



# Limpiar Metadatos del Docker-Compose (Recrea limpio (para que no quede metadata viejo))
## docker ps (Contenedores en UP)
## docker stop [Nombre Contenedor] (Detener Contenedor)
## docker rm [Nombre Contenedor] (Borrar Contenedor)
## docker compose down -v



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------



# Levantar Kafka (v2)
## docker compose up -d
## Comprueba lo que anuncia el broker:
## docker logs kafka | grep -Ei 'advertised.listeners|Registered broker|listeners'
## #Debe aparecer ...EXTERNAL://localhost:29092 e INTERNAL://kafka:9092


# En tu app fuera de Docker
## Usa SIEMPRE el externo:
## spring.kafka.bootstrap-servers=localhost:29092
## # opcional:
## spring.kafka.properties.client.dns.lookup=use_all_dns_ips


## Si tu app corre en otra máquina de la red, cambia en el compose
## EXTERNAL://localhost:29092 → EXTERNAL://<TU_IP_LAN>:29092
## y en la app usa <TU_IP_LAN>:29092.


# Validar Consola WEB Kafka
## http://localhost:8080/



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------



# Archivo hosts (Plan B (rápido pero no ideal) - Plan de contingencia (temporal, para avanzar))
## Agregar en tu host:
## Windows: C:\Windows\System32\drivers\etc\hosts
## Linux/macOS: /etc/hosts
## 127.0.0.1 kafka
## (Así dejaría de fallar, pero lo correcto es el ajuste de advertised.listeners).



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------



## B) Loguea el valor efectivo en tiempo de ejecución (infalible)

Añade algo así para ver qué usa de verdad el Producer/Consumer:

@Bean
ApplicationRunner showKafkaEffective(Environment env,
                                     KafkaTemplate<?,?> template,
                                     ObjectProvider<ConsumerFactory<?,?>> cf) {
  return args -> {
    System.out.println("spring.kafka.bootstrap-servers=" +
        env.getProperty("spring.kafka.bootstrap-servers"));
    System.out.println("Producer bootstrap.servers=" +
        template.getProducerFactory().getConfigurationProperties().get("bootstrap.servers"));
    ConsumerFactory<?,?> consumerFactory = cf.getIfAvailable();
    if (consumerFactory != null) {
      System.out.println("Consumer bootstrap.servers=" +
          consumerFactory.getConfigurationProperties().get("bootstrap.servers"));
    }
  };
}

Si aquí ves kafka:9092, ya sabes quién lo está seteando.



## -------------------------------------------------------------------------------------------
## -------------------------------------------------------------------------------------------