package hu.diplomatervezes.client.view.settings;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RichTextArea.BasicFormatter;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NewAnnouncementViewImpl extends Composite implements NewAnnouncementView {

	private static NewAnnouncementViewImplUiBinder uiBinder = GWT
			.create(NewAnnouncementViewImplUiBinder.class);

	interface NewAnnouncementViewImplUiBinder extends
			UiBinder<Widget, NewAnnouncementViewImpl> {
	}

	@UiField TextBox title;
	@UiField RichTextArea body;
	@UiField PushButton saveButton;
	@UiField PushButton clearButton;
	private Presenter presenter;
	
	public NewAnnouncementViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		title.setFocus(true);
	}

	@UiHandler("saveButton")
	void onClickSaveButton(ClickEvent e) {
		presenter.saveAnnouncement();
	}
	
	@UiHandler("clearButton")
	void onClickClearButton(ClickEvent e) {
		clearAll();
	}
	
	@Override
	public String getHeaderText() {
		return title.getText();
	}

	@Override
	public String getBodyText() {
		return body.getText();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	
	@Override
	public void clearHeaderText() {
		title.setText("");
	}

	@Override
	public void clearBodyText() {
		body.setText("");
	}

	@Override
	public void clearAll() {
		clearHeaderText();
		clearBodyText();
	}
}
