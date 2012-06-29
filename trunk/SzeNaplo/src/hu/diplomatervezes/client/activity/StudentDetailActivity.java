package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.view.StudentDetailView;
import hu.diplomatervezes.client.view.StudentDetailViewImpl;
import hu.diplomatervezes.shared._RatingGen;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class StudentDetailActivity extends AbstractActivity implements StudentDetailView.Presenter{

	private final StudentDetailView view;
	private final PlaceController placeController;
	//
	private String className;
	
	public StudentDetailActivity(StudentDetailPlace place, ClientFactory clientFactory) {
		view = new StudentDetailViewImpl();
		placeController = clientFactory.getPlaceController();
		className = (place == null) ? "Üres" : place.getName();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		view.setData(className);
		panel.setWidget(view.asWidget());
	}
	
	public void onStop() {
		
	}
	
	
	
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		placeController.goTo(place);
	}

	@Override
	public void getJegyek(String subject) {
		view.setSubjectChart(_RatingGen.get());
	}
}
