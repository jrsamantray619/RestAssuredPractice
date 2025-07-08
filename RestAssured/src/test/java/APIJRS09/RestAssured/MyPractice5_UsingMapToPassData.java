package APIJRS09.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;

import PayloadData.Payload1;

public class MyPractice5_UsingMapToPassData {

	public static void main(String[] args) throws Exception {
		Map<String,Object> mp= new LinkedHashMap<String, Object>();
		String u_isbn="luni";
		int u_aisle=1994;
		mp.put("name", "java selenium");
		mp.put("isbn", u_isbn);
		mp.put("aisle", u_aisle);
		mp.put("author", "John foe");
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response =given().log().all().headers("Content-Type","application/json").body(mp)
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("the respose is"+response);

		String Expected_ID=u_isbn+u_aisle;
		JsonPath js= new JsonPath(response);
		String Actual_ID=js.getString("ID");
		Assert.assertEquals(Actual_ID, Expected_ID);
		System.out.println("My testcase got pass for ID verification");
		
		
		
		
		
		
	}

}
