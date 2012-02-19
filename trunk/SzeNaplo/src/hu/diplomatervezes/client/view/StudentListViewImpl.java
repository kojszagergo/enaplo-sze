package hu.diplomatervezes.client.view;

import hu.diplomatervezes.client.SzeNaplo;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.view.decor.MenuHeader;
import hu.diplomatervezes.shared._SimpleDataBase;
import hu.diplomatervezes.shared._SimpleSchoolClass;
import hu.diplomatervezes.shared._SimpleStudent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.StackLayoutPanel;

public class StudentListViewImpl extends Composite implements StudentListView {

	private static StudentListViewImplUiBinder uiBinder = GWT
			.create(StudentListViewImplUiBinder.class);

	interface StudentListViewImplUiBinder extends UiBinder<Widget, StudentListViewImpl> {
	}
	private Presenter presenter; 
	@UiField StackLayoutPanel studentListPanel;
	@UiField Button tesztButton;

	public StudentListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		studentListPanel.setHeight("600px");
		
	}

	@Override
	public void setStudentList(_SimpleDataBase students) {
		
		for (_SimpleSchoolClass schoolClass : students.getIskolaOsztalyok()) {
			StudentContainer sc = new StudentContainer();
			sc.getScrollPanel().setStyleName("tesztScroll");
			//System.out.println(sc.getScrollContainer().getOffsetHeight());
			sc.getScrollPanel().setHeight(600-(students.getIskolaOsztalyok().size()*30) + "px");
			FlexTable st = sc.getStudentTable();
			int row = 0;
				for (_SimpleStudent student : schoolClass.getStudentList()) {
					st.setWidget(row, 0, new Label(row+1 + ". " + student.getFirstName() + " " + student.getLastName()));
					++row;
				}
			studentListPanel.add(sc, new MenuHeader(presenter, schoolClass.getGrade()), 30);
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("tesztButton")
	void onClick(ClickEvent e) {
		//Window.alert(tesztButton.getText());
		tesztButton.setText(tesztButton.getText());
		presenter.onClassSelected(tesztButton.getText());
	}
}
