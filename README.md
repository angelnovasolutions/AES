# Estándar de Cifrado Avanzado (AES)
El propósito de este proyecto, es crear un método para encriptar una cadena de texto con el estándar de cifrado avanzado (AES) a 128 bits.

# Estructura del proyecto
El proyecto consta de las clases principales para generar la cadena cifrada:
- PBKDF2AES: Clase del algoritmo de encriptación AES.
- Rfc2898DeriveBytesAES: Clase del algoritmo para obtener los arreglos de bytes de la "Secret Key"
- TestAES: Clase de prueba para ejecutar el método de encriptación.
# Implementación
Para ejecutar el método de encriptación, sera necesario realizar los siguientes pasos:
- Descargar el proyecto del repositorio GIT.
- Importar el proyecto tipo maven.
- Compilar el proyecto con el comando:
   - mvn package
   Nota: Ejecutar este comando al nivel del Pom.xml de la carpeta raíz del proyecto.
- Ejecutar el algoritmo de encriptación mediante la clase TestAES, asignando la cadena a encriptar a la variable stringOriginal.
