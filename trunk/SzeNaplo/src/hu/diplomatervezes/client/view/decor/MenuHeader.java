package hu.diplomatervezes.client.view.decor;


import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.view.StudentListView.Presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuHeader extends Composite {

	private static MenuHeaderUiBinder uiBinder = GWT
			.create(MenuHeaderUiBinder.class);

	interface MenuHeaderUiBinder extends UiBinder<Widget, MenuHeader> {
	}

	public MenuHeader() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	private Presenter presenter;
	@UiField Anchor toStudentClassPage;

	public MenuHeader(Presenter presenter, String headerName) {
		initWidget(uiBinder.createAndBindUi(this));
		this.presenter = presenter; 
		toStudentClassPage.setText(headerName);
	}
	
	@UiHandler("toStudentClassPage")
	void onClick(ClickEvent e) {
		//Window.alert("Clicked " + toStudentClassPage.getText());
		presenter.onClassSelected(toStudentClassPage.getText());
	}
}
