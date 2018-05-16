package webapi.business;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/funktionen")
public class EmuService {
	
	@GET
	@Path("/leseMessungen/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leseMessungen(@PathParam("id") int messreihenid){
		
		try {
			ObjectMapper obm = new ObjectMapper();
			DbAktionen dbAktionen = new DbAktionen();
			Messung[] messungen = new DbAktionen().leseMessungen(messreihenid);
			try {
				String jsonString = obm.writeValueAsString(messungen);
				Response resp = Response.status(200).entity(jsonString).build();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String leseMessungen(){
		
		return "Test erfolgreich";
		
	}
}
