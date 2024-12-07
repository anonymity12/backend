## how to test these api endpoint

mvn package -DskipTests;
java -jar /home/tt/code/CodeForFamily/backend/target/family-0.0.1-SNAPSHOT.jar --server.port=9001 

one line:➜ 
mvn package -DskipTests; java -jar /home/tt/code/CodeForFamily/backend/target/family-0.0.1-SNAPSHOT.jar --server.port=9001 


---

then:

goto:

https://hoppscotch.io/

add this in HeaderList

key:val

like below:

token:68e84490