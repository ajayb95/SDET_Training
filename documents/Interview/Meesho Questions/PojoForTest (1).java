package meesho;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","job"})
public class PojoForTest {
	
	/*{
	    "name": "autouser",
	    "job": "tester"
	}*/
	
	private String name;
	private String job;
	
	
	public PojoForTest(String name, String job) {
		this.name = name;
		this.job = job;
	}

}
