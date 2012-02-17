package hu.diplomatervezes.client.view.decor;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MenuHeader extends Composite {

	private static MenuHeaderUiBinder uiBinder = GWT
			.create(MenuHeaderUiBinder.class);

	interface MenuHeaderUiBinder extends UiBinder<Widget, MenuHeader> {
	}

	public MenuHeader() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Label className;

	public MenuHeader(String headerName) {
		initWidget(uiBinder.createAndBindUi(this));
		className.setText(headerName);
	}
}
