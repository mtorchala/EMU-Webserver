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
	
	// GET
	
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
				return resp;
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
	@Path("/leseAlleMessreihen")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leseAlleMessreihen(){
		
		try {
			ObjectMapper obm = new ObjectMapper();
			DbAktionen dbAktionen = new DbAktionen();
			Messreihe[] messreihen = new DbAktionen().leseAlleMessreihen();
			try {
				String jsonString = obm.writeValueAsString(messreihen);
				Response resp = Response.status(200).entity(jsonString).build();
				return resp;
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
	@Path("/getAnzahlMessungen/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnzahlMessungen(@PathParam("id") int id){
		
		try {
			ObjectMapper obm = new ObjectMapper();
			DbAktionen dbAktionen = new DbAktionen();
			int anzahl = new DbAktionen().getAnzahlMessungen(id);
			try {
				String jsonString = obm.writeValueAsString(anzahl);
				Response resp = Response.status(200).entity(jsonString).build();
				return resp;
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
	@Path("/getAnzahlMessreihen/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnzahlMessreihen(@PathParam("id") int id){
		
		try {
			ObjectMapper obm = new ObjectMapper();
			DbAktionen dbAktionen = new DbAktionen();
			int anzahl = new DbAktionen().getAnzahlMessungen(id);
			try {
				String jsonString = obm.writeValueAsString(anzahl);
				Response resp = Response.status(200).entity(jsonString).build();
				return resp;
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
	
	
	// POST
	
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String leseMessungen(){
		
		return "Test erfolgreich";
		
	}
}
