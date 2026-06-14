package ar.net.dac.learning.langchain.lab05;

import java.util.List;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Assistant {
	
    @UserMessage("""
    		Extrae los datos de la persona.

    		Texto:
    		{{texto}}
    		""")
    Persona extraerPersona(
            @V("texto") String texto);
    

    @UserMessage("""
    		Extrae una lista de personas mencionadas en el texto.

    		Texto:
    		{{texto}}
    		""")
    Personas extraerPersonas(
            @V("texto") String texto);	    
    
    
    @UserMessage("""
    		Extrae los datos del producto.

    		Texto:
    		{{texto}}
    		""")
    Producto extraerProducto(
            @V("texto") String texto);	
    
    
    
}
