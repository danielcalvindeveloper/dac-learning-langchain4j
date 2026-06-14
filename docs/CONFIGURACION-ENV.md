# Configuración común del curso

## Variables de entorno y archivo .env

Todos los laboratorios utilizarán un archivo `.env` para almacenar credenciales y parámetros sensibles.

---

## Dependencia utilizada

```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
</dependency>
```

---

## Ubicación del archivo

Cada laboratorio posee su propio archivo:

```text
lab-01-hello-llm/.env
lab-02-chat-memory/.env
...
```

Ejemplo:

```properties
OPENAI_API_KEY=sk-xxxxxxxxxxxxxxxx
```

---

## Lectura desde Java

```java
Dotenv dotenv = Dotenv.load();

String apiKey = dotenv.get("OPENAI_API_KEY");
```

---

## Buenas prácticas

### Nunca

```java
String apiKey = "sk-xxxxxxxx";
```

### Nunca

Subir el archivo `.env` al repositorio Git.

Agregar al `.gitignore`:

```gitignore
.env
**/.env
```

---

## Variables previstas para el curso

```properties
OPENAI_API_KEY=...
ANTHROPIC_API_KEY=...
GEMINI_API_KEY=...
MISTRAL_API_KEY=...
```

---

## Objetivo

Mantener separadas:

- Configuración.
- Código.
- Credenciales.

Esta práctica será utilizada en todos los laboratorios del curso.
