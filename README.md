# User Service

Bu proje, Java Spring Boot ile geliştirilmiş bir API sunucusudur. API, kullanıcı ve rol yönetimi işlemlerini destekler. Aşağıda API'ların nasıl kullanılacağı ve ilgili endpointlerin listesi bulunmaktadır.

## API'lar ve Endpointler

### Kullanıcılar (Users)

- Kullanıcı Oluşturma:
  - Endpoint: POST /users
  - Açıklama: Yeni bir kullanıcı oluşturmak için bu endpointi kullanın.
  - Request Body:
    ```
    {
      "username": "kullanici1",
      "password": "sifre123",
      "roles": [1]
    }
    ```
  - Response: Oluşturulan kullanıcı bilgileriyle birlikte 200 OK yanıtı döner.
 
- Tüm Kullanıcıları Getirme:
  - Endpoint: GET /users
  - Açıklama: Tüm kullanıcıları getirmek için bu endpointi kullanın.
  - Response: Tüm kullanıcıların bilgileriyle birlikte 200 OK yanıtı döner.

- Belirli Bir Kullanıcıyı Getirme:
  - Endpoint: GET /users/{userId}
  - Açıklama: Belirli bir kullanıcıyı getirmek için bu endpointi kullanın.
  - Response: Belirtilen kullanıcının bilgileriyle birlikte 200 OK yanıtı döner.

- Kullanıcı Güncelleme:
  - Endpoint: PUT /users/{userId}
  - Açıklama: Varolan bir kullanıcıyı güncellemek için bu endpointi kullanın.
  - Request Body:
    ```
    {
      "username": "kullanici1",
      "roles": [2]
    }
    ```
  - Response: Güncellenen kullanıcı bilgileriyle birlikte 200 OK yanıtı döner.

- Kullanıcı Silme:
  - Endpoint: DELETE /users/{userId}
  - Açıklama: Bir kullanıcıyı silmek için bu endpointi kullanın.
  - Response: 204 No Content yanıtı döner.

### Roller (Roles)

- Rol Oluşturma:
  - Endpoint: POST /roles
  - Açıklama: Yeni bir rol oluşturmak için bu endpointi kullanın.
  - Request Body:
    ```
    {
      "name": "Admin"
    }
    ```
  - Response: Oluşturulan rol bilgileriyle birlikte 200 OK yanıtı döner.
  - 
- Tüm Rolleri Getirme:
  - Endpoint: GET /roles
  - Açıklama: Tüm rolleri getirmek için bu endpointi kullanın.
  - Response: Tüm rollerin bilgileriyle birlikte 200 OK yanıtı döner.

- Belirli Bir Rolü Getirme:
  - Endpoint: GET /roles/{roleId}
  - Açıklama: Belirli bir rolü getirmek için bu endpointi kullanın.
  - Response: Belirtilen rolün bilgileriyle birlikte 200 OK yanıtı döner.

- Rol Güncelleme:
  - Endpoint: PUT /roles/{roleId}
  - Açıklama: Varolan bir rolü güncellemek için bu endpointi kullanın.
  - Request Body:
    ```
    {
      "name": "Editor"
    }
    ```
  - Response: Güncellenen rol bilgileriyle birlikte 200 OK yanıtı döner.

- Rol Silme:
  - Endpoint: DELETE /roles/{roleId}
  - Açıklama: Bir rolü silmek için bu endpointi kullanın.
  - Response: 204 No Content yanıtı döner.

## Kullanım

1. Projeyi yerel bilgisayarınıza klonlayın.
2. Gerekli bağımlılıkları yüklemek için Maven'i kullanın.
3. Uygulamayı başlatın.
4. İstekleri Postman veya benzeri bir API test aracıyla gönderin.

## Technologies

---
- Java 17
- Spring Boot 3.0
- Spring Data JPA
- H2 In Memory Database
- Restful API
- Maven

---

Bu README dosyası, projenin nasıl kullanılacağı ve API endpointlerinin nasıl çağrılacağı hakkında bilgi vermektedir. İlgili API endpointlerini ve ilgili istekleri nasıl yapacağınızı anlamak için bu belgeyi kullanabilirsiniz. İlgili endpointlerin dökümantasyonunu okuyarak, API'ları doğru şekilde kullanabilir ve geliştirme işlemlerinizi gerçekleştirebilirsiniz.

