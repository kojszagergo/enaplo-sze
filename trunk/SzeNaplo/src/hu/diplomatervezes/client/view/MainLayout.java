package hu.diplomatervezes.client.view;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public interface MainLayout {

	public interface Presenter {
		HorizontalPanel getTopPanel();
		VerticalPanel getLeftPanel();
		VerticalPanel getMainPanel();
	}
	
	void setPresenter(Presenter presenter);
	Widget asWidget();
}
