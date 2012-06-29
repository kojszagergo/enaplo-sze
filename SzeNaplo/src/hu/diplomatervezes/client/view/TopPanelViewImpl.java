package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class TopPanelViewImpl extends Composite implements TopPanelView {

	private static TopPanelViewImplUiBinder uiBinder = GWT
			.create(TopPanelViewImplUiBinder.class);

	interface TopPanelViewImplUiBinder extends
			UiBinder<Widget, TopPanelViewImpl> {
	}

	@UiField PushButton loginButton;
	String loginUrl;

	
	public TopPanelViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setLinkHref(String href) {
		loginUrl = href;
	}
	
	@UiHandler("loginButton")
	void onclick(ClickEvent e) {
		Window.Location.assign(loginUrl);
		
	}
}

