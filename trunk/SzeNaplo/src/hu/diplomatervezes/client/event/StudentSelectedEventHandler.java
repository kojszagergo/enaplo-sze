package hu.diplomatervezes.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface StudentSelectedEventHandler extends EventHandler {
	void onStudentSelected(StudentSelectedEvent event);
}
