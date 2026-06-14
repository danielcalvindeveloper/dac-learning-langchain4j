# DAC Learning LangChain

## Introducción

Los Large Language Models (LLM) han transformado la forma en que construimos software. Sin embargo, gran parte del material disponible se encuentra orientado al ecosistema Python.

DAC Learning LangChain nace con el objetivo de enseñar los mismos conceptos desde la perspectiva de un desarrollador Java, utilizando LangChain4j como framework principal.

El curso sigue una progresión incremental: cada laboratorio introduce una única abstracción nueva y se apoya en los conocimientos adquiridos anteriormente.

---

## Objetivos Generales

Al finalizar el curso el estudiante será capaz de:

- Comprender cómo interactuar con un LLM.
- Utilizar LangChain4j desde Java.
- Implementar memoria conversacional.
- Diseñar asistentes basados en interfaces.
- Construir Prompt Templates reutilizables.
- Obtener resultados estructurados.
- Implementar soluciones RAG.
- Integrar herramientas externas.
- Construir agentes.
- Utilizar LangGraph4j.
- Comprender MCP.
- Diseñar aplicaciones de IA modernas utilizando Java.

---

## Filosofía del Curso

Cada laboratorio responde una pregunta concreta.

```text
¿Cómo invoco un LLM?
        ↓
¿Cómo mantiene contexto?
        ↓
¿Cómo encapsulo prompts?
        ↓
¿Cómo reutilizo prompts?
        ↓
¿Cómo obtengo objetos Java?
        ↓
¿Cómo incorporo conocimiento externo?
        ↓
¿Cómo construyo agentes?
```

La idea es comprender el motivo detrás de cada abstracción antes de utilizarla.

---

## Roadmap

### Lab 01 - Hello LLM

Objetivo:

Realizar la primera llamada a un modelo de lenguaje.

Conceptos:

- LLM
- Prompt
- Respuesta
- Modelo

---

### Lab 02 - Chat Memory

Objetivo:

Comprender por qué los modelos son stateless.

Conceptos:

- Contexto
- Historial
- ChatMemory

---

### Lab 03 - AI Services

Objetivo:

Transformar interfaces Java en asistentes de IA.

Conceptos:

- AiServices
- Interfaces
- Proxies dinámicos
- @UserMessage

---

### Lab 04 - Prompt Templates

Objetivo:

Construir prompts dinámicos.

Conceptos:

- @V
- Variables
- Templates
- Placeholders

---

### Lab 05 - Structured Output

Objetivo:

Convertir respuestas del modelo en objetos Java.

Conceptos:

- JSON
- POJOs
- Extracción de datos

---

### Lab 06 - Chat Memory Advanced

Objetivo:

Persistir memoria y controlar ventanas conversacionales.

Conceptos:

- Persistencia
- Estrategias de memoria
- Contexto de largo plazo

---

### Lab 07 - Embeddings

Objetivo:

Representar significado mediante vectores.

Conceptos:

- Embeddings
- Similaridad
- Espacio vectorial

---

### Lab 08 - Document Loader

Objetivo:

Cargar documentos desde distintas fuentes.

Conceptos:

- Parsers
- Loaders
- Normalización

---

### Lab 09 - RAG Basic

Objetivo:

Construir el primer sistema RAG.

Conceptos:

- Retrieval
- Contexto externo
- Grounding

---

### Lab 10 - RAG Advanced

Objetivo:

Mejorar la calidad de recuperación.

Conceptos:

- Chunking
- Ranking
- Estrategias de búsqueda

---

### Lab 11 - Tools

Objetivo:

Permitir que el modelo utilice funcionalidades Java.

Conceptos:

- Tools
- Integración
- Capacidades externas

---

### Lab 12 - Function Calling

Objetivo:

Invocar funciones de forma estructurada.

Conceptos:

- Schemas
- Argumentos
- Invocaciones

---

### Lab 13 - Agents

Objetivo:

Construir agentes autónomos.

Conceptos:

- Planificación
- Decisión
- Ejecución

---

### Lab 14 - Multi Agents

Objetivo:

Coordinar agentes especializados.

Conceptos:

- Roles
- Delegación
- Colaboración

---

### Lab 15 - LangGraph4j

Objetivo:

Orquestar procesos mediante grafos.

Conceptos:

- Estado
- Nodos
- Transiciones

---

### Lab 16 - MCP

Objetivo:

Comprender Model Context Protocol.

Conceptos:

- Contexto
- Integración
- Protocolos

---

### Lab 17 - Final Project

Objetivo:

Integrar todos los conocimientos adquiridos.

Conceptos:

- Arquitectura
- Diseño
- Integración completa

---

## Bibliografía Recomendada

- LangChain4j Documentation
- LangGraph4j Documentation
- OpenAI Documentation
- Anthropic Documentation
- Model Context Protocol Specification

---

## Resultado Esperado

Al finalizar el recorrido el estudiante podrá diseñar y construir aplicaciones modernas basadas en IA utilizando Java como lenguaje principal.
