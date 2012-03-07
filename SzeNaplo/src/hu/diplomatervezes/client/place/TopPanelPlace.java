package hu.diplomatervezes.client.place;

import hu.diplomatervezes.client.LoginInfo;

import com.google.gwt.place.shared.Place;

public class TopPanelPlace extends Place {

	private LoginInfo loginInfo;
	
	public TopPanelPlace(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
}