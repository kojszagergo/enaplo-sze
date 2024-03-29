package hu.diplomatervezes.server;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import hu.diplomatervezes.client.NewsService;
import hu.diplomatervezes.shared.News;

import javax.jdo.Query;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NewsServiceImpl extends RemoteServiceServlet implements
		NewsService {
	
	@Override
	public void addNews(String headerText, String bodyText) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			pm.makePersistent(new News(headerText, bodyText));
		} 
		finally {
			pm.close();
		}
	}

	@Override
	public List<News> getNews() {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(News.class);
		q.setOrdering("createDate descending");
		
		try {
			List<News> announcements = (List<News>) q.execute();
			System.out.print("System.out.println készült");
			GWT.log("GWT.log készült");
			return (List<News>) pm.detachCopyAll(announcements);
		} finally {
			pm.close();
		}
	}
}
