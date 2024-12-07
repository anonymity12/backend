I code for family

# tech I used

- java
- spring-boot
- mysql
- mybatis
- redis

# how to start this app

## redis start

`redis-server  &`  

## spring start

✖ mvn spring-boot:run -Dspring-boot.run.arguments=--spring-boot.run.ports=9001
✖ mvn spring-boot:run -Drun.ports=9001
✖ mvn spring-boot:run -Dserver.port=9001

mvn package -DskipTests;
java -jar xx.jar --server.port=9001