package hu.diplomatervezes.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface SettingsMenuView extends IsWidget {

	void SetPresenter(Presenter presenter);
	
	public interface Presenter {
		void onClickNewAnnouncement();
		void onClickEditAnnouncements();
		void onClickNewStudent();
		void onClickBack();
	}
}
