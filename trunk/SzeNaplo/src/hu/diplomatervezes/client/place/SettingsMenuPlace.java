package hu.diplomatervezes.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SettingsMenuPlace extends SettingsPlace {

	private static final String PREFIX = "settings";
	
	public SettingsMenuPlace(){	
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
	public static class Tokenizer implements PlaceTokenizer<SettingsMenuPlace> {

		@Override
		public SettingsMenuPlace getPlace(String token) {
			return new SettingsMenuPlace();
		}

		@Override
		public String getToken(SettingsMenuPlace place) {
			return PREFIX;
		}
		
	}
}
