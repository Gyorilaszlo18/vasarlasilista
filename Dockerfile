FROM openjdk:17-jdk-alpine3.14

COPY "./target/vasarlasilista.jar" "/application/vasarlasilista.jar"

CMD ["java", "-jar", "/application/vasarlasilista.jar"]
