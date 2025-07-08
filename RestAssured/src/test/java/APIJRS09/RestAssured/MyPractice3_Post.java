package APIJRS09.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class MyPractice3_Post {

	public static void main(String[] args) throws Exception {
		RestAssured.baseURI="https://reqres.in";
		Response res=given().log().all().headers("x-api-key","reqres-free-v1")
				.headers("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"name\": \"Harry\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}")
		.when().post("api/users/2")
		.then().log().all().assertThat().statusCode(201).body("name", equalTo("Harry"))
		.extract().response();
		
		long time=res.getTime();
		if(time<5000) {
			System.out.println("My Testcase Got Passed");
		}else {
			throw new Exception("taking more time");
		}

		String responce=res.asString();
		System.out.println(responce);
		
		JsonPath js= new JsonPath(responce);
		String createdAt=js.getString("createdAt");
		String []date=createdAt.split("T");
		System.out.println(date[0]);
		/*if(date[0].equalsIgnoreCase("2025-06-25")) {
		System.out.println("Testcase Passed");	
		}else {
			System.out.println("Testcase failed");
		}*/
		System.out.println(java.time.LocalDate.now().toString());
		Assert.assertEquals(date[0], java.time.LocalDate.now().toString().toString());
		
		
		
		
		
		
		
		
	}

}
