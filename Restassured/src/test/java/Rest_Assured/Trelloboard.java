package Rest_Assured;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class Trelloboard {
	@Test
	public void CreateBoard() {
		 RestAssured.baseURI="https://trello.com";
		Response rep = given().queryParam("name", "Sam")
		.queryParam("key", "bbfed49b556f6631b9b6130cb4eb9353")
		.queryParam("token", "ATTA782e368de5113e1c8c041f8b10cd0e40be58ad52b9c7f1dc36b98f9b62d0588f7DDD1CA5")
		.header("Content-Type","application/json")
		.when().post("/1/boards/")
		.then().contentType(ContentType.JSON)
		.extract().response();
		String str = rep.asString();
		JsonPath js = new JsonPath(str);
		String id = js.get("id");
		System.out.println(id);
		
		 given().queryParam("key", "bbfed49b556f6631b9b6130cb4eb9353")
			.queryParam("token", "ATTA782e368de5113e1c8c041f8b10cd0e40be58ad52b9c7f1dc36b98f9b62d0588f7DDD1CA5")
			.header("Content-Type","application/json")
			.when().delete("/1/boards/"+id)
			.then().contentType(ContentType.JSON);
			
		
		
	}

}
