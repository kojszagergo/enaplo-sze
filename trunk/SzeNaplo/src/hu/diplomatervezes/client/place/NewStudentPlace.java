package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class NewStudentPlace extends SettingsPlace {

	public NewStudentPlace(){
	}
	
	public static class Tokenizer implements PlaceTokenizer<NewStudentPlace> {

		@Override
		public NewStudentPlace getPlace(String token) {
			return new NewStudentPlace();
		}

		@Override
		public String getToken(NewStudentPlace place) {
			return "newStudent";
		}
		
	}
}
