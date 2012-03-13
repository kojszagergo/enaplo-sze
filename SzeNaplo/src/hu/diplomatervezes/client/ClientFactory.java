package hu.diplomatervezes.client;

import hu.diplomatervezes.client.view.SettingsMenuView;
import hu.diplomatervezes.client.view.StudentDetailView;
import hu.diplomatervezes.client.view.StudentListView;
import hu.diplomatervezes.client.view.TesztPanel;
import hu.diplomatervezes.client.view.TopPanelView;
import hu.diplomatervezes.client.view.WelcomePage;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {

	EventBus getEventBus();
	PlaceController getPlaceController();
	
	StudentListView getStudentListView();
	StudentDetailView getStudentDetailView();
	TopPanelView getTopPanelView();
	TesztPanel getTesztPanel(String name);
	WelcomePage getWelcomePage();
	SettingsMenuView getSettingsMenu();
	
}
