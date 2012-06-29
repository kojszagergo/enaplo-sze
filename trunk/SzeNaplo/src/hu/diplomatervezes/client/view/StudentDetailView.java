package hu.diplomatervezes.client.view;

import hu.diplomatervezes.shared._RatingGen;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface StudentDetailView extends IsWidget{

	void setSubjectChart(_RatingGen adatok);
	void setData(String name);
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void goTo(Place place);
		void getJegyek(String subject);
	}
}
