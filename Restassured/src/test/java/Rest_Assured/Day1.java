package Rest_Assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class Day1 {
@Test(enabled = false)
public void first() {
	Response rev = RestAssured.get("https://reqres.in/api/users");
	int scod=rev.statusCode();
	Assert.assertEquals(scod, 200);
	//System.out.println(rev);
}
@Test(enabled = false)
public void listuser() {
	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
}
@Test(enabled = false)
public void Singleuser() {
	given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.first_name", equalTo("Janet"));
}
@Test(enabled = false)
public void Singleuserunsucess() {
	given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();

}
@Test(enabled = false)
public void listreso() {
	given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
}
@Test(enabled = false)
public void singleresource() {
	given().get("https://reqres.in/api/unknown/2").then().statusCode(200).body("data.name",equalTo("fuchsia rose")).log().all();

}
@Test(enabled = false)
public void singleresourcenotfound() {
	given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();

}
@Test(enabled = false)
public void Create() {
	 JSONObject obj = new JSONObject();	
	 obj.put("name", "Rajendra");
	 obj.put("job", "Tester");
	 given().body(obj.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
}
@Test(enabled = false)
public void Delete() {
	 given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
}
@Test(enabled = false)
public void RegisterSucc() {
	JSONObject obj1 = new JSONObject();	
	 obj1.put("email", "rajendra@gmail.com");
	 obj1.put("password", "Tester@12");
	 given().body(obj1.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
}
@Test(enabled = false)
public void Registeunsu() {
	JSONObject obj1 = new JSONObject();	
	 obj1.put("email", "rajendra@gmail.com");
	 given().body(obj1.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();
}

@Test(enabled = false)
public void LoginSucc() {
	JSONObject obj1 = new JSONObject();	
	 obj1.put("email", "rajendra@gmail.com");
	 obj1.put("password", "Tester@12");
	 given().body(obj1.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();
}
@Test(enabled = false)
public void Loginunsu() {
	JSONObject obj1 = new JSONObject();	
	 obj1.put("email", "rajendra@gmail.com");
	 given().body(obj1.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();
}
@Test(enabled = true)
public void Delayedres() {
	 given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
}


}
