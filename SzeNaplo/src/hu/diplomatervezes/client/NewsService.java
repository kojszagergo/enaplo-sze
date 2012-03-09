package hu.diplomatervezes.client;

import java.util.List;

import hu.diplomatervezes.shared.News;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("news")
public interface NewsService extends RemoteService {
	void addNews(String headerText, String bodyText);
	List<News> getNews();
}
