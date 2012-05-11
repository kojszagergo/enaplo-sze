package hu.diplomatervezes.client;

import hu.diplomatervezes.shared.Diak;
import hu.diplomatervezes.shared.Tantargy;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StudentServiceAsync {

	void doNothing(AsyncCallback<Void> callback);

	//meghivhato tantargy kezelesi metodusok async valtozat
	void addNewSubject(Tantargy ujTantargy, AsyncCallback<Void> callback);
	void deleteSubject(Tantargy regiTantargy, AsyncCallback<Void> callback);
	void modifySubject(Tantargy regiTantargy, AsyncCallback<Void> callback);
	
	//meghivhato diak kezelesi metodusok async valtozat
	void addNewStudent(Diak newStudent, AsyncCallback<Void> callback);

	
	

	

}
