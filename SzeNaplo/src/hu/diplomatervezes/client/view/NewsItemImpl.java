package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

public class NewsItemImpl extends UIObject {

	private static NewsItemImplUiBinder uiBinder = GWT
			.create(NewsItemImplUiBinder.class);

	interface NewsItemImplUiBinder extends UiBinder<Element, NewsItemImpl> {
	}

	@UiField
	Element headerDiv;
	Element bodyDiv;

	public NewsItemImpl() {
		setElement(uiBinder.createAndBindUi(this));
	}
	
	public void setHeader(String headerText) {
		headerDiv.setInnerText(headerText);
	}
	
	public void setBody(String bodyText) {
		bodyDiv.setInnerText(bodyText);
	}
}
