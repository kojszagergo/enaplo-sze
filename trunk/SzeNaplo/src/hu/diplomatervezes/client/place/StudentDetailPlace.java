package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StudentDetailPlace extends Place {
	
	private String name;
	
	public StudentDetailPlace(String token) {
		this.name = token;
	}
	
	public String getName() {
		return name;
	}
	
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
