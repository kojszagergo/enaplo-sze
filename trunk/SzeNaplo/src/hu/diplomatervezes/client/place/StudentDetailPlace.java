package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class StudentDetailPlace extends StudentPlace {
	
	private String name;
	
	public StudentDetailPlace(String token) {
		this.name = token;
	}
	
	public String getName() {
		return name;
	}
	
	@Prefix("student")
	public static class Tokenizer implements PlaceTokenizer<StudentDetailPlace> {

		@Override
		public StudentDetailPlace getPlace(String token) {
			return new StudentDetailPlace(token);
		}

		@Override
		public String getToken(StudentDetailPlace place) {
			return place.getName();
		}
		
	}
}
