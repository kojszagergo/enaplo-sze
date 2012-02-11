package hu.diplomatervezes.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("studentService")
public interface StudentService extends RemoteService {

	void doNothing();
}
