package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.view.StudentListView;
import hu.diplomatervezes.client.view.StudentListViewImpl;
import hu.diplomatervezes.shared._SimpleDataBase;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class StudentPanelActivity extends AbstractActivity implements StudentListView.Presenter{

	private final StudentListView view;
	private final PlaceController placeController;
	
	public StudentPanelActivity(ClientFactory clientFactory) {
		view = new StudentListViewImpl();
		placeController = clientFactory.getPlaceController();		
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		view.setStudentList(_SimpleDataBase.get());
		panel.setWidget(view.asWidget());
	}

	@Override
	public void onClassSelected(String osztaly) {
		placeController.goTo(new StudentDetailPlace(osztaly));
	}

	@Override
	public void onStudentSelected(String id) {
		placeController.goTo(new StudentDetailPlace(id));		
	}
}
