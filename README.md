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

Ingresando a 

```
http://<IP_EC2>:8080
```

### Lista de propiedades



### Crear propiedad	



### Actualizar propiedad	



### Eliminar propiedad



🛠 Tecnologías utilizadas
Categoría	Tecnologías
Backend	Spring Boot, Java, Spring Data JPA
Frontend	HTML, CSS, JS
Base de datos	Aurora RDS MySQL
Despliegue	EC2 Ubuntu


### Vídeo de implementación








