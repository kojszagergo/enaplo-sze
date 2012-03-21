package hu.diplomatervezes.client.activity;

import java.util.ArrayList;
import java.util.List;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.NewsService;
import hu.diplomatervezes.client.NewsServiceAsync;
import hu.diplomatervezes.client.view.WelcomePage;
import hu.diplomatervezes.client.view.WelcomePageImpl;
import hu.diplomatervezes.shared.News;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity extends AbstractActivity {

	private WelcomePage view;
	
	public WelcomeActivity(ClientFactory clientFactory) {
		view = new WelcomePageImpl();
		loadNews();
	}
	
	private void loadNews() { 
		NewsServiceAsync newsService = GWT.create(NewsService.class);
		newsService.getNews(new AsyncCallback<List<News>>() {
			@Override
			public void onSuccess(List<News> result) {
				// TODO Auto-generated method stub
				view.setnews(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
	}

}
