package hu.diplomatervezes.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface TopPanelView extends IsWidget {
	String getLoggedInUserFullName();
	void setLoggedInUserFullName(String loggedInUserFullName);
	void setLinkHref(String href);
}
