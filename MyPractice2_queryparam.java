package APIJRS09.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class MyPractice2_queryparam {

	public static void main(String[] args) throws Exception {
		RestAssured.baseURI="https://reqres.in";
		
		/*String responce=given().log().all().queryParam("page", "2").headers("x-api-key","reqres-free-v1")
		.when().get("api/users?page=2")
		.then().log().all().assertThat().statusCode(200).extract()
		.response().asString();
		System.out.println(responce);*/
		
		Response res=given().log().all().queryParam("page", "2").headers("x-api-key","reqres-free-v1")
				.when().get("api/users?page=2")
				.then().log().all().assertThat().statusCode(200).extract()
				.response();
		
		long time=res.getTime();
		if(time<5000) {
			System.out.println("My Testcase Got Passed");
		}else {
			throw new Exception("taking more time");
		}
		
		
		
}

}















