package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.NewAnnouncementPlace;
import hu.diplomatervezes.client.place.NewStudentPlace;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.view.SettingsMenuView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SettingsPanelActivity extends AbstractActivity implements SettingsMenuView.Presenter{

	private final SettingsMenuView view;
	private final PlaceController placeController;
	
	public SettingsPanelActivity(ClientFactory clientFactory) {
		
		view = clientFactory.getSettingsMenu();
		placeController = clientFactory.getPlaceController();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.SetPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void onClickNewAnnouncement() {
		placeController.goTo(new NewAnnouncementPlace());
	}

	@Override
	public void onClickEditAnnouncements() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClickBack() {
		placeController.goTo(new StudentListPlace());
	}

	@Override
	public void onClickNewStudent() {
		// TODO Auto-generated method stub
		placeController.goTo(new NewStudentPlace());
	}
}
