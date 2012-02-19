package hu.diplomatervezes.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;

public class WelcomeActivity extends AbstractActivity {

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HTML view = new HTML("HELLO BELLO");
		panel.setWidget(view.asWidget());
	}

}
