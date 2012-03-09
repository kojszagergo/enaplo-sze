package hu.diplomatervezes.client.view;

import hu.diplomatervezes.shared.News;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class WelcomePageImpl extends Composite implements WelcomePage {

	private static WelcomePageImplUiBinder uiBinder = GWT
			.create(WelcomePageImplUiBinder.class);

	interface WelcomePageImplUiBinder extends UiBinder<Widget, WelcomePageImpl> {
	}

	public WelcomePageImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField VerticalPanel welcomePageContainer;

	@Override
	public void setnews(List<News> news) {
		// TODO Auto-generated method stub
		for (News item : news) {
				
		}
	}
}
