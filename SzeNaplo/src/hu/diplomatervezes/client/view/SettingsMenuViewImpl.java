package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SettingsMenuViewImpl extends Composite implements SettingsMenuView{

	private static SettingsMenuViewImplUiBinder uiBinder = GWT
			.create(SettingsMenuViewImplUiBinder.class);

	interface SettingsMenuViewImplUiBinder extends
			UiBinder<Widget, SettingsMenuViewImpl> {
	}

	@UiField VerticalPanel settingsMenuContainer;
	private Presenter presenter;
	
	public SettingsMenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void SetPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
