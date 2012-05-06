package hu.diplomatervezes.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import hu.diplomatervezes.client.StudentService;
import hu.diplomatervezes.shared.Diak;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StudentServiceImpl extends RemoteServiceServlet implements
		StudentService {
	
	PersistenceManager pm = PMF.get().getPersistenceManager();
	
	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}

	@Override
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
