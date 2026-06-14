package ar.net.dac.learning.langchain.lab03;

import ar.net.dac.learning.langchain.lab03.config.Environment;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

public class Main {

	public static void main( String[] args) {

		String apiKey = Environment.get("OPENAI_API_KEY");
		
		System.out.println("API Key encontrada: "
                + (apiKey != null));
		
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();


        Assistant assistant =
                AiServices.create(Assistant.class,
                		model);
        // CHAT
        System.out.println("=== CHAT ===");
        System.out.println("chat() utiliza directamente el mensaje recibido.");
        String response = assistant.chat(
                "¿Qué es LangChain4j?"
        );
        System.out.println(response);
        System.out.println();
        
        // TRADUCIR
        System.out.println("=== TRADUCIR ===");
        System.out.println("El método tiene asociado un prompt mediante @UserMessage.");
        System.out.println(
        	    "traducir() parece un método Java normal, "
        	  + "pero internamente ejecuta un prompt."
        	);
        response = assistant.traducir(
        		"Las anotaciones describen el prompt."
        );
        System.out.println(response);
        System.out.println();

        // RESUMIR
        System.out.println("=== RESUMIR ===");
        System.out.println("El método tiene asociado un prompt mediante @UserMessage.");
        System.out.println(
        	    "resumir() parece un método Java normal, "
        	  + "pero internamente ejecuta un prompt."
        	);
        response = assistant.resumir(
        		"LangChain4j existe por estas funcionalidades, AiServices parece sólo una forma más complicada de hacer lo mismo si no entendemos esto."
        );
        System.out.println(response);
        System.out.println();
        
	}
}
