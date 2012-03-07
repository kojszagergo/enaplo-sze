package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Anchor;

public class TopPanelViewImpl extends Composite implements TopPanelView {

	private static TopPanelViewImplUiBinder uiBinder = GWT
			.create(TopPanelViewImplUiBinder.class);

	interface TopPanelViewImplUiBinder extends
			UiBinder<Widget, TopPanelViewImpl> {
	}

	@UiField Label loggedInUserFullName;
	@UiField Anchor link;

	
	public TopPanelViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		loggedInUserFullName.setText("defauld");
	}

	public String getLoggedInUserFullName() {
		return loggedInUserFullName.getText();
	}

	public void setLoggedInUserFullName(String loggedInUserFullName) {
		this.loggedInUserFullName.setText(loggedInUserFullName);
	}

	@Override
	public void setLinkHref(String href) {
		// TODO Auto-generated method stub
		link.setHref(href);
	}
}

