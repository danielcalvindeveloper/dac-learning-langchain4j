package ar.net.dac.learning.langchain.lab03;

import dev.langchain4j.service.UserMessage;

public interface Assistant {
	
	String chat(String message);
	
    @UserMessage(
            "Traduce al inglés: {{texto}}"
        )
    String traducir(String texto);

    @UserMessage(
            "Resume en una frase: {{texto}}"
        )
    String resumir(String texto);    
}
