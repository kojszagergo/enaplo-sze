package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.LoginInfo;
import hu.diplomatervezes.client.place.TopPanelPlace;
import hu.diplomatervezes.client.view.TopPanelView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class TopPanelActivity extends AbstractActivity {

	private final TopPanelView view;
	private final PlaceController placeContorller;
	private final LoginInfo loginInfo;

	public TopPanelActivity(TopPanelPlace place, ClientFactory clientFactory) {
		view = clientFactory.getTopPanelView();
		placeContorller = clientFactory.getPlaceController();
		this.loginInfo = place.getLoginInfo();
		setTopPanel();
		//System.out.println(loginInfo.isLoggedIn());
	}
	
	private void setTopPanel() {
		view.setLinkHref(loginInfo.getLoginUrl());
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
	}

}
