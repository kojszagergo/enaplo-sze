package hu.diplomatervezes.client;

import hu.diplomatervezes.shared.Diak;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("studentService")
public interface StudentService extends RemoteService {

	void doNothing();
	void addNewStudent(Diak newStudent);
}
