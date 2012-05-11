package hu.diplomatervezes.client;

import hu.diplomatervezes.shared.Diak;
import hu.diplomatervezes.shared.Tantargy;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("studentService")
public interface StudentService extends RemoteService {

	void doNothing();
	
	//meghivhato tantargykezelesi metodusok
	void addNewSubject(Tantargy ujTantargy);
	void deleteSubject(Tantargy regiTantargy);
	void modifySubject(Tantargy regiTantargy);
	
	//meghivhato diak kezelesi metodusok
	void addNewStudent(Diak newStudent);
}
