package fr.ups.mdl.iaws.client_jersey_scolarite;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class api_etudiant {

	public api_etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	void testmeteo(){
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target("http://notes.tsaap.eu/Scolarite/api/v1");
		//api.openweathermap.org/data/2.5/weather?q={London}
	}
	void chercher(int id){
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target("http://notes.tsaap.eu/Scolarite/api/v1");
		JsonArray etudiants = wt.path("etudiants").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(JsonArray.class);
		
		
		for (JsonValue e : etudiants) {
			int i = ((JsonObject) e).getInt("id");
			if(i==id){
				//ON chercher maintenant le tableau d'évaluation (pour obtenir les notes de l'eleve)
				JsonArray list = ((JsonObject) e).getJsonArray("evaluations");
				for (JsonValue jsonValue : list) {
					int i2 = ((JsonObject) jsonValue).getInt("id");
					 chercherEvalutation(i2);
				}
			}
				
		}
		
		//chercher le bon etudiant et le retourner
	}
	
	void chercherEvalutation(int id){
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target("http://notes.tsaap.eu/Scolarite/api/v1/");
		JsonArray eval = wt.path("evaluations").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(JsonArray.class);
		for (JsonValue e : eval) {
			int i = ((JsonObject) e).getInt("id");
			if(i==id)
				System.out.println(e);
		}
		
	}
}