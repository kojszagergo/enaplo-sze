package hu.diplomatervezes.client.view.settings.studentmanager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NewStudentView extends Composite {

	private static NewStudentViewUiBinder uiBinder = GWT
			.create(NewStudentViewUiBinder.class);

	interface NewStudentViewUiBinder extends UiBinder<Widget, NewStudentView> {
	}

	@UiField TextBox vezetekNev;
	@UiField TextBox keresztNev;
	@UiField TextBox szuletesiDatum;
	@UiField TextBox nem;
	@UiField TextBox iranyitoSzam;
	@UiField TextBox varos;
	@UiField TextBox utca;
	@UiField TextBox anyjaNeve;
	
	
	public NewStudentView() {
		initWidget(uiBinder.createAndBindUi(this));
		}

	
}
