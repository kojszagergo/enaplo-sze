package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.StackPanel;

public class Menu extends Composite {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	@UiField VerticalPanel menu_header;
	@UiField VerticalPanel menu_footer;
	@UiField StackPanel main_menu;

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}

	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}