package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.NewsService;
import hu.diplomatervezes.client.NewsServiceAsync;
import hu.diplomatervezes.client.place.SettingsMenuPlace;
import hu.diplomatervezes.client.view.settings.NewAnnouncementView;
import hu.diplomatervezes.client.view.settings.NewAnnouncementView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class NewAnnouncementActivity extends AbstractActivity implements
		Presenter {

	private final NewAnnouncementView view;
	private final PlaceController placeController;
	NewsServiceAsync newsService = GWT.create(NewsService.class);
	
	public NewAnnouncementActivity(ClientFactory clientFactory) {
		
		view = clientFactory.getNewAnnouncementView();
		this.placeController = clientFactory.getPlaceController();
		view.clearAll();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		view.clearAll();
		panel.setWidget(view.asWidget());

	}

	@Override
	public void saveAnnouncement() {
		newsService.addNews(view.getHeaderText(), view.getBodyText(), new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				placeController.goTo(new SettingsMenuPlace());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
	}

}
