# 🏠 Aplicación de Administración de Propiedades

## 📄 Resumen del Proyecto
Este proyecto es un sistema para la **administración de propiedades inmobiliarias**, que permite realizar operaciones **CRUD** (crear, leer, actualizar y eliminar) sobre propiedades, incluyendo información como dirección, precio, tamaño y descripción.  

- **Backend:** Spring Boot  
- **Base de datos:** Aurora RDS MySQL  
- **Despliegue:** EC2 Ubuntu  

---

## 🏗 Arquitectura del Sistema
La arquitectura sigue el patrón **MVC**:

| Componente | Tecnologías | Función |
|------------|------------|--------|
| Frontend | HTML, CSS, JS | Interfaz con el usuario |
| Backend | Spring Boot, Java | API REST para gestionar propiedades |
| Base de datos | Aurora RDS MySQL | Almacena los datos de propiedades |

**Flujo de interacción:**


1. **El usuario** interactúa con la interfaz del **Frontend** (ejemplo: completa un formulario para registrar una nueva propiedad).  
2. El **Frontend** envía la solicitud HTTP al **Backend** a través de los endpoints REST.  
3. El **Controller** del backend recibe la petición y la envía al **Service**, que contiene la lógica de negocio.  
4. El **Service** se apoya en el **Repository**, que traduce la operación a consultas SQL sobre la base de datos **Aurora RDS MySQL**.  
5. La base de datos devuelve el resultado (por ejemplo, la confirmación de que la propiedad fue creada o la lista de propiedades almacenadas).  
6. El **Backend** construye la respuesta y la envía de vuelta al **Frontend** en formato JSON.  
7. Finalmente, el **Frontend** muestra la información procesada al usuario en la interfaz gráfica.  

De esta forma, cada capa tiene una responsabilidad clara, y el sistema mantiene un flujo de datos ordenado y eficiente.  



---

## 📦 Diseño de Clases

### Clases principales

| Clase | Ruta | Descripción |
|-------|------|------------|
| Property | model/Property.java | Representa una propiedad con `id`, `address`, `price`, `size`, `description` |
| PropertyRepository | repository/PropertyRepository.java | Interfaz que extiende `JpaRepository` para persistencia |
| PropertyService | service/PropertyService.java | Lógica de negocio: crear, listar, actualizar y eliminar propiedades |
| PropertyController | controller/PropertyController.java | Endpoints REST para CRUD de propiedades |

**Endpoints principales:**

| Método | Endpoint | Acción |
|--------|---------|-------|
| POST | /api/properties | Crear propiedad |
| GET | /api/properties | Listar todas las propiedades |
| GET | /api/properties/{id} | Obtener propiedad por ID |
| PUT | /api/properties/{id} | Actualizar propiedad |
| DELETE | /api/properties/{id} | Eliminar propiedad |

### Diagrama de clases


### Diagrama de infraestructura


---

## ⚙️ Instrucciones de Implementación

### Requisitos
- Java 17 o superior  
- Maven  
- Conexión a la base de datos Aurora RDS MySQL  
- Instancia EC2 Ubuntu  

### Ejecución de forma local

1. Clonar el repositorio:

```
git clone https://github.com/CamiloQuinteroR/Taller5-AREP.git
```

2. Modificar `application.properties` con las credenciales correctas para la conexión a la base de datos:

