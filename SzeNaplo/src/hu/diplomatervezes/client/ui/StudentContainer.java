package hu.diplomatervezes.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;

public class StudentContainer extends Composite {

	private static StudentContainerUiBinder uiBinder = GWT
			.create(StudentContainerUiBinder.class);
	
	@UiField FlexTable studentTable;
	@UiField ScrollPanel scrollPanel;

	interface StudentContainerUiBinder extends
			UiBinder<Widget, StudentContainer> {
	}

	public StudentContainer() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public FlexTable getStudentTable() {
		return studentTable;
	}
	
	public ScrollPanel getScrollPanel() {
		return scrollPanel;
	}
}
