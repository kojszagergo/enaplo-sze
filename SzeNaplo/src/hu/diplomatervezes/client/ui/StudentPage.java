package hu.diplomatervezes.client.ui;

import com.google.gwt.core.client.GWT;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;

public class StudentPage extends Composite {

	private static StudentPageUiBinder uiBinder = GWT
			.create(StudentPageUiBinder.class);

	interface StudentPageUiBinder extends UiBinder<Widget, StudentPage> {
	}
	
	@UiField Label studentName;

	public StudentPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public Label getStudentName() {
		return studentName;
	}

	public void setStudentName(Label studentName) {
		this.studentName = studentName;
	}
}
