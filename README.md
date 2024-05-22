### Examen Final de Programación - Acceso a Ficheros y Manejo de Bases de Datos con Java

#### **Pregunta 1:**
**Aplicación en Java que realiza una consulta en la base de datos MariaDB y guarda el resultado en un fichero con formato JSON**

1. **Configuración Inicial:**
    - Crear una base de datos en MariaDB llamada `empresa`.
    - Crear una tabla llamada `empleados` con las siguientes columnas:
        ```sql
        CREATE TABLE empleados (
            id INT PRIMARY KEY AUTO_INCREMENT,
            nombre VARCHAR(50),
            departamento VARCHAR(50),
            salario DECIMAL(10, 2),
            fecha_contratacion DATE
        );
        ```
    - Insertar algunos registros de prueba en la tabla `empleados`:
        ```sql
        INSERT INTO empleados (nombre, departamento, salario, fecha_contratacion) VALUES
        ('Ana', 'Ventas', 30000.00, '2023-01-10'),
        ('Luis', 'Marketing', 45000.00, '2023-03-15'),
        ('Marta', 'IT', 50000.00, '2023-05-01');
        ```

2. **Requerimientos del Código Java:**
    - Conectar a la base de datos MariaDB.
    - Realizar una consulta que seleccione todos los registros de la tabla `empleados`.
    - Guardar los resultados de la consulta en un fichero JSON con el formato adecuado.

#### **Pregunta 2:**
**Aplicación en Java que realiza una consulta en la base de datos MariaDB y guarda el resultado en un fichero con formato XML**

1. **Configuración Inicial:**
    - Crear una base de datos en MariaDB llamada `escuela`.
    - Crear una tabla llamada `estudiantes` con las siguientes columnas:
        ```sql
        CREATE TABLE estudiantes (
            id INT PRIMARY KEY AUTO_INCREMENT,
            nombre VARCHAR(50),
            apellido VARCHAR(50),
            curso VARCHAR(50),
            fecha_inscripcion DATE
        );
        ```
    - Insertar algunos registros de prueba en la tabla `estudiantes`:
        ```sql
        INSERT INTO estudiantes (nombre, apellido, curso, fecha_inscripcion) VALUES
        ('Carlos', 'Martínez', 'Matemáticas', '2022-09-01'),
        ('Lucía', 'Fernández', 'Ciencias', '2022-09-01'),
        ('Pedro', 'García', 'Historia', '2022-09-01');
        ```

2. **Requerimientos del Código Java:**
    - Conectar a la base de datos MariaDB.
    - Realizar una consulta que seleccione todos los registros de la tabla `estudiantes`.
    - Guardar los resultados de la consulta en un fichero XML con el formato adecuado.

#### **Pregunta 3:**
**Aplicación en Java que realiza una consulta en la base de datos MariaDB y guarda el resultado en un fichero de texto con formato personalizado**

1. **Configuración Inicial:**
    - Crear una base de datos en MariaDB llamada `biblioteca`.
    - Crear una tabla llamada `libros` con las siguientes columnas:
        ```sql
        CREATE TABLE libros (
            id INT PRIMARY KEY AUTO_INCREMENT,
            titulo VARCHAR(100),
            autor VARCHAR(50),
            genero VARCHAR(50),
            fecha_publicacion DATE
        );
        ```
    - Insertar algunos registros de prueba en la tabla `libros`:
        ```sql
        INSERT INTO libros (titulo, autor, genero, fecha_publicacion) VALUES
        ('El Quijote', 'Miguel de Cervantes', 'Ficción', '1605-01-16'),
        ('Cien Años de Soledad', 'Gabriel García Márquez', 'Realismo Mágico', '1967-05-30'),
        ('Don Juan Tenorio', 'José Zorrilla', 'Drama', '1844-03-28');
        ```

2. **Requerimientos del Código Java:**
    - Conectar a la base de datos MariaDB.
    - Realizar una consulta que seleccione todos los registros de la tabla `libros`.
    - Guardar los resultados de la consulta en un fichero de texto con el siguiente formato personalizado:
        ```
        ID: {id}
        Título: {titulo}
        Autor: {autor}
        Género: {genero}
        Fecha de Publicación: {fecha_publicacion}
        ```

#### **Pregunta 4:**
**Aplicación en Java que realiza una consulta en la base de datos MariaDB y guarda el resultado en un fichero con formato YAML**

1. **Configuración Inicial:**
    - Crear una base de datos en MariaDB llamada `tienda`.
    - Crear una tabla llamada `productos` con las siguientes columnas:
        ```sql
        CREATE TABLE productos (
            id INT PRIMARY KEY AUTO_INCREMENT,
            nombre VARCHAR(50),
            categoria VARCHAR(50),
            precio DECIMAL(10, 2),
            fecha_creacion DATE
        );
        ```
    - Insertar algunos registros de prueba en la tabla `productos`:
        ```sql
        INSERT INTO productos (nombre, categoria, precio, fecha_creacion) VALUES
        ('Laptop', 'Electrónica', 1200.00, '2023-01-05'),
        ('Cafetera', 'Hogar', 80.00, '2023-02-10'),
        ('Bicicleta', 'Deportes', 300.00, '2023-03-15');
        ```

2. **Requerimientos del Código Java:**
    - Conectar a la base de datos MariaDB.
    - Realizar una consulta que seleccione todos los registros de la tabla `productos`.
    - Guardar los resultados de la consulta en un fichero YAML con el formato adecuado.

#### **Pregunta 5:**
**Aplicación en Java que realiza una consulta en la base de datos MariaDB y guarda el resultado en un fichero con formato HTML**

1. **Configuración Inicial:**
    - Crear una base de datos en MariaDB llamada `evento`.
    - Crear una tabla llamada `participantes` con las siguientes columnas:
        ```sql
        CREATE TABLE participantes (
            id INT PRIMARY KEY AUTO_INCREMENT,
            nombre VARCHAR(50),
            apellido VARCHAR(50),
            email VARCHAR(100),
            fecha_registro DATE
        );
        ```
    - Insertar algunos registros de prueba en la tabla `participantes`:
        ```sql
        INSERT INTO participantes (nombre, apellido, email, fecha_registro) VALUES
        ('Sofía', 'Rodríguez', 'sofia.rodriguez@example.com', '2023-01-20'),
        ('Andrés', 'Pérez', 'andres.perez@example.com', '2023-02-25'),
        ('Natalie', 'Gómez', 'natalie.gomez@example.com', '2023-03-30');
        ```

2. **Requerimientos del Código Java:**
    - Conectar a la base de datos MariaDB.
    - Realizar una consulta que seleccione todos los registros de la tabla `participantes`.
    - Guardar los resultados de la consulta en un fichero HTML con el siguiente formato:
        ```html
        <html>
        <head>
            <title>Lista de Participantes</title>
        </head>
        <body>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Fecha de Registro</th>
                </tr>
                <!-- Rellenar con los datos de la consulta -->
            </table>
        </body>
        </html>
        ```
