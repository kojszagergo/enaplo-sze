package hu.diplomatervezes.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface StudentDetailView extends IsWidget{

	void setData(String name);
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void goTo(Place place);
	}
}
