# Lab 05 - Structured Output

## Objetivo

Aprender a convertir respuestas generadas por un LLM en objetos Java utilizando las capacidades de Structured Output de LangChain4j.

---

## Problema

Hasta este momento todos los laboratorios devolvieron:

String

Esto funciona correctamente para:

- Chat
- Traducciones
- Resúmenes

Pero en aplicaciones reales normalmente necesitamos trabajar con objetos Java.

---

## Motivación

Supongamos el siguiente texto:

Mi nombre es Daniel y tengo 63 años.

Nuestro objetivo es obtener:

Persona

con:

- nombre = Daniel
- edad = 63

Sin parsear manualmente JSON.
Sin expresiones regulares.
Sin lógica adicional.

---

## Structured Output

LangChain4j permite que el modelo genere información estructurada y la convierta automáticamente en POJOs.

Ejemplo conceptual:

Persona persona =
        assistant.extraerPersona(texto);

---

## Ejemplo 1 - Persona

Clase:

Persona

Campos:

- nombre
- edad

Invocación:

assistant.extraerPersona(
        "Mi nombre es Daniel y tengo 63 años.");

Resultado:

nombre = Daniel
edad = 63

---

## Ejemplo 2 - Producto

Clase:

Producto

Campos:

- nombre
- categoria

Invocación:

assistant.extraerProducto(
        "Notebook Lenovo ThinkPad categoría informática");

---

## Ejemplo 3 - Colección de Personas

Objetivo:

Obtener múltiples objetos Persona a partir de un único texto.

---

## Limitación Encontrada

Durante el desarrollo del laboratorio se observó que:

List<Persona>

como tipo raíz produjo una excepción en tiempo de ejecución.

La prueba fue realizada utilizando:

LangChain4j 1.16.1

La alternativa utilizada fue un objeto contenedor.

---

## Solución Adoptada

Clase:

Personas

que contiene:

List<Persona>

Ejemplo conceptual:

Personas personas =
        assistant.extraerPersonas(texto);

---

## Arquitectura Conceptual

Texto
 ↓
Prompt
 ↓
LLM
 ↓
JSON
 ↓
POJO
 ↓
Objeto Java

---

## Beneficios

- Menos código de parsing.
- Menor acoplamiento.
- Tipado fuerte.
- Integración natural con Java.

---

## Qué aprendimos

- Qué es Structured Output.
- Cómo convertir respuestas en POJOs.
- Cómo trabajar con objetos complejos.
- Cómo trabajar con colecciones.
- Limitaciones encontradas durante la implementación.

---

## Relación con el siguiente laboratorio

¿Cómo representamos significado mediante vectores para búsquedas semánticas?

Esa pregunta será respondida en:

Lab 06 - Embeddings.
