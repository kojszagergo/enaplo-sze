package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class StudentListPlace extends StudentPlace {
	
	 private static final String PREFIX = "students";
	
	 public StudentListPlace() {
	 }
	 
	@Override
	public boolean equals(Object otherPlace) {
		return this == otherPlace || (otherPlace != null && getClass() == otherPlace.getClass());
	}

	@Override
	 public int hashCode() {
		return PREFIX.hashCode();
	}
	 
	@Prefix(PREFIX)
	public static class Tokenizer implements PlaceTokenizer<StudentListPlace> {

		@Override
		public StudentListPlace getPlace(String token) {
			return new StudentListPlace();
		}

		@Override
		public String getToken(StudentListPlace place) {
			return PREFIX;
		}
		
	}
}
