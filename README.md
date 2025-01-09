# Proje Adı: Huawei Tedarik Sistemi Yönetimi

## Proje Tanımı
Bu proje, bir tedarik sisteminde aylık bazda üretim hedeflerini planlamak ve yönetmek için geliştirilmiştir. API'ler, projelerin, modellerin ve parçaların esnek bir şekilde yönetilmesini sağlar.

## Teknolojiler
- Java 17
- Spring Boot 3.3.x
- PostgreSQL
- Docker
- Swagger (OpenAPI 3.0)

## Kurulum
1. Maven bağımlılıklarını yüklemek için `mvn clean install` çalıştırın.
2. Uygulamayı başlatmak için `mvn spring-boot:run` komutunu kullanın.

## Kullanım
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Geliştirici Notları
- Soft delete için `isDeleted` özelliği kullanılmaktadır.
- Loglama mekanizması AOP kullanilarak yapilmistir, tüm CRUD işlemlerini kaydetmektedir, loglar `logs` tablosunda tutulmaktadir. Ayrica sorgulanabilmektedir.
- Uygulama dockerize edilmistir. 
- Veritabanı bağlantı ayarlarını application.properties dosyasından yapabilirsiniz.
- API versiyonlama, /v1 ile yapılmaktadır.
- Uygulama, tüm API'ler için Swagger entegrasyonu sağlamaktadır.