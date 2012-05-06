package hu.diplomatervezes.client;

import hu.diplomatervezes.shared.Diak;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StudentServiceAsync {

	void doNothing(AsyncCallback<Void> callback);

	void addNewStudent(Diak newStudent, AsyncCallback<Void> callback);

}
