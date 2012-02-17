package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StudentListPlace extends Place {

	private String name;
	
	public StudentListPlace(String token) {
		this.name = token;
	}
	
	public String getName() {
		return name;
	}
	
	public static class Tokenizer implements PlaceTokenizer<StudentListPlace> {

		@Override
		public StudentListPlace getPlace(String token) {
			return new StudentListPlace(token);
		}

		@Override
		public String getToken(StudentListPlace place) {
			return place.getName();
		}
		
	}
}
