# SETUP.md

## Objetivo

Configurar el entorno necesario para ejecutar todos los laboratorios del curso DAC Learning LangChain.

---

## Requisitos

### Java

Versión recomendada:

```text
Java 21
```

Verificación:

```cmd
java -version
```

---

### Maven

Versión recomendada:

```text
Maven 3.9 o superior
```

Verificación:

```cmd
mvn -version
```

---

### Eclipse

Versión recomendada:

```text
Eclipse IDE for Enterprise Java and Web Developers
2024-09 o superior
```

---

### Git

Verificación:

```cmd
git --version
```

---

## API Key OpenAI

Crear una cuenta en OpenAI y generar una API Key.

La clave será utilizada por todos los laboratorios.

---

## Archivo .env

Crear un archivo:

```text
.env
```

en la raíz de cada laboratorio.

Contenido:

```properties
OPENAI_API_KEY=sk-xxxxxxxxxxxxxxxxxxxxxxxx
```

---

## Dependencia DotEnv

Todos los laboratorios utilizarán:

```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.2.0</version>
</dependency>
```

---

## Clase Environment

Los laboratorios utilizan una clase auxiliar para acceder a variables del archivo .env.

Ejemplo:

```java
String apiKey =
        Environment.get("OPENAI_API_KEY");
```

---

## Importar el proyecto

Desde Eclipse:

File -> Import -> Existing Maven Projects

Seleccionar la carpeta raíz:

```text
dac-learning-langchain
```

---

## Estructura del Workspace

```text
dac-learning-langchain
│
├── README.md
├── SETUP.md
├── dac-learning-langchain.md
│
├── lab-01-hello-llm
├── lab-02-chat-memory
├── lab-03-ai-services
├── lab-04-prompt-templates
├── lab-05-structured-output
├── ...
└── lab-17-final-project
```

---

## Verificación

Ejecutar:

```text
lab-01-hello-llm
```

Resultado esperado:

- API Key encontrada.
- Respuesta generada por el modelo.

---

## Problemas frecuentes

### API Key no encontrada

Verificar:

```text
.env
``

### Dependencias Maven

Actualizar:

```cmd
mvn clean install
```

o

```text
Maven -> Update Project
```

---

## Próximo paso

Completar:

```text
Lab 01 - Hello LLM
```
