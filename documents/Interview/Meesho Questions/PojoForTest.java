package meesho;

import java.util.List;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"include","school","university"})
public class PojoForTest {
	
	private boolean include;
	private List<School> school;
	private University university;
	
	public PojoForTest(boolean include,List<School> school,University university) {
		this.include = include;
		this.school = school;
		this.university = university;
	}
	

}
