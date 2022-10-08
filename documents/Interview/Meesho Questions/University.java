package meesho;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","name"})
public class University {
	int id;
	String name;
	public University(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
}
