package APIJRS09.RestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class MyPractice1_GetMethod {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		
		String responce=given().log().all().headers("x-api-key","reqres-free-v1")
		.when().get("api/users")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(responce);
	}

}
