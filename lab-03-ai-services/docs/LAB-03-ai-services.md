# Lab 03 - AI Services

## Objetivo

Comprender cómo LangChain4j transforma interfaces Java en asistentes de IA y cómo los métodos pueden representar prompts mediante anotaciones.

---

## Punto de partida

En los laboratorios anteriores utilizamos:

```java
model.chat(...)
```

La aplicación enviaba prompts directamente al modelo.

---

## Problema

A medida que aparecen más funcionalidades:

```java
model.chat("Traduce al inglés: " + texto);

model.chat("Resume: " + texto);

model.chat("Clasifica: " + comentario);
```

los prompts comienzan a dispersarse por el código.

---

## AI Services

LangChain4j permite definir una interfaz:

```java
public interface Assistant {

    String chat(String message);

    String traducir(String texto);

    String resumir(String texto);

}
```

y generar automáticamente una implementación:

```java
Assistant assistant =
        AiServices.create(
                Assistant.class,
                model
        );
```

No existe una clase `AssistantImpl` escrita por el desarrollador.

---

## Método sin prompt

```java
String chat(String message);
```

El mensaje recibido es enviado directamente al modelo.

```java
assistant.chat(
    "¿Qué es LangChain4j?"
);
```

---

## Método con prompt

```java
@UserMessage("Traduce al inglés: {{it}}")
String traducir(String texto);
```

Ahora el método tiene asociado un prompt.

```java
assistant.traducir(
    "Las anotaciones describen el prompt."
);
```

Internamente LangChain4j genera:

```text
Traduce al inglés:
Las anotaciones describen el prompt.
```

---

## Otro ejemplo

```java
@UserMessage("Resume en una frase: {{it}}")
String resumir(String texto);
```

Invocación:

```java
assistant.resumir(texto);
```

El desarrollador trabaja con métodos Java mientras LangChain4j construye el prompt real.

---

## Evolución

```text
Lab 01
Prompt directo
    |
    v
model.chat(...)

Lab 02
Memoria conversacional
    |
    v
Assistant + ChatMemory

Lab 03
Métodos Java representan prompts
    |
    v
AiServices + @UserMessage
```

---

## Conceptos aprendidos

- AI Services genera implementaciones dinámicas.
- Una interfaz puede representar un asistente de IA.
- Un método Java puede representar un prompt.
- `@UserMessage` permite asociar prompts a métodos.
- El código se vuelve más expresivo y mantenible.

---

## Conclusión

AI Services permite trabajar con operaciones de negocio:

```java
assistant.traducir(...);

assistant.resumir(...);
```

en lugar de construir manualmente prompts mediante concatenación de texto.

---

## Próximo laboratorio

Lab 04 - Prompt Templates Avanzados

Objetivo:

Construir prompts parametrizados utilizando múltiples variables y plantillas más complejas.
