package hu.diplomatervezes.client;

import hu.diplomatervezes.client.view.*;
import hu.diplomatervezes.client.view.settings.NewAnnouncementView;
import hu.diplomatervezes.client.view.settings.NewAnnouncementViewImpl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
	
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final StudentListView studentListView = new StudentListViewImpl();
	private static final StudentDetailView studentDetailView = new StudentDetailViewImpl();
	private static final TopPanelView topPanelView = new TopPanelViewImpl();
	private static final TesztPanel tesztPanel = new TesztPanel();
	private static final WelcomePage welcomePage = new WelcomePageImpl();
	private static final SettingsMenuView settingsMenuview = new SettingsMenuViewImpl();
	private static final NewAnnouncementView newAnnouncementView = new NewAnnouncementViewImpl();
	

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public StudentListView getStudentListView() {
		return studentListView;
	}

	@Override
	public StudentDetailView getStudentDetailView() {
		return studentDetailView;
	}
	
	@Override
	public TesztPanel getTesztPanel(String name) {
		return tesztPanel;
	}

	@Override
	public TopPanelView getTopPanelView() {
		return topPanelView;
	}

	@Override
	public WelcomePage getWelcomePage() {
		return welcomePage;
	}

	@Override
	public SettingsMenuView getSettingsMenu() {
		return settingsMenuview;
	}

	public NewAnnouncementView getNewAnnouncementView() {
		return newAnnouncementView;
	}
		
}
