package practice.jersey.service.config.application;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class CustomObjMapper implements ContextResolver<ObjectMapper> {
 
    final ObjectMapper defaultObjectMapper;
    //final ObjectMapper combinedObjectMapper;
    
    public CustomObjMapper() {
    	System.out.println("load mapper");
        defaultObjectMapper = createDefaultMapper();
        //combinedObjectMapper = createCombinedObjectMapper();
    }
 
    @Override
    public ObjectMapper getContext(Class<?> type) {
    	return defaultObjectMapper;
        
    }
    
   /* private static ObjectMapper createCombinedObjectMapper() {
        return new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector());
    }*/
    
    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.configure(SerializationFeature.INDENT_OUTPUT, true);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //result.configure(SerializationFeature., state)
        result.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES , true);
        result.configure(DeserializationFeature.WRAP_EXCEPTIONS, false);
        return result;
    }
    
}
