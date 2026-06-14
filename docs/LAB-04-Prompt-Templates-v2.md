# Lab 04 - Prompt Templates

## Objetivo

Aprender a construir prompts dinámicos utilizando variables y plantillas mediante las anotaciones proporcionadas por LangChain4j.

---

## Problema

En el laboratorio anterior vimos cómo encapsular prompts dentro de métodos Java.

Ejemplo:

@UserMessage("Traduce al inglés: {{it}}")
String traducir(String texto);

Este enfoque funciona correctamente cuando existe un único parámetro.

Pero ¿qué ocurre cuando necesitamos más información?

Por ejemplo:

- Idioma destino.
- Cantidad de líneas.
- Rol del asistente.
- Nivel de detalle.

---

## Construcción Manual

Sin Prompt Templates podríamos terminar escribiendo:

model.chat(
    "Traduce al idioma "
    + idioma
    + ": "
    + texto
);

Este enfoque genera:

- Código repetitivo.
- Prompts difíciles de mantener.
- Mezcla entre lógica de negocio y construcción de mensajes.

---

## Prompt Templates

LangChain4j permite definir plantillas reutilizables.

Ejemplo conceptual:

@UserMessage(
    "Traduce al idioma {{idioma}}: {{texto}}"
)

Las variables son reemplazadas automáticamente.

---

## Anotación @V

Para asociar parámetros Java con variables del template utilizamos:

@V("idioma")

Ejemplo:

String traducir(
        @V("idioma") String idioma,
        @V("texto") String texto);

---

## Ejemplo 1 - Traducción

Invocación:

assistant.traducir(
        "ingles",
        "Hola mundo");

Prompt generado conceptualmente:

Traduce al idioma ingles:

Hola mundo

---

## Ejemplo 2 - Resumen

Definición conceptual:

String resumir(
        @V("lineas") int lineas,
        @V("texto") String texto);

Invocación:

assistant.resumir(
        2,
        texto);

El valor de lineas modifica el prompt generado.

---

## Ejemplo 3 - Cambio de Rol

Definición conceptual:

String consultar(
        @V("rol") String rol,
        @V("pregunta") String pregunta);

Invocaciones:

assistant.consultar(
        "profesor de matematicas",
        "¿Qué es una derivada?");

assistant.consultar(
        "abogado",
        "¿Qué es un contrato?");

El mismo método produce prompts distintos dependiendo del rol recibido.

---

## Beneficios

- Separación entre lógica y prompts.
- Mayor reutilización.
- Mejor mantenibilidad.
- Menor duplicación de código.

---

## Arquitectura Conceptual

Método Java
        ↓
Variables
        ↓
Prompt Template
        ↓
Prompt Final
        ↓
LLM

---

## Qué aprendimos

- Qué es un Prompt Template.
- Cómo utilizar placeholders.
- Cómo asociar parámetros mediante @V.
- Cómo construir prompts dinámicos.
- Cómo reutilizar plantillas.

---

## Relación con el siguiente laboratorio

Hasta ahora todas las respuestas fueron Strings.

¿Cómo obtenemos objetos Java directamente desde el modelo?

Esa pregunta será respondida en:

Lab 05 - Structured Output.
