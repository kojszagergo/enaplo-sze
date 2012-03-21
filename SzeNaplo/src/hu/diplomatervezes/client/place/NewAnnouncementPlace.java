package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class NewAnnouncementPlace extends SettingsPlace {

	public NewAnnouncementPlace() {
		
	}
	
	public static class Tokenizer implements PlaceTokenizer<NewAnnouncementPlace> {

		@Override
		public NewAnnouncementPlace getPlace(String token) {
			return new NewAnnouncementPlace();
		}

		@Override
		public String getToken(NewAnnouncementPlace place) {
			return null;
		}
		
	}
}
