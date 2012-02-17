package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.view.StudentDetailView;
import hu.diplomatervezes.client.view.TesztPanel;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;

public class CenterPanelActivity extends AbstractActivity implements StudentDetailView.Presenter {

	private final StudentDetailView view;
	private final PlaceController placeController;
	//
	private String className;
	
	public CenterPanelActivity(StudentDetailPlace place, ClientFactory clientFactory) {
		view = clientFactory.getStudentDetailView();
		placeController = clientFactory.getPlaceController();
		className = place.getName();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setData(className);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		placeController.goTo(place);
	}

}
