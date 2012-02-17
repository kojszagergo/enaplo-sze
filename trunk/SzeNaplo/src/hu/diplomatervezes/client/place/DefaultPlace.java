package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DefaultPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<DefaultPlace> {

		@Override
		public DefaultPlace getPlace(String token) {
			return new DefaultPlace();
		}

		@Override
		public String getToken(DefaultPlace place) {
			return "";
		}
		
	}
}
