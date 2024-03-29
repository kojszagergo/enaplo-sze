package hu.diplomatervezes.client.view;

import hu.diplomatervezes.shared._SimpleDataBase;

import com.google.gwt.user.client.ui.IsWidget;

public interface StudentListView extends IsWidget{
	void setStudentList(_SimpleDataBase students);
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void onClassSelected(String osztaly);
		void onStudentSelected(String id);
	}
}
