package ar.net.dac.learning.langchain.lab04;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Assistant {
	
	String chat(String message);
	
	@UserMessage("""
			Traduce al {{idioma}}

			Texto:
			{{texto}}
			""")
			String traducir(
			        @V("idioma") String idioma,
			        @V("texto") String texto);

	@UserMessage("""
			Resume el siguiente texto en un máximo de {{lineas}} líneas:

			{{texto}}
			""")
			String resumir(
			        @V("lineas") int lineas,
			        @V("texto") String texto);
	
	@UserMessage("""
			Actúa como un {{rol}}.

			Pregunta:

			{{pregunta}}
			""")
			String consultar(
			        @V("rol") String rol,
			        @V("pregunta") String pregunta);
	
}
