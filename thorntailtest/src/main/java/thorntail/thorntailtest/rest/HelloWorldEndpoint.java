package thorntail.thorntailtest.rest;




import com.google.gson.Gson;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/spelplan")
public class HelloWorldEndpoint {

    String json = Skapa.spelplan();


    @GET
    @Produces("text/plain")
    public Response doGet() {
        return Response.ok(json).build();
    }
}
