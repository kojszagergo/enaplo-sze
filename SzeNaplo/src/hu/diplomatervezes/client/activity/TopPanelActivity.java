package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.LoginInfo;
import hu.diplomatervezes.client.LoginService;
import hu.diplomatervezes.client.LoginServiceAsync;
import hu.diplomatervezes.client.place.TopPanelPlace;
import hu.diplomatervezes.client.view.TopPanelView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class TopPanelActivity extends AbstractActivity {

	private final TopPanelView view;
	private final PlaceController placeContorller;
	private final LoginInfo loginInfo;

	public TopPanelActivity(TopPanelPlace place, ClientFactory clientFactory) {
		view = clientFactory.getTopPanelView();
		placeContorller = clientFactory.getPlaceController();
		this.loginInfo = place.getLoginInfo();
		
		//System.out.println(loginInfo.isLoggedIn());
	}
	
	private void setTopPanel() {
		if (loginInfo == null)
		
		if(loginInfo.isLoggedIn()) {
			view.setLoggedInUserFullName(loginInfo.getNickName());
			//view.setLinkHref(loginInfo.getLogoutUrl());
		}
		else {
			view.setLoggedInUserFullName("Guest!");
			//view.setLinkHref(loginInfo.getLoginUrl());
		}
		
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setLinkHref(loginInfo.getLoginUrl());
		//view.setLoggedInUserFullName(loginInfo.getNickName());
		panel.setWidget(view.asWidget());
	}

}
