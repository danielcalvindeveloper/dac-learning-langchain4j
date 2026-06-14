# Lab 05 - Structured Output

## Objetivo

Comprender cómo convertir automáticamente las respuestas de un modelo de lenguaje en objetos Java utilizando Structured Output.

En lugar de recibir texto libre, LangChain4j permite obtener directamente instancias de clases Java.

---

## Punto de partida

Hasta el laboratorio anterior todos los métodos devolvían:

```java
String
```

Por ejemplo:

```java
String traducir(...)

String resumir(...)

String consultar(...)
```

El modelo generaba texto y la aplicación trabajaba con texto.

---

## Problema

Supongamos el siguiente contenido:

```text
Mi nombre es Daniel y tengo 63 años.
```

Podríamos pedirle al modelo que nos devuelva:

```text
{
  "nombre": "Daniel",
  "edad": 63
}
```

y luego parsear manualmente el JSON.

Sin embargo:

* Hay que escribir código de parsing.
* Hay que manejar errores.
* Se pierde simplicidad.
* El código se vuelve más verboso.

---

## Solución: Structured Output

LangChain4j permite indicar que el resultado esperado es un POJO.

Ejemplo:

```java
@UserMessage("""
Extrae los datos de la persona.

Texto:
{{texto}}
""")
Persona extraerPersona(
        @V("texto") String texto);
```

Invocación:

```java
Persona persona =
        assistant.extraerPersona(
                "Mi nombre es Daniel y tengo 63 años.");
```

Resultado:

```java
persona.getNombre(); // Daniel
persona.getEdad();   // 63
```

---

## Ejemplo 1 - Persona

Clase:

```java
public class Persona {

    private String nombre;

    private Integer edad;

}
```

Texto:

```text
Mi nombre es Daniel y tengo 63 años.
```

Resultado esperado:

```java
Persona
```

---

## Ejemplo 2 - Producto

Clase:

```java
public class Producto {

    private String nombre;

    private String categoria;

}
```

Texto:

```text
Notebook Lenovo ThinkPad categoría informática.
```

Resultado esperado:

```java
Producto
```

---

## Ejemplo 3 - Varias Personas

Texto:

```text
Mi nombre es Daniel y tengo 63 años.
Su nombre es Roberto y tiene 17 años.
Juana tiene 30 años.
```

Inicialmente se intentó utilizar:

```java
List<Persona>
```

como resultado del método.

---

## Limitación Encontrada

Durante las pruebas realizadas con:

```text
LangChain4j 1.16.1
```

la definición:

```java
List<Persona> extraerPersonas(...)
```

produjo una excepción en tiempo de ejecución.

---

## Solución Adoptada

Se utilizó un objeto contenedor.

```java
public class Personas {

    private List<Persona> personas;

}
```

Método:

```java
Personas extraerPersonas(
        @V("texto") String texto);
```

De esta forma LangChain4j construye correctamente la colección.

---

## Conceptos aprendidos

* Qué es Structured Output.
* Cómo convertir respuestas en POJOs.
* Cómo trabajar con objetos complejos.
* Cómo modelar resultados estructurados.
* Limitaciones encontradas durante la implementación.

---

## Evolución

```text
Lab 01 -> Hello LLM
Lab 02 -> Chat Memory
Lab 03 -> AI Services
Lab 04 -> Prompt Templates
Lab 05 -> Structured Output
```

---

## Conclusión

Structured Output permite dejar de pensar únicamente en texto y comenzar a trabajar directamente con objetos Java.

Esto simplifica el código y facilita la integración de los modelos de lenguaje con aplicaciones empresariales.

---

## Próximo laboratorio

Lab 06 - Embeddings

Objetivo:

Comprender cómo representar información mediante vectores y realizar búsquedas semánticas.

```
```
