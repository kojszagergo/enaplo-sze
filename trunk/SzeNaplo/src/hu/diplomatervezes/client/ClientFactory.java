package hu.diplomatervezes.client;

import hu.diplomatervezes.client.view.StudentDetailView;
import hu.diplomatervezes.client.view.StudentListView;
import hu.diplomatervezes.client.view.TesztPanel;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {

	EventBus getEventBus();
	PlaceController getPlaceController();
	
	StudentListView getStudentListView();
	StudentDetailView getStudentDetailView();
	TesztPanel getTesztPanel(String name);
	
}
