package hu.diplomatervezes.client;

import hu.diplomatervezes.client.presenter.Presenter;
import hu.diplomatervezes.client.presenter.SzeNaploPresenter;
import hu.diplomatervezes.client.view.Layout;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final StudentServiceAsync rpcService;
	private HasWidgets container;
	
	public AppController(StudentServiceAsync rpcService, HandlerManager eventBus) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		bind();
	}
	
	private void bind() {
		History.addValueChangeHandler(this);
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub
		String token = event.getValue();
		
		if(token != null) {
			Presenter presenter = null;
			
			if(token.equals("startLayout")) {
				presenter = new SzeNaploPresenter(rpcService, eventBus, new Layout());
			}
			//else if
			
			if(presenter != null) {
				presenter.go(container);
			}
		}
	}
	
	public void go(HasWidgets container) {
		this.container = container;
		
		if ("".equals(History.getToken())) {
			History.newItem("startLayout");
		}
		else {
			History.fireCurrentHistoryState();
		}
	}

}
