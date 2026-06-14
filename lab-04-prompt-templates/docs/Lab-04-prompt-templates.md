# Lab 04 - Prompt Templates

## Objetivo

Comprender cómo construir prompts dinámicos utilizando variables y plantillas.

En lugar de crear prompts mediante concatenación de texto, LangChain4j permite definir plantillas reutilizables mediante anotaciones.

---

## Punto de partida

En el laboratorio anterior vimos:

```java
@UserMessage("Traduce al inglés: {{it}}")
String traducir(String texto);
```

El placeholder `{{it}}` representa el único parámetro recibido por el método.

---

## Problema

Cuando aparecen múltiples parámetros, la construcción manual de prompts se vuelve compleja:

```java
model.chat(
    "Traduce al idioma " + idioma
    + ": " + texto
);
```

o

```java
model.chat(
    "Resume en " + lineas
    + " líneas: " + texto
);
```

Los prompts terminan mezclados con la lógica de negocio.

---

## Solución: Prompt Templates

LangChain4j permite definir plantillas mediante variables nombradas.

Ejemplo:

```java
@UserMessage("""
Traduce al idioma {{idioma}}:

{{texto}}
""")
String traducir(
        @V("idioma") String idioma,
        @V("texto") String texto);
```

---

## Variables

La anotación:

```java
@V("idioma")
```

indica qué parámetro Java debe reemplazar la variable:

```text
{{idioma}}
```

dentro del prompt.

---

## Ejemplo 1 - Traducción

Invocación:

```java
assistant.traducir(
        "ingles",
        "Las anotaciones describen el prompt."
);
```

Prompt generado conceptualmente:

```text
Traduce al idioma ingles:

Las anotaciones describen el prompt.
```

---

## Ejemplo 2 - Resumen

Definición:

```java
@UserMessage("""
Resume el siguiente texto en un máximo de {{lineas}} líneas:

{{texto}}
""")
String resumir(
        @V("lineas") int lineas,
        @V("texto") String texto);
```

Invocación:

```java
assistant.resumir(
        2,
        texto);
```

El valor de `lineas` modifica dinámicamente el prompt.

---

## Ejemplo 3 - Cambio de rol

Definición:

```java
@UserMessage("""
Actúa como un {{rol}}.

Pregunta:

{{pregunta}}
""")
String consultar(
        @V("rol") String rol,
        @V("pregunta") String pregunta);
```

Invocaciones:

```java
assistant.consultar(
        "profesor de matematicas",
        "¿Qué es una derivada?");
```

```java
assistant.consultar(
        "abogado",
        "¿Qué es un contrato?");
```

El mismo método genera prompts distintos dependiendo del rol recibido.

---

## Conceptos aprendidos

* Los prompts pueden parametrizarse.
* Las variables se definen mediante `@V`.
* Los placeholders utilizan la sintaxis `{{variable}}`.
* Un mismo método puede generar distintos prompts.
* El código Java permanece limpio y expresivo.

---

## Evolución

```text
Lab 01 -> Prompt directo
Lab 02 -> Memoria conversacional
Lab 03 -> AI Services
Lab 04 -> Prompt Templates
```

---

## Conclusión

Los Prompt Templates permiten separar:

* Lógica de negocio.
* Variables.
* Construcción del prompt.

Esto facilita el mantenimiento y la reutilización de prompts complejos.

---

## Próximo laboratorio

Lab 05 - Structured Output

Objetivo:

Solicitar respuestas estructuradas y convertir automáticamente la salida del modelo en objetos Java.
