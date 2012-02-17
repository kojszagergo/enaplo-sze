package hu.diplomatervezes.client;

import hu.diplomatervezes.client.view.StudentDetailView;
import hu.diplomatervezes.client.view.StudentDetailViewImpl;
import hu.diplomatervezes.client.view.StudentListView;
import hu.diplomatervezes.client.view.StudentListViewImpl;
import hu.diplomatervezes.client.view.TesztPanel;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
	
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	private final StudentListView studentListView = new StudentListViewImpl();
	private final StudentDetailView studentDetailView = new StudentDetailViewImpl();
	private final TesztPanel tesztPanel = new TesztPanel();
	
	

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
		// TODO Auto-generated method stub
		return tesztPanel;
	}

}
