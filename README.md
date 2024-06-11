## Requisitos Previos

Asegúrate de tener instalados los siguientes componentes en tu entorno de desarrollo:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/) (para la construcción y gestión del proyecto)

## Instalación y Configuración

Sigue estos pasos para clonar el repositorio, instalar las dependencias y construir el proyecto:

1. Clona el repositorio:
    ```bash
    git clone https://github.com/sntramirez/order-management-system.git
    cd order-management-system
    ```

2. Configura las dependencias en el archivo `pom.xml`:
    ```xml
    <groupId>org.springframework.boot</groupId>
    <version>2.4.2</version>
    <java.version>11</java.version>
    ```

3. Construye el proyecto:
    ```bash
    mvn clean install -U
    ```

## Ejecución de Pruebas

Para ejecutar las pruebas unitarias incluidas en el proyecto, usa el siguiente comando:

```bash
mvn test