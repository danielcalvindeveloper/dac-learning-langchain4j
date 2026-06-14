# Lab 03 - AI Services

## Objetivo

Comprender cómo LangChain4j transforma interfaces Java en asistentes de Inteligencia Artificial mediante AI Services.

---

## Problema

En los laboratorios anteriores utilizamos directamente:

model.chat(...)

A medida que la aplicación crece comienzan a aparecer distintos tipos de prompts:

- Traducciones
- Resúmenes
- Clasificaciones
- Extracción de información

Esto provoca que los prompts terminen distribuidos por todo el código.

---

## Primera aproximación

Podríamos encapsular los prompts dentro de una clase Java tradicional.

Ejemplo conceptual:

public class Assistant {

    public String traducir(String texto) {
        ...
    }

    public String resumir(String texto) {
        ...
    }
}

Sin embargo seguimos teniendo que implementar toda la lógica manualmente.

---

## AI Services

LangChain4j introduce una nueva abstracción:

AI Services

Permite definir una interfaz y generar automáticamente su implementación.

Ejemplo:

public interface Assistant {

    String chat(String message);

}

---

## Creación del asistente

Assistant assistant =
        AiServices.create(
                Assistant.class,
                model);

No existe una clase:

AssistantImpl

escrita por el desarrollador.

LangChain4j la genera dinámicamente.

---

## ¿Qué sucede internamente?

Conceptualmente:

Aplicación Java
        ↓
AiServices
        ↓
Proxy Dinámico
        ↓
LLM

---

## Analogías Java

Para un desarrollador Java esto resulta familiar.

Patrones similares:

- Spring Data Repositories
- Feign Clients
- JDK Dynamic Proxies

La interfaz describe el comportamiento.

La implementación se genera automáticamente.

---

## Incorporando Prompts

Podemos asociar prompts directamente a los métodos.

Ejemplo conceptual:

@UserMessage(
    "Traduce al inglés: {{it}}"
)
String traducir(String texto);

Ahora el método representa un prompt.

---

## Beneficios

- Código más expresivo.
- Menor acoplamiento.
- Prompts encapsulados.
- Mayor mantenibilidad.

---

## Qué aprendimos

- Qué es un AI Service.
- Cómo generar asistentes mediante interfaces.
- Cómo LangChain4j utiliza proxies dinámicos.
- Cómo asociar prompts a métodos.

---

## Relación con el siguiente laboratorio

Hasta ahora los prompts poseen una única variable.

¿Cómo construimos prompts dinámicos con múltiples parámetros?

Esa pregunta será respondida en:

Lab 04 - Prompt Templates.
