package hu.diplomatervezes.client;

import java.util.List;

import hu.diplomatervezes.shared.News;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NewsServiceAsync {

	void addNews(String headerText, String bodyText,
			AsyncCallback<Void> callback);
	void getNews(AsyncCallback<List<News>> callback);
}
