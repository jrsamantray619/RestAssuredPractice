package PayloadData;

public class Payload1 {

	public static String addEmpDetails(String empname,String emprole) {
		String emp="{\r\n" + 
				"    \"name\": \""+empname+"\",\r\n" + 
				"    \"job\": \""+emprole+"\"\r\n" + 
				"}";
		return emp;
	}
	
	public static String bookDetails() {
		return null;
		
	}
}
