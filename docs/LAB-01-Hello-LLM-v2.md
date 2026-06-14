# Lab 01 - Hello LLM

## Objetivo

Realizar la primera invocación a un Large Language Model (LLM) desde una aplicación Java utilizando LangChain4j.

## Problema

¿Cómo envío una consulta a un modelo y obtengo una respuesta desde Java?

Este laboratorio responde exactamente esa pregunta.

## ¿Qué es un LLM?

Un Large Language Model es un modelo entrenado para comprender y generar lenguaje natural.

Capacidades habituales:

- Responder preguntas
- Generar texto
- Traducir idiomas
- Resumir contenido
- Extraer información

## Conceptos principales

### Modelo

Representa la inteligencia artificial con la que interactuamos.

### Prompt

Es la instrucción enviada al modelo.

### Respuesta

Es el resultado generado por el modelo.

### Proveedor

Empresa que expone el modelo:

- OpenAI
- Anthropic
- Google

## Arquitectura mínima

Aplicación Java
    ↓
LangChain4j
    ↓
Proveedor
    ↓
LLM
    ↓
Respuesta

## Solución

Ejemplo conceptual:

model.chat("¿Qué es LangChain4j?");

## Qué sucede internamente

1. LangChain4j construye la solicitud.
2. Se envía una petición HTTP.
3. El modelo procesa el prompt.
4. Se genera una respuesta.
5. LangChain4j devuelve el resultado.

## Limitaciones

En este laboratorio el modelo:

- No recuerda conversaciones.
- No posee contexto previo.
- No utiliza herramientas.
- No consulta documentos.

## Qué aprendimos

- Qué es un LLM.
- Qué es un prompt.
- Cómo invocar un modelo.
- Cómo obtener una respuesta desde Java.

## Próximo laboratorio

Lab 02 - Chat Memory
