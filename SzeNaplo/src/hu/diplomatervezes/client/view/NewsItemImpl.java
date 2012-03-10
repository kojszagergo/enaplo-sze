package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NewsItemImpl extends Composite {

	private static NewsItemImplUiBinder uiBinder = GWT
			.create(NewsItemImplUiBinder.class);

	interface NewsItemImplUiBinder extends UiBinder<Widget, NewsItemImpl> {
	}

	@UiField Element headerDiv;
	@UiField Element bodyDiv;

	public NewsItemImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public NewsItemImpl(String headerText, String bodyText) {
		initWidget(uiBinder.createAndBindUi(this));
		setHeader(headerText);
		setBody(bodyText);
	}
	
	public void setHeader(String headerText) {
		headerDiv.setInnerText(headerText);
	}
	
	public void setBody(String bodyText) {
		bodyDiv.setInnerText(bodyText);
	}
}
