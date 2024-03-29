package hu.diplomatervezes.client.view;

import java.awt.MenuComponent;

import hu.diplomatervezes.client.LoginInfo;
import hu.diplomatervezes.client.place.SettingsMenuPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class UserPanelImpl extends Composite {

	private static UserPanelImplUiBinder uiBinder = GWT
			.create(UserPanelImplUiBinder.class);

	interface UserPanelImplUiBinder extends UiBinder<Widget, UserPanelImpl> {
	}

	public UserPanelImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField MenuItem mainMenu;
	@UiField MenuItem settings; 
	@UiField MenuItem logout;
	LoginInfo loginInfo;
	Command cmdSettings;
	Command cmdLogout;
	PlaceController placeController;

	public UserPanelImpl(LoginInfo loginInfo, PlaceController placeController) {
		initWidget(uiBinder.createAndBindUi(this));
		this.loginInfo = loginInfo;
		this.placeController = placeController;
		mainMenu.setText(this.loginInfo.getEmailAddress());
		bindCommands();
	}
	
	private void bindCommands() {
		setMenuCommands();
		settings.setCommand(cmdSettings);
		logout.setCommand(cmdLogout);
	}
	
	private void setMenuCommands() {	
		cmdSettings = new Command() {
			@Override
			public void execute() {
				placeController.goTo(new SettingsMenuPlace());
			}
		};
		
		cmdLogout = new Command() {
			@Override
			public void execute() {
				Window.Location.assign(loginInfo.getLogoutUrl());
			}
		};
	}
}
