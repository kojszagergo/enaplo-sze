package hu.diplomatervezes.client.view.settings;

import com.google.gwt.user.client.ui.IsWidget;

public interface NewAnnouncementView extends IsWidget{

	void clearHeaderText();
	void clearBodyText();
	String getHeaderText();
	String getBodyText();
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void saveAnnouncement();
	}
}
