package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class WelcomePlace extends Place {
	
	private static final String PREFIX = "WELCOME";

	@Prefix(PREFIX)
	public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {

		@Override
		public WelcomePlace getPlace(String token) {
			return new WelcomePlace();
		}

		@Override
		public String getToken(WelcomePlace place) {
			// TODO Auto-generated method stub
			return PREFIX;
		}
		
	}
}
