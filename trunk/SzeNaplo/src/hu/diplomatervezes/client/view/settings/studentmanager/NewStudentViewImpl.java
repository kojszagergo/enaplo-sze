package hu.diplomatervezes.client.view.settings.studentmanager;

import hu.diplomatervezes.shared.Diak;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class NewStudentViewImpl extends Composite implements NewStudentView, Editor<Diak> {

	private static NewStudentViewUiBinder uiBinder = GWT
			.create(NewStudentViewUiBinder.class);

	interface NewStudentViewUiBinder extends UiBinder<Widget, NewStudentViewImpl> {
	}

	@UiField TextBox vezetekNev;
	@UiField TextBox keresztNev;
	@UiField DateBox szuletesiDatum;
	@UiField ListBox neme;
	@UiField TextBox iranyitoSzam;
	@UiField TextBox varos;
	@UiField TextBox utca;
	@UiField TextBox anyjaNeve;
	
	@UiField PushButton newStudentButton;
	@UiField PushButton cancelButton;
	private Presenter presenter;
	
	
	public NewStudentViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		szuletesiDatum.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy.MM.dd")));
		szuletesiDatum.getElement().setAttribute("placeholder", "\"éééé.hh.nn\"");
		neme.setSelectedIndex(1);
		}


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("newStudentButton")
	void onClickHozzaad(ClickEvent e) {
		presenter.saveNewStudent();
	}
	
	@UiHandler("cancelButton")
	void onClickCancel(ClickEvent e) {
		presenter.cancelNewStudent();
	}
}
