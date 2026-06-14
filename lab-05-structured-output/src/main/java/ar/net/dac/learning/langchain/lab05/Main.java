package ar.net.dac.learning.langchain.lab05;

import java.util.List;

import ar.net.dac.learning.langchain.lab05.config.Environment;
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

		Persona persona=assistant.extraerPersona( "Mi nombre es Daniel y tengo 63 años.");
		System.out.println(persona.getNombre());
		System.out.println(persona.getEdad());

		Personas personas=assistant.extraerPersonas( """
				Mi nombre es Daniel y tengo 63 años.
				Su nomnbre es Roberto, un joven aún, apenas 17 años.
				30 años, que bella que es Juana.
				""");
		for (Persona p:personas.getPersonas())
			System.out.println(String.format("%s tiene %s", p.getNombre(),p.getEdad()));
		
		
		Producto producto=assistant.extraerProducto( "Notebook Lenovo ThinkPad.");
		System.out.println(producto.getCategoria());
		System.out.println(producto.getNombre());		
	}
}