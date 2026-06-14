# Lab 02 - Chat Memory

## Objetivo

Comprender que un LLM no posee memoria entre invocaciones y cómo LangChain4j incorpora memoria conversacional.

---

## Problema

Se realizan dos llamadas independientes al modelo:

```java
model.chat("Mi nombre es Daniel");

model.chat("¿Como me llamo?");
```

Resultado:

```text
No tengo la capacidad de saber tu nombre...
```

El modelo no recuerda la conversación anterior.

---

## Concepto: Stateless

Los LLM son esencialmente stateless.

Cada invocación es procesada de forma independiente.

```text
Llamada 1
Usuario: Mi nombre es Daniel

Llamada 2
Usuario: ¿Como me llamo?
```

La segunda llamada no tiene conocimiento de la primera.

---

## Solución: Chat Memory

LangChain4j permite mantener el historial de mensajes mediante:

```java
MessageWindowChatMemory.withMaxMessages(20)
```

La memoria conserva las últimas interacciones y las reenvía al modelo en cada solicitud.

---

## AI Services

Para incorporar memoria se utiliza:

```java
Assistant assistant =
        AiServices.builder(Assistant.class)
                .chatModel(model)
                .chatMemory(
                        MessageWindowChatMemory.withMaxMessages(20)
                )
                .build();
```

LangChain4j genera dinámicamente una implementación de la interfaz:

```java
public interface Assistant {

    String chat(String message);

}
```

No existe una implementación concreta escrita por el desarrollador.

---

## Flujo sin memoria

```text
Usuario
   |
   v
LLM
```

---

## Flujo con memoria

```text
Usuario
   |
   v
ChatMemory
   |
   v
LLM
```

---

## Resultado

```java
assistant.chat("Mi nombre es Daniel");

assistant.chat("¿Como me llamo?");
```

Respuesta:

```text
Te llamas Daniel.
```

---

## Conclusiones

- El LLM no recuerda conversaciones por sí mismo.
- La memoria no vive dentro del modelo.
- LangChain4j implementa la memoria reenviando el historial de mensajes.
- AI Services permite crear asistentes conversacionales mediante interfaces Java.

---

## Próximo laboratorio

Lab 03 - AI Services

Objetivo:

Comprender cómo LangChain4j genera implementaciones dinámicas a partir de interfaces y cómo definir prompts mediante anotaciones.
