package ar.net.dac.learning.langchain.lab04;

import ar.net.dac.learning.langchain.lab04.config.Environment;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

public class Main {

	public static void main(String[] args) {

		String apiKey = Environment.get("OPENAI_API_KEY");

		System.out.println("API Key encontrada: " + (apiKey != null));

		OpenAiChatModel model = OpenAiChatModel.builder()
				.apiKey(apiKey)
				.modelName("gpt-4o-mini")
				.build();

		Assistant assistant =
				AiServices.create(
						Assistant.class,
						model);

		/*
		 * ==========================================================
		 * EJEMPLO 1 - TRADUCCION
		 * ==========================================================
		 */
		System.out.println("=== TRADUCCION ===");
		System.out.println(
				"El metodo recibe el idioma y el texto. "
				+ "LangChain4j inserta ambos valores dentro del template definido en @UserMessage.");

		String response = assistant.traducir(
				"ingles",
				"Las anotaciones describen el prompt."
		);

		System.out.println(response);
		System.out.println();

		/*
		 * ==========================================================
		 * EJEMPLO 2 - RESUMEN
		 * ==========================================================
		 */
		System.out.println("=== RESUMEN ===");
		System.out.println(
				"El metodo recibe la cantidad maxima de lineas y el texto a resumir. "
				+ "Ambos valores son inyectados en el prompt template.");

		String texto = """
				LangChain4j es una biblioteca Java diseñada para facilitar la integración con modelos de lenguaje.
				Permite trabajar con prompts, memoria conversacional, herramientas y agentes.
				Los AI Services permiten representar prompts mediante interfaces Java.
				Los Prompt Templates permiten construir mensajes dinámicos utilizando variables.
				Estas abstracciones ayudan a escribir código más expresivo y mantenible.
				""";

		response = assistant.resumir(
				2,
				texto);

		System.out.println(response);
		System.out.println();

		/*
		 * ==========================================================
		 * EJEMPLO 3 - CAMBIO DE ROL
		 * ==========================================================
		 */
		System.out.println("=== CONSULTA COMO PROFESOR ===");
		System.out.println(
				"El parametro 'rol' modifica el comportamiento esperado del asistente.");

		response = assistant.consultar(
				"profesor de matematicas",
				"¿Que es una derivada?"
		);

		System.out.println(response);
		System.out.println();

		System.out.println("=== CONSULTA COMO ABOGADO ===");
		System.out.println(
				"Se utiliza el mismo metodo, pero cambiando el rol utilizado en el template.");

		response = assistant.consultar(
				"abogado",
				"¿Que es un contrato?"
		);

		System.out.println(response);
		System.out.println();

		System.out.println("=== CONCLUSION ===");
		System.out.println(
				"Los Prompt Templates permiten construir prompts dinamicos "
				+ "a partir de parametros Java. El mismo metodo puede generar "
				+ "distintos prompts dependiendo de los valores recibidos.");
	}
}