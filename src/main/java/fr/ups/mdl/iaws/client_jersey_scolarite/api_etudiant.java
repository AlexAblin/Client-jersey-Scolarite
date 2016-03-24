package fr.ups.mdl.iaws.client_jersey_scolarite;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class api_etudiant {

	public api_etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	void chercher(){
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target("http://sampleserver6.arcgisonline.com/arcgis/rest/services/Utilities/Geometry/GeometryServer").path("distance")
				.queryParam("sr","4326")
				.queryParam("geometry1","{\"geometryType\":\"esriGeometryPolygon\",\"geometry\":{\"rings\":[[[-117,34],[-117,35],[-116,35],[-116,34],[-117,34]]]}}")
				.queryParam("geometry2","{\"geometryType\":\"esriGeometryPoint\",\"geometry\":{\"x\":-115,\"y\":36}}")
				.queryParam("geodesic","true")
				.queryParam("f","json");


		JsonArray distance = wt.request(MediaType.APPLICATION_JSON).get(JsonArray.class);


		/*for (JsonValue e : etudiants) {
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
	*/}
	
	void chercherEvalutation(int id){
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target("http://resources.arcgis.com/en/help/arcgis-rest-api/");
		JsonArray eval = wt.path("evaluations").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(JsonArray.class);
		for (JsonValue e : eval) {
			int i = ((JsonObject) e).getInt("id");
			if(i==id)
				System.out.println(e);
		}
		
	}
}
