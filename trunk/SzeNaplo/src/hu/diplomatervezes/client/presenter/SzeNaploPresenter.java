package hu.diplomatervezes.client.presenter;

import hu.diplomatervezes.client.StudentServiceAsync;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class SzeNaploPresenter implements Presenter {

	private final StudentServiceAsync rpcService;
	private final HandlerManager eventBus;
	// Korabban Display interface-t implementalo UI widget. ez változni fog
	private Widget view;
	
	
	public SzeNaploPresenter(StudentServiceAsync rpcService, HandlerManager eventBus, Widget view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.view = view;
	}
	
	//Handler-ek beallítása, kezdő adatok betoltése
	public void bind() {
	}
	
	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		//asWidget()-et a Display interface-be
		container.add(view);
	}

}
