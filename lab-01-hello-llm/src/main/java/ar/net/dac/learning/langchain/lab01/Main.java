package ar.net.dac.learning.langchain.lab01;

import ar.net.dac.learning.langchain.lab01.config.Environment;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {

	public static void main( String[] args) {

		String apiKey = Environment.get("OPENAI_API_KEY");
		
		System.out.println("API Key encontrada: "
                + (apiKey != null));
		
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();

        long inicio = System.currentTimeMillis();
        String response = model.chat(
                "Explica en una frase qué es LangChain4j"
        );
        long fin = System.currentTimeMillis();
        System.out.println(response);
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
        
	}
}
