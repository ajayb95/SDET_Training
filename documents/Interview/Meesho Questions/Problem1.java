package meesho;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Problem1 {
	
	@Test
	public void example1() {
		
		File file = new File("");
		List<School> school = new ArrayList<School>();
		int[] id = new int[1];
		id[0] = 599515;
		School schoolName = new School("jnv", id);
		school.add(schoolName);
		University university = new University(78, "Pune");
		PojoForTest obj = new PojoForTest(false, school, university);
		
		System.out.println(obj);
		
		
		RequestSpecification spec = RestAssured.given().log().all();
		Response response = spec.accept(ContentType.JSON)
				.when().body(obj).post("http://xyz/school/1.0/download-data");
		int sCode = response.getStatusCode();
		long time = response.getTime();
	}

}
