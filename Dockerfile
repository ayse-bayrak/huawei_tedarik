#Base image olarak Java 17 kullanıyoruz
FROM openjdk:17-jdk-slim

#Çalışma dizinini oluştur
WORKDIR /app

#Jar dosyasını container'a kopyala
COPY target/huawei_tedarik-0.0.1-SNAPSHOT.jar huawei_tedarik-0.0.1-SNAPSHOT.jar

#Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]