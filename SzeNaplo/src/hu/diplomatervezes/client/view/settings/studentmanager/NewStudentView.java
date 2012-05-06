package hu.diplomatervezes.client.view.settings.studentmanager;

import com.google.gwt.user.client.ui.IsWidget;

public interface NewStudentView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void saveNewStudent();
		void cancelNewStudent();
	}
}
