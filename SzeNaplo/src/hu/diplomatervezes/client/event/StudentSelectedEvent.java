package hu.diplomatervezes.client.event;

import hu.diplomatervezes.shared._SimpleStudent;

import com.google.gwt.event.shared.GwtEvent;

public class StudentSelectedEvent extends GwtEvent<StudentSelectedEventHandler> {
	public static Type<StudentSelectedEventHandler> TYPE = new Type<StudentSelectedEventHandler>();
	private final _SimpleStudent student;
	
	public StudentSelectedEvent(_SimpleStudent student) {
		this.student = student;
	}
	
	public _SimpleStudent getSelectedStudent() {
		return this.student;
	}
	
	@Override
	public Type<StudentSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(StudentSelectedEventHandler handler) {
		handler.onStudentSelected(this);
	}

}
