package ar.net.dac.learning.langchain.lab02;

import ar.net.dac.learning.langchain.lab02.config.Environment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
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

        System.out.println("=== SIN MEMORIA ===");
        String r1 = model.chat(
                "Mi nombre es Daniel"
        );
        System.out.println(r1);

        String r2 = model.chat(
                "¿Como me llamo?"
        );
        System.out.println(r2);
        System.out.println();
        
        // LA MAGIA DE AiServices!!!!
        System.out.println("=== CON MEMORIA ===");
        Assistant assistant =
                AiServices.builder(Assistant.class)
                        .chatModel(model)
                        .chatMemory(
                                MessageWindowChatMemory.withMaxMessages(20)
                        )
                        .build();
        
        String r3 = assistant.chat(
                "Mi nombre es Daniel"
        );
        System.out.println(r3);

        String r4 = assistant.chat(
                "¿Como me llamo?"
        );
        System.out.println(r4);
        System.out.println();

        
	}
}