```properties
spring.datasource.url=jdbc:mysql://properties.ctwamawq28qp.us-east-1.rds.amazonaws.com:3306/properties?useSSL=true&serverTimezone=UTC
spring.datasource.username=<nombre_de_usuario>
spring.datasource.password=<clave>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

3. Compilar el proyecto:

```
mvn clean package
```

4. Ejecutar el proyecto:

```
mvn spring-boot:run
```

5. Ingresar a la aplicación en el buscador:

```
http://localhost:8080
```

### Ejecución en instancia EC2 

1. Nos conectamos a la instancia EC2 por medio de SSH:
   
```
ssh -i "ubuntu.pem" ubuntu@ec2-34-227-10-232.compute-1.amazonaws.com
```

2. Nos conectamos a la base de datos:
   
```
mysql -h properties.ctwamawq28qp.us-east-1.rds.amazonaws.com -P 3306 -u admin -p
```
3. Copia el archivo .jar a tu EC2 con scp:

```
scp -i clave.pem target/app.jar ubuntu@<IP-EC2>:/home/ubuntu/
```

4. Ejecutamos el .jar de nuestro proyecto:

```
java -jar app.jar
```

5. Ingresamos a la aplicación en el buscador teniendo en cuenta el puerto de la aplicación y la IP publica de la instancia EC2:

```
http://<IP_EC2>:8080
```

## 🖼 Capturas de Pantalla


### Instancia EC2 ubuntu desplegada y corriendo

<img width="1111" height="137" alt="image" src="https://github.com/user-attachments/assets/190a9a4c-b9dc-4f70-a61a-1499f803062d" />


### Base de datos Aurora and RDS desplegada:

<img width="1089" height="159" alt="image" src="https://github.com/user-attachments/assets/b3915d31-6cc7-4823-bfc2-160f65a7626a" />


Ingresando a 

```
http://34.228.160.96:8080
```


<img width="859" height="321" alt="image" src="https://github.com/user-attachments/assets/edd53865-977a-42df-9c9f-3dcc609e04f0" />

### Crear propiedad

<img width="872" height="128" alt="image" src="https://github.com/user-attachments/assets/cab307b2-3c5b-4890-ad8b-315f14cc1967" />

Vemos que la propiedad se añade a la lista de propiedades:

<img width="519" height="150" alt="image" src="https://github.com/user-attachments/assets/f24a2b64-c499-4f79-b665-9a9e5200f296" />


Confirmando con postman usando el método GET y la sigiente url para verificar la creación de la propiedad: 

```
http://34.228.160.96:8080/api/properties
```

<img width="931" height="511" alt="image" src="https://github.com/user-attachments/assets/545f7d19-1afe-4b83-824f-11ba63d2212a" />


Tambien podesmo crear una propiedad desde Postaman con el método POST:


<img width="925" height="523" alt="image" src="https://github.com/user-attachments/assets/d5ebe438-ead6-4d38-b9f9-34fef7b4e5c2" />


Vemos que se registra en la lista de propiedades:

<img width="857" height="299" alt="image" src="https://github.com/user-attachments/assets/06a03047-5844-4932-8ee5-fb0b937de586" />


### Lista de propiedades
	
En Postman con el método GET y la URL podemos listar las propiedades de nuestra base de datos:

<img width="937" height="524" alt="image" src="https://github.com/user-attachments/assets/d0b1f45d-c92c-485b-ba79-3b42da40c615" />

Esta mimas lista es la que se muestra en nuestra página:

<img width="832" height="293" alt="image" src="https://github.com/user-attachments/assets/defe1c94-d3c5-45d6-9bbe-55340c15b582" />


Además podemos obtener la propiedad con un ID específico como se muestra a continuación:

<img width="512" height="304" alt="image" src="https://github.com/user-attachments/assets/a683e086-735f-4d43-9a49-65e883963fc3" />


### Actualizar propiedad	

Actualizando una propiedad desde la página de la aplicación, la propiedad que editaremos será la que tiene como dirección Carrera 2 #45-67:

<img width="507" height="28" alt="image" src="https://github.com/user-attachments/assets/1506e8ba-a2da-482d-8054-d96ff84f853b" />

Editaremos su precio y descripción:

<img width="452" height="194" alt="image" src="https://github.com/user-attachments/assets/e35370b2-8680-475e-b53c-732a86836cdc" />

<img width="464" height="200" alt="image" src="https://github.com/user-attachments/assets/b7457792-0450-4b1a-ae7e-325a7a81cf44" />

Veremos que la propiedad ahora estará actualizada con los nuevos datos:

<img width="835" height="290" alt="image" src="https://github.com/user-attachments/assets/b8cde3f3-a32a-4e07-b67a-ec0832a5799e" />

Confirmamos en Postman:

<img width="921" height="505" alt="image" src="https://github.com/user-attachments/assets/d6855747-85e0-4109-ab3c-aa4046b2397e" />

Ahora, desde Postman, podemos actuaizar los datos de una propiedad con le método PUT, como podemos ver a continuación:

<img width="537" height="477" alt="image" src="https://github.com/user-attachments/assets/fa7ce836-9dd8-4788-8931-9a88fa2c8430" />

En este editamos la misma propiedad, verificamos en nuestra pagina web:

<img width="819" height="294" alt="image" src="https://github.com/user-attachments/assets/ddca39a3-d7a4-4936-8e30-962ffc70f5de" />

### Eliminar propiedad

Eliminando una propiedad desde la pagina web:

<img width="839" height="289" alt="image" src="https://github.com/user-attachments/assets/6a00369f-6669-4d42-96eb-a1d113487c09" />

Veremos que ya no aparece en la lista de propiedades:

<img width="834" height="271" alt="image" src="https://github.com/user-attachments/assets/58452cf0-5a4b-4ff8-895c-0eaeae6e639b" />

Listamos las propiedades en Postaman y veremos que ya no está la propiedad eliminada:

<img width="929" height="525" alt="image" src="https://github.com/user-attachments/assets/546869fc-5cfd-49da-9bb0-16575dc2fc2e" />


Tambien podemos eliminar una porpiedad desde Postman con el método DELETE y un ID específico, en este caso el ID sera "6";

<img width="924" height="507" alt="image" src="https://github.com/user-attachments/assets/d9d359e2-7953-4cac-8c2d-cadc7815179b" />

<img width="933" height="194" alt="image" src="https://github.com/user-attachments/assets/cbdaad23-1466-419a-a943-a0b627c2c531" />


Verificamos nuevamente y veremos que ya no está la propiedad:

<img width="959" height="517" alt="image" src="https://github.com/user-attachments/assets/8f08ef30-6e27-4a49-9b86-1d9842d429b3" />

En nuestra lista de la pagina web tampoco estará:

<img width="855" height="281" alt="image" src="https://github.com/user-attachments/assets/de145ea8-d11f-4bfb-9da8-ad0fad16d071" />



## 🛠 Tecnologías utilizadas

| **Categoría**   | **Tecnologías**                  |
|------------------|----------------------------------|
| Backend          | Spring Boot, Java, Spring Data JPA |
| Frontend         | HTML, CSS, JavaScript            |
| Base de datos    | Aurora RDS MySQL                 |
| Despliegue       | EC2 Ubuntu                       |



### Vídeo de implementación








