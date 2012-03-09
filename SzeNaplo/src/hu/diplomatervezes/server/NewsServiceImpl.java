package hu.diplomatervezes.server;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import hu.diplomatervezes.client.NewsService;
import hu.diplomatervezes.shared.News;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NewsServiceImpl extends RemoteServiceServlet implements
		NewsService {

	private static final PersistenceManagerFactory PMF =
		      JDOHelper.getPersistenceManagerFactory("transactions-optional");
	
	@Override
	public void addNews(String headerText, String bodyText) {
		PersistenceManager pm = getPersistenceManager();
		
		try {
			pm.makePersistent(new News(headerText, bodyText));
		} 
		finally {
			pm.close();
		}
	}

	@Override
	public List<News> getNews() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private PersistenceManager getPersistenceManager() {
	    return PMF.getPersistenceManager();
	  }
}
