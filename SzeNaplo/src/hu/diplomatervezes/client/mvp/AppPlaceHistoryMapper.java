package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.place.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
	WelcomePlace.Tokenizer.class,
	StudentListPlace.Tokenizer.class,
	StudentDetailPlace.Tokenizer.class
	})

public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
	
}
