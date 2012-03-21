package hu.diplomatervezes.client.view;

import hu.diplomatervezes.shared.News;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class WelcomePageImpl extends Composite implements WelcomePage {

	private static WelcomePageImplUiBinder uiBinder = GWT
			.create(WelcomePageImplUiBinder.class);

	interface WelcomePageImplUiBinder extends UiBinder<Widget, WelcomePageImpl> {
	}

	@UiField VerticalPanel welcomePageContainer;
	
	public WelcomePageImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setnews(List<News> news) {
		
		if (news != null ) {
			for (News item : news) {
				welcomePageContainer.add(new NewsItemImpl(item.getHeaderText(), item.getBodyText()));
				}
		} else {
			welcomePageContainer.add(new NewsItemImpl("Nincs hirdetmény!", "Új hirdetmény hozzáadásához jelentkezzen be!"));
		}

	}

	@Override
	public void setNewsTest() {
		welcomePageContainer.add(new NewsItemImpl("12", "21"));
	}
}
