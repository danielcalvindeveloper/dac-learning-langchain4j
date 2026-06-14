# Lab 02 - Chat Memory

## Objetivo

Comprender que los modelos de lenguaje son esencialmente stateless y aprender cómo incorporar memoria conversacional utilizando LangChain4j.

---

## Problema

Consideremos la siguiente secuencia:

1. Mi nombre es Daniel.
2. ¿Cómo me llamo?

Para una persona, la segunda pregunta es trivial.

Sin embargo, un LLM no recuerda automáticamente conversaciones anteriores.

---

## Concepto Fundamental

Los modelos de lenguaje no poseen memoria permanente entre invocaciones.

Cada llamada es independiente.

Conceptualmente:

Llamada 1
Usuario: Mi nombre es Daniel

Llamada 2
Usuario: ¿Cómo me llamo?

La segunda llamada no conoce la primera.

---

## Experimento

Sin memoria:

model.chat("Mi nombre es Daniel");

model.chat("¿Cómo me llamo?");

Resultado esperado:

El modelo no puede responder correctamente.

---

## Solución

LangChain4j incorpora memoria conversacional mediante ChatMemory.

Ejemplo conceptual:

MessageWindowChatMemory.withMaxMessages(20);

La memoria conserva el historial reciente y lo reenvía al modelo.

---

## AI Services

Para utilizar memoria aparece una nueva abstracción:

AiServices

Ejemplo conceptual:

Assistant assistant =
    AiServices.builder(Assistant.class)
        .chatModel(model)
        .chatMemory(...)
        .build();

---

## Arquitectura

Usuario
    ↓
Assistant
    ↓
ChatMemory
    ↓
LLM

---

## Beneficios

- Conversaciones coherentes.
- Contexto compartido.
- Mejor experiencia de usuario.
- Base para asistentes reales.

---

## Qué aprendimos

- Los LLM son stateless.
- La memoria no vive dentro del modelo.
- ChatMemory conserva historial.
- AiServices permite incorporar memoria fácilmente.

---

## Relación con el siguiente laboratorio

Ahora surge una nueva pregunta:

¿Cómo podemos transformar prompts en métodos Java?

Esa pregunta será respondida en:

Lab 03 - AI Services.
