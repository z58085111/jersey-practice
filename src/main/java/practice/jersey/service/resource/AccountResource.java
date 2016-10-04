package practice.jersey.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONObject;

import practice.jersey.service.resource.account.AccountResourceImpl;
import practice.jersey.service.resource.account.RegisterPhoneBean;
import practice.jersey.util.exception.InvalidException;

@Path("/account")
public class AccountResource {
	AccountResourceImpl resImpl;
	
	public AccountResource() {
		new ResourceConfig()
			.packages("org.glassfish.jersey.examples.jackson")
			.register(JacksonFeature.class);
		resImpl = new AccountResourceImpl();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test() {
		JSONObject resp = new JSONObject().put("description", "hello");
		return Response.ok().entity(resp.toString()).build();
	}
	
	@POST
	@Path("/paramTest/{pathParam}/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response paramTest(@HeaderParam("apiKey")String apiKey, @PathParam("pathParam")String fromPath, @QueryParam("queryParam")String fromQuery, RegisterPhoneBean bean) {
		try {
			JSONObject resp = bean.toJSONObject()
								  .put("pathParam", fromPath)
								  .put("queryParam", fromQuery);
			return Response.ok().entity(resp.toString()).build();
		} catch (InvalidException e) {
			return Response.status(401).entity(e.getJSONMessage()).build();
		}
	}
}
