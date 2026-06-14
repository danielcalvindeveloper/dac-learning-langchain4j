# Lab 01 - Hello LLM

## Objetivo

Realizar la primera invocación a un Large Language Model (LLM) utilizando LangChain4j.

Este laboratorio demuestra el flujo mínimo necesario para interactuar con un modelo de lenguaje:

Usuario -> Aplicación Java -> LangChain4j -> OpenAI -> Respuesta

---

## Conceptos de IA introducidos

### LLM (Large Language Model)

Un LLM es un modelo entrenado con grandes cantidades de texto capaz de:

- Responder preguntas.
- Generar contenido.
- Resumir información.
- Clasificar texto.
- Extraer datos estructurados.

En este laboratorio utilizamos GPT-4o-mini.

---

### Prompt

El prompt es el texto enviado al modelo.

Ejemplo:

```text
Explica qué es LangChain4j en una frase
```

Toda interacción con un LLM comienza con un prompt.

---

### Modelo

LangChain4j representa un modelo mediante la clase:

```java
OpenAiChatModel
```

La instancia encapsula la comunicación con OpenAI.

---

### Invocación

La primera llamada real al LLM ocurre mediante:

```java
String response = model.chat(prompt);
```

En ese momento:

1. LangChain4j genera una solicitud HTTP.
2. La solicitud es enviada a OpenAI.
3. El modelo procesa el prompt.
4. Se recibe la respuesta.
5. La respuesta es convertida a String.

---

## Arquitectura del laboratorio

```text
Prompt
   |
   v
LangChain4j
   |
   v
OpenAI API
   |
   v
GPT-4o-mini
   |
   v
Respuesta
```

---

## Qué aprendimos

- Qué es un LLM.
- Qué es un prompt.
- Cómo invocar un modelo desde Java.
- Cómo obtener una respuesta.
- Dónde ocurre realmente el consumo de IA.

---

## Próximo laboratorio

Lab 02 - Chat Memory

Objetivo:

Comprender por qué un modelo no recuerda conversaciones entre llamadas y cómo LangChain4j incorpora memoria conversacional.
