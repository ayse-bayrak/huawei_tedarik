FROM maven:3.8.5-openjdk-17 as builder

WORKDIR usr/app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

#Base image olarak Java 17 kullanıyoruz
FROM openjdk:17-jdk-slim

#Jar dosyasını container'a kopyala
COPY --from=builder usr/app/target/huawei_tedarik-0.0.1-SNAPSHOT.jar /huawei_tedarik-0.0.1-SNAPSHOT.jar

#Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "huawei_tedarik-0.0.1-SNAPSHOT.jar"]