package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.view.StudentListView;
import hu.diplomatervezes.shared._SimpleDataBase;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LeftPanelActivity extends AbstractActivity implements StudentListView.Presenter{

	private final StudentListView view;
	private final PlaceController placeController;
	
	public LeftPanelActivity(StudentListPlace place, ClientFactory clientFactory) {
		view = clientFactory.getStudentListView();
		placeController = clientFactory.getPlaceController();		
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		view.setStudentList(_SimpleDataBase.get());
		panel.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		placeController.goTo(place);
	}
}
