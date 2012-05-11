package hu.diplomatervezes.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import hu.diplomatervezes.client.StudentService;
import hu.diplomatervezes.shared.Diak;
import hu.diplomatervezes.shared.Tantargy;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class StudentServiceImpl extends RemoteServiceServlet implements
		StudentService {
	
	PersistenceManager pm = PMF.get().getPersistenceManager();
	
	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}
	
	@Override
	//ellenorozni kell uj tantargy eseten, hogy letezik-e mar az adatbazisban
	public void addNewSubject(Tantargy ujTantargy) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			pm.makePersistent(ujTantargy);
		} 
		finally {
			pm.close();
		}		
	}
	
	@Override
	public void deleteSubject(Tantargy regiTantargy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifySubject(Tantargy regiTantargy) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	//ellenorozni kell uj diak felvitele eseteben, hogy letezik-e mar az adatbazisban
	public void addNewStudent(Diak newStudent) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			pm.makePersistent(newStudent);
		} 
		finally {
			pm.close();
		}		
	}


	

}
