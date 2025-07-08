package APIJRS09.RestAssured;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyPractice6_UsingTestNG_Dataprovider {

	
	@DataProvider(name="booksData")
	public Object [][] getdata(){
		return new Object[][]
				{
			{"sfds",1234,"Harry"},{"dfet",2563,"Tom"},{"wert",8956,"Virat"}		
				};
			}
	@Test(dataProvider="booksData")
	public void addbook(String isbn,String aisle,String author) {
		
RestAssured.baseURI="http://216.10.245.166";
		
		String response =given().log().all().headers("Content-Type","application/json")
				//.body(isbn,aisle,author)
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("the respose is"+response);
	}
	
}
