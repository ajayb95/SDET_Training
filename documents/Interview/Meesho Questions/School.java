package meesho;

import java.util.List;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"schoolName","StudentID"})
public class School {
	
	String schoolName;
	int[] idList;
	
	public School(String schoolName,int[] idList) {
		this.schoolName = schoolName;
		this.idList = idList;
	}
	

}
