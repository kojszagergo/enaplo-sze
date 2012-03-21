package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SettingsMenuViewImpl extends Composite implements SettingsMenuView{

	private static SettingsMenuViewImplUiBinder uiBinder = GWT
			.create(SettingsMenuViewImplUiBinder.class);

	interface SettingsMenuViewImplUiBinder extends
			UiBinder<Widget, SettingsMenuViewImpl> {
	}

	@UiField VerticalPanel settingsMenuContainer;
	@UiField Label backLink; 
	@UiField Anchor newAnnouncementLink;
	private Presenter presenter;
	
	public SettingsMenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void SetPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("backLink")
	void onBackMenuItemClicked(ClickEvent e) {
		presenter.onClickBack();
	}
	
	@UiHandler("newAnnouncementLink")
	void onClickNewAnnouncement(ClickEvent e) {
		presenter.onClickNewAnnouncement();
	}
}
