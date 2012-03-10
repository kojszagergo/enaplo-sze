package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.view.WelcomePage;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity extends AbstractActivity {

	private final WelcomePage view;
	
	public WelcomeActivity(ClientFactory clientFactory) {
		view = clientFactory.getWelcomePage();
		view.setnews(null);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		//HTML view = new HTML("HELLO BELLO");
		panel.setWidget(view.asWidget());
	}

}
