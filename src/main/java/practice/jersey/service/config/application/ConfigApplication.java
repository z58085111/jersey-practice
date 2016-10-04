package practice.jersey.service.config.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import practice.jersey.service.resource.AccountResource;

public class ConfigApplication extends Application{

	@Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources and features
        classes.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
        classes.add(CustomObjMapper.class);
        classes.add(JsonProcessingExceptionMapper.class);
        classes.add(MultiPartFeature.class);
        classes.add(AccountResource.class);
        return classes;
    }
}
