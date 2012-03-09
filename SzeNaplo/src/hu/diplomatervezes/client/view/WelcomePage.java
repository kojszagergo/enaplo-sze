package hu.diplomatervezes.client.view;

import hu.diplomatervezes.shared.News;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

public interface WelcomePage extends IsWidget{
	void setnews(List<News> news);
}
